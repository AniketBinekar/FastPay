package com.example.bankbasic2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.bankbasic2.data.myDbHandler;
import com.example.bankbasic2.model.Accounts;

public class MainActivity extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.viewusers);
       

       myDbHandler db=new myDbHandler(MainActivity.this);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(!prefs.getBoolean("firstTime", false)) {
            //Adding accounts
            Accounts ashish = new Accounts();
            ashish.setName("Ashish Mehra");
            ashish.setEmail("ashish.mehra@gmail.com");
            ashish.setPhone("899999999");
            ashish.setBalance(10000);
            db.addAccount(ashish);


            Accounts anand = new Accounts();
            anand.setName("Anand Joshi");
            anand.setEmail("anand.joshi@gmail.com");
            anand.setPhone("9888888888");
            anand.setBalance(2000);
            db.addAccount(anand);

            Accounts barkha = new Accounts();
            barkha.setName("Barkha Jaiswal");
            barkha.setEmail("barkha.jaiswal@gmail.com");
            barkha.setPhone("9998887766");
            barkha.setBalance(200000);
            db.addAccount(barkha);

            Accounts kunal = new Accounts();
            kunal.setName("Kunal Singh");
            kunal.setEmail("kunal.singh@gmail.com");
            kunal.setPhone("9998885566");
            kunal.setBalance(80000);
            db.addAccount(kunal);

            Accounts nishant = new Accounts();
            nishant.setName("Nishant Roy");
            nishant.setEmail("nishant.roy@gmail.com");
            nishant.setPhone("8888888566");
            nishant.setBalance(900000);
            db.addAccount(nishant);

            Accounts riya = new Accounts();
            riya.setName("Riya Khanna");
            riya.setEmail("riya.khanna@gmail.com");
            riya.setPhone("9998988566");
            riya.setBalance(9000);
            db.addAccount(riya);

            Accounts shweta = new Accounts();
            shweta.setName("Shweta Sinha");
            shweta.setEmail("shweta.sinha@gmail.com");
            shweta.setPhone("999999566");
            shweta.setBalance(110000);
            db.addAccount(shweta);

            Accounts siddhi = new Accounts();
            siddhi.setName("Siddhi Menon");
            siddhi.setEmail("siddhi.menon@gmail.com");
            siddhi.setPhone("999999566");
            siddhi.setBalance(110000);
            db.addAccount(siddhi);


            Accounts taniya = new Accounts();
            taniya.setName("Taniya Roy");
            taniya.setEmail("taniya.roy@gmail.com");
            taniya.setPhone("999999566");
            taniya.setBalance(110000);
            db.addAccount(taniya);

            Accounts tejas = new Accounts();
            tejas.setName("Tejas Shah");
            tejas.setEmail("tejas.shah@gmail.com");
            tejas.setPhone("999999566");
            tejas.setBalance(110000);
            db.addAccount(tejas);


      //  Log.d("sid","Inserted all");
       SharedPreferences.Editor editor = prefs.edit();
          editor.putBoolean("firstTime", true);
           editor.commit();
        }

/*

        //Get all accounts
        List<Accounts> allAccounts=db.getAllAccounts();
        for(Accounts accounts:allAccounts)
        {
            Log.d("sid","Account: "+accounts.getId1()+"\n"+
                    "Name: "+accounts.getName() +"\n"+
                    "Email: "+accounts.getEmail()+"\n"+
                    "PhoneNO: "+accounts.getPhone()+"\n"+
                    "Balance: "+accounts.getBalance());
        }


        //Get all transactions
        List<Transactions> allTransactions=db.getAllTransactions();
        for(Transactions transactions:allTransactions)
        {
            Log.d("sid","Sender's Account: "+transactions.getS_acc()+"\n"+
                    "Sender's Name: "+transactions.getS_name() +"\n"+
                    "Receiver's Account: "+transactions.getR_acc()+"\n"+
                    "Receiver's Name: "+transactions.getR_name() +"\n"+
                    "Transaction amount: "+transactions.getT_amt()+"\n");
        }*/
        //Log.d("count","Number of rows in Accounts:"+db.getAccountCount());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccountList();
            }
        });

    }
    public void openAccountList()
    {
        Intent intent=new Intent(this,AccountList.class);
        startActivity(intent);
    }

}