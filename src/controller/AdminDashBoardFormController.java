package controller;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class AdminDashBoardFormController {
    public ImageView imgReport;
    public ImageView imgDetail;
    public ImageView imgItems;
    public Label lblMenu;
    public Label lblDescription;
    public AnchorPane root;


    public void playMouseEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            switch (icon.getId()) {
                case "imgReport":
                    lblMenu.setText("Manage Report");
                    lblDescription.setText("Click search or view all reports");
                    break;
                case "imgDetail":
                    lblMenu.setText("View Detail");
                    lblDescription.setText("Click to search or view all options");
                    break;
                case "imgItems":
                    lblMenu.setText("Manage Items");
                    lblDescription.setText("Click to add, edit, delete, search or view items");
                    break;
            }

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }

    public void playMouseExitAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
            lblMenu.setText("Welcome");
            lblDescription.setText("Please select one of above main operations to proceed");
        }
    }

    public void navigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "imgReport":
                    root = FXMLLoader.load(this.getClass().getResource("/view/ManageReportForm.fxml"));
                    break;
                case "imgDetail":
                    root = FXMLLoader.load(this.getClass().getResource("/view/ViewDetailForm.fxml"));
                    break;
                case "imgItems":
                    root = FXMLLoader.load(this.getClass().getResource("/view/ManageItemForm.fxml"));
                    break;
            }

            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();
            }
        }
    }

    public void navigateToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/LoginForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }


    public void closeWindowOnAction(ActionEvent actionEvent) {
        javafx.application.Platform.exit();
    }
}
