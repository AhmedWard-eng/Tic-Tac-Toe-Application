package tictactoegame;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXMLOnlineScreen extends AnchorPane {

    protected final Button ButtonLogin;
    protected final Button ButtonSignUp;
    protected final Text text;
    protected final ImageView ImageViewHome;

    public FXMLOnlineScreen() {

        ButtonLogin = new Button();
        ButtonSignUp = new Button();
        text = new Text();
        ImageViewHome = new ImageView();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");

        ButtonLogin.setLayoutX(241.0);
        ButtonLogin.setLayoutY(252.0);
        ButtonLogin.setMnemonicParsing(false);
        ButtonLogin.setPrefHeight(49.0);
        ButtonLogin.setPrefWidth(120.0);
        ButtonLogin.setStyle("-fx-border-color: #000000; -fx-border-width: 3px; -fx-background-color: #ff9900;");
        ButtonLogin.setText("Login");
        ButtonLogin.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        ButtonLogin.setFont(new Font("Comic Sans MS", 18.0));

        ButtonSignUp.setLayoutX(240.0);
        ButtonSignUp.setLayoutY(151.0);
        ButtonSignUp.setMnemonicParsing(false);
        ButtonSignUp.setPrefHeight(49.0);
        ButtonSignUp.setPrefWidth(120.0);
        ButtonSignUp.setStyle("-fx-border-color: #000000; -fx-border-width: 3px; -fx-background-color: #cc0000;");
        ButtonSignUp.setText("Sign Up");
        ButtonSignUp.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        ButtonSignUp.setTextFill(javafx.scene.paint.Color.WHITE);
        ButtonSignUp.setFont(new Font("Comic Sans MS", 18.0));

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(234.0);
        text.setLayoutY(76.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Online");
        text.setFont(new Font("Comic Sans MS Bold", 45.0));

        ImageViewHome.setFitHeight(69.0);
        ImageViewHome.setFitWidth(81.0);
        ImageViewHome.setLayoutX(49.0);
        ImageViewHome.setLayoutY(286.0);
        ImageViewHome.setPickOnBounds(true);
        ImageViewHome.setPreserveRatio(true);
        ImageViewHome.setImage(new Image(getClass().getResource("Resources/homeIcon.png").toExternalForm()));

        getChildren().add(ButtonLogin);
        getChildren().add(ButtonSignUp);
        getChildren().add(text);
        getChildren().add(ImageViewHome);

    }
}
