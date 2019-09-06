package org.robatipoor;

import org.robatipoor.util.Resources;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        long l = 45l;
        int i = (int)l;
        System.out.println(i);
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Resources.getURLFXMLFile("main-list"));
        AnchorPane anchorPane = fxmlLoader.<AnchorPane>load();
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}