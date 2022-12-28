package tictactoegame;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXMLSignUpBase extends AnchorPane {

    protected final Rectangle rectangle;
    protected final Rectangle rectangle0;
    protected final Rectangle rectangle1;
    protected final Rectangle rectangle2;
    protected final Pane pane;
    protected final Rectangle rectangle3;
    protected final Text text;
    protected final TextField TextFieldMail;
    protected final Button ButtonSigmUp;
    protected final TextField TextFieldpassword;
    protected final TextField TextFieldConfirmPassword;
    protected final Button buttonBackHome;

    public FXMLSignUpBase() {

        rectangle = new Rectangle();
        rectangle0 = new Rectangle();
        rectangle1 = new Rectangle();
        rectangle2 = new Rectangle();
        pane = new Pane();
        rectangle3 = new Rectangle();
        text = new Text();
        TextFieldMail = new TextField();
        ButtonSigmUp = new Button();
        TextFieldpassword = new TextField();
        TextFieldConfirmPassword = new TextField();
        buttonBackHome = new Button();

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
        rectangle.setLayoutX(-135.0);
        rectangle.setLayoutY(59.0);
        rectangle.setRotate(-119.1);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#cf0e0c"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(201.0);

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle0.setHeight(111.0);
        rectangle0.setLayoutX(-135.0);
        rectangle0.setLayoutY(37.0);
        rectangle0.setRotate(-121.0);
        rectangle0.setStroke(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(201.0);

        rectangle1.setArcHeight(5.0);
        rectangle1.setArcWidth(5.0);
        rectangle1.setFill(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle1.setHeight(111.0);
        rectangle1.setLayoutX(486.0);
        rectangle1.setLayoutY(345.0);
        rectangle1.setRotate(-45.0);
        rectangle1.setStroke(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle1.setWidth(201.0);

        rectangle2.setArcHeight(5.0);
        rectangle2.setArcWidth(5.0);
        rectangle2.setFill(javafx.scene.paint.Color.valueOf("#12947f"));
        rectangle2.setHeight(111.0);
        rectangle2.setLayoutX(500.0);
        rectangle2.setLayoutY(345.0);
        rectangle2.setRotate(-48.0);
        rectangle2.setStroke(javafx.scene.paint.Color.valueOf("#12947f"));
        rectangle2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle2.setWidth(201.0);

        pane.setLayoutX(138.0);
        pane.setPrefHeight(408.0);
        pane.setPrefWidth(325.0);
        pane.setStyle("-fx-background-color: #12947F; -fx-border-color: white;");

        rectangle3.setArcHeight(5.0);
        rectangle3.setArcWidth(5.0);
        rectangle3.setFill(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle3.setHeight(54.0);
        rectangle3.setLayoutX(4.0);
        rectangle3.setLayoutY(42.0);
        rectangle3.setStroke(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle3.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle3.setWidth(317.0);

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(97.0);
        text.setLayoutY(79.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Sign Up");
        text.setFont(new Font("Comic Sans MS Bold", 35.0));

        TextFieldMail.setLayoutX(49.0);
        TextFieldMail.setLayoutY(134.0);
        TextFieldMail.setPrefHeight(41.0);
        TextFieldMail.setPrefWidth(237.0);
        TextFieldMail.setPromptText("E-mail");
        TextFieldMail.setStyle("-fx-background-color: #12947F; -fx-border-radius: 15; -fx-background-radius: 15; -fx-border-color: white;");
        TextFieldMail.setFont(new Font(16.0));

        ButtonSigmUp.setLayoutX(243.0);
        ButtonSigmUp.setLayoutY(330.0);
        ButtonSigmUp.setMnemonicParsing(false);
        ButtonSigmUp.setPrefHeight(49.0);
        ButtonSigmUp.setPrefWidth(120.0);
        ButtonSigmUp.setStyle("-fx-background-color: #ff9900; -fx-border-radius: 15; -fx-background-radius: 15;");
        ButtonSigmUp.setText("Sign Up");
        ButtonSigmUp.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        ButtonSigmUp.setFont(new Font("Comic Sans MS", 18.0));
        ButtonSigmUp.setOpaqueInsets(new Insets(0.0));
        ButtonSigmUp.setCursor(Cursor.CLOSED_HAND);

        TextFieldpassword.setLayoutX(187.0);
        TextFieldpassword.setLayoutY(200.0);
        TextFieldpassword.setPrefHeight(41.0);
        TextFieldpassword.setPrefWidth(237.0);
        TextFieldpassword.setPromptText("Password");
        TextFieldpassword.setStyle("-fx-background-color: #12947F; -fx-border-radius: 15; -fx-background-radius: 15; -fx-border-color: white;");
        TextFieldpassword.setFont(new Font(16.0));

        TextFieldConfirmPassword.setLayoutX(187.0);
        TextFieldConfirmPassword.setLayoutY(266.0);
        TextFieldConfirmPassword.setPrefHeight(41.0);
        TextFieldConfirmPassword.setPrefWidth(237.0);
        TextFieldConfirmPassword.setPromptText("Confirm Password");
        TextFieldConfirmPassword.setStyle("-fx-background-color: #12947F; -fx-border-radius: 15; -fx-background-radius: 15; -fx-border-color: white;");
        TextFieldConfirmPassword.setFont(new Font(16.0));

        buttonBackHome.setLayoutX(20.0);
        buttonBackHome.setLayoutY(340.0);
        buttonBackHome.setMnemonicParsing(false);
        buttonBackHome.setPrefHeight(26.0);
        buttonBackHome.setPrefWidth(42.0);
        buttonBackHome.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonBackHome.setText("<");
        buttonBackHome.setFont(new Font("Arial Black", 20.0));

        getChildren().add(rectangle);
        getChildren().add(rectangle0);
        getChildren().add(rectangle1);
        getChildren().add(rectangle2);
        pane.getChildren().add(rectangle3);
        pane.getChildren().add(text);
        pane.getChildren().add(TextFieldMail);
        getChildren().add(pane);
        getChildren().add(ButtonSigmUp);
        getChildren().add(TextFieldpassword);
        getChildren().add(TextFieldConfirmPassword);
        getChildren().add(buttonBackHome);

    }
}
