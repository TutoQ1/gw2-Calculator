package org.example.demo.controllers.methods;

import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class MethodController {

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

    //Those methods are used for @MultiController convenience-------------
    public void hideResultLabels1(Label label, Label label2){
        label.setVisible(false);
        label2.setVisible(false);
    }
    public void showResultLabels1(Label label, Label label2){
        label.setVisible(true);
        label2.setVisible(true);
    }

    public void showError(Label lbl,Exception e){
        lbl.setText(e.getMessage());
        lbl.setAlignment(Pos.BASELINE_CENTER);
        lbl.setVisible(true);
    }
    //---------------------------------------------------------------------

    public void hideImages(ImageView image, ImageView image2, ImageView image3){
        image.setVisible(false);
        image2.setVisible(false);
        image3.setVisible(false);
    }
    public void showImages(ImageView image, ImageView image2, ImageView image3){
        image.setVisible(true);
        image2.setVisible(true);
        image3.setVisible(true);
    }

    public void showTemporary(Label label, double time){
        label.setVisible(true);

        PauseTransition pause = new PauseTransition(Duration.seconds(time));
        pause.setOnFinished(event -> label.setVisible(false));
        pause.play();
    }
}
