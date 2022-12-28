package tictactoegame;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public  class FXMLUserItemBase extends AnchorPane {

    protected final Label labelScore;
    protected final Label labelName;
    protected final Label labelStatus;

    public FXMLUserItemBase() {

        labelScore = new Label();
        labelName = new Label();
        labelStatus = new Label();

        setId("AnchorPane");
        setPrefHeight(50.0);
        setPrefWidth(465.0);
        setStyle("-fx-background-color: fedb39;");

        labelScore.setAlignment(javafx.geometry.Pos.CENTER);
        labelScore.setLayoutX(6.0);
        labelScore.setLayoutY(8.0);
        labelScore.setStyle("-fx-border-color: #363062; -fx-border-width: 3;");
        labelScore.setText("100");
        labelScore.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        labelScore.setTextFill(javafx.scene.paint.Color.valueOf("#363062"));
        labelScore.setWrapText(true);
        labelScore.setFont(new Font("Arial Black", 19.0));
        labelScore.setPadding(new Insets(0.0, 5.0, 0.0, 5.0));

        labelName.setAlignment(javafx.geometry.Pos.CENTER);
        labelName.setLayoutX(140.0);
        labelName.setLayoutY(11.0);
        labelName.setText("Marina Abd Elmalak");
        labelName.setTextFill(javafx.scene.paint.Color.valueOf("#363062"));
        labelName.setWrapText(true);
        labelName.setFont(new Font("Comic Sans MS Bold", 20.0));

        labelStatus.setAlignment(javafx.geometry.Pos.CENTER);
        labelStatus.setLayoutX(400.0);
        labelStatus.setLayoutY(11.0);
        labelStatus.setText("online");
        labelStatus.setTextFill(javafx.scene.paint.Color.valueOf("#363062"));
        labelStatus.setWrapText(true);
        labelStatus.setFont(new Font("Comic Sans MS Bold", 20.0));

        getChildren().add(labelScore);
        getChildren().add(labelName);
        getChildren().add(labelStatus);

    }
}
