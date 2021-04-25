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

import static java.lang.Integer.parseInt;

public class TransferController {
@FXML private TextField transferTextField,toAccountTextField;
@FXML private Label errorLabel,transferAccountLabel;
private ATM atm;
private int amount;
    @FXML public void initialize(){
        Platform.runLater(new Runnable() { @Override
        public void run() {
            transferAccountLabel.setText("Account: "+atm.getCurrentAccount().getAccountNumber()+" Balance : "+atm.getCurrentAccount().getBalance());
        }
        });}

    @FXML public void handelBtn500OnAction(ActionEvent event) throws IOException {
        amount=500;
        goToConfirmPage(event);
       }


    @FXML public void handelBtn1000OnAction(ActionEvent event) throws IOException {
        amount=1000;
        goToConfirmPage(event);
    }
    @FXML public void handelBtn2000OnAction(ActionEvent event) throws IOException {
        amount=2000;
        goToConfirmPage(event);

    }
    @FXML public void handelBtn5000OnAction(ActionEvent event) throws IOException {
        amount=5000;
        goToConfirmPage(event);

    }

    @FXML public void handelBtn10000OnAction(ActionEvent event) throws IOException {
        amount=10000;
        goToConfirmPage(event);
    }

    @FXML  public void goToConfirmPage(ActionEvent event) throws IOException {
        if(atm.getCurrentAccount().getBalance()>=amount&&!toAccountTextField.getText().isEmpty()&&!toAccountTextField.getText().equalsIgnoreCase(atm.getCurrentAccount().getAccountNumber())&&atm.isThereAnAccount(toAccountTextField.getText())){
            Button b =(Button) event.getSource();
            Stage stage =(Stage) b.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/confirm.fxml"));
            stage.setScene(new Scene(loader.load(),800,600));
            ConfirmController cf =loader.getController();
            cf.setAmount(amount);
            cf.setAtm(atm);
            cf.setTranStat("Transfer");
            cf.setToAccount(toAccountTextField.getText());
            stage.show();
        }
        else if(!atm.isThereAnAccount(toAccountTextField.getText())){
            errorLabel.setText("Not found this account number in system.");
        }
        else if(toAccountTextField.getText().isEmpty()){
            errorLabel.setText("Please enter destination account number.");
        }
        else if(toAccountTextField.getText().equalsIgnoreCase(atm.getCurrentAccount().getAccountNumber())){
            errorLabel.setText("Cannot transfer to the same account");
        }
        else{
            errorLabel.setText("Not enough money !!");
        }
    }
    @FXML public void handleOkBtnOnAction(ActionEvent event) throws IOException {
        amount = parseInt(transferTextField.getText());
        goToConfirmPage(event);
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
public void setATM(ATM atm){
    this.atm=atm;
}
}
