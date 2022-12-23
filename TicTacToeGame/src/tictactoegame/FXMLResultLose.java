package tictactoegame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class FXMLResultLose extends AnchorPane {

    protected final ImageView imageViewHome;
    protected final ImageView imageViewPlayAgain;
    protected final MediaView mediaViewVideoLose;

    MediaPlayer player;
    Media media ;
    Image pathImagePlayAgin;
    Image pathImageHome;
    public FXMLResultLose() {

        imageViewHome = new ImageView();
        imageViewPlayAgain = new ImageView();
        mediaViewVideoLose = new MediaView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        
        this.getStyleClass().add("AnchorPane");

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
        mediaViewVideoLose.setFitWidth(550.0);
        mediaViewVideoLose.setLayoutX(25.0);
        mediaViewVideoLose.setLayoutY(21.0);

        getChildren().add(imageViewHome);
        getChildren().add(imageViewPlayAgain);
        getChildren().add(mediaViewVideoLose);

        //video
        media = new Media(tictactoegame.TicTacToeGame.class.getResource("Resources/try agin.mp4").toExternalForm());
        player=new MediaPlayer(media);
        mediaViewVideoLose.setMediaPlayer(player);
        player.play();
        
        //image
        pathImagePlayAgin=new Image(getClass().getResourceAsStream("Resources/playAgin.png"));
        imageViewPlayAgain.setImage(pathImagePlayAgin);
        
        pathImageHome=new Image(getClass().getResourceAsStream("Resources/homeIcon.png"));
        imageViewHome.setImage(pathImageHome);
    }
}
