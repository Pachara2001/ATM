package ATMapp.models;

import static java.lang.Integer.parseInt;

public class BankAccount {
    private String accountNumber;
    private String pin;
    private int balance;

    public BankAccount(String accountNumber,String pin ,String balance){
        this.accountNumber = accountNumber;
        this.balance = parseInt(balance);
        this.pin = pin;
    }
    public void deposit(int amount){
        if(amount>0){
            balance+=amount;
        }
    }

    public void withdraw(int amount){
        if(amount>0&&balance>=amount){
            balance-=amount;
        }

    }

    public void setPin(String pin){
        this.pin=pin;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public String[] getInformation(){
        String[] a = new String[]{accountNumber,pin,Integer.toString(balance)};
        return a;
    }
    @Override
    public String toString() {
        return "Account Number "+accountNumber+" Balance : "+balance;
    }
}
