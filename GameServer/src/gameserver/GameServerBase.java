package gameserver;

import DataBaseLayer.DataAccessLayer;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameServerBase extends AnchorPane {

    protected final Rectangle rectangle;
    protected final Rectangle rectangle0;
    protected final Rectangle rectangle1;
    protected final Pane pane;
    protected final Rectangle rectangle2;
    protected final Button buttonOn;
    protected final Glow glow;
    protected final Button buttonOff;
    protected final Glow glow0;
    protected final Label label;
    protected final Pane paneview;
    protected final Rectangle rect;

    ServerSocket serverSocket;
    Socket s;
    DataInputStream dis;
    PrintStream ps;
    Server server;
    DataAccessLayer test;

    private void loadData() throws SQLException {
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
                        try {
                            Label online = new Label();
                            Label offline = new Label();
                            offline.setLayoutX(-120.0);
                            offline.setLayoutY(320.0);
                            offline.setTextFill(javafx.scene.paint.Color.valueOf("#f5f3f3"));
                            offline.setFont(new Font("Arial Black", 14.0));
                            online.setLayoutX(-120.0);
                            online.setLayoutY(350.0);
                            online.setTextFill(javafx.scene.paint.Color.valueOf("#f5f3f3"));
                            online.setFont(new Font("Arial Black", 14.0));
                            
                            test = new DataAccessLayer();
                            paneview.getChildren().clear();
                            
                            ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
                            list.add(new PieChart.Data("Online", test.getOnlineRate()));
                            list.add(new PieChart.Data("Offline", test.getOfflineRate()));
                            PieChart piechart = new PieChart(list);
                            piechart.setTitle("Players Chart");
                            online.setText("OnLine : " + (int) test.getOnlineRate());
                            offline.setText("OffLine : " + (int) test.getOfflineRate());
                            paneview.getChildren().add(piechart);
                            paneview.getChildren().add(online);
                            paneview.getChildren().add(offline);
                        } catch (SQLException ex) {
                            Logger.getLogger(GameServerBase.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        }).start();

//        new Thread() {
//            @Override
//            public void run() {
//                //while ((server.isOpened)&&(!serverSocket.isClosed())) {
//                try {
//                    Thread.sleep(100);
//                    
//                    ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
//                    list.add(new PieChart.Data("Online", test.getOnlineRate()));
//                    list.add(new PieChart.Data("Offline", test.getOfflineRate()));
//                    PieChart piechart = new PieChart(list);
//                    piechart.setTitle("Players Chart");
//                    online.setText("OnLine : " + (int) test.getOnlineRate());
//                    offline.setText("OffLine : " + (int) test.getOfflineRate());
//                    paneview.getChildren().add(piechart);
//                    paneview.getChildren().add(online);
//                    paneview.getChildren().add(offline);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(GameServerBase.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (SQLException ex) {
//                    Logger.getLogger(GameServerBase.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            //  }
//        }.start();
    }

    public GameServerBase(Stage stage) throws IOException, SQLException {
        rect = new Rectangle();
        rectangle = new Rectangle();
        rectangle0 = new Rectangle();
        rectangle1 = new Rectangle();
        pane = new Pane();
        rectangle2 = new Rectangle();
        buttonOn = new Button();
        glow = new Glow();
        buttonOff = new Button();
        glow0 = new Glow();
        label = new Label();
        paneview = new Pane();

        buttonOff.setDisable(true);

//        buttonOn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                server = new Server();
//                buttonOn.setDisable(true);
//                buttonOff.setDisable(false);
//                while (server.isOpened) {
//                    new Thread(){
//                        @Override
//                        public void run() {
//                            try {
//                                loadData();  //To change body of generated methods, choose Tools | Templates.
//                            } catch (SQLException ex) {
//                                Logger.getLogger(GameServerBase.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                        }
//                        
//                    }.start();
//                }
//            }
//        });
        buttonOn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                server = new Server();
                buttonOn.setDisable(true);
                buttonOff.setDisable(false);
                Thread t = new Thread() {
                    @Override
                    public void run() {
                        try {
                            loadData();  //To change body of generated methods, choose Tools | Templates.
                        } catch (SQLException ex) {
                            Logger.getLogger(GameServerBase.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                };

                while (server.isOpened) {

                    if (!t.isAlive()) {
                        t.start();
                    }

                }
               
            }
        });

        buttonOff.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    server.closeConnection();
                    buttonOn.setDisable(false);
                    buttonOff.setDisable(true);

                } catch (IOException ex) {
                    Logger.getLogger(GameServerBase.class.getName()).log(Level.SEVERE, null, ex);
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

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#cf0e0c"));
        rectangle.setHeight(111.0);
        rectangle.setLayoutX(416.0);
        rectangle.setLayoutY(-119.0);
        rectangle.setRotate(-119.1);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#cf0e0c"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(201.0);

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle0.setHeight(111.0);
        rectangle0.setLayoutX(190.0);
        rectangle0.setLayoutY(412.0);
        rectangle0.setRotate(-121.0);
        rectangle0.setStroke(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(201.0);

        rectangle1.setArcHeight(5.0);
        rectangle1.setArcWidth(5.0);
        rectangle1.setFill(javafx.scene.paint.Color.valueOf("#12947f"));
        rectangle1.setHeight(111.0);
        rectangle1.setLayoutX(425.0);
        rectangle1.setLayoutY(415.0);
        rectangle1.setRotate(-48.0);
        rectangle1.setStroke(javafx.scene.paint.Color.valueOf("#12947f"));
        rectangle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle1.setWidth(201.0);

        pane.setPrefHeight(450.0);
        pane.setPrefWidth(201.0);
        pane.setStyle("-fx-background-color: #12947F;");

        rectangle2.setArcHeight(5.0);
        rectangle2.setArcWidth(5.0);
        rectangle2.setFill(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle2.setHeight(54.0);
        rectangle2.setLayoutY(78.0);
        rectangle2.setStroke(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle2.setWidth(201.0);

        rect.setArcHeight(5.0);
        rect.setArcWidth(5.0);
        rect.setFill(javafx.scene.paint.Color.valueOf("#d0880b"));
        rect.setHeight(80.0);
        rect.setLayoutX(0.0);
        rect.setLayoutY(300.0);
        rect.setStroke(javafx.scene.paint.Color.valueOf("#d0880b"));
        rect.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rect.setWidth(201.0);

        buttonOn.setLayoutX(59.0);
        buttonOn.setLayoutY(155.0);
        buttonOn.setMnemonicParsing(false);
        buttonOn.setPrefHeight(41.0);
        buttonOn.setPrefWidth(85.0);
        buttonOn.setStyle("-fx-background-color: #54B435; -fx-border-radius: 10; -fx-background-radius: 10;");
        buttonOn.setText("ON");
        buttonOn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        buttonOn.setTextFill(javafx.scene.paint.Color.WHITE);
        buttonOn.setCursor(Cursor.CLOSED_HAND);

        buttonOn.setEffect(glow);
        buttonOn.setFont(new Font("Arial Black", 18.0));

        buttonOff.setLayoutX(59.0);
        buttonOff.setLayoutY(219.0);
        buttonOff.setMnemonicParsing(false);
        buttonOff.setPrefHeight(41.0);
        buttonOff.setPrefWidth(85.0);
        buttonOff.setStyle("-fx-background-color: #cc0000; -fx-border-radius: 10; -fx-background-radius: 10;");
        buttonOff.setText("OFF");
        buttonOff.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        buttonOff.setTextFill(javafx.scene.paint.Color.WHITE);
        buttonOff.setCursor(Cursor.CLOSED_HAND);

        buttonOff.setEffect(glow0);
        buttonOff.setFont(new Font("Arial Black", 18.0));

        label.setLayoutX(52.0);
        label.setLayoutY(87.0);
        label.setText("Server ");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#f5f3f3"));
        label.setFont(new Font("Arial Black", 25.0));

        paneview.setLayoutX(130.0);
        paneview.setLayoutY(0.0);
        paneview.setPrefHeight(150.0);
        paneview.setPrefWidth(10.0);
        paneview.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
        // System.out.println(paneview.widthProperty().floatValue());

        pane.getChildren().add(paneview);
        getChildren().add(rectangle);
        getChildren().add(rectangle0);
        getChildren().add(rectangle1);
        getChildren().add(pane);
        pane.getChildren().add(rectangle2);
        pane.getChildren().add(label);
        pane.getChildren().add(buttonOn);
        pane.getChildren().add(buttonOff);

    }
}
