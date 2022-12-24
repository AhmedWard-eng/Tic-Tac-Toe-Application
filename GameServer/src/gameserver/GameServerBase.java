package gameserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    ServerSocket serverSocket;
    Socket s;
    DataInputStream dis ;
    PrintStream ps;
     private void loadData(){
        paneview.getChildren().clear();
        ObservableList<PieChart.Data> list=FXCollections.observableArrayList();
        list.add(new PieChart.Data("Online",5000));
        list.add(new PieChart.Data("Offline",7000));
        PieChart piechart=new PieChart(list);
        piechart.setTitle("Players Chart");
        paneview.getChildren().add(piechart);
    }
    public GameServerBase(Stage stage) throws IOException {

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
        
        
        buttonOn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try {
                    serverSocket = new ServerSocket(5005);
                    
                    while(true)
                    {
                         s = serverSocket.accept();
                        
                    }
                } catch (IOException ex) {
                    Logger.getLogger(GameServerBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        buttonOff.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try {
                    s.close();
                    serverSocket.close();
                    
                } catch (IOException ex) {
                    Logger.getLogger(GameServerBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        loadData();
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

        paneview.setLayoutX(155.0);
        paneview.setLayoutY(5.0);
        paneview.setPrefHeight(170.0);
        paneview.setPrefWidth(350.0);

        getChildren().add(rectangle);
        getChildren().add(rectangle0);
        getChildren().add(rectangle1);
        pane.getChildren().add(rectangle2);
        pane.getChildren().add(buttonOn);
        pane.getChildren().add(buttonOff);
        pane.getChildren().add(label);
        getChildren().add(pane);
        getChildren().add(paneview);

    }
}
