package com.example.bankbasic2.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.bankbasic2.model.Accounts;
import com.example.bankbasic2.model.Transactions;
import com.example.bankbasic2.params.Params;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class myDbHandler extends SQLiteOpenHelper
{
    public myDbHandler(Context context)
    {
        super(context, Params.DB_NAME,null,Params.DB_version);

    }
    //Create tables
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE "+Params.TABLE_NAME+"("+Params.KEY_ID+" INTEGER PRIMARY KEY ,"+Params.Name+" TEXT ,"+Params.Phone+" TEXT, "+Params.Email+" TEXT, "+Params.Balance+" INTEGER "+")");
        db.execSQL("CREATE TABLE "+Params.TABLE_NAME_1+"("+Params.KEY_ID1+" INTEGER PRIMARY KEY ,"+Params.Sender+" TEXT ,"+Params.Sender_acc+" TEXT ,"+Params.Receiver+" TEXT ,"+Params.Receiver_acc+" TEXT ,"+Params.Amount+" INTEGER ,"+Params.DateTime+ " TEXT" +")");
        
        Log.d("db","Tables created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    { db.execSQL("DROP TABLE IF EXISTS " + Params.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Params.TABLE_NAME_1);
        onCreate(db);

    }




    //Function to add account
    public void addAccount(Accounts accounts)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        //values.put(Params.KEY_ID,accounts.getId1());
        values.put(Params.Name,accounts.getName());
        values.put(Params.Email,accounts.getEmail());
        values.put(Params.Phone,accounts.getPhone());
        values.put(Params.Balance,accounts.getBalance());

        db.insert(Params.TABLE_NAME,null,values);
       // Log.d("db","Successfully inserted");
        db.close();
    }

    //Function to add transactions
    public void addTransaction(String sender, String receiver, int amount,int rec_bal,int sender_bal)
    {

        Date currentTime = Calendar.getInstance().getTime();
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();
       values.put(Params.Sender_acc,sender_bal);
       values.put(Params.Receiver_acc,rec_bal);
        values.put(Params.Sender,sender);
        values.put(Params.Receiver,receiver);
        values.put(Params.Amount,amount);
        values.put(Params.DateTime, String.valueOf(currentTime));

        db.insert(Params.TABLE_NAME_1,null,values);
        //Log.d("db","Successfully inserted 2");
        db.close();

    }

    //To get list of all the accounts

    public List<Accounts> getAllAccounts()
   {
       List<Accounts> accountsList =new ArrayList<>();
       SQLiteDatabase db =this.getReadableDatabase();

       //Generate the query to read from the database
       String query="SELECT * FROM " + Params.TABLE_NAME;
       Cursor cursor=db.rawQuery(query,null);

       //Loop through rows
       if(cursor.moveToFirst())
       {
           do{
               Accounts accounts=new Accounts();
               accounts.setId1(cursor.getInt(0));
               accounts.setName(cursor.getString(1));
               accounts.setEmail(cursor.getString(3));
               accounts.setPhone(cursor.getString(2));
               accounts.setBalance(cursor.getInt(4));
               accountsList.add(accounts);
           }while (cursor.moveToNext());
       }
       return accountsList;
   }

    //To get list of all the transactions
    public List<Transactions> getAllTransactions()
    {
        List<Transactions> transactionsList =new ArrayList<>();
        SQLiteDatabase db =this.getReadableDatabase();

        //Generate the query to read from the database
        String query="SELECT * FROM " + Params.TABLE_NAME_1;
        Cursor cursor=db.rawQuery(query,null);

        //Loop through rows
        if(cursor.moveToFirst())
        {
            do{
                Transactions transactions=new Transactions();
                transactions.setId2(cursor.getInt(0));
                transactions.setS_name(cursor.getString(1));
                transactions.setS_acc(cursor.getString(2));
                transactions.setR_name(cursor.getString(3));
                transactions.setR_acc(cursor.getString(4));
                transactions.setT_amt(cursor.getInt(5));
                transactions.setDatetime(cursor.getString(6));
                transactionsList.add(transactions);
            }while (cursor.moveToNext());
        }
        return transactionsList;
    }
/*
    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String query="SELECT * FROM " + Params.TABLE_NAME + "WHERE ID "+ id+"";
        Cursor res = db.rawQuery(query,null);
        return res;

    }*/

    public void updateAccount(String name_from, int balance, String name_to, int amount)
        {
            SQLiteDatabase db= this.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put(Params.Name, name_from);
            values.put(Params.Balance, balance);
            //Update now
            db.update(Params.TABLE_NAME,values,Params.KEY_ID+"=?",new String[]{name_from});

            String[] projections ={Params.KEY_ID,Params.Name,Params.Phone,Params.Email,Params.Balance};
            String selection = Params.Name+" LIKE ?";
            String[] selection_args = {name_to};
            Cursor cursor = db.query(Params.TABLE_NAME,projections,selection,selection_args,null,null,null);
            if(cursor.moveToFirst()) {
                Log.d("YES", "send to: " + cursor.getString(1));
                int bal = Integer.parseInt(cursor.getString(4)) + amount;
                ContentValues value = new ContentValues();
                value.put(Params.Name, name_to);
                value.put(Params.Balance, bal);
                db.update(Params.TABLE_NAME, value, Params.Name + "=?", new String[]{name_to});
                Log.d("userdb", "successfully updated to");
                addTransaction(name_from, name_to, amount, bal, balance);
            }
            db.close();

        }
/*
        public int getAccountCount(){
        String query="SELECT * FROM "+Params.TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        return cursor.getCount();
        }
*/
}
