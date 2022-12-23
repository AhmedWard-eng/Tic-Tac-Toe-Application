/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author AhmedWard
 */
public class TicTacToeGame extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new FXMLResultDraw();
        
        Scene scene = new Scene(root);
        
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        
        stage.setScene(scene);
        
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.setResizable(false);
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
