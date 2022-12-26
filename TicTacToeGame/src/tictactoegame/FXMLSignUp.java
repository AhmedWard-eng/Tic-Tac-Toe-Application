package tictactoegame;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXMLSignUp extends AnchorPane {

    protected final Text text;
    protected final ImageView ImageViewHome;
    protected final TextField TextFieldMail;
    protected final TextField TextFieldPassword;
    protected final TextField TextFieldConfirmPassword;
    protected final Button ButtonSignUp;

    public FXMLSignUp() {

        text = new Text();
        ImageViewHome = new ImageView();
        TextFieldMail = new TextField();
        TextFieldPassword = new TextField();
        TextFieldConfirmPassword = new TextField();
        ButtonSignUp = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(239.0);
        text.setLayoutY(74.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Sign Up");
        text.setFont(new Font("Comic Sans MS Bold", 45.0));

        ImageViewHome.setFitHeight(69.0);
        ImageViewHome.setFitWidth(81.0);
        ImageViewHome.setLayoutX(38.0);
        ImageViewHome.setLayoutY(296.0);
        ImageViewHome.setPickOnBounds(true);
        ImageViewHome.setPreserveRatio(true);
        ImageViewHome.setImage(new Image(getClass().getResource("Resources/homeIcon.png").toExternalForm()));

        TextFieldMail.setLayoutX(161.0);
        TextFieldMail.setLayoutY(132.0);
        TextFieldMail.setPrefHeight(31.0);
        TextFieldMail.setPrefWidth(323.0);
        TextFieldMail.setPromptText("E-mail");

        TextFieldPassword.setLayoutX(161.0);
        TextFieldPassword.setLayoutY(185.0);
        TextFieldPassword.setPrefHeight(31.0);
        TextFieldPassword.setPrefWidth(323.0);
        TextFieldPassword.setPromptText("Password");

        TextFieldConfirmPassword.setLayoutX(161.0);
        TextFieldConfirmPassword.setLayoutY(237.0);
        TextFieldConfirmPassword.setPrefHeight(31.0);
        TextFieldConfirmPassword.setPrefWidth(323.0);
        TextFieldConfirmPassword.setPromptText("Confirm password");

        ButtonSignUp.setDefaultButton(true);
        ButtonSignUp.setLayoutX(263.0);
        ButtonSignUp.setLayoutY(306.0);
        ButtonSignUp.setMnemonicParsing(false);
        ButtonSignUp.setPrefHeight(49.0);
        ButtonSignUp.setPrefWidth(120.0);
        ButtonSignUp.setStyle("-fx-border-color: #000000; -fx-border-width: 3px; -fx-background-color: #cc0000;");
        ButtonSignUp.setText("Sign Up");
        ButtonSignUp.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        ButtonSignUp.setTextFill(javafx.scene.paint.Color.WHITE);
        ButtonSignUp.setFont(new Font("Comic Sans MS", 18.0));

        getChildren().add(text);
        getChildren().add(ImageViewHome);
        getChildren().add(TextFieldMail);
        getChildren().add(TextFieldPassword);
        getChildren().add(TextFieldConfirmPassword);
        getChildren().add(ButtonSignUp);

    }
}
