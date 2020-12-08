package com.example.bankbasic2;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bankbasic2.R;
import com.example.bankbasic2.data.myDbHandler;
import com.example.bankbasic2.model.Transactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistory extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        //ListView
        ListView listView;
        listView = findViewById(R.id.listView);

        ArrayList<String> transactions = new ArrayList<>();
        myDbHandler db  = new myDbHandler(TransactionHistory.this);

        List<Transactions> transactionList = db.getAllTransactions();
        for (Transactions transaction: transactionList) {
            transactions.add("From: "+transaction.getS_name()+
                    "\nTo: "+transaction.getR_name()+
                    "\nAmount: "+transaction.getT_amt()+
                    "\nTime: "+transaction.getDatetime()+
                    "\nAvailable Balance: "+transaction.getS_acc());

        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,transactions);
        listView.setAdapter(arrayAdapter);
    }


}

