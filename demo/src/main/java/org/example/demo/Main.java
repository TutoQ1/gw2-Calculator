package org.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.demo.controllers.ChangeController;
import org.example.demo.controllers.MainController;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/org/example/demo/Main.fxml"));
        Image icon = new Image(Main.class.getResourceAsStream("/org/example/demo/images/gold.png"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

       MainController controller = fxmlLoader.getController();
       controller.setHostService(getHostServices());


        stage.getIcons().addAll(icon);
        stage.setTitle("Gw2 Calculator");
        stage.setScene(scene);
        stage.show();
    }
}
