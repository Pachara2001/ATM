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

public class DepositController {
    @FXML private Button okBtn;
    @FXML private TextField depositTextField;
    @FXML private ImageView backToWithOrDepo;
    @FXML private Label showAccount,error;
    private ATM atm;
    private int amount;

    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                showAccount.setText("Account: " + atm.getCurrentAccount().getAccountNumber() + " Balance : " + atm.getCurrentAccount().getBalance());
            }
        });

    }
    public void handleOkbtnOnAction(ActionEvent event) throws IOException {

        try{
            amount=Integer.parseInt(depositTextField.getText());
            if(amount>0){
                Button b =(Button) event.getSource();
                Stage stage =(Stage) b.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/confirm.fxml"));
                stage.setScene(new Scene(loader.load(),800,600));
                ConfirmController cf =loader.getController();
                cf.setAmount(amount);
                cf.setAtm(atm);
                cf.setTranStat("Deposit");
            }
            else{error.setText("Invalid input, please try again.");}
        }
        catch (NumberFormatException e){ error.setText("Please input integer value.");}
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

    public void setAtm(ATM atm){
        this.atm=atm;
    }

}