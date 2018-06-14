package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Atm {

     ArrayList<Account> account ;

    public Atm() {
        account = new ArrayList<Account>();
    }

    public void addToAccount(Account addAll){

        this.account.add(addAll);
    }


    public  void userAccountCreate(){
        String userName="";
        int accounNum =0;
        int pin =0;
        double balance=0;
        String createNew ="";

        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("Create New Account");

            System.out.println("Enter user name");
            userName =scan.nextLine();

            System.out.println("Enter account number");
            accounNum = scan.nextInt();
            scan.nextLine();

            System.out.println("Enter pin number");
            pin= scan.nextInt();
            scan.nextLine();

            System.out.println("Enter a initial balance");
            balance = scan.nextDouble();
            scan.nextLine();

            Account ac = new Account(userName,accounNum,pin,balance);
            // adds all the value to the account class that the user inputs
            addToAccount(ac);

            System.out.println("Do you want to create new account y/n");
            createNew = scan.nextLine();

        }while(!createNew.equalsIgnoreCase("n"));

    }

    public void userAuthentication(){

        double deposit = 0;
        double withdrawal = 0;
        double updatedBalance = 0;
        String userName="";
        int accounNum =0;
        int pin =0;
        double balance=0;

        boolean pinCount = false;
        int count =1;
        int numCount =1;

        Scanner input = new Scanner(System.in);

        do{
            System.out.println("Enter your account number");
            accounNum = input.nextInt();
            input.nextLine();

            for(Account a: account){
                if(a.getAcountNum() == accounNum){
                    System.out.println("Enter pin");
                    pin = input.nextInt();
                    input.nextLine();

                    while(numCount < 3){
                        if(a.getPinNum() == pin){
                                System.out.println("Welcome "+ a.getUserName());
                                System.out.println("Enter 1 to deposit, 2 to withdraw and 3 to check balance");
                                int options = input.nextInt();
                                input.nextLine();

                                    if(options == 1){
                                        System.out.println("Enter the amount to deposit");
                                        deposit = input.nextDouble();
                                        input.nextLine();
                                        pinCount = true;
                                    }
                                    else if(options == 2){
                                        System.out.println("Enter the amount to withdraw");
                                        withdrawal = input.nextDouble();
                                        input.nextLine();
                                        pinCount = true;
                                    }
                                    else if(options == 3){
                                        pinCount = true;
                                    }
                                    else{
                                            System.out.println("Invalid Selection");
                                            break;
                                    }


                            if(pinCount){
                                balance = a.getBalance();
                                updatedBalance = balance - withdrawal + deposit;
                                System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
                                System.out.println("Account Number: " + a.getAcountNum());
                                System.out.println("User Name: " + a.getUserName());
                                System.out.println("Initial Balance " + a.getBalance());
                                System.out.println("Final Balance: " + updatedBalance);
                                System.out.println("Withdrawals:  " + withdrawal);
                                System.out.println("Deposit: " + deposit);
                            }
                                numCount =4;

                        }
                        else if(numCount <3 && a.getPinNum() != pin){
                                numCount++;
                                System.out.println("You Entered a wrong pin: Enter your pin number");
                                pin= input.nextInt();
                                input.nextLine();
                                pinCount = false;

                        }
                        else{
                            System.out.println("You entered wrong pin for more than " +
                                    "3 times. you have been logged out of the system");
                        }
                    }

                }
                else{
                    if(count == account.size()){
                        System.out.println("Invalid Account number");
                        break ;
                    }
                    else{
                        count++;
                    }
                }
            }



            System.out.println("Do you want to use the atm again (y/n)");
            String use =input.nextLine();
            if(!use.equalsIgnoreCase("n")){
                numCount =1;
                pinCount =false;
                count=1;
            }
        }while(!userName.equalsIgnoreCase("n"));
    }
}
