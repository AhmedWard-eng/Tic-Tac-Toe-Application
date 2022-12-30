/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigationLogic;

import game.Seed;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tictactoegame.FXMLGameTwoPlayerBase;
import tictactoegame.FXMLResultWinBase;

/**
 *
 * @author AhmedWard
 */
public class Navigation {

    public static void navigate(Stage stage, AnchorPane anchorPane) {
        Scene scene = new Scene(anchorPane);
        scene.getStylesheets().add(anchorPane.getClass().getResource("Style.css").toExternalForm());
        stage.setScene(scene);
    }
}
