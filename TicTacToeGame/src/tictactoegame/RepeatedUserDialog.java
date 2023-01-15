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

import beans.LogoutBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import navigationLogic.Navigation;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static tictactoegame.NetworkConnection.users;
import javafx.application.HostServices;
import javafx.scene.paint.Paint;
/**
 *
 * @author Nada Hamed
 */
public class RepeatedUserDialog extends Application{

    protected DialogPane dialogPaneName;
    protected GridPane gridPane;
    protected Label labelFirstPlayer;
    NetworkConnection networkConnection;
    Node Button;
    Dialog<ButtonType> dialog;

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

    public static void acceptPlaying(NetworkConnection networkConnection, RequestGameBean bean, Stage stage) {
        DialogPane dialogPaneName;
        GridPane gridPane;
        Label labelFirstPlayer;
        dialogPaneName = new DialogPane();
        gridPane = new GridPane();
        labelFirstPlayer = new Label(bean.myUserName + " want to play with you..");

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
            RequestGameBean requestGameBean = new RequestGameBean("accept", bean.otherPlayerUN, bean.myUserName, bean.otherPlayerIp, bean.myIp, NetworkConnection.userOnline.getScore());
            networkConnection.sendMessage(new Gson().toJson(requestGameBean));
            Navigation.navigate(stage, new FXMLGameOnlineBase(stage, bean, false, bean.score));
        } else if (clickedButton.get() == cancelButtonType) {
            RequestGameBean requestGameBean = new RequestGameBean("refuse", bean.otherPlayerUN, bean.myUserName, bean.otherPlayerIp, bean.myIp, NetworkConnection.userOnline.getScore());
            networkConnection.sendMessage(new Gson().toJson(requestGameBean));
        }
    }

    public static void dialogRefuse(RequestGameBean requestGameBean) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("MESSAGE...!");
//        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText(requestGameBean.myUserName + " can't play now");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
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

    public void logoutDialog(String message) {
        dialogPaneName = new DialogPane();
        gridPane = new GridPane();
        labelFirstPlayer = new Label(message);

        labelFirstPlayer.setFont(new Font("Comic Sans MS Bold", 15.0));
        labelFirstPlayer.setTextFill(Color.WHITE);

        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));

        //dialogPaneName.setHeaderText(" ERROR ! ");
        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));

        dialogPaneName.setStyle("-fx-background-color: #22726e;");

        gridPane.add(labelFirstPlayer, 0, 0);
        dialogPaneName.setContent(gridPane);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(dialogPaneName);
        dialog.setTitle("Logout !");

        ButtonType OkButtonType = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        //if (!buttonAdded) {
        dialogPaneName.getButtonTypes().addAll(OkButtonType, cancelButtonType);

        Node okButton = dialogPaneName.lookupButton(OkButtonType);
        okButton.setStyle("-fx-background-color: #ff9900; -fx-border-radius: 15; -fx-background-radius: 15; -fx-fontfamily: 'Comic-Sans MS'");

        Node cancelButton = dialogPaneName.lookupButton(cancelButtonType);
        cancelButton.setStyle("-fx-background-color: #ff9900; -fx-border-radius: 15; -fx-background-radius: 15;");

//            buttonAdded = true;
//        }
        Optional<ButtonType> clickedButton = dialog.showAndWait();

        if (clickedButton.get() == OkButtonType) {
            //logout and nav
            Gson gson = new GsonBuilder().create();

            LogoutBean logoutBean = new LogoutBean("logout", FXMLLoginBase.playerOneName);
            String h = gson.toJson(logoutBean);
//            System.out.println(h);
            networkConnection = new NetworkConnection();
            networkConnection.sendMessage(h);
//            System.out.println("data is sent ");
            //dialog
            Stage stage = TicTacToeGame.getStage();
            navigationLogic.Navigation.navigate(stage, new FXMLHomeBase(stage));

        } else if (clickedButton.get() == cancelButtonType) {

        }
    }

    public static void dialogPatternPassword(String message) {
        DialogPane dialogPaneName;
        GridPane gridPane;
        Label passwordPattern;
        dialogPaneName = new DialogPane();
        gridPane = new GridPane();

        passwordPattern = new Label(message);

        passwordPattern.setFont(new Font("Comic Sans MS Bold", 15.0));
        passwordPattern.setTextFill(Color.WHITE);

        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));

        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));

        dialogPaneName.setStyle("-fx-background-color: #22726e;");

        gridPane.add(passwordPattern, 0, 0);
        dialogPaneName.setContent(gridPane);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(dialogPaneName);

        ButtonType OkButtonType = new ButtonType("Ok");

        dialogPaneName.getButtonTypes().addAll(OkButtonType);

        Node okButton = dialogPaneName.lookupButton(OkButtonType);

        okButton.setStyle("-fx-background-color: #ff9900; -fx-border-radius: 15; -fx-background-radius: 15; -fx-fontfamily: 'Comic-Sans MS'");

        Optional<ButtonType> clickedButton = dialog.showAndWait();

        if (clickedButton.get() == OkButtonType) {
            try {
                Stage stage = TicTacToeGame.getStage();
                navigationLogic.Navigation.navigate(stage, new FXMLSignUpBase(stage));
            } catch (IOException ex) {
                Logger.getLogger(RepeatedUserDialog.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void dialogOutOfConnection() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("MESSAGE...!");
                alert.setHeaderText("OK, an Information Dialog");
                alert.setContentText("OUT OF CONNECTION");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        System.out.println("Pressed OK.");
                        Stage stage = TicTacToeGame.getStage();
                        navigationLogic.Navigation.navigate(stage, new FXMLHomeBase(stage));
                    }
                });
            }
        });

    }

    public static void assureWithdrawing(NetworkConnection networkConnection,String message, Stage stage) {
        DialogPane dialogPaneName;
        GridPane gridPane;
        Label labelFirstPlayer;
        dialogPaneName = new DialogPane();
        gridPane = new GridPane();
        labelFirstPlayer = new Label("are you sure you want to withdraw?\n you will lose 5 points from your score");

        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));

        dialogPaneName.setHeaderText("withdrawing");

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
            networkConnection.sendMessage(message);
            Navigation.navigate(stage, new FXMLAvailableUsersBase(stage,NetworkConnection.users));
        } else if (clickedButton.get() == cancelButtonType) {
            
        }
    }
    
    public void oppistePlayerWithDrawDialog(String message) {
        dialogPaneName = new DialogPane();
        gridPane = new GridPane();
        labelFirstPlayer = new Label(message);

        labelFirstPlayer.setFont(new Font("Comic Sans MS Bold", 15.0));
        labelFirstPlayer.setTextFill(Color.WHITE);

        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));

        //dialogPaneName.setHeaderText(" ERROR ! ");
        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));

        dialogPaneName.setStyle("-fx-background-color: #22726e;");

        gridPane.add(labelFirstPlayer, 0, 0);
        dialogPaneName.setContent(gridPane);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(dialogPaneName);

        ButtonType OkButtonType = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);

        dialogPaneName.getButtonTypes().addAll(OkButtonType);

        Node okButton = dialogPaneName.lookupButton(OkButtonType);
        okButton.setStyle("-fx-background-color: #ff9900; -fx-border-radius: 15; -fx-background-radius: 15; -fx-fontfamily: 'Comic-Sans MS'");

        Optional<ButtonType> clickedButton = dialog.showAndWait();

        if (clickedButton.get() == OkButtonType) {
            
            Stage stage = TicTacToeGame.getStage();
            navigationLogic.Navigation.navigate(stage, new FXMLAvailableUsersBase(stage, users));

        }
    }
    
    public void helpDialog() {
        Label label2;
        dialogPaneName = new DialogPane();
        gridPane = new GridPane();
        Hyperlink githubHyperlink = new Hyperlink("https://github.com/AhmedWard-eng/Tic-Tac-Toe-Application");
        
        String message;
        //Want to add your ideas?
        message = "Copyright 2023 JETS LLC. All rights reserved. \n\nWant to add your ideas? Contribute in:\n\n";
        String message2 = "\nCredits to:\n\n";
        
        message2 += "Ahmed gamal Ward\n";
        message2 += "Hossam Ahmed Fadaly\n";
        message2 += "Marina abdelmalak beshara\n";
        message2 += "Nada Alsayed hamed";
        labelFirstPlayer = new Label(message);
        label2 = new Label(message2);

        githubHyperlink.setFont(new Font("Comic Sans MS Bold", 15.0));
        githubHyperlink.setTextFill(Paint.valueOf("#ff9900"));
        
        labelFirstPlayer.setFont(new Font("Comic Sans MS Bold", 15.0));
        labelFirstPlayer.setTextFill(Color.WHITE);

        label2.setFont(new Font("Comic Sans MS Bold", 15.0));
        label2.setTextFill(Color.WHITE);
        
        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));
        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));
        dialogPaneName.setStyle("-fx-background-color: #22726e;");
        
        
        githubHyperlink.setOnAction((event) -> {
            getHostServices().showDocument(githubHyperlink.getText());
        });

        gridPane.add(labelFirstPlayer, 0, 0);
        gridPane.add(githubHyperlink, 0, 1);
        gridPane.add(label2, 0, 2);
        dialogPaneName.setContent(gridPane);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(dialogPaneName);
        dialog.setTitle("About TicTacToe");
        
        ButtonType OkButtonType = new ButtonType("Close", ButtonBar.ButtonData.OK_DONE);

        dialogPaneName.getButtonTypes().addAll(OkButtonType);

        Node okButton = dialogPaneName.lookupButton(OkButtonType);
        okButton.setStyle("-fx-background-color: #ff9900; -fx-border-radius: 15; -fx-background-radius: 15; -fx-fontfamily: 'Comic-Sans MS'");

        Optional<ButtonType> clickedButton = dialog.showAndWait();

    }
    
    public void loadingDialog() {
        dialogPaneName = new DialogPane();
        gridPane = new GridPane();
        String message = "loading";

        ProgressIndicator pi = new ProgressIndicator();        
        pi.setStyle("-fx-accent: #ffffff;");
        
        labelFirstPlayer = new Label(message);
        labelFirstPlayer.setFont(new Font("Comic Sans MS Bold", 15.0));
        labelFirstPlayer.setTextFill(Color.WHITE);
        
        dialogPaneName.setPadding(new Insets(10, 20, 0, 20));
        dialogPaneName.setStyle("-fx-background-color: #12947F; -fx-border-style: solid inside; -fx-border-width: 3; -fx-border-radius: 5; -fx-border-color: white;");

        gridPane.setVgap(15);
        gridPane.add(pi, 0, 1);
        gridPane.add(labelFirstPlayer, 0, 0);
        dialogPaneName.setContent(gridPane);

        dialog = new Dialog<>();
        
        dialog.setDialogPane(dialogPaneName);
        dialog.initStyle(StageStyle.TRANSPARENT);
                
        dialog.show();
    }
    
    public void closeLoadingDialog(){
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
        dialog.close();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
    }
    
    
}
