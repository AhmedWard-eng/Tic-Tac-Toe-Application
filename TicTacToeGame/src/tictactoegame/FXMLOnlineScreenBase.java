package tictactoegame;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXMLOnlineScreenBase extends AnchorPane {

    protected final Text text;
    protected final Button ButtonLogin;
    protected final Glow glow;
    protected final Button ButtonSignUp;
    protected final Glow glow0;
    protected final Button buttonBackHome;

    public FXMLOnlineScreenBase() {

        text = new Text();
        ButtonLogin = new Button();
        glow = new Glow();
        ButtonSignUp = new Button();
        glow0 = new Glow();
        buttonBackHome = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(232.0);
        text.setLayoutY(121.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Online");
        text.setFont(new Font("Comic Sans MS Bold", 45.0));

        ButtonLogin.setLayoutX(240.0);
        ButtonLogin.setLayoutY(157.0);
        ButtonLogin.setMnemonicParsing(false);
        ButtonLogin.setPrefHeight(49.0);
        ButtonLogin.setPrefWidth(120.0);
        ButtonLogin.setStyle("-fx-background-color: #ff9900; -fx-border-radius: 15; -fx-background-radius: 15;");
        ButtonLogin.setText("Login");
        ButtonLogin.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        ButtonLogin.setFont(new Font("Comic Sans MS", 18.0));

        ButtonLogin.setEffect(glow);
        ButtonLogin.setCursor(Cursor.CLOSED_HAND);

        ButtonSignUp.setLayoutX(240.0);
        ButtonSignUp.setLayoutY(231.0);
        ButtonSignUp.setMnemonicParsing(false);
        ButtonSignUp.setPrefHeight(49.0);
        ButtonSignUp.setPrefWidth(120.0);
        ButtonSignUp.setStyle("-fx-background-color: #ff9900; -fx-border-radius: 15; -fx-background-radius: 15;");
        ButtonSignUp.setText("Sign Up");
        ButtonSignUp.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        ButtonSignUp.setFont(new Font("Comic Sans MS", 18.0));

        ButtonSignUp.setEffect(glow0);
        ButtonSignUp.setCursor(Cursor.CLOSED_HAND);

        buttonBackHome.setLayoutX(20.0);
        buttonBackHome.setLayoutY(341.0);
        buttonBackHome.setMnemonicParsing(false);
        buttonBackHome.setPrefHeight(26.0);
        buttonBackHome.setPrefWidth(42.0);
        buttonBackHome.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonBackHome.setText("<");
        buttonBackHome.setFont(new Font("Arial Black", 20.0));
        
        buttonBackHome.setCursor(Cursor.CLOSED_HAND);
        
        getChildren().add(text);
        getChildren().add(ButtonLogin);
        getChildren().add(ButtonSignUp);
        getChildren().add(buttonBackHome);

    }
}
