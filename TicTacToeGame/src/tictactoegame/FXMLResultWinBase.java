package tictactoegame;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FXMLResultWinBase extends AnchorPane {

    protected final MediaView mediaViewVideoWin;
    protected final Label labelCongratulation;
    protected final Label labelName;
    protected final Button buttonBackHome;
    protected final Button buttonReplay;
    MediaPlayer player;
    Media media;
    
    
    public FXMLResultWinBase(Stage stage, String winnerSymbol) {

        mediaViewVideoWin = new MediaView();
        labelCongratulation = new Label();
        labelName = new Label();
        buttonBackHome = new Button();
        buttonReplay = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");

        AnchorPane.setBottomAnchor(mediaViewVideoWin, 129.0);
        AnchorPane.setLeftAnchor(mediaViewVideoWin, 80.0);
        AnchorPane.setRightAnchor(mediaViewVideoWin, 100.0);
        AnchorPane.setTopAnchor(mediaViewVideoWin, 21.0);
        mediaViewVideoWin.setFitHeight(250.0);
        mediaViewVideoWin.setFitWidth(500.0);
        mediaViewVideoWin.setLayoutX(50.0);
        mediaViewVideoWin.setLayoutY(22.0);

        labelCongratulation.setLayoutX(209.0);
        labelCongratulation.setLayoutY(288.0);
        labelCongratulation.setText(" Winner is ");
        labelCongratulation.setTextFill(javafx.scene.paint.Color.WHITE);
        labelCongratulation.setFont(new Font("Arial Black", 20.0));

        labelName.setLayoutX(321.0);
        labelName.setLayoutY(290.0);
        //labelName.setText("Name");
        labelName.setText(winnerSymbol);
        labelName.setTextFill(javafx.scene.paint.Color.WHITE);
        labelName.setFont(new Font("Arial Black", 18.0));

        buttonBackHome.setLayoutX(80.0);
        buttonBackHome.setLayoutY(307.0);
        buttonBackHome.setMnemonicParsing(false);
        buttonBackHome.setPrefHeight(43.0);
        buttonBackHome.setPrefWidth(91.0);
        buttonBackHome.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonBackHome.setText("Home");
        buttonBackHome.setFont(new Font("Arial Bold", 18.0));
        buttonBackHome.setCursor(Cursor.CLOSED_HAND);

        buttonReplay.setLayoutX(421.0);
        buttonReplay.setLayoutY(307.0);
        buttonReplay.setMnemonicParsing(false);
        buttonReplay.setPrefHeight(43.0);
        buttonReplay.setPrefWidth(91.0);
        buttonReplay.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonReplay.setText("Replay");
        buttonReplay.setFont(new Font("Arial Bold", 18.0));
        buttonReplay.setCursor(Cursor.CLOSED_HAND);

        getChildren().add(mediaViewVideoWin);
        getChildren().add(labelCongratulation);
        getChildren().add(labelName);
        getChildren().add(buttonBackHome);
        getChildren().add(buttonReplay);
        
        //video
        if(winnerSymbol == "X")
            media = new Media(tictactoegame.TicTacToeGame.class.getResource("Resources/WinVideo .mp4").toExternalForm());
        else if(winnerSymbol == "O")
            media = new Media(tictactoegame.TicTacToeGame.class.getResource("Resources/Owinner.mp4").toExternalForm());
        player = new MediaPlayer(media);
        mediaViewVideoWin.setMediaPlayer(player);
        player.play();
        
        buttonReplay.setOnAction((ActionEvent event) -> {
            player.stop();
            Scene scene = new Scene(new FXMLGameTwoPlayerBase(stage));
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
