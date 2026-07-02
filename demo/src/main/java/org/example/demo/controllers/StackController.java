package org.example.demo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.TextAlignment;
import org.example.demo.controllers.methods.MethodController;
import org.example.demo.services.Implements.GoldStack;

import java.net.URL;
import java.util.ResourceBundle;
public class StackController implements Initializable {

    MethodController method = new MethodController();
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
    @FXML private Label stack;
    @FXML private Label unit;
    @FXML private Label added;

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
        added.setVisible(false);
        stack.setVisible(false); unit.setVisible(false);
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
            int stack1 = Integer.parseInt(txtStack);

            goldStack.validation(gold,silver,copper,stack1);
            goldStack.stackGold(gold,silver,copper,stack1);
            method.resetValue(txt_Gold,txt_Silver,txt_Copper,txt_value);
            method.hideResultLabels1(stack ,unit);
            method.showTemporary(added,1);

        }catch (IllegalArgumentException e){
            method.showError(lbl_Error,e);

        }catch (Exception e) {
            lbl_Error.setVisible(true);
            lbl_Error.setText("Fill all the fields");
            lbl_Error.setAlignment(Pos.BASELINE_CENTER);
        }
    }
    @FXML
    public void showResult(){
        lbl_Error.setVisible(false);

        int value = (int) goldStack.showValueResult();
        lbl_Value.setTextAlignment(TextAlignment.RIGHT);
        lbl_Value.setText(String.valueOf(value));

        double decimal = goldStack.showDecimal();
        lbl_Decimal.setText(String.valueOf(decimal));

        method.showResultLabels1(lbl_Value,lbl_Decimal);
        method.showResultLabels1(stack,unit);

    }
    @FXML
    public void reset(){
        goldStack.reset1();
        method.hideResultLabels1(lbl_Value,lbl_Decimal);
        lbl_Error.setVisible(false);
        method.hideResultLabels1(stack ,unit);

    }
}

