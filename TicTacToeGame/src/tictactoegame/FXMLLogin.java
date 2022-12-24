package tictactoegame;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXMLLogin extends AnchorPane {

    protected final Button ButtonLoginID;
    protected final Text text;
    protected final ImageView ImageViewHome;
    protected final TextField TextFieldMail;
    protected final TextField TextFieldPassword;

    public FXMLLogin() {

        ButtonLoginID = new Button();
        text = new Text();
        ImageViewHome = new ImageView();
        TextFieldMail = new TextField();
        TextFieldPassword = new TextField();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");

        ButtonLoginID.setLayoutX(252.0);
        ButtonLoginID.setLayoutY(296.0);
        ButtonLoginID.setMnemonicParsing(false);
        ButtonLoginID.setPrefHeight(49.0);
        ButtonLoginID.setPrefWidth(120.0);
        ButtonLoginID.setStyle("-fx-border-color: #000000; -fx-border-width: 3px; -fx-background-color: #ff9900;");
        ButtonLoginID.setText("Login");
        ButtonLoginID.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        ButtonLoginID.setFont(new Font("Comic Sans MS", 18.0));

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(256.0);
        text.setLayoutY(85.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Login");
        text.setFont(new Font("Comic Sans MS Bold", 45.0));

        ImageViewHome.setFitHeight(69.0);
        ImageViewHome.setFitWidth(81.0);
        ImageViewHome.setLayoutX(49.0);
        ImageViewHome.setLayoutY(286.0);
        ImageViewHome.setPickOnBounds(true);
        ImageViewHome.setPreserveRatio(true);
        ImageViewHome.setImage(new Image(getClass().getResource("Resources/homeIcon.png").toExternalForm()));

        TextFieldMail.setLayoutX(149.0);
        TextFieldMail.setLayoutY(136.0);
        TextFieldMail.setPrefHeight(31.0);
        TextFieldMail.setPrefWidth(323.0);
        TextFieldMail.setPromptText("E-mail");

        TextFieldPassword.setLayoutX(151.0);
        TextFieldPassword.setLayoutY(210.0);
        TextFieldPassword.setPrefHeight(31.0);
        TextFieldPassword.setPrefWidth(323.0);
        TextFieldPassword.setPromptText("Password");

        getChildren().add(ButtonLoginID);
        getChildren().add(text);
        getChildren().add(ImageViewHome);
        getChildren().add(TextFieldMail);
        getChildren().add(TextFieldPassword);

    }
}
