package tictactoegame;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class FXMLGameHistoryItemBase extends AnchorPane {

    protected final Label gameNameLabel;
    protected final Label playerNameLabel,playerTwoNameLabel;
    

    public FXMLGameHistoryItemBase() {

        gameNameLabel = new Label();
        playerNameLabel = new Label();
        playerTwoNameLabel = new Label();

        setId("AnchorPane");
        setPrefHeight(85.0);
        setPrefWidth(580.0);
        setWidth(USE_PREF_SIZE);
        setStyle("-fx-background-color: #12947F;");

        gameNameLabel.setAlignment(javafx.geometry.Pos.CENTER);
        gameNameLabel.setLayoutX(150.0);
        gameNameLabel.setLayoutY(29.0);
        gameNameLabel.setText("Sat Jan 07 13:18:57 EET 2023");
        gameNameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        gameNameLabel.setTextFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));
        gameNameLabel.setWrapText(true);
        gameNameLabel.setFont(new Font("Arial Black", 18.0));
        gameNameLabel.setPadding(new Insets(0.0, 5.0, 0.0, 5.0));

        playerNameLabel.setAlignment(javafx.geometry.Pos.CENTER);
        playerNameLabel.setLayoutX(14.0);
        playerNameLabel.setLayoutY(30.0);
        playerNameLabel.setText("Marina");
        playerNameLabel.setTextFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));
        playerNameLabel.setWrapText(true);
        playerNameLabel.setFont(new Font("Arial Black", 18.0));

        playerTwoNameLabel.setAlignment(javafx.geometry.Pos.CENTER);
        playerTwoNameLabel.setLayoutX(480.0);
        playerTwoNameLabel.setLayoutY(30.0);
        playerTwoNameLabel.setText("Wardward");
        playerTwoNameLabel.setTextFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));
        playerTwoNameLabel.setWrapText(true);
        playerTwoNameLabel.setFont(new Font("Arial Black", 18.0));
        
//        playerTwoNameLabel.setFitHeight(104.0);
//        playerTwoNameLabel.setFitWidth(80.0);
//        playerTwoNameLabel.setLayoutX(506.0);
//        playerTwoNameLabel.setPickOnBounds(true);
//        playerTwoNameLabel.setPreserveRatio(true);
//        playerTwoNameLabel.setImage(new Image(getClass().getResource("Resources/startArrow.png").toExternalForm()));

        getChildren().add(gameNameLabel);
        getChildren().add(playerNameLabel);
        getChildren().add(playerTwoNameLabel);

    }
}
