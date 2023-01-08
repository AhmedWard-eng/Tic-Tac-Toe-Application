/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.util.Optional;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Nada Hamed
 */
public class RepeatedUserDialog   {
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
    
}
