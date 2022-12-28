package tictactoegame;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FXMLResultDrawBase extends AnchorPane {

    protected final MediaView mediaViewVideoDraw;
    protected final Button buttonBackHome;
    protected final Button buttonReplay;
    MediaPlayer player;
    Media media;

    public FXMLResultDrawBase(Stage stage) {

        mediaViewVideoDraw = new MediaView();
        buttonBackHome = new Button();
        buttonReplay = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");

        AnchorPane.setBottomAnchor(mediaViewVideoDraw, 129.0);
        AnchorPane.setLeftAnchor(mediaViewVideoDraw, 80.0);
        AnchorPane.setRightAnchor(mediaViewVideoDraw, 100.0);
        AnchorPane.setTopAnchor(mediaViewVideoDraw, 21.0);
        mediaViewVideoDraw.setFitHeight(250.0);
        mediaViewVideoDraw.setFitWidth(500.0);
        mediaViewVideoDraw.setLayoutX(25.0);
        mediaViewVideoDraw.setLayoutY(21.0);

        buttonBackHome.setLayoutX(88.0);
        buttonBackHome.setLayoutY(310.0);
        buttonBackHome.setMnemonicParsing(false);
        buttonBackHome.setPrefHeight(43.0);
        buttonBackHome.setPrefWidth(91.0);
        buttonBackHome.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonBackHome.setText("Home");
        buttonBackHome.setFont(new Font("Arial Bold", 18.0));
        buttonBackHome.setCursor(Cursor.CLOSED_HAND);

        buttonReplay.setLayoutX(420.0);
        buttonReplay.setLayoutY(310.0);
        buttonReplay.setMnemonicParsing(false);
        buttonReplay.setPrefHeight(43.0);
        buttonReplay.setPrefWidth(91.0);
        buttonReplay.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonReplay.setText("Replay");
        buttonReplay.setFont(new Font("Arial Bold", 18.0));
        buttonReplay.setCursor(Cursor.CLOSED_HAND);

        getChildren().add(mediaViewVideoDraw);
        getChildren().add(buttonBackHome);
        getChildren().add(buttonReplay);

        media = new Media(tictactoegame.TicTacToeGame.class.getResource("Resources/DrawVideo.mp4").toExternalForm());
        player = new MediaPlayer(media);
        mediaViewVideoDraw.setMediaPlayer(player);
        player.play();
        
         buttonReplay.setOnAction((ActionEvent event) -> {
            player.stop();
            Scene scene = new Scene(new FXMLGameTwoPlayerBase(stage));
            scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            stage.setScene(scene);
        });
        
        buttonBackHome.setOnAction((ActionEvent event) -> {
            player.stop();
            Scene scene = new Scene(new FXMLHome(stage));
            scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            stage.setScene(scene);
        });
        
    }
}
