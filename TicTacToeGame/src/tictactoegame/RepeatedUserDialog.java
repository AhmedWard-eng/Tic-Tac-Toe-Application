/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.util.Optional;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Nada Hamed
 */
public class RepeatedUserDialog   {
    protected DialogPane dialogPaneName;
    protected GridPane gridPane;
    protected Label labelFirstPlayer;
    
   
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
                Stage stage=TicTacToeGame.getStage();
                navigationLogic.Navigation.navigate(stage, new FXMLOnlineScreenBase(stage));
            }
        });
    }

}
    

