package ATMapp.controllers;

import ATMapp.models.ATM;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class WithdrawController {

    @FXML private TextField withdrawTxt;
    @FXML private Button btn500, btn1000,btn2000, btn5000,btn10000, withdrawBtn;
    @FXML private Label withdrawAccountLabel,errorLabel;
    @FXML private ImageView backToWithOrDepo;

    private ATM atm;
    private int amount;


 @FXML public void initialize(){
     Platform.runLater(new Runnable() { @Override
         public void run() {
            withdrawAccountLabel.setText("Account: "+atm.getCurrentAccount().getAccountNumber()+" Balance : "+atm.getCurrentAccount().getBalance());
         }
     });



 }

     @FXML public void handelBtn500OnAction(ActionEvent event) throws IOException {
     amount=500;
           if(atm.getCurrentAccount().getBalance()>=amount){
                Button b =(Button) event.getSource();
                Stage stage =(Stage) b.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/confirm.fxml"));
                stage.setScene(new Scene(loader.load(),800,600));
                ConfirmController cf =loader.getController();
                cf.setAmount(amount);
                cf.setAtm(atm);
                cf.setTranStat("Withdraw");

                stage.show();
            }
            else{
                errorLabel.setText("Not enough money !!");
            }}


@FXML public void handelBtn1000OnAction(ActionEvent event) throws IOException {
     amount=1000;
    if(atm.getCurrentAccount().getBalance()>=amount){
        Button b =(Button) event.getSource();
        Stage stage =(Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/confirm.fxml"));
        stage.setScene(new Scene(loader.load(),800,600));
        ConfirmController cf =loader.getController();
        cf.setAmount(amount);
        cf.setAtm(atm);
        cf.setTranStat("Withdraw");

        stage.show();
    }
    else{
        errorLabel.setText("Not enough money !!");
    }

}
    @FXML public void handelBtn2000OnAction(ActionEvent event) throws IOException {
        amount=2000;
        if(atm.getCurrentAccount().getBalance()>=amount){
            Button b =(Button) event.getSource();
            Stage stage =(Stage) b.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/confirm.fxml"));
            stage.setScene(new Scene(loader.load(),800,600));
            ConfirmController cf =loader.getController();
            cf.setAmount(amount);
            cf.setAtm(atm);
            cf.setTranStat("Withdraw");

            stage.show();
        }
        else{
            errorLabel.setText("Not enough money !!");
        }

    }
    @FXML public void handelBtn5000OnAction(ActionEvent event) throws IOException {
        amount=5000;
        if(atm.getCurrentAccount().getBalance()>=amount){
            Button b =(Button) event.getSource();
            Stage stage =(Stage) b.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/confirm.fxml"));
            stage.setScene(new Scene(loader.load(),800,600));
            ConfirmController cf =loader.getController();
            cf.setAmount(amount);
            cf.setAtm(atm);
            cf.setTranStat("Withdraw");

            stage.show();
        }
        else{
            errorLabel.setText("Not enough money !!");
        }

    }

    @FXML public void handelBtn10000OnAction(ActionEvent event) throws IOException {
        amount=10000;
        if(atm.getCurrentAccount().getBalance()>=amount){
            Button b =(Button) event.getSource();
            Stage stage =(Stage) b.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/confirm.fxml"));
            stage.setScene(new Scene(loader.load(),800,600));
            ConfirmController cf =loader.getController();
            cf.setAmount(amount);
            cf.setAtm(atm);
            cf.setTranStat("Withdraw");

            stage.show();
        }
        else{
            errorLabel.setText("Not enough money !!");
        }

    }

    @FXML public void handleWithdrawBtnOnAction(ActionEvent event) throws IOException {
   try{
       amount=Integer.parseInt(withdrawTxt.getText());
     if(atm.getCurrentAccount().getBalance()>=amount){
         Button b =(Button) event.getSource();
         Stage stage =(Stage) b.getScene().getWindow();
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/confirm.fxml"));
         stage.setScene(new Scene(loader.load(),800,600));
         ConfirmController cf =loader.getController();
         cf.setAmount(amount);
         cf.setAtm(atm);
         cf.setTranStat("Withdraw");

         stage.show();
     }
     else{
         errorLabel.setText("Not enough money !!");
     }}
   catch (NumberFormatException e){ errorLabel.setText("Please input integer value.");}


    }
    @FXML public void handelBackToWithOrDepoOrTransOnAction(MouseEvent event) throws IOException {
        ImageView b=(ImageView) event.getSource();
        Stage stage =(Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/deposit_or_withdraw_or_transfer.fxml"));
        stage.setScene(new Scene(loader.load(),800,600));
        DepositOrWithdrawOrTransferController dp=loader.getController();
        dp.setAtm(atm);
        stage.show();
    }


    public void setAtmForWithdraw(ATM atm){
        this.atm =atm;
    }

}
