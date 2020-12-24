package com;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Controller {
    @FXML
    TextField name;
    @FXML
    TextField amount;
    @FXML
    Label count;
    @FXML
    Label name1;
    @FXML
    Label name2;
    @FXML
    Label name3;
    @FXML
    Label name4;
    @FXML
    Label name5;
    @FXML
    Label name6;
    @FXML
    Label name7;
    @FXML
    Label amount1;
    @FXML
    Label amount2;
    @FXML
    Label amount3;
    @FXML
    Label amount4;
    @FXML
    Label amount5;
    @FXML
    Label amount6;
    @FXML
    Label amount7;

    Boolean limitReached = false;
    public void load(){
        DebtConnectDB debtConnectDB = new DebtConnectDB();
        List<Debt> debts = debtConnectDB.getAllDebts();
        count.setText("Count: " + debts.size());
        if(debts.size()>=7){
            limitReached = true;
        }
        try{
            name1.setText(debts.get(0).getPersonName());
            amount1.setText(debts.get(0).getAmount());
            name2.setText(debts.get(1).getPersonName());
            amount2.setText(debts.get(1).getAmount());
            name3.setText(debts.get(2).getPersonName());
            amount3.setText(debts.get(2).getAmount());
            name4.setText(debts.get(3).getPersonName());
            amount4.setText(debts.get(3).getAmount());
            name5.setText(debts.get(4).getPersonName());
            amount5.setText(debts.get(4).getAmount());
            name6.setText(debts.get(5).getPersonName());
            amount6.setText(debts.get(5).getAmount());
            name7.setText(debts.get(6).getPersonName());
            amount7.setText(debts.get(6).getAmount());
        }
        catch (IndexOutOfBoundsException ex){
            switch (debts.size()){
                case 0: name1.setText("");
                    amount1.setText("");
                case 1: name2.setText("");
                    amount2.setText("");
                case 2: name3.setText("");
                    amount3.setText("");
                case 3: name4.setText("");
                    amount4.setText("");
                case 4: name5.setText("");
                    amount5.setText("");
                case 5: name6.setText("");
                    amount6.setText("");
                case 6: name7.setText("");
                    amount7.setText("");
            }
        }
    }
    public void save() throws IOException {
        DebtConnectDB debtConnectDB = new DebtConnectDB();
        if(!limitReached){
            debtConnectDB.saveDebt(new Debt(name.getText(), amount.getText()));
        }
        else{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Error.fxml"));
            stage.setTitle("Error!");
            Scene scene = new Scene(root,250, 100);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        }
        load();
    }
    public void reset(){
        DebtConnectDB debtConnectDB = new DebtConnectDB();
        debtConnectDB.resetDatabase();
        load();
        limitReached = false;
    }
}
