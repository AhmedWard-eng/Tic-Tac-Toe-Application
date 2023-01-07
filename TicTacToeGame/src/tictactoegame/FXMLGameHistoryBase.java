package tictactoegame;

import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FXMLGameHistoryBase extends AnchorPane {

    protected final JFXListView listViewGameHistory;
    protected final Rectangle rectangle;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Button buttonBackHome;

    public FXMLGameHistoryBase(Stage stage) {

        listViewGameHistory = new JFXListView();
        rectangle = new Rectangle();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        buttonBackHome = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");
        getStylesheets().add("/tictactoegame/View/Style.css");

        listViewGameHistory.setLayoutX(9.0);
        listViewGameHistory.setLayoutY(75.0);
        listViewGameHistory.setPrefSize(620, 260);
        listViewGameHistory.setStyle("-fx-background-color: #12947F; -fx-border-color: white; -fx-background-radius: 10; -fx-border-radius: 10;");
        listViewGameHistory.setOpaqueInsets(new Insets(0.0));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle.setHeight(46.0);
        rectangle.setLayoutX(9.0);
        rectangle.setLayoutY(14.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(625.0);

        label.setLayoutX(26.0);
        label.setLayoutY(23.0);
        label.setText("Player one");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Arial Black", 20.0));

        label0.setLayoutX(255.0);
        label0.setLayoutY(23.0);
        label0.setText("Game Date");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#fffdfd"));
        label0.setFont(new Font("Arial Black", 20.0));

        label1.setLayoutX(490.0);
        label1.setLayoutY(23.0);
        label1.setText("Player two");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#fffafa"));
        label1.setFont(new Font("Arial Black", 20.0));

        buttonBackHome.setLayoutX(26.0);
        buttonBackHome.setLayoutY(343.0);
        buttonBackHome.setMnemonicParsing(false);
        buttonBackHome.setPrefHeight(26.0);
        buttonBackHome.setPrefWidth(42.0);
        buttonBackHome.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonBackHome.setText("<");
        buttonBackHome.setFont(new Font("Arial Black", 20.0));
        buttonBackHome.setCursor(Cursor.CLOSED_HAND);

        getChildren().add(listViewGameHistory);
        getChildren().add(rectangle);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(buttonBackHome);
        
        listViewGameHistory.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            
            System.out.println("clicked on " + listViewGameHistory.getSelectionModel().getSelectedIndices());
        });
        
        buttonBackHome.setOnAction((ActionEvent event) -> {
            Scene scene = new Scene(new FXMLHomeBase(stage));
            scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            stage.setScene(scene);
        });
        
        listViewGameHistory.getItems().add(new FXMLGameHistoryItemBase());
        listViewGameHistory.getItems().add(new FXMLGameHistoryItemBase());
        listViewGameHistory.getItems().add(new FXMLGameHistoryItemBase());
        listViewGameHistory.getItems().add(new FXMLGameHistoryItemBase());
        listViewGameHistory.getItems().add(new FXMLGameHistoryItemBase());
        listViewGameHistory.getItems().add(new FXMLGameHistoryItemBase());
        
        

    }
}
