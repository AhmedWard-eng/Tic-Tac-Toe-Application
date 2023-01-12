package tictactoegame;

import beans.UserOnline;
import com.google.gson.Gson;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class FXMLUserItemBase extends AnchorPane {

    protected final Label labelScore;
    protected final Label labelName;
    protected final Label labelStatus;

//    NetworkConnection networkConnection;
//    Gson g;
//    UserOnline p;

    public FXMLUserItemBase(String userName, String status, int score) {
        //  networkConnection=new NetworkConnection();
//        g = new Gson();
//        String lis = NetworkConnection.listPlayer.get(0);
//        p = g.fromJson(lis, UserOnline.class);

        labelScore = new Label();
        labelName = new Label();
        labelStatus = new Label();

        setId("AnchorPane");
        setPrefHeight(50.0);
        setPrefWidth(465.0);

        setStyle("-fx-background-color: #12947F;");

        labelScore.setAlignment(javafx.geometry.Pos.CENTER);
        labelScore.setLayoutX(23.0);
        labelScore.setLayoutY(12.0);
        labelScore.setText(String.valueOf(score));//String.valueOf(p.getScore())
        labelScore.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        labelScore.setTextFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));

        labelScore.setWrapText(true);
        labelScore.setFont(new Font("Arial Black", 19.0));
        labelScore.setPadding(new Insets(0.0, 5.0, 0.0, 5.0));

        labelName.setAlignment(javafx.geometry.Pos.CENTER);

        labelName.setLayoutX(160.0);
        labelName.setLayoutY(10.0);
        labelName.setText("         "+userName);
        labelName.setTextFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));
        labelName.setWrapText(true);
        labelName.setFont(new Font("Arial Black", 20.0));

        labelStatus.setAlignment(javafx.geometry.Pos.CENTER);
        labelStatus.setLayoutX(455.0);
        labelStatus.setLayoutY(8.0);
        labelStatus.setText(status);
        labelStatus.setTextFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));
        labelStatus.setWrapText(true);
        labelStatus.setFont(new Font("Arial Black", 21.0));

        getChildren().add(labelScore);
        getChildren().add(labelName);
        getChildren().add(labelStatus);

    }

    
}
