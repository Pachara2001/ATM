package ATMapp.models;

import java.util.ArrayList;

public class ATM {
    private ArrayList <BankAccount> accounts;
    private BankAccount currentAccount;
    public ATM(){
        accounts = new ArrayList<>();
    }


    public void addAccount(BankAccount acc){
        accounts.add(acc);
    }

    public boolean checkPin(String number,String pin){
        for(BankAccount i : accounts){
            if(number.equalsIgnoreCase(i.getAccountNumber())){
                if(pin.equals(i.getPin())) {
                    currentAccount = i;
                    return true;
                }
                else throw new IllegalArgumentException("Wrong password !!");
            }
        }
        throw new IllegalArgumentException("Wrong account number !!");
    }

    public BankAccount getCurrentAccount() {
        return currentAccount;
    }
    public ArrayList<BankAccount> getAccountList(){return  accounts;}


    public void transfer(String toAccountNo,int amount){
            if(isThereAnAccount(toAccountNo)) {
                currentAccount.withdraw(amount);
                BankAccount i = getSpecificAccount(toAccountNo);
                i.deposit(amount);
            }
    }
    public boolean isThereAnAccount(String accountNumber){
        for(BankAccount i : accounts){
            if(i.getAccountNumber().equals(accountNumber)) return true;
        }
        return false;
    }
    public BankAccount getSpecificAccount(String accountNumber){
        for(BankAccount i : accounts){
            if(i.getAccountNumber().equals(accountNumber)) return i;
        }
        throw new IllegalArgumentException("Not found this account number in system.");
    }
    @Override
    public String toString() {
        return accounts.toString();
    }
}
