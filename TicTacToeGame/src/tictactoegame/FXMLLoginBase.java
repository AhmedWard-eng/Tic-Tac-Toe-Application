package tictactoegame;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXMLLoginBase extends AnchorPane {

    protected final ImageView imageView;
    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final Button ButtonLoginID;
    protected final TextField TextFieldMail;
    protected final Label label0;
    protected final TextField TextFiellPassword;
    protected final Text text;
    protected final Button buttonBackHome;
    protected final Rectangle rectangle;
    protected final Rectangle rectangle0;

    public FXMLLoginBase() {

        imageView = new ImageView();
        anchorPane = new AnchorPane();
        label = new Label();
        ButtonLoginID = new Button();
        TextFieldMail = new TextField();
        label0 = new Label();
        TextFiellPassword = new TextField();
        text = new Text();
        buttonBackHome = new Button();
        rectangle = new Rectangle();
        rectangle0 = new Rectangle();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");

        imageView.setFitHeight(497.0);
        imageView.setFitWidth(327.0);
        imageView.setLayoutX(136.0);
        imageView.setLayoutY(-81.0);
        imageView.setOpacity(0.46);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Resources/The leader.png").toExternalForm()));

        anchorPane.setLayoutX(136.0);
        anchorPane.setPrefHeight(411.0);
        anchorPane.setPrefWidth(327.0);
        anchorPane.setStyle("-fx-border-color: white;");

        label.setLayoutX(7.0);
        label.setLayoutY(163.0);
        label.setText("E-mail :");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));
        label.setFont(new Font("System Bold", 20.0));

        ButtonLoginID.setLayoutX(109.0);
        ButtonLoginID.setLayoutY(312.0);
        ButtonLoginID.setMnemonicParsing(false);
        ButtonLoginID.setPrefHeight(49.0);
        ButtonLoginID.setPrefWidth(120.0);
        ButtonLoginID.setStyle("-fx-background-color: #ff9900; -fx-border-radius: 15; -fx-background-radius: 15;");
        ButtonLoginID.setText("Login");
        ButtonLoginID.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        ButtonLoginID.setFont(new Font("Comic Sans MS", 18.0));
        ButtonLoginID.setCursor(Cursor.CLOSED_HAND);

        TextFieldMail.setLayoutX(83.0);
        TextFieldMail.setLayoutY(159.0);
        TextFieldMail.setPrefHeight(41.0);
        TextFieldMail.setPrefWidth(237.0);
        TextFieldMail.setPromptText("E-mail");
        TextFieldMail.setStyle("-fx-background-color: #12947F; -fx-border-radius: 15; -fx-background-radius: 15; -fx-border-color: white;");
        TextFieldMail.setFont(new Font(16.0));

        label0.setLayoutX(7.0);
        label0.setLayoutY(232.0);
        label0.setText("Password :");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));
        label0.setFont(new Font("System Bold", 20.0));

        TextFiellPassword.setLayoutX(113.0);
        TextFiellPassword.setLayoutY(227.0);
        TextFiellPassword.setPrefHeight(41.0);
        TextFiellPassword.setPrefWidth(206.0);
        TextFiellPassword.setPromptText("Password");
        TextFiellPassword.setStyle("-fx-background-color: #12947F; -fx-border-radius: 15; -fx-background-radius: 15; -fx-border-color: white;");
        TextFiellPassword.setFont(new Font(16.0));

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(107.0);
        text.setLayoutY(114.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Login");
        text.setFont(new Font("Comic Sans MS Bold", 45.0));

        buttonBackHome.setLayoutX(20.0);
        buttonBackHome.setLayoutY(340.0);
        buttonBackHome.setMnemonicParsing(false);
        buttonBackHome.setPrefHeight(26.0);
        buttonBackHome.setPrefWidth(42.0);
        buttonBackHome.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonBackHome.setText("<");
        buttonBackHome.setFont(new Font("Arial Black", 20.0));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#cf0e0c"));
        rectangle.setHeight(153.0);
        rectangle.setLayoutX(-162.0);
        rectangle.setLayoutY(88.0);
        rectangle.setRotate(-55.5);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#cf0e0c"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(247.0);

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle0.setHeight(111.0);
        rectangle0.setLayoutX(-100.0);
        rectangle0.setLayoutY(11.0);
        rectangle0.setRotate(-45.0);
        rectangle0.setStroke(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(201.0);

        getChildren().add(imageView);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(ButtonLoginID);
        anchorPane.getChildren().add(TextFieldMail);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(TextFiellPassword);
        anchorPane.getChildren().add(text);
        getChildren().add(anchorPane);
        getChildren().add(buttonBackHome);
        getChildren().add(rectangle);
        getChildren().add(rectangle0);

    }
}
