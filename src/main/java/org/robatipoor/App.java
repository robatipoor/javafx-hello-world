package org.robatipoor;

import java.util.Locale;

import com.github.naoghuman.lib.i18n.core.I18NFacade;
import com.github.naoghuman.lib.i18n.core.I18NResourceBundleBuilder;

import org.robatipoor.util.Resources;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void init() {
        I18NResourceBundleBuilder.configure().baseBundleName("language")
                .supportedLocales(Locale.ENGLISH, Locale.GERMAN)
                .defaultLocale(Locale.ENGLISH).actualLocale(Locale.ENGLISH).build();
                I18NFacade.getDefault().setActualLocale(Locale.GERMAN);
    }

    @Override
    public void start(Stage stage) throws Exception {
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