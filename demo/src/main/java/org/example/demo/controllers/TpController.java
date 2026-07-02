package org.example.demo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.example.demo.controllers.methods.MethodController;
import org.example.demo.entity.Valuables;
import org.example.demo.services.Implements.GoldTp;

import java.net.URL;
import java.util.ResourceBundle;

public class TpController implements Initializable {
    MethodController method = new MethodController();
    GoldTp goldTp = new GoldTp();

    @FXML private Label lbl_Title;
    @FXML private Label lbl_Sub1;
    @FXML private TextField txt_Gold;
    @FXML private TextField txt_Silver;
    @FXML private TextField txt_Copper;
    @FXML private Label lbl_Info;
    @FXML private Label lbl_Gold;
    @FXML private Label lbl_Silver;
    @FXML private Label lbl_Copper;
    @FXML private Label lbl_Error;
    @FXML private TextField txt_value;
    @FXML private TextField txt_Tp;
    @FXML private ImageView gold;
    @FXML private ImageView silver;
    @FXML private ImageView copper;
    @FXML private Label added;

    @Override
    public void initialize(URL url, ResourceBundle bundle){
        lbl_Title.setText("TP@ VALUER");
        lbl_Title.setAlignment(Pos.BASELINE_CENTER);
        lbl_Sub1.setText("Input the asked currency");
        lbl_Sub1.setAlignment(Pos.BASELINE_CENTER);
        lbl_Info.setText("for more info, check the user guide");
        lbl_Info.setAlignment(Pos.BASELINE_CENTER);
        txt_Gold.setPromptText("Gold"); txt_Silver.setPromptText("Silver"); txt_Copper.setPromptText("Copper");
        txt_value.setPromptText("number"); txt_Tp.setPromptText("TP@");
        method.hideResultLabels(lbl_Gold,lbl_Silver,lbl_Copper);
        method.hideImages(gold,silver,copper);
        added.setVisible(false);
    }
    @FXML
    public void handleMore(){
        try {
            String txtGold = txt_Gold.getText();
            double gold1 = Double.parseDouble(txtGold);
            String txtSilver = txt_Silver.getText();
            double silver1 = Double.parseDouble(txtSilver);
            String txtCopper = txt_Copper.getText();
            double copper1 = Double.parseDouble(txtCopper);
            String txtStack = txt_value.getText();
            int stack = Integer.parseInt(txtStack);
            String txtTp = txt_Tp.getText();
            double tp = Double.parseDouble(txtTp);

            goldTp.validation(gold1, silver1, copper1, stack, tp);
            goldTp.goldTp(gold1, silver1, copper1, stack, tp);
            method.resetValue(txt_Gold,txt_Silver,txt_Copper,txt_Tp);txt_value.setText(null);
            method.hideResultLabels(lbl_Gold,lbl_Silver,lbl_Copper);
            method.hideImages(gold,silver,copper);
            method.showTemporary(added,1);

        }catch (IllegalArgumentException e){
            method.showError(lbl_Error,e);
        }catch (Exception e){
            lbl_Error.setText("Fill all the fields");
            lbl_Error.setAlignment(Pos.BASELINE_CENTER);
            lbl_Error.setVisible(true);
        }
    }
    @FXML
    public void showResult(){
        Valuables valuables = goldTp.getResult();

        lbl_Error.setVisible(false);
        lbl_Gold.setText(String.valueOf((int)valuables.getGold()));
        lbl_Silver.setText(String.valueOf((int)valuables.getSilver()));
        lbl_Copper.setText(String.valueOf((int)valuables.getCopper()));

        method.showResultLabels(lbl_Gold,lbl_Silver,lbl_Copper);
        method.showImages(gold,silver,copper);
        method.resetValue(txt_Gold,txt_Silver,txt_Copper,txt_Tp);txt_value.setText(null);
    }
    @FXML
    public void reset(){
        goldTp.reset1();
        method.hideResultLabels(lbl_Gold,lbl_Silver,lbl_Copper);
        method.resetValue(txt_Gold,txt_Silver,txt_Copper,txt_Tp);txt_value.setText(null);
        lbl_Error.setVisible(false);
        method.hideImages(gold,silver,copper);

    }
}
