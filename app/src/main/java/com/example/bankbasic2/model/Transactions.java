package com.example.bankbasic2.model;

public class Transactions
{
    private String s_name;
    private String r_name;
    private int t_amt;
    private String s_acc;
    private String r_acc;
    private int id2;
    private String datetime;

    public Transactions(String s_name, String r_name, int t_amt, String s_acc, String r_acc, int id2) {
        this.s_name = s_name;
        this.r_name = r_name;
        this.t_amt = t_amt;
        this.s_acc = s_acc;
        this.r_acc = r_acc;
        this.id2 = id2;
    }

    public Transactions(String s_name, String r_name, int t_amt) {
        this.s_name = s_name;
        this.r_name = r_name;
        this.t_amt = t_amt;
    }
    public Transactions() {
        this.s_name = s_name;
        this.r_name = r_name;
        this.t_amt = t_amt;
        this.s_acc = s_acc;
        this.r_acc = r_acc;
        this.id2 = id2;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public int getT_amt() {
        return t_amt;
    }

    public void setT_amt(int t_amt) {
        this.t_amt = t_amt;
    }

    public String getS_acc() {
        return s_acc;
    }

    public void setS_acc(String s_acc) {
        this.s_acc = s_acc;
    }

    public String getR_acc() {
        return r_acc;
    }

    public void setR_acc(String r_acc) {
        this.r_acc = r_acc;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }
}
