package org.example.demo.controllers.methods;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllersMethods {

    //this method is used to set null txtfields
    public void resetValue(TextField textField, TextField textField2, TextField textField3, TextField textField4){
        textField.setText(null);
        textField2.setText(null);
        textField3.setText(null);
        textField4.setText(null);
    }
    public void resetValue1(TextField textField, TextField textField2, TextField textField3){
        textField.setText(null);
        textField2.setText(null);
        textField3.setText(null);

    }
    //this method is used to hide result labels
    public void hideResultLabels(Label label,Label label2,Label label3){
        label.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
    }
    //this method is used to show result labels
    public void showResultLabels(Label label,Label label2,Label label3){
        label.setVisible(true);
        label2.setVisible(true);
        label3.setVisible(true);
    }
}
