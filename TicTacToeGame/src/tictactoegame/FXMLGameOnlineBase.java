package tictactoegame;

import beans.GameBean;
import beans.RequestGameBean;
import beans.GameFinishBean;
import beans.GameStatus;
import com.google.gson.Gson;
import com.jfoenix.controls.JFXToggleButton;
import game.Cell;
import game.ComputerPlayer;
import game.GameManager;
import game.Seed;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import navigationLogic.Navigation;

public class FXMLGameOnlineBase extends AnchorPane implements OnlineGameMove {

    ServerSocket serverSocket;
    Socket socket;
    DataInputStream dis;
    public PrintStream ps;
    String msg;
    Thread thread;
    private GameManager gameManager;
    private Gson gson;

    int playerTurn = 0;

    String winnerSymbol;

    String player1name, player2name;
    Stage stage;
    int playerXCount = 0;
    int playerOCount = 0;

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
    protected final Label labelPlayer1;
    protected final Label labelVS;
    protected final Label labelPlayer2;
    protected final Button buttonBackHome;
//    protected final Button buttonRestart;
    protected final Label labelPlayer1Score;
    protected final Label labelPlayer2Score;
    private ArrayList<Label> labelsBoard;
    Seed yourSymbol;
    private RequestGameBean requestGameBean;
    NetworkConnection networkConnection;
    String userName;
    int userScore;

    public FXMLGameOnlineBase(Stage stage, RequestGameBean requestGameBean, boolean start, int otherPlayerScore) {

        this.stage = stage;
        this.requestGameBean = requestGameBean;

        networkConnection = new NetworkConnection(this);
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
        labelPlayer1 = new Label();
        labelVS = new Label();
        labelPlayer2 = new Label();
        buttonBackHome = new Button();
//        buttonRestart = new Button();
        labelPlayer1Score = new Label();
        labelPlayer2Score = new Label();
        userName = NetworkConnection.userOnline != null ? NetworkConnection.userOnline.getUserName() : "";
        userScore = NetworkConnection.userOnline != null ? NetworkConnection.userOnline.getScore() : 0;

        this.getStyleClass().add("Pane");
        init();
        labelsBoard = new ArrayList<>(Arrays.asList(label0, label1, label2, label3, label4, label5, label6, label7, label8));

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
        gson = new Gson();

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

        labelsBoard.forEach((label) -> {
            setLabelsMouseListener(label);
        });

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

        pane1.setId("pane 1");
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

        labelPlayer1.setId("labelPlayer");
        labelPlayer1.setLayoutX(68.0);
        labelPlayer1.setLayoutY(97.0);
        labelPlayer1.setText(userName);
        labelPlayer1.setTextFill(javafx.scene.paint.Color.valueOf("#ededed"));
        labelPlayer1.setFont(new Font("Arial Black", 22.0));

        labelVS.setId("labelVS");
        labelVS.setLayoutX(93.0);
        labelVS.setLayoutY(175.0);
        labelVS.setText("VS");
        labelVS.setTextFill(javafx.scene.paint.Color.valueOf("#e12810"));
        labelVS.setFont(new Font("Arial Black", 30.0));

        labelPlayer2.setId("labelCumputer");
        labelPlayer2.setLayoutX(67.0);
        labelPlayer2.setLayoutY(233.0);
        labelPlayer2.setText(requestGameBean.myUserName);
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

//        buttonRestart.setLayoutX(131.0);
//        buttonRestart.setLayoutY(342.0);
//        buttonRestart.setMnemonicParsing(false);
//        buttonRestart.setPrefHeight(42.0);
//        buttonRestart.setPrefWidth(83.0);
//        buttonRestart.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
//        buttonRestart.setText("Restart");
//        buttonRestart.setFont(new Font("Arial Bold", 15.0));
//        buttonRestart.setCursor(Cursor.CLOSED_HAND);
        labelPlayer1Score.setId("labelPlayer");
        labelPlayer1Score.setLayoutX(85.0);
        labelPlayer1Score.setLayoutY(129.0);
        labelPlayer1Score.setText(String.valueOf(userScore));
        labelPlayer1Score.setTextFill(javafx.scene.paint.Color.valueOf("#ff9900"));
        labelPlayer1Score.setFont(new Font("Arial Black", 22.0));

        labelPlayer2Score.setId("labelPlayer");
        labelPlayer2Score.setLayoutX(88.0);
        labelPlayer2Score.setLayoutY(264.0);
        labelPlayer2Score.setText(otherPlayerScore + "");
        labelPlayer2Score.setTextFill(javafx.scene.paint.Color.valueOf("#ff9900"));
        labelPlayer2Score.setFont(new Font("Arial Black", 22.0));

        buttonBackHome.setOnAction((ActionEvent event) -> {
            Map map = new HashMap();
            map.put("operation", "withdraw");
            map.put("ip", requestGameBean.myIp);

            map.put("otherPlayeruserName", requestGameBean.myUserName);
            map.put("userName", userName);
            String msg = new Gson().toJson(map);
//            networkConnection.sendMessage();

            RepeatedUserDialog.assureWithdrawing(networkConnection, msg, stage);
//            Scene scene = new Scene(new FXMLHomeBase(stage));
//            scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
//            stage.setScene(scene);

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
        pane1.getChildren().add(toggleButtonRecord);
        pane1.getChildren().add(labelPlayer1);
        pane1.getChildren().add(labelVS);
        pane1.getChildren().add(labelPlayer2);
        pane1.getChildren().add(buttonBackHome);
//        pane1.getChildren().add(buttonRestart);
        pane1.getChildren().add(labelPlayer1Score);
        pane1.getChildren().add(labelPlayer2Score);
        getChildren().add(pane1);
        newGame();
        if (start) {
            yourSymbol = Seed.CROSS;
        } else {
            yourSymbol = Seed.NOUGHT;
            setTextDisabled();
        }

        stage.setOnCloseRequest((event) -> {
            Map map = new HashMap();
            map.put("operation", "logoutwithdraw");
            map.put("ip", requestGameBean.myIp);
            map.put("otherPlayeruserName", requestGameBean.myUserName);
            map.put("userName", userName);
            String msg = new Gson().toJson(map);
            RepeatedUserDialog.logoutWithDrawing(networkConnection, msg, stage, event);
            }); 
    }

    void init() {
        gameManager = new GameManager(userName, requestGameBean.myUserName);
    }
    
    

    void newGame() {
        for (int i = 0; i < labelsBoard.size(); i++) {
            labelsBoard.get(i).setText(" ");
            labelsBoard.get(i).setMouseTransparent(false);
        }
        toggleButtonRecord.setDisable(false);
        toggleButtonRecord.setSelected(false);

        setTextEnabled();
        gameManager.newGame();
    }

    private void setTextEnabled() {
        for (int i = 0; i < labelsBoard.size(); i++) {
            labelsBoard.get(i).setDisable(false);
        }
    }

    private void setTextDisabled() {
        for (int i = 0; i < labelsBoard.size(); i++) {
            labelsBoard.get(i).setDisable(true);
        }
    }

    public void setLabelsMouseListener(Label label) {

        label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                toggleButtonRecord.setDisable(true);
                int index = Integer.parseInt(label.getId());
                gameManager.setCell(index, yourSymbol);
                label.setText(gameManager.getCell(index).content.getIcon());
                label.setStyle("-fx-text-fill: linear-gradient(to top,ff9900,#ff9900);");
                label.setMouseTransparent(true);
                GameBean gameBean = new GameBean("gameMove", requestGameBean.myIp, new Cell(yourSymbol, index));
                String message = new Gson().toJson(gameBean);
                networkConnection.sendMessage(message);
                if ((gameManager.isPlayerXWon() && yourSymbol == Seed.CROSS) || (gameManager.isPlayerOWon() && yourSymbol == Seed.NOUGHT)) {
                    String gameFinishMessage = gson.toJson(new GameFinishBean("gameFinish", GameStatus.WIN, userName));
                    networkConnection.sendMessage(gameFinishMessage);
                    gameManager.saveRecord();
                    NetworkConnection.userOnline.setScore(NetworkConnection.userOnline.getScore() + 5);
                    Navigation.navigate(stage, new FXMLResultWinBase(stage, yourSymbol.getIcon(), new FXMLAvailableUsersBase(stage, FXMLAvailableUsersBase.usersList)));
                } else if (gameManager.isDraw()) {
                    String gameFinishMessage = gson.toJson(new GameFinishBean("gameFinish", GameStatus.DRAW, userName));
                    networkConnection.sendMessage(gameFinishMessage);
                    gameManager.saveRecord();
                    Navigation.navigate(stage, new FXMLResultDrawBase(stage, new FXMLAvailableUsersBase(stage, FXMLAvailableUsersBase.usersList)));
                }
                setTextDisabled();
            }

        });
    }

    @Override
    public void getMove(Cell cell) {
        System.out.println("cell = " + cell.content.getIcon());
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                gameManager.setCell(cell.index, cell.content);
                labelsBoard.get(cell.index).setText(cell.content.getIcon());
                labelsBoard.get(cell.index).setStyle("-fx-text-fill: linear-gradient(to top,#f0f0f0,#f0f0f0);");
                labelsBoard.get(cell.index).setMouseTransparent(true);
                setTextEnabled();
                if ((gameManager.isPlayerOWon() && yourSymbol == Seed.CROSS) || (gameManager.isPlayerXWon() && yourSymbol == Seed.NOUGHT)) {
                    String gameFinishMessage = gson.toJson(new GameFinishBean("gameFinish", GameStatus.LOSE, userName));
                    networkConnection.sendMessage(gameFinishMessage);
                    gameManager.saveRecord();
                    Navigation.navigate(stage, new FXMLResultLoseBase(stage, new FXMLAvailableUsersBase(stage, FXMLAvailableUsersBase.usersList)));
                    setTextDisabled();
                    NetworkConnection.userOnline.setScore(NetworkConnection.userOnline.getScore() - 5);
                } else if (gameManager.isDraw()) {
                    String gameFinishMessage = gson.toJson(new GameFinishBean("gameFinish", GameStatus.DRAW, userName));
                    networkConnection.sendMessage(gameFinishMessage);
                    gameManager.saveRecord();
                    Navigation.navigate(stage, new FXMLResultDrawBase(stage, new FXMLAvailableUsersBase(stage, FXMLAvailableUsersBase.usersList)));
                }
            }
        });
    }

}
