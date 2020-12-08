package com.example.bankbasic2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bankbasic2.data.myDbHandler;

import javax.xml.parsers.SAXParser;

public class Transact extends AppCompatActivity {

    private Spinner spinner;
    private Button button;
    private EditText editAmt;
    int amount;
    int bal_from;
    String name_sender;
    String name_receiver;
     String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transact);

        button = (Button)findViewById(R.id.confirm_pay);
        spinner = findViewById(R.id.transact_spinner);
        editAmt = findViewById(R.id.editAmount);


        //getting list of contacts from Array
        String [] names_contact = getResources().getStringArray(R.array.names_of_contact);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, names_contact);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if(getIntent().hasExtra("RBalance")&& (getIntent().hasExtra("RName"))) {
            bal_from= Integer.parseInt(getIntent().getStringExtra("RBalance"));
            name_sender = getIntent().getStringExtra("RName");
            Log.d("Amount", String.valueOf(bal_from));

        }

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                name_receiver = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransactHistory();
            }
        });
}


    public void openTransactHistory()
    {
        editAmt = findViewById(R.id.editAmount);
        amount = Integer.parseInt(editAmt.getText().toString());
        Log.d("amt", String.valueOf(amount));
        Log.d("amt", String.valueOf(bal_from));

        if (amount>bal_from){
            Toast.makeText(getApplicationContext(),"Insufficient Balance",Toast.LENGTH_SHORT).show();
        }
        else if(name_receiver.equals(name_sender)){
            Toast.makeText(getApplicationContext(),"Sender and receiver cannot be the same person",Toast.LENGTH_LONG).show();
        }
        else
        {
            Log.d("Amount","In else");
            int new_curr_bal = bal_from - amount;
            myDbHandler db = new myDbHandler(Transact.this);
            db.updateAccount(name_sender,new_curr_bal,name_receiver,amount);
            Toast.makeText(getApplicationContext(),"Transaction Successful",Toast.LENGTH_SHORT).show();
            Intent i = getBaseContext().getPackageManager()
                    .getLaunchIntentForPackage( getBaseContext().getPackageName() );
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            Intent intent=new Intent(this,TransactionSuccessful.class);
            startActivity(intent);
        }


    }

}


