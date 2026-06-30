package org.example.demo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class its for MainTab
 */

public class MainController implements Initializable {

    //IDs references used for .fxml
    @FXML private Label labelMainTitle;
    @FXML private Label labelChangelog;
    @FXML private TextArea textAreaMain;

    //Here its set the Text for different nodes
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle){
        labelChangelog.setText(" changelog\n(for full changelog check github)");
        labelChangelog.setAlignment(Pos.BASELINE_CENTER);
        labelMainTitle.setText("WELCOME!!!");
        labelMainTitle.setAlignment(Pos.BASELINE_CENTER);
        textAreaMain.setText("ver - 0.1 - \nJUST RELEASE!!!");
        textAreaMain.setScrollTop(0);
    }


}
