package org.example.demo.controllers;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class its for MainTab
 */

public class ChangeController implements Initializable {

    //IDs references used for .fxml
    @FXML private Label labelMainTitle;
    @FXML private Label labelChangelog;
    @FXML private TextArea textAreaMain;
    @FXML private ImageView ko_fi;
    private HostServices hostServices;

    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    //Here its set, the Text for different nodes
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle){
        labelChangelog.setText(" changelog\n(for full changelog check github)");
        labelChangelog.setAlignment(Pos.BASELINE_CENTER);
        labelMainTitle.setText("WELCOME!!!");
        labelMainTitle.setAlignment(Pos.BASELINE_CENTER);
        textAreaMain.setText("ver - 0.1 - \nJUST RELEASE!!!");
        textAreaMain.setScrollTop(0);
    }


    @FXML
    public void handleKofi(){
        Tooltip tooltip = new Tooltip("Support 🥹");
        Tooltip.install(ko_fi,tooltip);
        hostServices.showDocument("https://ko-fi.com/tutoq1");
    }
    @FXML
    public void handleGit(){
        hostServices.showDocument("https://github.com/TutoQ1/gw2-Calculator/tree/main");
    }


}
