package org.example.demo.controllers;

import javafx.application.HostServices;
import javafx.fxml.FXML;

public class MainController {
    @FXML private ChangeController changeController;
    public void setHostService(HostServices hostServices){
        changeController.setHostServices(hostServices);
    }
}
