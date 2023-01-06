package tictactoegame;

import com.jfoenix.controls.JFXToggleButton;
import game.GameManager;
import game.Seed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import navigationLogic.Navigation;

public class FXMLGameTwoPlayerBase extends AnchorPane {

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
    protected final JFXToggleButton toggleButtonRecord;
    protected final Label labelPlayer;
    protected final Label labelVS;
    protected final Label labelPlayer2;
    protected final Button buttonBackHome;
    protected final Button buttonRestart;

    protected final DialogPane dialogPaneName;
    protected final GridPane gridPane;
    protected final Label labelFirstPlayer;
    protected final Label labelSecondPlayer;
    protected final TextField textFieldFirstPlayer;
    protected final TextField textFieldSecondPlayer;
    protected String firstPlayer, secondPlayer;

    //decleration array list to cary label
    ArrayList<Label> borderLabel;
    private GameManager gameManager;
    private Seed seed;

    int playerTurn = 0;

    String winnerSymbol;

    Stage stage;
    String player1name, player2name;

    public FXMLGameTwoPlayerBase(Stage stage, String playerOneName, String playerTwoName) {

        this.stage = stage;
        player1name = playerOneName;
        player2name = playerTwoName;

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
        toggleButtonRecord = new JFXToggleButton();
        labelPlayer = new Label();
        labelVS = new Label();
        labelPlayer2 = new Label();
        buttonBackHome = new Button();
        buttonRestart = new Button();

        dialogPaneName = new DialogPane();
        gridPane = new GridPane();
        labelFirstPlayer = new Label("First Player: ");
        labelSecondPlayer = new Label("Second Player: ");
        textFieldFirstPlayer = new TextField();
        textFieldSecondPlayer = new TextField();

        initGame();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        //  setStyle("-fx-background-color: #22726e;");
        this.getStyleClass().add("AnchorPane");

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
        label2.setPrefWidth(76.0);
        label2.setId("2");
        label2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label2.setFont(new Font("Arial Black", 55.0));
        label2.setCursor(Cursor.HAND);

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setGraphicTextGap(0.0);
        label1.setLayoutX(108.0);
        label1.setLayoutY(7.0);
        label1.setPrefHeight(72.0);
        label1.setPrefWidth(83.0);
        label1.setId("1");
        label1.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label1.setFont(new Font("Arial Black", 55.0));
        label1.setCursor(Cursor.HAND);

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setGraphicTextGap(0.0);
        label0.setLayoutX(5.0);
        label0.setLayoutY(5.0);
        label0.setPrefHeight(62.0);
        label0.setPrefWidth(83.0);
        label0.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label0.setId("0");
        label0.setFont(new Font("Arial Black", 55.0));
        label0.setCursor(Cursor.HAND);

        label3.setAlignment(javafx.geometry.Pos.CENTER);
        label3.setGraphicTextGap(0.0);
        label3.setLayoutX(9.0);
        label3.setLayoutY(109.0);
        label3.setPrefHeight(82.0);
        label3.setPrefWidth(76.0);
        label3.setId("3");
        //label3.setText("x");
        label3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label3.setFont(new Font("Arial Black", 55.0));
        label3.setCursor(Cursor.HAND);

        label4.setAlignment(javafx.geometry.Pos.CENTER);
        label4.setGraphicTextGap(0.0);
        label4.setLayoutX(112.0);
        label4.setLayoutY(109.0);
        label4.setPrefHeight(82.0);
        label4.setPrefWidth(76.0);
        //label4.setText("x");
        label4.setId("4");
        label4.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label4.setFont(new Font("Arial Black", 55.0));
        label4.setCursor(Cursor.HAND);

        label5.setAlignment(javafx.geometry.Pos.CENTER);
        label5.setGraphicTextGap(0.0);
        label5.setLayoutX(210.0);
        label5.setLayoutY(108.0);
        label5.setPrefHeight(82.0);
        label5.setPrefWidth(76.0);
        //label5.setText("x");
        label5.setId("5");
        label5.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label5.setFont(new Font("Arial Black", 55.0));
        label5.setCursor(Cursor.HAND);

        label6.setAlignment(javafx.geometry.Pos.CENTER);
        label6.setGraphicTextGap(0.0);
        label6.setLayoutX(6.0);
        label6.setLayoutY(207.0);
        label6.setPrefHeight(72.0);
        label6.setPrefWidth(83.0);
        //label6.setText("o");
        label6.setId("6");
        label6.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label6.setFont(new Font("Arial Black", 55.0));
        label6.setCursor(Cursor.HAND);

        label7.setAlignment(javafx.geometry.Pos.CENTER);
        label7.setGraphicTextGap(0.0);
        label7.setLayoutX(108.0);
        label7.setLayoutY(206.0);
        label7.setPrefHeight(72.0);
        label7.setPrefWidth(83.0);
        //label7.setText("o");
        label7.setId("7");
        label7.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label7.setFont(new Font("Arial Black", 55.0));
        label7.setCursor(Cursor.HAND);

        label8.setAlignment(javafx.geometry.Pos.CENTER);
        label8.setGraphicTextGap(0.0);
        label8.setLayoutX(210.0);
        label8.setLayoutY(206.0);
        label8.setPrefHeight(72.0);
        label8.setPrefWidth(83.0);
        label8.setId("8");
        //label8.setText("o");
        label8.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label8.setFont(new Font("Arial Black", 55.0));
        label8.setCursor(Cursor.HAND);

        pane1.setLayoutX(-12.0);
        pane1.setLayoutY(-8.0);
        pane1.setPrefHeight(438.0);
        pane1.setPrefWidth(229.0);
        pane1.setStyle("-fx-background-color: #12947F; -fx-border-color: white;");

        toggleButtonRecord.setId("Record");
        toggleButtonRecord.setText("Record");
        toggleButtonRecord.setToggleColor(Paint.valueOf("#d63333"));
        toggleButtonRecord.setLayoutX(84.0);
        toggleButtonRecord.setLayoutY(19.0);
        toggleButtonRecord.setFont(new Font("Arial Black", 18.0));
        toggleButtonRecord.setCursor(Cursor.CLOSED_HAND);

        labelPlayer.setId("labelPlayer");
        labelPlayer.setLayoutX(76.0);
        labelPlayer.setLayoutY(122.0);
        labelPlayer.setText(player1name);
        labelPlayer.setTextFill(javafx.scene.paint.Color.valueOf("#ededed"));
        labelPlayer.setFont(new Font("Arial Black", 22.0));

        labelVS.setId("labelVS");
        labelVS.setLayoutX(96.0);
        labelVS.setLayoutY(174.0);
        labelVS.setText("VS");
        labelVS.setTextFill(javafx.scene.paint.Color.valueOf("#ee9d12"));
        labelVS.setFont(new Font("System Bold Italic", 30.0));

        labelPlayer2.setId("labelPlayer2");
        labelPlayer2.setLayoutX(76.0);
        labelPlayer2.setLayoutY(240.0);
        labelPlayer2.setText(player2name);
        labelPlayer2.setTextFill(javafx.scene.paint.Color.valueOf("#eeeeee"));
        labelPlayer2.setFont(new Font("Arial Black", 22.0));

        buttonBackHome.setLayoutX(34.0);
        buttonBackHome.setLayoutY(341.0);
        buttonBackHome.setMnemonicParsing(false);
        buttonBackHome.setPrefHeight(26.0);
        buttonBackHome.setPrefWidth(42.0);
        buttonBackHome.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonBackHome.setText("<");
        buttonBackHome.setFont(new Font("Arial Black", 20.0));
        buttonBackHome.setCursor(Cursor.CLOSED_HAND);

        buttonRestart.setLayoutX(131.0);
        buttonRestart.setLayoutY(342.0);
        buttonRestart.setMnemonicParsing(false);
        buttonRestart.setPrefHeight(42.0);
        buttonRestart.setPrefWidth(83.0);
        buttonRestart.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonRestart.setText("Restart");
        buttonRestart.setFont(new Font("Arial Bold", 15.0));
        buttonRestart.setCursor(Cursor.CLOSED_HAND);

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
        pane1.getChildren().add(toggleButtonRecord);
        pane1.getChildren().add(labelPlayer);
        pane1.getChildren().add(labelVS);
        pane1.getChildren().add(labelPlayer2);
        pane1.getChildren().add(buttonBackHome);
        pane1.getChildren().add(buttonRestart);
        getChildren().add(pane1);

        borderLabel = new ArrayList<>(Arrays.asList(label0, label1, label2, label3, label4, label5, label6, label7, label8));

        borderLabel.forEach(label -> {
            setupButton(label);
            label.setFocusTraversable(false);
        });

        buttonRestart.setOnAction((ActionEvent event) -> {
            newGame();
        });

        buttonBackHome.setOnAction((ActionEvent event) -> {
            Scene scene = new Scene(new FXMLHomeBase(stage));
            scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            stage.setScene(scene);
        });

    }

    private void initGame() {
        gameManager = new GameManager();
        seed = Seed.CROSS;
    }

    private void readingPlayerName() {
        dialogPaneName.setHeaderText("add your names please!");
        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));

        textFieldFirstPlayer.setPromptText("First player name");
        textFieldSecondPlayer.setPromptText("Second player name");

        gridPane.add(labelFirstPlayer, 0, 0);
        gridPane.add(textFieldFirstPlayer, 1, 0);
        gridPane.add(labelSecondPlayer, 0, 1);
        gridPane.add(textFieldSecondPlayer, 1, 1);

        dialogPaneName.setContent(gridPane);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(dialogPaneName);
        dialog.setTitle("player names");

        ButtonType OkButtonType = new ButtonType("Ok");
        ButtonType cancelButtonType = new ButtonType("Cancel");

        dialogPaneName.getButtonTypes().addAll(OkButtonType, cancelButtonType);

        Optional<ButtonType> clickedButton = dialog.showAndWait();

        if (clickedButton.get() == OkButtonType) {
            firstPlayer = textFieldFirstPlayer.getText();
            secondPlayer = textFieldSecondPlayer.getText();
            if (!firstPlayer.equals("")) {
                labelPlayer.setText(firstPlayer);
            }
            if (!secondPlayer.equals("")) {
                labelPlayer2.setText(secondPlayer);
            }

        } else if (clickedButton.get() == cancelButtonType) {
            Scene scene = new Scene(new FXMLHomeBase(stage));
            scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            stage.setScene(scene);
        }
    }

    public void setupButton(Label label) {

        label.setOnMouseClicked(mouseEvent -> {

            label.setMouseTransparent(true);

            setPlayerSymbol(label);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {

                            checkEndGame();

                        }
                    });
                }
            }).start();

        });
    }

    public void setPlayerSymbol(Label label) {

        //drow x and o
        if (seed == Seed.CROSS) {
            gameManager.setCell(Integer.parseInt(label.getId()), Seed.CROSS);
            label.setText(gameManager.getCell(Integer.parseInt(label.getId())).content.getIcon());
            label.setStyle("-fx-text-fill: linear-gradient(to top,ff9900,#ff9900);");
            labelPlayer.setStyle("-fx-text-fill:#c22115;");
            labelPlayer2.setStyle("-fx-text-fill:#f0f0f0 ;");
            seed = Seed.NOUGHT;
        } else {
            gameManager.setCell(Integer.parseInt(label.getId()), Seed.NOUGHT);
            label.setText(gameManager.getCell(Integer.parseInt(label.getId())).content.getIcon());
            label.setStyle("-fx-text-fill: linear-gradient(to top,#f0f0f0,#f0f0f0);");
            labelPlayer2.setStyle("-fx-text-fill:#c22115;");
            labelPlayer.setStyle("-fx-text-fill:#f0f0f0 ;");
            seed = Seed.CROSS;
        }

    }

    public void checkEndGame() {
        if (gameManager.isPlayerXWon()) {

            Navigation.navigate(stage, new FXMLResultWinBase(stage, Seed.CROSS.getIcon(), new FXMLGameTwoPlayerBase(stage, player1name, player2name)));
        } else if (gameManager.isPlayerOWon()) {
            Navigation.navigate(stage, new FXMLResultWinBase(stage, Seed.NOUGHT.getIcon(), new FXMLGameTwoPlayerBase(stage, player1name, player2name)));

        } else if (gameManager.isDraw()) {
            Navigation.navigate(stage, new FXMLResultDrawBase(stage, new FXMLGameTwoPlayerBase(stage, player1name, player2name)));
        }

    }

    protected String getWinnerName(String winnerSymbol) {
        if (winnerSymbol.equals("X")) {
            return player1name;
        }
        return player2name;
    }
    void newGame() {
        for (int i = 0; i < borderLabel.size(); i++) {
            borderLabel.get(i).setText(" ");
            borderLabel.get(i).setMouseTransparent(false);
        }
        toggleButtonRecord.setDisable(false);
        toggleButtonRecord.setSelected(false);
        gameManager.newGame();
    }

}
