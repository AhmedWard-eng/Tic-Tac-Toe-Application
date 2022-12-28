package tictactoegame;

import com.jfoenix.controls.JFXListView;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class FXMLAvailablesBase2 extends AnchorPane {

    protected final JFXListView listViewAvailableUsers;
    protected final Rectangle rectangle;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;

    public FXMLAvailablesBase2() {

        listViewAvailableUsers = new JFXListView();
        rectangle = new Rectangle();
        label = new Label();
        label0 = new Label();
        label1 = new Label();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");
        getStylesheets().add("/tictactoegame/Style.css");

        listViewAvailableUsers.setLayoutX(15.0);
        listViewAvailableUsers.setLayoutY(66.0);
        listViewAvailableUsers.setStyle("-fx-background-color: #12947F; -fx-border-color: white; -fx-background-radius: 10; -fx-border-radius: 10;");
        listViewAvailableUsers.setPrefSize(585, 350);
        
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
        
        listViewAvailableUsers.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            
            System.out.println("clicked on " + listViewAvailableUsers.getSelectionModel().getSelectedIndices());
        });
        
        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle.setHeight(46.0);
        rectangle.setLayoutX(10.0);
        rectangle.setLayoutY(12.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(583.0);

        label.setLayoutX(52.0);
        label.setLayoutY(20.0);
        label.setText("Score");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Arial Black", 20.0));

        label0.setLayoutX(263.0);
        label0.setLayoutY(20.0);
        label0.setText("Name");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#fffdfd"));
        label0.setFont(new Font("Arial Black", 20.0));

        label1.setLayoutX(476.0);
        label1.setLayoutY(20.0);
        label1.setText("Status");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#fffafa"));
        label1.setFont(new Font("Arial Black", 20.0));

        getChildren().add(listViewAvailableUsers);
        getChildren().add(rectangle);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);

    }
}
