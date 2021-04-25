package ATMapp.controllers;

import ATMapp.models.ATM;
import ATMapp.services.ReadWriteAccount;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SuccessController {
    @FXML private Label showLabel,showFinalBalanceLabel;
    @FXML private ImageView home;
    private String tranStat;
    private int amount;
    private ATM atm;
    private ReadWriteAccount readWrite;

@FXML public void initialize(){
    Platform.runLater(new Runnable() {
        @Override public void run() {
            showLabel.setText(tranStat+" "+amount+" THB "+"completed.");
            showFinalBalanceLabel.setText("Account "+atm.getCurrentAccount().getAccountNumber()+" current balance : "+atm.getCurrentAccount().getBalance());
            readWrite = new ReadWriteAccount();
            readWrite.updateAccount(atm.getAccountList()); }
    });

}
public void handleHomeOnAction(MouseEvent event) throws IOException {
    ImageView b=(ImageView) event.getSource();
    Stage stage =(Stage) b.getScene().getWindow();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/deposit_or_withdraw_or_transfer.fxml"));
    stage.setScene(new Scene(loader.load(),800,600));
    DepositOrWithdrawOrTransferController a = loader.getController();
    a.setAtm(atm);
    stage.show();
}
public void setTranStat (String a){
    tranStat=a;
}
public void setAmount(int amount){
    this.amount=amount;
}
public void setAtm(ATM atm){
    this.atm=atm;
}
}
