/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import game.Seed;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @authors AhmedWard, Marina AbdelMalek, NadaElsayed, HossamFadaly
 */
public class TicTacToeGame extends Application {

    private static Stage guiStage;

    public static Stage getStage() {
        return guiStage;
    }

    @Override
    public void start(Stage stage) throws Exception {

        guiStage = stage;

        Parent root = new FXMLGameOnlineBase(stage);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        File file = new File(getClass().getResource("").toExternalForm());
        System.out.println(file.getParentFile().getAbsolutePath());
        stage.setTitle("Tic-Tac-Toe Game");

        stage.setScene(scene);
        stage.setResizable(false);

        stage.getIcons().add(new Image(tictactoegame.TicTacToeGame.class.getResource("Resources/Capture.PNG").toExternalForm()));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
