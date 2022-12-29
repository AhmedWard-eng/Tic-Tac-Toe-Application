package tictactoegame;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FXMLResultLoseBase extends AnchorPane {

    protected final ImageView imageViewHome;
    protected final ImageView imageViewPlayAgain;
    protected final MediaView mediaViewVideoLose;
    protected final Button buttonBackHome;
    protected final Button buttonReplay;
    MediaPlayer player;
    Media media;
    public FXMLResultLoseBase(Stage stage) {

        imageViewHome = new ImageView();
        imageViewPlayAgain = new ImageView();
        mediaViewVideoLose = new MediaView();
        buttonBackHome = new Button();
        buttonReplay = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");

        imageViewHome.setFitHeight(80.0);
        imageViewHome.setFitWidth(85.0);
        imageViewHome.setLayoutX(35.0);
        imageViewHome.setLayoutY(300.0);
        imageViewHome.setPickOnBounds(true);
        imageViewHome.setPreserveRatio(true);

        imageViewPlayAgain.setFitHeight(80.0);
        imageViewPlayAgain.setFitWidth(85.0);
        imageViewPlayAgain.setLayoutX(480.0);
        imageViewPlayAgain.setLayoutY(300.0);
        imageViewPlayAgain.setPickOnBounds(true);
        imageViewPlayAgain.setPreserveRatio(true);

        AnchorPane.setBottomAnchor(mediaViewVideoLose, 129.0);
        AnchorPane.setLeftAnchor(mediaViewVideoLose, 80.0);
        AnchorPane.setRightAnchor(mediaViewVideoLose, 100.0);
        AnchorPane.setTopAnchor(mediaViewVideoLose, 21.0);
        mediaViewVideoLose.setFitHeight(250.0);
        mediaViewVideoLose.setFitWidth(500.0);
        mediaViewVideoLose.setLayoutX(50.0);
        mediaViewVideoLose.setLayoutY(26.0);

        buttonBackHome.setLayoutX(87.0);
        buttonBackHome.setLayoutY(312.0);
        buttonBackHome.setMnemonicParsing(false);
        buttonBackHome.setPrefHeight(43.0);
        buttonBackHome.setPrefWidth(91.0);
        buttonBackHome.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonBackHome.setText("Home");
        buttonBackHome.setFont(new Font("Arial Bold", 18.0));
        buttonBackHome.setCursor(Cursor.CLOSED_HAND);

        buttonReplay.setLayoutX(422.0);
        buttonReplay.setLayoutY(312.0);
        buttonReplay.setMnemonicParsing(false);
        buttonReplay.setPrefHeight(43.0);
        buttonReplay.setPrefWidth(91.0);
        buttonReplay.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonReplay.setText("Replay");
        buttonReplay.setFont(new Font("Arial Bold", 18.0));
        buttonReplay.setCursor(Cursor.CLOSED_HAND);

        getChildren().add(imageViewHome);
        getChildren().add(imageViewPlayAgain);
        getChildren().add(mediaViewVideoLose);
        getChildren().add(buttonBackHome);
        getChildren().add(buttonReplay);
        
        media = new Media(tictactoegame.TicTacToeGame.class.getResource("Resources/try agin.mp4").toExternalForm());
        player = new MediaPlayer(media);
        mediaViewVideoLose.setMediaPlayer(player);
        player.play();

        buttonReplay.setOnAction((ActionEvent event) -> {
            player.stop();
            Scene scene = new Scene(new FXMLGameOnePlayerBase(stage));
            scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            stage.setScene(scene);
        });

        buttonBackHome.setOnAction((ActionEvent event) -> {
            player.stop();
            Scene scene = new Scene(new FXMLHomeBase(stage));
            scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            stage.setScene(scene);
        });
    }
}
