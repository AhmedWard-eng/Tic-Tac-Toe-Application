/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameserver;

import DataBaseLayer.DataAccessLayer;
import beans.LoginBean;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Nada Hamed
 */
public class GameServer extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new GameServerBase(stage) ;
        
        Scene scene = new Scene(root);
        stage.setTitle("Tic-Tac-Toe Game Server");
        stage.setResizable(false);
        stage.setScene(scene);
        Image image = new Image(getClass().getResource("serverIcon.png").toExternalForm());
        System.out.println("aaaaaaaaa");
        stage.getIcons().add(image);
        
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
