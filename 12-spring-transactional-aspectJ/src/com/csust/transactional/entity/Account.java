package com.csust.transactional.entity;

public class Account {
    private Integer aid;
    private String aname;
    private double balance;

    public Account(String aname, double balance) {
        this.aname = aname;
        this.balance = balance;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
