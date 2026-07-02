package org.example.demo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.example.demo.controllers.methods.MethodController;
import org.example.demo.entity.Valuables;
import org.example.demo.services.Implements.GoldSub;

import java.net.URL;
import java.util.ResourceBundle;

public class SubController implements Initializable {

    MethodController method = new MethodController();
    GoldSub goldSub = new GoldSub();

    @FXML private Label lbl_Title;
    @FXML private Label lbl_Sub1;
    @FXML private TextField txt_Gold;
    @FXML private TextField txt_Silver;
    @FXML private TextField txt_Copper;
    @FXML private TextField txt_Gold1;
    @FXML private TextField txt_Silver1;
    @FXML private TextField txt_Copper1;
    @FXML private Label lbl_Info;
    @FXML private Label lbl_Gold;
    @FXML private Label lbl_Silver;
    @FXML private Label lbl_Copper;
    @FXML private Label lbl_Error;
    @FXML private Label added;
    @FXML private ImageView gold;
    @FXML private ImageView silver;
    @FXML private ImageView copper;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lbl_Title.setText("GOLD SUBTRACTOR");
        lbl_Title.setAlignment(Pos.BASELINE_CENTER);
        lbl_Sub1.setText("Input the asked currency");
        lbl_Sub1.setAlignment(Pos.BASELINE_CENTER);
        lbl_Info.setText("for more info, check the user guide");
        lbl_Info.setAlignment(Pos.BASELINE_CENTER);
        txt_Gold.setPromptText("Gold"); txt_Silver.setPromptText("Silver"); txt_Copper.setPromptText("Copper");
        txt_Gold1.setPromptText("Gold"); txt_Silver1.setPromptText("Silver"); txt_Copper1.setPromptText("Copper");
        method.hideResultLabels(lbl_Copper,lbl_Silver,lbl_Gold);
        method.hideImages(gold,silver,copper);
        added.setVisible(false);
    }
    @FXML
    public void handleMore(){

        try {
            String txtGold1 = txt_Gold.getText();
            int gold1 = Integer.parseInt(txtGold1);

            String txtSilver1 = txt_Silver.getText();
            int silver1 = Integer.parseInt(txtSilver1);

            String txtCopper1 = txt_Copper.getText();
            int copper1 = Integer.parseInt(txtCopper1);

            String txtGold2 = txt_Gold1.getText();
            int gold_2 = Integer.parseInt(txtGold2);

            String txtSilver2 = txt_Silver1.getText();
            int silver_2 = Integer.parseInt(txtSilver2);

            String txtCopper2 = txt_Copper.getText();
            int copper_2 = Integer.parseInt(txtCopper2);

            goldSub.validation(gold1, silver1, copper1);
            goldSub.validation(gold_2, silver_2, copper_2);
            goldSub.getValue1(gold1,silver1,copper1);
            goldSub.getValue2(gold_2,silver_2,copper_2);
            method.resetValue1(txt_Gold,txt_Silver,txt_Copper);
            method.resetValue1(txt_Gold1,txt_Silver1,txt_Copper1);
            method.hideResultLabels(lbl_Gold,lbl_Silver,lbl_Copper);
            method.hideImages(gold,silver,copper);
            method.showTemporary(added,1);

        }catch (IllegalArgumentException e){
            method.showError(lbl_Error,e);
        } catch (Exception e) {
            lbl_Error.setAlignment(Pos.BASELINE_CENTER);
            lbl_Error.setText("INVALID INPUT");
            lbl_Error.setVisible(true);
        }
    }

    @FXML
    public void showResult(){
        Valuables valuables = goldSub.getSubGold();

        lbl_Error.setVisible(false);
        lbl_Gold.setText(String.valueOf((int)valuables.getGold()));
        lbl_Silver.setText(String.valueOf((int) valuables.getSilver()));
        lbl_Copper.setText(String.valueOf((int)valuables.getCopper()));

        method.showResultLabels(lbl_Gold,lbl_Silver,lbl_Copper);
        method.resetValue1(txt_Gold,txt_Silver,txt_Copper);
        method.resetValue1(txt_Gold1,txt_Silver1,txt_Copper1);
        method.showImages(gold,silver,copper);
    }

    @FXML
    public void reset(){
        goldSub.reset();
        method.hideResultLabels(lbl_Gold,lbl_Silver,lbl_Copper);
        method.resetValue1(txt_Gold,txt_Silver,txt_Copper);
        method.resetValue1(txt_Gold1,txt_Silver1,txt_Copper1);
        method.hideImages(gold,silver,copper);
        lbl_Error.setVisible(false);

    }
}
