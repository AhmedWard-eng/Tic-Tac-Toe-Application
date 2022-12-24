package tictactoegame;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXMLOnlineScreenBaseOnline extends AnchorPane {

    protected final Button button;
    protected final Button button0;
    protected final Text text;
    protected final ImageView imageView;

    public FXMLOnlineScreenBaseOnline() {

        button = new Button();
        button0 = new Button();
        text = new Text();
        imageView = new ImageView();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");

        button.setId("ButtonLoginID");
        button.setLayoutX(241.0);
        button.setLayoutY(252.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(49.0);
        button.setPrefWidth(120.0);
        button.setStyle("-fx-border-color: #000000; -fx-border-width: 3px; -fx-background-color: #ff9900;");
        button.setText("Login");
        button.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        button.setFont(new Font("Comic Sans MS", 18.0));

        button0.setId("ButtonSignUpID");
        button0.setLayoutX(240.0);
        button0.setLayoutY(151.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(49.0);
        button0.setPrefWidth(120.0);
        button0.setStyle("-fx-border-color: #000000; -fx-border-width: 3px; -fx-background-color: #cc0000;");
        button0.setText("Sign Up");
        button0.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        button0.setTextFill(javafx.scene.paint.Color.WHITE);
        button0.setFont(new Font("Comic Sans MS", 18.0));

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(234.0);
        text.setLayoutY(76.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Online");
        text.setFont(new Font("Comic Sans MS Bold", 45.0));

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(-11.0);
        imageView.setLayoutY(258.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(text);
        getChildren().add(imageView);

    }
}
