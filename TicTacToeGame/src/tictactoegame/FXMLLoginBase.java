package tictactoegame;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXMLLoginBase extends AnchorPane {

    protected final Button buttonBackHome;
    protected final AnchorPane anchorPane;
    protected final Button ButtonLogin;
    protected final TextField TextFieldMail;
    protected final TextField TextFiellPassword;
    protected final Rectangle rectangle;
    protected final Text text;
    protected final Rectangle rectangle0;
    protected final Rectangle rectangle1;

    public FXMLLoginBase(Stage stage) {

        buttonBackHome = new Button();
        anchorPane = new AnchorPane();
        ButtonLogin = new Button();
        TextFieldMail = new TextField();
        TextFiellPassword = new TextField();
        rectangle = new Rectangle();
        text = new Text();
        rectangle0 = new Rectangle();
        rectangle1 = new Rectangle();
        
        buttonBackHome.setOnAction((ActionEvent event) -> {
            navigationLogic.Navigation.navigate(stage,new FXMLHomeBase(stage));
        });
        
        ButtonLogin.setOnAction((ActionEvent event) -> {
            navigationLogic.Navigation.navigate(stage,new FXMLAvailableUsersBase(stage));
        });

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");

        buttonBackHome.setLayoutX(20.0);
        buttonBackHome.setLayoutY(340.0);
        buttonBackHome.setMnemonicParsing(false);
        buttonBackHome.setPrefHeight(26.0);
        buttonBackHome.setPrefWidth(42.0);
        buttonBackHome.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonBackHome.setText("<");
        buttonBackHome.setFont(new Font("Arial Black", 20.0));
        buttonBackHome.setCursor(Cursor.CLOSED_HAND);

        anchorPane.setLayoutX(147.0);
        anchorPane.setPrefHeight(400.0);
        anchorPane.setPrefWidth(331.0);
        anchorPane.setStyle("-fx-border-color: white; -fx-background-color: #12947F;");

        ButtonLogin.setLayoutX(109.0);
        ButtonLogin.setLayoutY(326.0);
        ButtonLogin.setMnemonicParsing(false);
        ButtonLogin.setPrefHeight(49.0);
        ButtonLogin.setPrefWidth(120.0);
        ButtonLogin.setStyle("-fx-background-color: #ff9900; -fx-border-radius: 15; -fx-background-radius: 15;");
        ButtonLogin.setText("Login");
        ButtonLogin.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        ButtonLogin.setFont(new Font("Comic Sans MS", 18.0));
        ButtonLogin.setCursor(Cursor.CLOSED_HAND);

        TextFieldMail.setLayoutX(51.0);
        TextFieldMail.setLayoutY(159.0);
        TextFieldMail.setPrefHeight(41.0);
        TextFieldMail.setPrefWidth(237.0);
        TextFieldMail.setPromptText("E-mail");
        TextFieldMail.setStyle("-fx-background-color: #12947F; -fx-border-radius: 15; -fx-background-radius: 15; -fx-border-color: white;");
        TextFieldMail.setFont(new Font(16.0));

        TextFiellPassword.setLayoutX(51.0);
        TextFiellPassword.setLayoutY(238.0);
        TextFiellPassword.setPrefHeight(41.0);
        TextFiellPassword.setPrefWidth(237.0);
        TextFiellPassword.setPromptText("Password");
        TextFiellPassword.setStyle("-fx-background-color: #12947F; -fx-border-radius: 15; -fx-background-radius: 15; -fx-border-color: white;");
        TextFiellPassword.setFont(new Font(16.0));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle.setHeight(64.0);
        rectangle.setLayoutX(2.0);
        rectangle.setLayoutY(54.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(327.0);

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(109.0);
        text.setLayoutY(97.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Login");
        text.setFont(new Font("Comic Sans MS Bold", 45.0));

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#cf0e0c"));
        rectangle0.setHeight(134.0);
        rectangle0.setLayoutX(-154.0);
        rectangle0.setLayoutY(112.0);
        rectangle0.setRotate(-55.5);
        rectangle0.setStroke(javafx.scene.paint.Color.valueOf("#cf0e0c"));
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(194.0);

        rectangle1.setArcHeight(5.0);
        rectangle1.setArcWidth(5.0);
        rectangle1.setFill(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle1.setHeight(111.0);
        rectangle1.setLayoutX(-110.0);
        rectangle1.setLayoutY(-6.0);
        rectangle1.setRotate(-61.4);
        rectangle1.setStroke(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle1.setWidth(201.0);

        getChildren().add(buttonBackHome);
        anchorPane.getChildren().add(ButtonLogin);
        anchorPane.getChildren().add(TextFieldMail);
        anchorPane.getChildren().add(TextFiellPassword);
        anchorPane.getChildren().add(rectangle);
        anchorPane.getChildren().add(text);
        getChildren().add(anchorPane);
        getChildren().add(rectangle0);
        getChildren().add(rectangle1);

    }
}
