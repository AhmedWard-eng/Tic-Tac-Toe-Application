package tictactoegame;

import com.google.gson.Gson;
import fileOperation.FileOperation;
import game.Cell;
import game.Record;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import navigationLogic.Navigation;

public class FXMLRecordShowBase extends AnchorPane {

    protected final Rectangle rectangleBordGameOnePlayer;
    protected final Pane pane;
    protected final Line line;
    protected final Line line0;
    protected final Line line1;
    protected final Line line2;
    protected final Pane pane0;
    protected final Label label2;
    protected final Label label1;
    protected final Label label0;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final Label label6;
    protected final Label label7;
    protected final Label label8;
    protected final Pane pane1;
    protected final Label labelPlayer;
    protected final Label labelVS;
    protected final Label labelPlayer1;
    protected final Button buttonBack;
    protected final Button buttonReplayRecord;
    private ArrayList<Label> borderLabel;

    public FXMLRecordShowBase(Stage stage, String fileName) {

        String json = getFileData(fileName);
        System.out.println(json);
        Record record = getRecordFromJson(json);

        rectangleBordGameOnePlayer = new Rectangle();
        pane = new Pane();
        line = new Line();
        line0 = new Line();
        line1 = new Line();
        line2 = new Line();
        pane0 = new Pane();
        label2 = new Label();
        label1 = new Label();
        label0 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();
        label8 = new Label();
        pane1 = new Pane();
        labelPlayer = new Label();
        labelVS = new Label();
        labelPlayer1 = new Label();
        buttonBack = new Button();
        buttonReplayRecord = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");

        rectangleBordGameOnePlayer.setArcHeight(5.0);
        rectangleBordGameOnePlayer.setArcWidth(5.0);
        rectangleBordGameOnePlayer.setFill(javafx.scene.paint.Color.valueOf("#12947f"));
        rectangleBordGameOnePlayer.setHeight(300.0);
        rectangleBordGameOnePlayer.setId("border");
        rectangleBordGameOnePlayer.setLayoutX(262.0);
        rectangleBordGameOnePlayer.setLayoutY(52.0);
        rectangleBordGameOnePlayer.setStroke(javafx.scene.paint.Color.valueOf("#12947f"));
        rectangleBordGameOnePlayer.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangleBordGameOnePlayer.setWidth(300.0);

        pane.setLayoutX(262.0);
        pane.setLayoutY(52.0);
        pane.setPrefHeight(300.0);
        pane.setPrefWidth(300.0);
        borderLabel = new ArrayList<>(Arrays.asList(label0, label1, label2, label3, label4, label5, label6, label7, label8));

        line.setEndX(438.0);
        line.setEndY(-60.0);
        line.setFill(javafx.scene.paint.Color.valueOf("#feffff"));
        line.setLayoutX(-140.0);
        line.setLayoutY(267.0);
        line.setStartX(142.0);
        line.setStartY(-60.0);
        line.setStroke(javafx.scene.paint.Color.valueOf("#ededed"));
        line.setStrokeWidth(3.0);

        line0.setEndX(17.0);
        line0.setEndY(187.0);
        line0.setFill(javafx.scene.paint.Color.valueOf("#f9fcfc"));
        line0.setLayoutX(81.0);
        line0.setLayoutY(111.0);
        line0.setStartX(17.0);
        line0.setStartY(-108.0);
        line0.setStroke(javafx.scene.paint.Color.valueOf("#ededed"));
        line0.setStrokeWidth(3.0);

        line1.setEndX(16.0);
        line1.setEndY(94.0);
        line1.setFill(javafx.scene.paint.Color.valueOf("#fcfcfc"));
        line1.setLayoutX(186.0);
        line1.setLayoutY(204.0);
        line1.setStartX(16.0);
        line1.setStartY(-201.0);
        line1.setStroke(javafx.scene.paint.Color.valueOf("#ededed"));
        line1.setStrokeWidth(3.0);

        line2.setEndX(406.0);
        line2.setFill(javafx.scene.paint.Color.WHITE);
        line2.setLayoutX(-108.0);
        line2.setLayoutY(97.0);
        line2.setStartX(110.0);
        line2.setStroke(javafx.scene.paint.Color.valueOf("#ededed"));
        line2.setStrokeWidth(3.0);

        pane0.setLayoutY(1.0);
        pane0.setPrefHeight(300.0);
        pane0.setPrefWidth(300.0);

        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setGraphicTextGap(0.0);
        label2.setLayoutX(215.0);
        label2.setLayoutY(7.0);
        label2.setPrefHeight(82.0);
        label2.setPrefWidth(83.0);
        label2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label2.setFont(new Font("Arial Black", 55.0));
        label2.setCursor(Cursor.HAND);
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#f0f0f0"));

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setGraphicTextGap(0.0);
        label1.setLayoutX(108.0);
        label1.setLayoutY(7.0);
        label1.setPrefHeight(72.0);
        label1.setPrefWidth(83.0);
        label1.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#f0f0f0"));
        label1.setFont(new Font("Arial Black", 55.0));
        label1.setCursor(Cursor.HAND);

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setGraphicTextGap(0.0);
        label0.setLayoutX(5.0);
        label0.setLayoutY(5.0);
        label0.setPrefHeight(62.0);
        label0.setPrefWidth(83.0);
        label0.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label0.setFont(new Font("Arial Black", 55.0));
        label0.setCursor(Cursor.HAND);
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#f0f0f0"));

        label3.setAlignment(javafx.geometry.Pos.CENTER);
        label3.setGraphicTextGap(0.0);
        label3.setLayoutX(9.0);
        label3.setLayoutY(109.0);
        label3.setPrefHeight(82.0);
        label3.setPrefWidth(76.0);
        label3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#f2f2f2"));
        label3.setFont(new Font("Arial Black", 55.0));
        label3.setCursor(Cursor.HAND);

        label4.setAlignment(javafx.geometry.Pos.CENTER);
        label4.setGraphicTextGap(0.0);
        label4.setLayoutX(112.0);
        label4.setLayoutY(109.0);
        label4.setPrefHeight(82.0);
        label4.setPrefWidth(76.0);
        label4.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label4.setTextFill(javafx.scene.paint.Color.valueOf("#f2f2f2"));
        label4.setFont(new Font("Arial Black", 55.0));
        label4.setCursor(Cursor.HAND);

        label5.setAlignment(javafx.geometry.Pos.CENTER);
        label5.setGraphicTextGap(0.0);
        label5.setLayoutX(210.0);
        label5.setLayoutY(108.0);
        label5.setPrefHeight(82.0);
        label5.setPrefWidth(76.0);
        label5.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label5.setTextFill(javafx.scene.paint.Color.valueOf("#f2f2f2"));
        label5.setFont(new Font("Arial Black", 55.0));
        label5.setCursor(Cursor.HAND);

        label6.setAlignment(javafx.geometry.Pos.CENTER);
        label6.setGraphicTextGap(0.0);
        label6.setLayoutX(6.0);
        label6.setLayoutY(207.0);
        label6.setPrefHeight(72.0);
        label6.setPrefWidth(83.0);
        label6.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label6.setTextFill(javafx.scene.paint.Color.valueOf("#f0f0f0"));
        label6.setFont(new Font("Arial Black", 55.0));
        label6.setCursor(Cursor.HAND);

        label7.setAlignment(javafx.geometry.Pos.CENTER);
        label7.setGraphicTextGap(0.0);
        label7.setLayoutX(108.0);
        label7.setLayoutY(206.0);
        label7.setPrefHeight(72.0);
        label7.setPrefWidth(83.0);
        label7.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label7.setTextFill(javafx.scene.paint.Color.valueOf("#f0f0f0"));
        label7.setFont(new Font("Arial Black", 55.0));
        label7.setCursor(Cursor.HAND);

        label8.setAlignment(javafx.geometry.Pos.CENTER);
        label8.setGraphicTextGap(0.0);
        label8.setLayoutX(210.0);
        label8.setLayoutY(206.0);
        label8.setPrefHeight(72.0);
        label8.setPrefWidth(83.0);
        label8.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label8.setTextFill(javafx.scene.paint.Color.valueOf("#f0f0f0"));
        label8.setFont(new Font("Arial Black", 55.0));
        label8.setCursor(Cursor.HAND);

        pane1.setLayoutX(-12.0);
        pane1.setLayoutY(-8.0);
        pane1.setPrefHeight(438.0);
        pane1.setPrefWidth(229.0);
        pane1.setStyle("-fx-background-color: #12947F; -fx-border-color: white;");

        labelPlayer.setId("labelPlayer");
        labelPlayer.setLayoutX(76.0);
        labelPlayer.setLayoutY(92.0);
        labelPlayer.setText(record.player1);
        labelPlayer.setFont(new Font("Arial Black", 22.0));
        labelPlayer.setAlignment(Pos.CENTER);
        labelPlayer.setStyle("-fx-text-fill: linear-gradient(to top,ff9900,#ff9900);");
        labelPlayer.setContentDisplay(ContentDisplay.CENTER);


        labelVS.setId("labelVS");
        labelVS.setLayoutX(76.0);
        labelVS.setLayoutY(151.0);
        labelVS.setText("VS");
        labelVS.setContentDisplay(ContentDisplay.CENTER);
        labelVS.setTextFill(javafx.scene.paint.Color.valueOf("#eeeeee"));
        labelVS.setFont(new Font("System Bold Italic", 30.0));

        labelPlayer1.setId("labelCumputer");
        labelPlayer1.setLayoutX(76.0);
        labelPlayer1.setLayoutY(219.0);
        labelPlayer1.setText(record.player2);
        labelPlayer1.setFont(new Font("Arial Black", 22.0));
        labelPlayer1.setAlignment(Pos.CENTER);
        labelPlayer1.setStyle("-fx-text-fill: linear-gradient(to top,#f0f0f0,#f0f0f0);");
        labelPlayer1.setContentDisplay(ContentDisplay.CENTER);


        buttonBack.setLayoutX(34.0);
        buttonBack.setLayoutY(321.0);
        buttonBack.setMnemonicParsing(false);
        buttonBack.setPrefHeight(26.0);
        buttonBack.setPrefWidth(42.0);
        buttonBack.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonBack.setText("<");
        buttonBack.setFont(new Font("Arial Black", 20.0));
        buttonBack.setCursor(Cursor.CLOSED_HAND);

        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigation.navigate(stage, new FXMLGameHistoryBase(stage));
            }
        });

        buttonReplayRecord.setLayoutX(132.0);
        buttonReplayRecord.setLayoutY(321.0);
        buttonReplayRecord.setMnemonicParsing(false);
        buttonReplayRecord.setPrefHeight(42.0);
        buttonReplayRecord.setPrefWidth(83.0);
        buttonReplayRecord.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonReplayRecord.setText("Replay");
        buttonReplayRecord.setFont(new Font("Arial Bold", 15.0));
        buttonReplayRecord.setCursor(Cursor.CLOSED_HAND);
        buttonReplayRecord.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                for (int i = 0; i < borderLabel.size(); i++) {
                    borderLabel.get(i).setText(" ");
                    borderLabel.get(i).setMouseTransparent(false);
                }
                playTheGame(record.board);
            }
        });
        getChildren().add(rectangleBordGameOnePlayer);
        pane.getChildren().add(line);
        pane.getChildren().add(line0);
        pane.getChildren().add(line1);
        pane.getChildren().add(line2);
        pane0.getChildren().add(label2);
        pane0.getChildren().add(label1);
        pane0.getChildren().add(label0);
        pane0.getChildren().add(label3);
        pane0.getChildren().add(label4);
        pane0.getChildren().add(label5);
        pane0.getChildren().add(label6);
        pane0.getChildren().add(label7);
        pane0.getChildren().add(label8);
        pane.getChildren().add(pane0);
        getChildren().add(pane);
        pane1.getChildren().add(labelPlayer);
        pane1.getChildren().add(labelVS);
        pane1.getChildren().add(labelPlayer1);
        pane1.getChildren().add(buttonBack);
        pane1.getChildren().add(buttonReplayRecord);
        getChildren().add(pane1);

        playTheGame(record.board);

    }

    private String getFileData(String fileName) {
        File file = new File("recordedGames\\" + fileName);
        return new FileOperation().getFileData(file);
    }

    private Record getRecordFromJson(String json) {
        return new Gson().fromJson(json, Record.class);
    }

    private void playTheGame(ArrayList<Cell> board) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < board.size(); i++) {
                    updateUI(i, board);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FXMLRecordShowBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }.start();
    }

    void updateUI(int i, ArrayList<Cell> board) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                borderLabel.get(board.get(i).index).setText(board.get(i).content.getIcon());
            }
        });
    }
}
