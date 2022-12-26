package tictactoegame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FXMLResultWin extends AnchorPane {

    protected final ImageView imageViewHome;
    protected final ImageView imageViewPlayAgain;
    protected final MediaView mediaViewVideoWin;
    protected final Label labelCongratulation;
    protected final Label labelName;

    MediaPlayer player;
    Media media;
    Image pathImagePlayAgin;
    Image pathImageHome;

    public FXMLResultWin(Stage stage) {

        imageViewHome = new ImageView();
        imageViewPlayAgain = new ImageView();
        mediaViewVideoWin = new MediaView();
        labelCongratulation = new Label();
        labelName = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        this.getStyleClass().add("AnchorPane");

        //setStyle("-fx-background-color: #22726e;");
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

        AnchorPane.setBottomAnchor(mediaViewVideoWin, 129.0);
        AnchorPane.setLeftAnchor(mediaViewVideoWin, 80.0);
        AnchorPane.setRightAnchor(mediaViewVideoWin, 100.0);
        AnchorPane.setTopAnchor(mediaViewVideoWin, 21.0);
        mediaViewVideoWin.setFitHeight(250.0);
        mediaViewVideoWin.setFitWidth(580.0);
        mediaViewVideoWin.setLayoutX(25.0);
        mediaViewVideoWin.setLayoutY(21.0);

        labelCongratulation.setLayoutX(202.0);
        labelCongratulation.setLayoutY(290.0);
        labelCongratulation.setText("Congratulations");
        labelCongratulation.setTextFill(javafx.scene.paint.Color.WHITE);
        labelCongratulation.setFont(new Font("System Bold", 18.0));

        labelName.setLayoutX(345.0);
        labelName.setLayoutY(290.0);
        labelName.setText("Name");
        labelName.setTextFill(javafx.scene.paint.Color.WHITE);
        labelName.setFont(new Font("System Bold", 20.0));

        getChildren().add(imageViewHome);
        getChildren().add(imageViewPlayAgain);
        getChildren().add(mediaViewVideoWin);
        getChildren().add(labelCongratulation);
        getChildren().add(labelName);

        //video
        media = new Media(tictactoegame.TicTacToeGame.class.getResource("Resources/WinVideo .mp4").toExternalForm());
        player = new MediaPlayer(media);
        mediaViewVideoWin.setMediaPlayer(player);
        player.play();

        //image
        pathImagePlayAgin = new Image(getClass().getResourceAsStream("Resources/playAgin.png"));
        imageViewPlayAgain.setImage(pathImagePlayAgin);

        pathImageHome = new Image(getClass().getResourceAsStream("Resources/homeIcon.png"));
        imageViewHome.setImage(pathImageHome);

       /* imageViewPlayAgain.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                Scene scene = new Scene(new FXML_GameTwoPlayer(stage));
                scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
                stage.setScene(scene);
            }
        });*/
        
    }
}
