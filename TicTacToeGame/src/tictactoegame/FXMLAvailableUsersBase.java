package tictactoegame;

import com.jfoenix.controls.JFXListView;
import java.awt.event.MouseEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class FXMLAvailableUsersBase extends AnchorPane {

    protected final JFXListView listViewAvailableUsers;
    protected final Rectangle rectangle;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;

    public FXMLAvailableUsersBase() {

        listViewAvailableUsers = new JFXListView();
        rectangle = new Rectangle();
        label = new Label();
        label0 = new Label();
        label1 = new Label();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");
        getStylesheets().add("Style.css");


        listViewAvailableUsers.setLayoutX(50.0);
        listViewAvailableUsers.setLayoutY(39.0);
        listViewAvailableUsers.setStyle("-fx-background-color: fedb39; -fx-border-color: #363062;");
        listViewAvailableUsers.setOpaqueInsets(new Insets(0.0));
        listViewAvailableUsers.setPrefSize(500, 350);
        
        listViewAvailableUsers.getItems().add(new FXMLUserItemBase());
        listViewAvailableUsers.getItems().add(new FXMLUserItemBase());
        listViewAvailableUsers.getItems().add(new FXMLUserItemBase());
        listViewAvailableUsers.getItems().add(new FXMLUserItemBase());
        listViewAvailableUsers.getItems().add(new FXMLUserItemBase());
        listViewAvailableUsers.getItems().add(new FXMLUserItemBase());
        listViewAvailableUsers.getItems().add(new FXMLUserItemBase());
        listViewAvailableUsers.getItems().add(new FXMLUserItemBase());
        listViewAvailableUsers.getItems().add(new FXMLUserItemBase());
        listViewAvailableUsers.getItems().add(new FXMLUserItemBase());
        listViewAvailableUsers.getItems().add(new FXMLUserItemBase());
        listViewAvailableUsers.getItems().add(new FXMLUserItemBase());
        listViewAvailableUsers.getItems().add(new FXMLUserItemBase());
        listViewAvailableUsers.getItems().add(new FXMLUserItemBase());
        
        
//        listViewAvailableUsers.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//        @Override
//        public void handle(MouseEvent event) {
//            System.out.println("clicked on " + lv.getSelectionModel().getSelectedItem());
//        }
//    });
        
        listViewAvailableUsers.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            
            System.out.println("clicked on " + listViewAvailableUsers.getSelectionModel().getSelectedIndices());
        });

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#fedb39"));
        rectangle.setHeight(36.0);
        rectangle.setLayoutX(50.0);
        rectangle.setLayoutY(3.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#363062"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(504.0);

        label.setLayoutX(59.0);
        label.setLayoutY(10.0);
        label.setText("Score");
        label.setFont(new Font("Comic Sans MS Bold", 15.0));

        label0.setLayoutX(281.0);
        label0.setLayoutY(10.0);
        label0.setText("Label");
        label0.setFont(new Font("Comic Sans MS Bold", 15.0));

        label1.setLayoutX(491.0);
        label1.setLayoutY(10.0);
        label1.setText("Status");
        label1.setFont(new Font("Comic Sans MS Bold", 15.0));

        getChildren().add(listViewAvailableUsers);
        getChildren().add(rectangle);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);

    }
}
