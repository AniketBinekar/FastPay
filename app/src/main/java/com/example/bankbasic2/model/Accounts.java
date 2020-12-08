package com.example.bankbasic2.model;

public class Accounts
{
    private int id1;
    private String name;
    private String email;
    private String phone;
    private int balance;

    public Accounts(int id1, String name, String email, String phone, int balance) {
        this.id1 = id1;
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.phone = phone;
    }
    public Accounts(int id1, String name, String email, String phone) {
        this.id1 = id1;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }
    public Accounts(int id1, String name, String phone) {
        this.id1 = id1;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }
    public Accounts() {
        this.id1 = id1;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
