package org.example.demo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.demo.entity.Valuables;
import org.example.demo.services.Implements.GoldSum;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SumController implements Initializable {
    @FXML private Label labelTitleSum;
    @FXML private Label labelSubTitleSum1;
    @FXML private Label labelSubTitleSum2;
    @FXML private Label labelSumGold;
    @FXML private Label labelSumSilver;
    @FXML private Label labelSumCopper;
    @FXML private TextField txtSumGold;
    @FXML private TextField txtSumSilver;
    @FXML private TextField txtSumCopper;
    @FXML private Button btnSumPlus;
    @FXML private Button btnSumResult;
    @FXML private Label lblError;

    GoldSum goldSum = new GoldSum();

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
        labelSumGold.setText("0");
        labelSumSilver.setText("0");
        labelSumCopper.setText("0");
    }

    @FXML
    public void sumValue(){

        try {
            //Gold input
            String textGold = txtSumGold.getText();
            double gold = Double.parseDouble(textGold);
            //silver input
            String textSilver = txtSumSilver.getText();
            double silver = Integer.parseInt(textSilver);
            //copper input
            String textCopper = txtSumCopper.getText();
            double copper = Integer.parseInt(textCopper);
            //call the method @sumGold to add amounts until the user stop its
            goldSum.sumGold(gold,silver,copper);
            txtSumGold.setText(null);
            txtSumSilver.setText(null);
            txtSumCopper.setText(null);

        } catch (Exception e) {
            lblError.setText("ERROR, Fill all the fields");
            lblError.setAlignment(Pos.BASELINE_CENTER);
            lblError.setVisible(true);
        }

    }

    @FXML
    public void showResult(){

        lblError.setVisible(false);
        Valuables valuables = goldSum.getSumGold();

        labelSumGold.setText(String.valueOf((int)valuables.getGold()));
        labelSumSilver.setText(String.valueOf((int) valuables.getSilver()));
        labelSumCopper.setText(String.valueOf((int) valuables.getCopper()));

        txtSumGold.setText(null);
        txtSumSilver.setText(null);
        txtSumCopper.setText(null);

    }

    @FXML
    public void reset(){
        labelSumGold.setText("0");
        labelSumSilver.setText("0");
        labelSumCopper.setText("0");
        txtSumGold.setText(null);
        txtSumSilver.setText(null);
        txtSumCopper.setText(null);

        goldSum.reset();
    }
}
