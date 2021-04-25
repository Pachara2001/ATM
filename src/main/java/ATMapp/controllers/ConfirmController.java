package ATMapp.controllers;

import ATMapp.models.ATM;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class ConfirmController {
    @FXML private Label confirmLabel;
    @FXML private Button yesCfBtn,noCfBtn;
    private int amount;
    private ATM atm;
    private String tranStat,toAccount;


    @FXML public void initialize(){
        Platform.runLater(new Runnable() {
            @Override public void run() {
                if(tranStat=="Withdraw"){
                confirmLabel.setText(tranStat+" : "+amount+"THB from account : "+atm.getCurrentAccount().getAccountNumber()+" ?");
            }
                else if(tranStat=="Transfer"){
                    confirmLabel.setText(tranStat+" : "+amount+"THB to this account : "+toAccount+" ?");
                }
                else{confirmLabel.setText(tranStat+" : "+amount+"THB to account : "+atm.getCurrentAccount().getAccountNumber()+" ?");}
            }
        });
    }
    @FXML public void handleYesCfBtn (ActionEvent event) throws IOException {
        Button b =(Button) event.getSource();
        Stage stage =(Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/success.fxml"));
        stage.setScene(new Scene(loader.load(),800,600));
        SuccessController sc = loader.getController();
        sc.setTranStat(tranStat);
        sc.setAmount(amount);
        if(tranStat=="Withdraw"){atm.getCurrentAccount().withdraw(amount);}
        else if(tranStat=="Transfer"){atm.transfer(toAccount,amount);}
        else{atm.getCurrentAccount().deposit(amount);}
        sc.setAtm(atm);
        stage.show();
    }
    @FXML public void handleNoBtn (ActionEvent event) throws IOException{
        Button b =(Button) event.getSource();
        Stage stage =(Stage) b.getScene().getWindow();
        if(tranStat=="Withdraw"){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/withdraw_page.fxml"));
            stage.setScene(new Scene(loader.load(),800,600));
            WithdrawController wd=loader.getController();
            wd.setAtmForWithdraw(atm);
            stage.show();}
        else if(tranStat=="Transfer"){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/transfer.fxml"));
            stage.setScene(new Scene(loader.load(),800,600));
            TransferController tf=loader.getController();
            tf.setATM(atm);
            stage.show();}

        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/deposit_page.fxml"));
            stage.setScene(new Scene(loader.load(),800,600));
            DepositController dp = loader.getController();
            dp.setAtm(atm);
            stage.show();
        }

    }


    public void setAtm(ATM atm){this.atm=atm;}
    public void setAmount(int amount){this.amount=amount;}
    public void setTranStat(String a){tranStat=a;}
    public  void setToAccount(String a){toAccount=a; }
}
