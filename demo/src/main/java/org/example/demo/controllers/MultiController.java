package org.example.demo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.demo.controllers.methods.ControllersMethods;
import org.example.demo.entity.Valuables;
import org.example.demo.services.Implements.GoldMulti;

import java.net.URL;
import java.util.ResourceBundle;


public class MultiController implements Initializable {

    GoldMulti goldMulti = new GoldMulti();
    ControllersMethods method = new ControllersMethods();

    @FXML private Label lbl_Title;
    @FXML private Label lbl_Sub1;
    @FXML private TextField txt_Gold;
    @FXML private TextField txt_Silver;
    @FXML private TextField txt_Copper;
    @FXML private Button btn_Mul;
    @FXML private Button btn_Result;
    @FXML private Button btn_Reset;
    @FXML private Label lbl_Info;
    @FXML private Label lbl_Gold;
    @FXML private Label lbl_Silver;
    @FXML private Label lbl_Copper;
    @FXML private Label lbl_Error;
    @FXML private TextField txt_Multiplier;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        lbl_Title.setText("GOLD MULTIPLIER");
        lbl_Title.setAlignment(Pos.BASELINE_CENTER);
        lbl_Sub1.setText("Input the asked currency");
        lbl_Sub1.setAlignment(Pos.BASELINE_CENTER);
        lbl_Info.setText("for more info, check the user guide");
        lbl_Info.setAlignment(Pos.BASELINE_CENTER);
        txt_Gold.setPromptText("Gold"); txt_Silver.setPromptText("Silver"); txt_Copper.setPromptText("Copper");txt_Multiplier.setPromptText("number");
        method.hideResultLabels(lbl_Copper,lbl_Silver,lbl_Gold);

    }
    @FXML
    public void handleMore(){
        try {
            lbl_Error.setVisible(false);
            String txtGold = txt_Gold.getText();
            double valueGold = Double.parseDouble(txtGold);

            String txtSilver = txt_Silver.getText();
            double valueSilver = Double.parseDouble(txtSilver);

            String txtCopper = txt_Copper.getText();
            double valueCopper = Double.parseDouble(txtCopper);

            String txtMulti = txt_Multiplier.getText();
            int valueMulti = Integer.parseInt(txtMulti);

            goldMulti.validation(valueGold,valueSilver,valueCopper);
            goldMulti.multiGold(valueGold, valueSilver, valueCopper, valueMulti);

            method.resetValue(txt_Gold, txt_Silver, txt_Copper, txt_Multiplier);

        }catch (IllegalArgumentException e){
            lbl_Error.setVisible(true);
            lbl_Error.setText(e.getMessage());
            lbl_Error.setAlignment(Pos.BASELINE_CENTER);
        }catch (Exception e){
            lbl_Error.setVisible(true);
            lbl_Error.setText("Fill all the fields");
            lbl_Error.setAlignment(Pos.BASELINE_CENTER);
        }
    }

    @FXML
    public void showResult(){
        Valuables valuables = goldMulti.getResult();

        lbl_Gold.setText(String.valueOf((int) valuables.getGold()));
        lbl_Silver.setText(String.valueOf((int) valuables.getSilver()));
        lbl_Copper.setText(String.valueOf((int) valuables.getCopper()));

        method.resetValue(txt_Gold,txt_Silver,txt_Copper,txt_Multiplier);
        method.showResultLabels(lbl_Gold,lbl_Silver,lbl_Copper);
    }
    @FXML
    public void reset(){
        goldMulti.reset();
        method.resetValue(txt_Gold,txt_Silver,txt_Copper,txt_Multiplier);
        method.hideResultLabels(lbl_Gold,lbl_Silver,lbl_Copper);
        lbl_Error.setVisible(false);
    }


}
