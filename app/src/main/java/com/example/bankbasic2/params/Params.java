package com.example.bankbasic2.params;

public class Params {
    public static final int DB_version=28;
    public static final String DB_NAME="ACCOUNTS.db";
    public static final String TABLE_NAME="Accounts_table";
    public static final String TABLE_NAME_1="Transactions_table";

    //keys in first table
    public static final String KEY_ID="account_no";
    public static final String Name="name";
    public static final String Phone="phone_no";
    public static final String Email="email_id";
    public static final String Balance="balance";

    //keys in second table
    public static final String KEY_ID1="transaction_no";
    public static final String Sender="s_name";
    public static final String Sender_acc="s_acc";
    public static final String Receiver="r_name";
    public static final String Receiver_acc="r_acc";
    public static final String Amount="t_amount";
    public static final String DateTime = "datetime";



}
