package com.example.bankbasic2;

import android.accounts.Account;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bankbasic2.data.myDbHandler;
import com.example.bankbasic2.model.Transactions;
import com.example.bankbasic2.params.Params;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TransactionSuccessful extends AppCompatActivity {
    private Button button;
    private String name;
    private String account;
    private String phone;
    private String email;
    private String balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        Intent intent=getIntent();
        name=intent.getStringExtra("RName");
        account=intent.getStringExtra("RAccount");
        phone= intent.getStringExtra("RPhone");
        email=intent.getStringExtra("REmail");
        balance=intent.getStringExtra("RBalance");
        button = findViewById(R.id.transactionLog);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentransactionHistory();
            }
        });
        

    }
    public void opentransactionHistory(){
        Intent intent=new Intent(this,TransactionHistory.class);
        intent.putExtra("RName",name);
        intent.putExtra("RAccount",account);
        intent.putExtra("REmail",email);
        intent.putExtra("RPhone",phone);
        intent.putExtra("RBalance",balance);

        startActivity(intent);
    }
}
