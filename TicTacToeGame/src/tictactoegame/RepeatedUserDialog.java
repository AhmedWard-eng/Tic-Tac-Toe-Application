/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import beans.RequestGameBean;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import navigationLogic.Navigation;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Nada Hamed
 */
public class RepeatedUserDialog {

    protected DialogPane dialogPaneName;
    protected GridPane gridPane;
    protected Label labelFirstPlayer;

    public void ExistDialog() {
        dialogPaneName = new DialogPane();
        gridPane = new GridPane();
        labelFirstPlayer = new Label("Repeated UserName try another one !");

        dialogPaneName.setHeaderText(" ERROR ! ");
        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));

        gridPane.add(labelFirstPlayer, 0, 0);
        dialogPaneName.setContent(gridPane);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(dialogPaneName);
        dialog.setTitle("Existed UserName");

        ButtonType OkButtonType = new ButtonType("Ok");

        dialogPaneName.getButtonTypes().addAll(OkButtonType);

        Optional<ButtonType> clickedButton = dialog.showAndWait();

    }

    public void loginUnsuccessDialog(String message) {
        dialogPaneName = new DialogPane();
        gridPane = new GridPane();
        labelFirstPlayer = new Label(message);

        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));

        
        labelFirstPlayer.setFont(new Font("Comic Sans MS Bold", 15.0));
        labelFirstPlayer.setTextFill(Color.WHITE);
        //remove
        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));
        
        //dialogPaneName.setHeaderText(" ERROR ! ");
        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));
        
        dialogPaneName.setStyle("-fx-background-color: #22726e;");

        gridPane.add(labelFirstPlayer, 0, 0);
        dialogPaneName.setContent(gridPane);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(dialogPaneName);
        dialog.setTitle("Error!");

        ButtonType OkButtonType = new ButtonType("Ok");

        dialogPaneName.getButtonTypes().addAll(OkButtonType);

        Node okButton = dialogPaneName.lookupButton(OkButtonType);
        okButton.setStyle("-fx-background-color: #ff9900; -fx-border-radius: 15; -fx-background-radius: 15; -fx-fontfamily: 'Comic-Sans MS'");

        Optional<ButtonType> clickedButton = dialog.showAndWait();

    }

    public static void acceptPlaying(NetworkConnection networkConnection, RequestGameBean bean) {
        DialogPane dialogPaneName;
        GridPane gridPane;
        Label labelFirstPlayer;
        dialogPaneName = new DialogPane();
        gridPane = new GridPane();
        labelFirstPlayer = new Label(bean.userName + " want to play with you..");

        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));

        dialogPaneName.setHeaderText("Request palying");

        gridPane.add(labelFirstPlayer, 0, 0);
        dialogPaneName.setContent(gridPane);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(dialogPaneName);
        //dialog.setTitle(message);

        ButtonType OkButtonType = new ButtonType("Ok");
        ButtonType cancelButtonType = new ButtonType("cancel");

        dialogPaneName.getButtonTypes().addAll(OkButtonType, cancelButtonType);

        Node okButton = dialogPaneName.lookupButton(OkButtonType);

        Node cancelButton = dialogPaneName.lookupButton(cancelButtonType);
        okButton.setStyle("-fx-background-color: #ff9900; -fx-border-radius: 15; -fx-background-radius: 15; -fx-fontfamily: 'Comic-Sans MS'");
        cancelButton.setStyle("-fx-background-color: #ff9900; -fx-border-radius: 15; -fx-background-radius: 15; -fx-fontfamily: 'Comic-Sans MS'");

        Optional<ButtonType> clickedButton = dialog.showAndWait();

        if (clickedButton.get() == OkButtonType) {

//            Navigation.navigate(stage, anchorPane);
//            networkConnection.sendMessage(message);
        } else if (clickedButton.get() == cancelButtonType) {
            //gridPane.getChildren().clear();
        }
    }

    public void dialogRepeated() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("MESSAGE...!");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("Sorry repeated username");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

    public void dialogSignUp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("MESSAGE...!");
        alert.setHeaderText("OK, an Information Dialog");
        alert.setContentText("SignUp Succeded");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
                Stage stage = TicTacToeGame.getStage();
                navigationLogic.Navigation.navigate(stage, new FXMLOnlineScreenBase(stage));
            }
        });

    }

}
