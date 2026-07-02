package org.example.demo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.example.demo.controllers.methods.MethodController;
import org.example.demo.entity.Valuables;
import org.example.demo.services.Implements.GoldSum;

import java.net.URL;
import java.util.ResourceBundle;

public class SumController implements Initializable {

    @FXML private Label labelTitleSum;
    @FXML private Label labelSubTitleSum1;
    @FXML private Label labelSubTitleSum2;
    @FXML private Label lbl_Gold;
    @FXML private Label lbl_Silver;
    @FXML private Label lbl_Copper;
    @FXML private TextField txtSumGold;
    @FXML private TextField txtSumSilver;
    @FXML private TextField txtSumCopper;
    @FXML private Label lblError;
    @FXML private ImageView gold;
    @FXML private ImageView silver;
    @FXML private ImageView copper;
    @FXML private Label added;

    GoldSum goldSum = new GoldSum();
    MethodController method = new MethodController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelTitleSum.setText("GOLD SUMATORY");
        labelTitleSum.setAlignment(Pos.BASELINE_CENTER);
        labelSubTitleSum1.setText("Input the asked amounts for each currency");
        labelSubTitleSum1.setAlignment(Pos.BASELINE_CENTER);
        labelSubTitleSum2.setText("for more info, check the user guide");
        labelSubTitleSum2.setAlignment(Pos.BASELINE_CENTER);
        txtSumGold.setPromptText("gold");
        txtSumSilver.setPromptText("silver");
        txtSumCopper.setPromptText("copper");
        method.hideResultLabels(lbl_Gold,lbl_Silver,lbl_Copper);
        added.setVisible(false);
        gold.setVisible(false); silver.setVisible(false); copper.setVisible(false);
    }

    @FXML
    public void sumValue(){

            try {
                lblError.setVisible(false);
                //Gold input
                String textGold = txtSumGold.getText();
                double gold1 = Double.parseDouble(textGold);
                //silver input
                String textSilver = txtSumSilver.getText();
                double silver1 = Integer.parseInt(textSilver);
                //copper input
                String textCopper = txtSumCopper.getText();
                double copper1 = Integer.parseInt(textCopper);
                //call the method @sumGold to add amounts until the user stop its

                goldSum.validation(gold1,silver1,copper1);
                goldSum.sumGold(gold1, silver1, copper1);
                method.hideImages(gold,silver,copper);
                method.resetValue1(txtSumGold, txtSumCopper, txtSumSilver);
                method.showTemporary(added,1);

            } catch (IllegalArgumentException e) {
                method.showError(lblError,e);
            } catch (Exception e) {
                lblError.setText("Fill all the fields");
                lblError.setAlignment(Pos.BASELINE_CENTER);
                lblError.setVisible(true);
            }

    }

    @FXML
    public void showResult(){

        lblError.setVisible(false);
        Valuables valuables = goldSum.getSumGold();

        lbl_Gold.setText(String.valueOf((int)valuables.getGold()));
        lbl_Silver.setText(String.valueOf((int) valuables.getSilver()));
        lbl_Copper.setText(String.valueOf((int) valuables.getCopper()));

        method.resetValue1(txtSumGold,txtSumCopper,txtSumSilver);
        method.showResultLabels(lbl_Gold,lbl_Silver,lbl_Copper);
        method.showImages(gold,silver,copper);

    }

    @FXML
    public void reset(){

        method.resetValue1(txtSumGold,txtSumCopper,txtSumSilver);
        method.hideResultLabels(lbl_Gold,lbl_Silver,lbl_Copper);
        lblError.setVisible(false);
        method.hideImages(gold,silver,copper);
        goldSum.reset();
    }
}
