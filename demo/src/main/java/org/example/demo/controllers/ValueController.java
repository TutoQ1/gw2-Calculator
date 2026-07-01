package org.example.demo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.demo.controllers.methods.ControllersMethods;
import org.example.demo.services.Implements.GoldStack;

import java.net.URL;
import java.util.ResourceBundle;
public class ValueController implements Initializable {

    ControllersMethods method = new ControllersMethods();
    GoldStack goldStack = new GoldStack();

    @FXML private Label lbl_Title;
    @FXML private Label lbl_Sub1;
    @FXML private TextField txt_Gold;
    @FXML private TextField txt_Silver;
    @FXML private TextField txt_Copper;
    @FXML private Label lbl_Info;
    @FXML private Label lbl_Value;
    @FXML private Label lbl_Decimal;
    @FXML private Label lbl_Error;
    @FXML private TextField txt_value;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        lbl_Title.setText("VALUE IN STACKS");
        lbl_Title.setAlignment(Pos.BASELINE_CENTER);
        lbl_Sub1.setText("Input the asked currency");
        lbl_Sub1.setAlignment(Pos.BASELINE_CENTER);
        lbl_Info.setText("for more info, check the user guide");
        lbl_Info.setAlignment(Pos.BASELINE_CENTER);
        txt_Gold.setPromptText("Gold"); txt_Silver.setPromptText("Silver"); txt_Copper.setPromptText("Copper");txt_value.setPromptText("number");
        method.hideResultLabels1(lbl_Decimal,lbl_Value);

    }

    @FXML
    public void handleMore(){

        try{
            String txtGold = txt_Gold.getText();
            double gold = Double.parseDouble(txtGold);
            String txtSilver = txt_Silver.getText();
            double silver = Double.parseDouble(txtSilver);
            String txtCopper = txt_Copper.getText();
            double copper = Double.parseDouble(txtCopper);
            String txtStack = txt_value.getText();
            int stack = Integer.parseInt(txtStack);

            goldStack.validation(gold,silver,copper,stack);
            goldStack.stackGold(gold,silver,copper,stack);
            method.resetValue(txt_Gold,txt_Silver,txt_Copper,txt_value);

        }catch (IllegalArgumentException e){
            lbl_Error.setVisible(true);
            lbl_Error.setText(e.getMessage());
            lbl_Error.setAlignment(Pos.BASELINE_CENTER);

        }catch (Exception e) {
            lbl_Error.setVisible(true);
            lbl_Error.setText("Fill all the fields");
            lbl_Error.setAlignment(Pos.BASELINE_CENTER);
        }   
    }
    @FXML
    public void showResult(){
       int value = (int) goldStack.showValueResult();
       lbl_Value.setText(String.valueOf(value));

       double decimal = goldStack.showDecimal();
       lbl_Decimal.setText(String.valueOf(decimal));

       method.showResultLabels1(lbl_Value,lbl_Decimal);

    }
    @FXML
    public void reset(){
        goldStack.reset1();
        method.hideResultLabels1(lbl_Value,lbl_Decimal);
        lbl_Error.setVisible(false);

    }
}

