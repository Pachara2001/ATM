package ATMapp.controllers;

import ATMapp.models.ATM;
import ATMapp.services.ReadWriteAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private PasswordField passwordField;
    @FXML private TextField accountNoTextField ;
    @FXML private Button okBtn;
    @FXML private Label errorLabel;
    private ATM atm;
    private ReadWriteAccount readWrite;
    @FXML public  void initialize(){
        atm = new ATM();
        readWrite = new ReadWriteAccount();
        readWrite.readAccount(atm.getAccountList());
    }
    // handle + NodeName + NodeType
    @FXML public void handleOkBtnOnAction(ActionEvent event) throws IOException {

        try{

            if(atm.checkPin(accountNoTextField.getText(),passwordField.getText()));{
                okBtn = (Button) event.getSource();
                Stage stage =(Stage) okBtn.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/deposit_or_withdraw_or_transfer.fxml"));
                stage.setScene(new Scene(loader.load(),800,600));
                DepositOrWithdrawOrTransferController dw = loader.getController();
                dw.setAtm(atm);
                stage.show();
            }
        }
        catch (IllegalArgumentException e){errorLabel.setText(e.getMessage());}

    }
}
