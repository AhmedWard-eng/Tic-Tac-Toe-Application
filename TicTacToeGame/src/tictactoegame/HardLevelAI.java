/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import com.jfoenix.controls.JFXToggleButton;
import game.Cell;
import game.GameManager;
import game.Record;
import game.Seed;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import navigationLogic.Navigation;

/**
 *
 * @author Nada Hamed
 */
public class HardLevelAI extends AnchorPane {

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
    protected final Label labelCumputer;
    protected final Button buttonBackHome;
    protected final Button buttonRestart;
    int x, y;
    boolean has_winner;
    private GameManager gameManager;

    //Record record;
    private Seed seed;

    HardLevelAI(Stage stage) {
        gameManager = new GameManager();
        rectangleBordGameOnePlayer = new Rectangle();
        // record=new Record(board, player1, player2);
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
        labelCumputer = new Label();
        buttonBackHome = new Button();
        buttonRestart = new Button();
        has_winner = false;
        gameManager=new GameManager();
        Label borderLabel[][] = {{label0, label1, label2}, {label3, label4, label5}, {label6, label7, label8}};

        toggleButtonRecord.setId("Record");
        toggleButtonRecord.setText("Record");
        toggleButtonRecord.setToggleColor(Paint.valueOf("#d63333"));
        toggleButtonRecord.setLayoutX(84.0);
        toggleButtonRecord.setLayoutY(19.0);
        toggleButtonRecord.setFont(new Font("Arial Black", 18.0));
        toggleButtonRecord.setCursor(Cursor.CLOSED_HAND);

        toggleButtonRecord.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (toggleButtonRecord.isSelected()) {
                    gameManager.setRecorded(true);
                } else {
                    gameManager.setRecorded(false);
                }
            }
        });

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
        label1.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label1.setFont(new Font("Arial Black", 55.0));
        label1.setCursor(Cursor.HAND);
        label1.setId("1");

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setGraphicTextGap(0.0);
        label0.setLayoutX(5.0);
        label0.setLayoutY(5.0);
        label0.setPrefHeight(62.0);
        label0.setPrefWidth(83.0);
        label0.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label0.setFont(new Font("Arial Black", 55.0));
        label0.setCursor(Cursor.HAND);
        label0.setId("0");

        label3.setAlignment(javafx.geometry.Pos.CENTER);
        label3.setGraphicTextGap(0.0);
        label3.setLayoutX(9.0);
        label3.setLayoutY(109.0);
        label3.setPrefHeight(82.0);
        label3.setPrefWidth(76.0);
        label3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label3.setFont(new Font("Arial Black", 55.0));
        label3.setCursor(Cursor.HAND);
        label3.setId("3");

        label4.setAlignment(javafx.geometry.Pos.CENTER);
        label4.setGraphicTextGap(0.0);
        label4.setLayoutX(112.0);
        label4.setLayoutY(109.0);
        label4.setPrefHeight(82.0);
        label4.setPrefWidth(76.0);
        label4.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label4.setFont(new Font("Arial Black", 55.0));
        label4.setCursor(Cursor.HAND);
        label4.setId("4");

        label5.setAlignment(javafx.geometry.Pos.CENTER);
        label5.setGraphicTextGap(0.0);
        label5.setLayoutX(210.0);
        label5.setLayoutY(108.0);
        label5.setPrefHeight(82.0);
        label5.setPrefWidth(76.0);
        label5.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label5.setFont(new Font("Arial Black", 55.0));
        label5.setCursor(Cursor.HAND);
        label5.setId("5");

        label6.setAlignment(javafx.geometry.Pos.CENTER);
        label6.setGraphicTextGap(0.0);
        label6.setLayoutX(6.0);
        label6.setLayoutY(207.0);
        label6.setPrefHeight(72.0);
        label6.setPrefWidth(83.0);
        label6.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label6.setFont(new Font("Arial Black", 55.0));
        label6.setCursor(Cursor.HAND);
        label6.setId("6");

        label7.setAlignment(javafx.geometry.Pos.CENTER);
        label7.setGraphicTextGap(0.0);
        label7.setLayoutX(108.0);
        label7.setLayoutY(206.0);
        label7.setPrefHeight(72.0);
        label7.setPrefWidth(83.0);
        label7.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label7.setFont(new Font("Arial Black", 55.0));
        label7.setCursor(Cursor.HAND);
        label7.setId("7");

        label8.setAlignment(javafx.geometry.Pos.CENTER);
        label8.setGraphicTextGap(0.0);
        label8.setLayoutX(210.0);
        label8.setLayoutY(206.0);
        label8.setPrefHeight(72.0);
        label8.setPrefWidth(83.0);
        label8.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label8.setFont(new Font("Arial Black", 55.0));
        label8.setCursor(Cursor.HAND);
        label8.setId("8");

        pane1.setLayoutX(-12.0);
        pane1.setLayoutY(-8.0);
        pane1.setPrefHeight(438.0);
        pane1.setPrefWidth(229.0);
        pane1.setStyle("-fx-background-color: #12947F; -fx-border-color: white;");

        labelPlayer.setId("labelPlayer");
        labelPlayer.setLayoutX(76.0);
        labelPlayer.setLayoutY(122.0);
        labelPlayer.setText("Player");
        labelPlayer.setTextFill(javafx.scene.paint.Color.valueOf("#ededed"));
        labelPlayer.setFont(new Font("Arial Black", 22.0));

        labelVS.setId("labelVS");
        labelVS.setLayoutX(96.0);
        labelVS.setLayoutY(174.0);
        labelVS.setText("VS");
        labelVS.setTextFill(javafx.scene.paint.Color.valueOf("#ee9d12"));
        labelVS.setFont(new Font("Arial Black", 30.0));

        labelCumputer.setId("labelCumputer");
        labelCumputer.setLayoutX(55.0);
        labelCumputer.setLayoutY(236.0);
        labelCumputer.setText("Computer");
        labelCumputer.setTextFill(javafx.scene.paint.Color.valueOf("#eeeeee"));
        labelCumputer.setFont(new Font("Arial Black", 22.0));

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
        pane1.getChildren().add(labelCumputer);
        pane1.getChildren().add(buttonBackHome);
        pane1.getChildren().add(buttonRestart);
        getChildren().add(pane1);
        toggleButtonRecord.setDisable(false);
        buttonBackHome.setOnAction((ActionEvent event) -> {
            Scene scene = new Scene(new FXMLChooseGameLevelBase(stage));
            scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            stage.setScene(scene);
        });

        buttonRestart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigation.navigate(stage, new HardLevelAI(stage));
                toggleButtonRecord.setDisable(false);
                toggleButtonRecord.setSelected(false);
            }
        });

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                action(stage, borderLabel[i][j], borderLabel);
            }
        }
    }

    public void action(Stage stage, Label label, Label borderLabel[][]) {
        label.setOnMouseClicked(mouseEvent -> {
            
            toggleButtonRecord.setDisable(true);
            
         //   seed = Seed.CROSS;
            //record=new Record(board, player1, player2);
            if (!has_winner) {
                if (label.getText().equals("")) {
                
                   // label.setText("X");
                    int index = Integer.parseInt(label.getId());
                    gameManager.setCell(index, Seed.CROSS);
                    label.setText(gameManager.getCell(index).content.getIcon());
                    label.setStyle("-fx-text-fill: linear-gradient(to top,ff9900,#ff9900);");
                    label.setMouseTransparent(true);
                    // record.board.add(new Cell(Seed.CROSS, Integer.parseInt(label.getId())));
                    // label.setStyle("-fx-text-fill: linear-gradient(to top,ff9900,#ff9900);");
                    //label.setMouseTransparent(true);
                    int result = minimax(borderLabel, 100, false, true);
                    System.out.println("result=" + result);
                    has_winner = checkWinner(borderLabel) != 1;
                } else {
                    System.out.println("The field is not empty \n");
                }
            }
            int result = checkWinner(borderLabel);
            if (result == 0) {
                gameManager.saveRecord();
                System.out.println("Tie \n");
                Navigation.navigate(stage, new FXMLResultDrawBase(stage, new HardLevelAI(stage)));
            } else {
                if (result == 2) {
                    gameManager.saveRecord();
                    System.out.println("X is winner");
                    Navigation.navigate(stage, new FXMLResultWinBase(stage, Seed.CROSS.getIcon(), new HardLevelAI(stage)));
                } else if (result == -2) {
                    gameManager.saveRecord();
                    System.out.println("O is winner");
                    Navigation.navigate(stage, new FXMLResultLoseBase(stage, new HardLevelAI(stage)));
                } else {
                    System.out.println("No winner yet");
                }
            }

        });

    }

    public int minimax(Label[][] borderLabel, int depth, boolean isMaximizing, boolean firstTime) {
        int result = checkWinner(borderLabel);

        if (depth == 0 || result != 1) {
            return result;
        }

        if (isMaximizing) {
            int finalScore = -10;
            int finalI = 0, finalJ = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (borderLabel[i][j].getText() == "") {
                        borderLabel[i][j].setText("X");
                        int score = minimax(borderLabel, depth - 1, false, false);
                        borderLabel[i][j].setText("");
                        if (score > finalScore) {
                            finalScore = score;
                            finalI = i;
                            finalJ = j;
                        }
                        if (firstTime) {
                         //   System.out.println("score," + i + "," + j + ": " + score + "\n");
                        }
                    }
                }
            }
            if (firstTime) {

              
               // borderLabel[finalI][finalJ].setText("O");
                borderLabel[finalI][finalJ].setStyle("-fx-text-fill: linear-gradient(to top,#f0f0f0,#f0f0f0);");
                // borderLabel[finalI][finalJ].setMouseTransparent(true);

                gameManager.setCell(getIndex(finalI, finalJ), Seed.NOUGHT);
                borderLabel[finalI][finalJ].setText(gameManager.getCell(getIndex(finalI, finalJ)).content.getIcon());
                borderLabel[finalI][finalJ].setMouseTransparent(true);
                //label.setStyle("-fx-text-fill: linear-gradient(to top,ff9900,#ff9900);");

                //  record.board.add(new Cell(Seed.NOUGHT,getIndex(finalI,finalJ)));
            }
            return finalScore;
        } else {
            int finalScore = 10;
            int finalI = 0, finalJ = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (borderLabel[i][j].getText() == "") {
                        borderLabel[i][j].setText("O");
                        int score = minimax(borderLabel, depth - 1, true, false);
                        borderLabel[i][j].setText("");
                        if (score < finalScore) {
                            finalScore = score;
                            finalI = i;
                            finalJ = j;
                        }
                        if (firstTime) {
                            System.out.println("score," + i + "," + j + ": " + score + "\n");
                        }
                    }
                }
            }
            if (firstTime) {
              //   borderLabel[finalI][finalJ].setText("O");
                borderLabel[finalI][finalJ].setStyle("-fx-text-fill: linear-gradient(to top,#f0f0f0,#f0f0f0);");
                //  borderLabel[finalI][finalJ].setMouseTransparent(true);
                //record.board.add(new Cell(Seed.NOUGHT,getIndex(finalI,finalJ))); 
               gameManager.setCell(getIndex(finalI, finalJ), Seed.NOUGHT);
                borderLabel[finalI][finalJ].setText(gameManager.getCell(getIndex(finalI, finalJ)).content.getIcon());
                borderLabel[finalI][finalJ].setMouseTransparent(true);
            }
            return finalScore;
        }
    }

    public boolean haveTheSameValueAndNotEmpty(String x, String y, String z) {
        if ((x.equals(y)) && (x.equals(z)) && (y.equals(z)) && (x != "")) {
            return true;
        }
        return false;
    }

    public int checkWinner(Label borderLabel[][]) {
        for (int i = 0; i < 3; i++) {
            if (haveTheSameValueAndNotEmpty(borderLabel[i][0].getText(), borderLabel[i][1].getText(), borderLabel[i][2].getText())) {
                // return borderLabel[i][0].getText() == "X" ? 2 : -2;
                if (borderLabel[i][0].getText().equals("X")) {
                   // gameManager.saveRecord();
                    return 2;

                } else {
                  //  gameManager.saveRecord();
                    return -2;
                }

            }
        }

        // For cols
        for (int i = 0; i < 3; i++) {
            if (haveTheSameValueAndNotEmpty(borderLabel[0][i].getText(), borderLabel[1][i].getText(), borderLabel[2][i].getText())) {
                // return borderLabel[0][i].getText() == "X" ? 2 : -2;
                if (borderLabel[0][i].getText() == "X") {
                   // gameManager.saveRecord();
                    return 2;

                } else {
                  //  gameManager.saveRecord();
                    return -2;
                }
            }
        }
        // Diameter 1

        if (haveTheSameValueAndNotEmpty(borderLabel[0][0].getText(), borderLabel[1][1].getText(), borderLabel[2][2].getText())) {
            // return borderLabel[0][0].getText() == "X" ? 2 : -2;
            if (borderLabel[0][0].getText() == "X") {
               // gameManager.saveRecord();
                return 2;

            } else {
               // gameManager.saveRecord();
                return -2;
            }
        }

        // Diameter 2
        if (haveTheSameValueAndNotEmpty(borderLabel[0][2].getText(), borderLabel[1][1].getText(), borderLabel[2][0].getText())) {
            // return borderLabel[0][2].getText() == "X" ? 2 : -2;
            if (borderLabel[0][2].getText() == "X") {
              //  gameManager.saveRecord();
                return 2;

            } else {
              //  gameManager.saveRecord();
                return -2;
            }
        }

        // For Tie Case
        boolean tie = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (borderLabel[i][j].getText() == "") {

                    tie = false;
                }
            }
        }
        if (tie) {
          //  gameManager.saveRecord();
            return 0;
        }

        // Else
        return 1;
    }

    public int getIndex(int i, int j) {
        if ((i == 0) && (j == 0)) {
            return 0;
        } else if ((i == 0) && (j == 1)) {
            return 1;
        } else if ((i == 0) && (j == 2)) {
            return 2;
        } else if ((i == 1) && (j == 0)) {
            return 3;
        } else if ((i == 1) && (j == 1)) {
            return 4;
        } else if ((i == 1) && (j == 2)) {
            return 5;
        } else if ((i == 2) && (j == 0)) {
            return 6;
        } else if ((i == 2) && (j == 1)) {
            return 7;
        } else {
            return 8;
        }

    }

}
