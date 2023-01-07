package tictactoegame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import navigationLogic.Navigation;

public class FXMLChooseGameLevelBase extends AnchorPane {

    protected final Button buttonHard;
    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final Button buttonMedium;
    protected final AnchorPane anchorPane0;
    protected final Label label0;
    protected final ImageView imageView2;
    protected final ImageView imageView3;
    protected final ImageView imageView4;
    protected final Button buttonEasy;
    protected final AnchorPane anchorPane1;
    protected final Label label1;
    protected final ImageView imageView5;
    protected final ImageView imageView6;
    protected final ImageView imageView7;

    public FXMLChooseGameLevelBase(Stage stage) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(-10.0);
        dropShadow.setOffsetY(10.0);
        dropShadow.setColor(Color.color(0, 0, 0, .16));

        buttonHard = new Button();
        anchorPane = new AnchorPane();
        label = new Label();
        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        buttonMedium = new Button();
        anchorPane0 = new AnchorPane();
        label0 = new Label();
        imageView2 = new ImageView();
        imageView3 = new ImageView();
        imageView4 = new ImageView();
        buttonEasy = new Button();
        anchorPane1 = new AnchorPane();
        label1 = new Label();
        imageView5 = new ImageView();
        imageView6 = new ImageView();
        imageView7 = new ImageView();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #12947F;");

        buttonHard.setLayoutX(426.0);
        buttonHard.setLayoutY(125.0);
        buttonHard.setMaxHeight(USE_PREF_SIZE);
        buttonHard.setMaxWidth(USE_PREF_SIZE);
        buttonHard.setMinHeight(USE_PREF_SIZE);
        buttonHard.setMinWidth(USE_PREF_SIZE);
        buttonHard.setMnemonicParsing(false);
        buttonHard.setPrefHeight(150.0);
        buttonHard.setPrefWidth(150.0);
        buttonHard.setStyle("-fx-background-color: #cc0000; -fx-background-radius: 20;");
        buttonHard.setEffect(dropShadow);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(200.0);

        label.setLayoutX(41.0);
        label.setLayoutY(107.0);
        label.setText("Hard");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Arial Black", 20.0));

        imageView.setFitHeight(40.0);
        imageView.setFitWidth(39.0);
        imageView.setLayoutX(4.0);
        imageView.setLayoutY(52.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Resources/fullStar.png").toExternalForm()));

        imageView0.setFitHeight(40.0);
        imageView0.setFitWidth(39.0);
        imageView0.setLayoutX(45.0);
        imageView0.setLayoutY(12.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("Resources/fullStar.png").toExternalForm()));

        imageView1.setFitHeight(40.0);
        imageView1.setFitWidth(39.0);
        imageView1.setLayoutX(87.0);
        imageView1.setLayoutY(52.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("Resources/fullStar.png").toExternalForm()));
        buttonHard.setGraphic(anchorPane);

        buttonMedium.setLayoutX(231.0);
        buttonMedium.setLayoutY(125.0);
        buttonMedium.setMaxHeight(USE_PREF_SIZE);
        buttonMedium.setMaxWidth(USE_PREF_SIZE);
        buttonMedium.setMinHeight(USE_PREF_SIZE);
        buttonMedium.setMinWidth(USE_PREF_SIZE);
        buttonMedium.setMnemonicParsing(false);
        buttonMedium.setPrefHeight(150.0);
        buttonMedium.setPrefWidth(150.0);
        buttonMedium.setStyle("-fx-background-color: #ee5007; -fx-background-radius: 20;");
        buttonMedium.setEffect(dropShadow);
        anchorPane0.setPrefHeight(200.0);
        anchorPane0.setPrefWidth(200.0);

        label0.setLayoutX(24.0);
        label0.setLayoutY(110.0);
        label0.setText("Medium");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("Arial Black", 20.0));

        imageView2.setFitHeight(40.0);
        imageView2.setFitWidth(39.0);
        imageView2.setLayoutX(5.0);
        imageView2.setLayoutY(52.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("Resources/fullStar.png").toExternalForm()));

        imageView3.setFitHeight(40.0);
        imageView3.setFitWidth(39.0);
        imageView3.setLayoutX(46.0);
        imageView3.setLayoutY(12.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("Resources/fullStar.png").toExternalForm()));

        imageView4.setFitHeight(40.0);
        imageView4.setFitWidth(39.0);
        imageView4.setLayoutX(88.0);
        imageView4.setLayoutY(52.0);
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);
        imageView4.setImage(new Image(getClass().getResource("Resources/emptyStar.png").toExternalForm()));
        buttonMedium.setGraphic(anchorPane0);

        buttonEasy.setLayoutX(34.0);
        buttonEasy.setLayoutY(125.0);
        buttonEasy.setMaxHeight(USE_PREF_SIZE);
        buttonEasy.setMaxWidth(USE_PREF_SIZE);
        buttonEasy.setMinHeight(USE_PREF_SIZE);
        buttonEasy.setMinWidth(USE_PREF_SIZE);
        buttonEasy.setMnemonicParsing(false);
        buttonEasy.setPrefHeight(150.0);
        buttonEasy.setPrefWidth(150.0);
        buttonEasy.setStyle("-fx-background-color: #f5de2c; -fx-background-radius: 20;");
        buttonEasy.setEffect(dropShadow);
        
        
        anchorPane1.setPrefHeight(200.0);
        anchorPane1.setPrefWidth(200.0);
        
        
        buttonEasy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigation.navigate(stage, new FXMLGameOnePlayerEasyBase(stage));
            }
        });

        label1.setLayoutX(41.0);
        label1.setLayoutY(108.0);
        label1.setText("Easy");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("Arial Black", 20.0));

        imageView5.setFitHeight(40.0);
        imageView5.setFitWidth(39.0);
        imageView5.setLayoutX(3.0);
        imageView5.setLayoutY(52.0);
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);
        imageView5.setImage(new Image(getClass().getResource("Resources/fullStar.png").toExternalForm()));

        imageView6.setFitHeight(40.0);
        imageView6.setFitWidth(39.0);
        imageView6.setLayoutX(44.0);
        imageView6.setLayoutY(12.0);
        imageView6.setPickOnBounds(true);
        imageView6.setPreserveRatio(true);
        imageView6.setImage(new Image(getClass().getResource("Resources/emptyStar.png").toExternalForm()));

        imageView7.setFitHeight(40.0);
        imageView7.setFitWidth(39.0);
        imageView7.setLayoutX(86.0);
        imageView7.setLayoutY(52.0);
        imageView7.setPickOnBounds(true);
        imageView7.setPreserveRatio(true);
        imageView7.setImage(new Image(getClass().getResource("Resources/emptyStar.png").toExternalForm()));
        buttonEasy.setGraphic(anchorPane1);

        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(imageView0);
        anchorPane.getChildren().add(imageView1);
        getChildren().add(buttonHard);
        anchorPane0.getChildren().add(label0);
        anchorPane0.getChildren().add(imageView2);
        anchorPane0.getChildren().add(imageView3);
        anchorPane0.getChildren().add(imageView4);
        getChildren().add(buttonMedium);
        anchorPane1.getChildren().add(label1);
        anchorPane1.getChildren().add(imageView5);
        anchorPane1.getChildren().add(imageView6);
        anchorPane1.getChildren().add(imageView7);
        getChildren().add(buttonEasy);

    }
}
