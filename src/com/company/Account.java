package com.company;

public class Account {
    private String userName;
    private int acountNum;
    private int pinNum;
    private double balance;

public Account(String userName, int acountNum, int pinNum, double balance ){


    this. acountNum = acountNum;
    this.userName = userName;
    this.pinNum = pinNum;
    this.balance = balance;
}

    public Account() {
    }

    public String getUserName(){return userName; }

    public void setUserName(String userName){ this.userName = userName; }

    public int getAcountNum() { return acountNum; }

    public void setAcountNum(int acountNum) {   this.acountNum = acountNum; }

    public int getPinNum() {  return pinNum; }

    public void setPinNum(int pinNum) { this.pinNum = pinNum; }

    public double getBalance() {  return balance; }

    public void setBalance(double balance) {  this.balance = balance; }

}
