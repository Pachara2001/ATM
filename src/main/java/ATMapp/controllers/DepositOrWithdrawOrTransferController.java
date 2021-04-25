package ATMapp.controllers;

import ATMapp.models.ATM;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;

public class DepositOrWithdrawOrTransferController {
    @FXML private Button depositBtn,withdrawBtn,transferBtn;
    @FXML private Label accountLabel;
    @FXML private ImageView backToSample;

    private ATM atm;

    @FXML public void initialize(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                accountLabel.setText("Account: "+atm.getCurrentAccount().getAccountNumber()+" Balance: "+atm.getCurrentAccount().getBalance());
            }
        });

    }
    @FXML public  void handleDepositBtnOnAction(ActionEvent event) throws IOException {
        Button depo = (Button) event.getSource();
        Stage stage = (Stage) depo.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/deposit_page.fxml"));
        stage.setScene(new Scene(loader.load(),800,600));
        DepositController dp=loader.getController();
        dp.setAtm(atm);
        stage.show();
    }
    @FXML public void handleWithdrawBtnOnAction(ActionEvent event) throws IOException {
        Button depo = (Button) event.getSource();
        Stage stage = (Stage) depo.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/withdraw_page.fxml"));
        stage.setScene(new Scene(loader.load(),800,600));
        WithdrawController wd=loader.getController();
        wd.setAtmForWithdraw(atm);
        stage.show();
    }

    @FXML public void handelBackToSampleOnAction(MouseEvent event) throws IOException {
        ImageView b=(ImageView) event.getSource();
        Stage stage =(Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample.fxml"));
        stage.setScene(new Scene(loader.load(),800,600));
        stage.show();
    }
    @FXML public void handleTransferBtnOnAction(ActionEvent event) throws IOException {
        Button depo = (Button) event.getSource();
        Stage stage = (Stage) depo.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/transfer.fxml"));
        stage.setScene(new Scene(loader.load(),800,600));
        TransferController tf=loader.getController();
        tf.setATM(atm);
        stage.show();
    }
    public void setAtm(ATM atm){
        this.atm =atm;
    }
}
