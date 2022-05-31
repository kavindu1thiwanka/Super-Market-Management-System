package controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomePageFormController {

    public ImageView imageView;
    public AnchorPane context;

    public void initialize(){
        new ShowSplashScreen().start();
    }

    class ShowSplashScreen extends Thread{
        public void run(){
            try{
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                Platform.runLater(() -> {
                    Stage stage = new Stage();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(HomePageFormController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                    context.getScene().getWindow().hide();
                });
            } catch (Exception ex) {
                Logger.getLogger(HomePageFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
