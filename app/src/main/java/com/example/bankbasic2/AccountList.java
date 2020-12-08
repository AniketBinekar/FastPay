package com.example.bankbasic2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.bankbasic2.adapter.RecyclerViewAdapter;
import com.example.bankbasic2.data.myDbHandler;
import com.example.bankbasic2.model.Accounts;

import java.util.ArrayList;
import java.util.List;

public class AccountList extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Accounts> accountsArrayList;
    private ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_list);

        myDbHandler db=new myDbHandler(AccountList.this);

        //Recyclerview initialization
        recyclerView=findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       

        accountsArrayList=new ArrayList<>();


        //Get all accounts
        List<Accounts>accountsList=db.getAllAccounts();
        for(Accounts account:accountsList)
        {
            Log.d("sid","Account: "+account.getId1()+"\n"+
                    "Name: "+account.getName() +"\n"+
                    "Email: "+account.getEmail()+"\n"+
                    "PhoneNO: "+account.getPhone()+"\n"+
                    "Balance: "+account.getBalance());

            accountsArrayList.add(account);
        }

        //Use Recyclerview
        recyclerViewAdapter= new RecyclerViewAdapter(AccountList.this,accountsArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}