package com.example.bankbasic2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bankbasic2.model.Accounts;

public class DisplayAccount extends AppCompatActivity {
    private Button button;
    private String name;
    private String account;
    private String phone;
    private String email;
    private String balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_account);

        button=(Button)findViewById(R.id.transact);

        Intent intent=getIntent();
        name=intent.getStringExtra("RName");
         account=intent.getStringExtra("RAccount");
        phone= intent.getStringExtra("RPhone");
        email=intent.getStringExtra("REmail");
        balance=intent.getStringExtra("RBalance");

        TextView nameTextView=findViewById(R.id.dName);
        nameTextView.setText(name);
        TextView accTextView=findViewById(R.id.dAccount_number);
        accTextView.setText(account);
        TextView phoneTextView=findViewById(R.id.dPhoneNumber);
        phoneTextView.setText(phone);
        TextView emailTextView=findViewById(R.id.dEmailID);
        emailTextView.setText(email);
        TextView balanceTextView=findViewById(R.id.dBalance);
        balanceTextView.setText(balance);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransact();
            }
        });

    }
    public void openTransact()
    {
        Intent intent=new Intent(this,Transact.class);
        intent.putExtra("RName",name);
        intent.putExtra("RAccount",account);
        intent.putExtra("REmail",email);
        intent.putExtra("RPhone",phone);
        intent.putExtra("RBalance",balance);
        Log.d("Amt", String.valueOf(balance));


        startActivity(intent);
    }

}