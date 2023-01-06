package tictactoegame;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import navigationLogic.Navigation;

public class FXMLHomeBase extends AnchorPane {

    protected final ImageView imageViewLogo;
    protected final AnchorPane anchorPane;
    protected final Rectangle rectangle;
    protected final Label label;
    protected final AnchorPane anchorPane0;
    protected final Button buttonOnePlayer;
    protected final Glow glow;
    protected final Button buttonTwoPlayer;
    protected final Glow glow0;
    protected final Button buttonOnline;
    protected final Glow glow1;
    protected final Rectangle rectangle0;
    protected final Label label0;
    protected final Glow glow2;
    protected final Line line;
    protected final Line line0;
    protected final Line line1;
    protected final Line line2;
    protected final Label label1;
    protected final Glow glow3;
    protected final Label label2;
    protected final Glow glow4;
    protected final Button buttonRecord;

    protected final DialogPane dialogPaneName;
    protected final GridPane gridPane;
    protected final Label labelFirstPlayer;
    protected final Label labelSecondPlayer;
    protected final TextField textFieldFirstPlayer;
    protected final TextField textFieldSecondPlayer;
    protected String firstPlayer, secondPlayer;
    protected Boolean buttonAdded;
    protected ButtonType OkButtonType;
    protected ButtonType cancelButtonType;
    protected Dialog<ButtonType> dialog;

    public FXMLHomeBase(Stage stage) {

        imageViewLogo = new ImageView();
        anchorPane = new AnchorPane();
        rectangle = new Rectangle();
        label = new Label();
        anchorPane0 = new AnchorPane();
        buttonOnePlayer = new Button();
        glow = new Glow();
        buttonTwoPlayer = new Button();
        glow0 = new Glow();
        buttonOnline = new Button();
        glow1 = new Glow();
        rectangle0 = new Rectangle();
        buttonRecord = new Button();

        label0 = new Label();
        glow2 = new Glow();
        line = new Line();
        line0 = new Line();
        line1 = new Line();
        line2 = new Line();
        label1 = new Label();
        glow3 = new Glow();
        label2 = new Label();
        glow4 = new Glow();

        dialogPaneName = new DialogPane();
        gridPane = new GridPane();
        gridPane.setVgap(10);

        labelFirstPlayer = new Label("Player 1: ");
        labelSecondPlayer = new Label("Player 2: ");
        textFieldFirstPlayer = new TextField();
        textFieldSecondPlayer = new TextField();
        buttonAdded = false;

        textFieldFirstPlayer.setStyle("-fx-background-color: #12947F; -fx-border-radius: 15; -fx-background-radius: 15; -fx-border-color: white; -fx-text-fill: white;");
        textFieldSecondPlayer.setStyle("-fx-background-color: #12947F; -fx-border-radius: 15; -fx-background-radius: 15; -fx-border-color: white; -fx-text-fill: white;");
        dialogPaneName.setStyle("-fx-background-color: #22726e;");

        initializeDialogTwoPlayers();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");

        imageViewLogo.setFitHeight(114.0);
        imageViewLogo.setFitWidth(253.0);
        imageViewLogo.setLayoutX(278.0);
        imageViewLogo.setLayoutY(36.0);
        imageViewLogo.setPickOnBounds(true);
        imageViewLogo.setPreserveRatio(true);
        imageViewLogo.setImage(new Image(getClass().getResource("Resources/Capture.PNG").toExternalForm()));

        anchorPane.setPrefHeight(450.0);
        anchorPane.setPrefWidth(195.0);
        anchorPane.setStyle("-fx-background-color: #12947F;");

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#ff9900"));
        rectangle.setHeight(69.0);
        rectangle.setLayoutX(1.0);
        rectangle.setLayoutY(55.0);
        rectangle.setSmooth(false);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#ff9900"));
        rectangle.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(200.0);

        label.setLayoutX(58.0);
        label.setLayoutY(64.0);
        label.setText("Menu");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#f5f3f3"));
        label.setFont(new Font("Comic Sans MS", 33.0));

        anchorPane0.setLayoutX(28.0);
        anchorPane0.setLayoutY(134.0);
        anchorPane0.setPrefHeight(98.0);
        anchorPane0.setPrefWidth(147.0);

        buttonOnePlayer.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        buttonOnePlayer.setLayoutY(24.0);
        buttonOnePlayer.setMnemonicParsing(false);
        buttonOnePlayer.setPrefHeight(45.0);
        buttonOnePlayer.setPrefWidth(147.0);
        buttonOnePlayer.setStyle("-fx-background-color: #ff9900; -fx-background-radius: 10;");
        buttonOnePlayer.setText("One Player");
        buttonOnePlayer.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        buttonOnePlayer.setTextFill(javafx.scene.paint.Color.valueOf("#fcf6f6"));
        buttonOnePlayer.setFont(new Font("Arial Black", 18.0));
        buttonOnePlayer.setCursor(Cursor.CLOSED_HAND);

        buttonOnePlayer.setEffect(glow);

        buttonTwoPlayer.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        buttonTwoPlayer.setLayoutY(86.0);
        buttonTwoPlayer.setMnemonicParsing(false);
        buttonTwoPlayer.setPrefHeight(45.0);
        buttonTwoPlayer.setPrefWidth(147.0);
        buttonTwoPlayer.setStyle("-fx-background-color: #ee5007; -fx-background-radius: 10;");
        buttonTwoPlayer.setText("Two Player");
        buttonTwoPlayer.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        buttonTwoPlayer.setTextFill(javafx.scene.paint.Color.valueOf("#fcf6f6"));
        buttonTwoPlayer.setFont(new Font("Arial Black", 18.0));
        buttonTwoPlayer.setCursor(Cursor.CLOSED_HAND);

        buttonTwoPlayer.setEffect(glow0);

        buttonOnline.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        buttonOnline.setLayoutY(150.0);
        buttonOnline.setMnemonicParsing(false);
        buttonOnline.setPrefHeight(45.0);
        buttonOnline.setPrefWidth(147.0);
        buttonOnline.setStyle("-fx-background-color: #cc0000; -fx-background-radius: 10;");
        buttonOnline.setText("Onlline ");
        buttonOnline.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        buttonOnline.setTextFill(javafx.scene.paint.Color.valueOf("#fcf6f6"));
        buttonOnline.setFont(new Font("Arial Black", 18.0));
        buttonOnline.setCursor(Cursor.CLOSED_HAND);

        buttonOnline.setEffect(glow1);

        buttonRecord.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
//        buttonRecord.setLayoutX(-13.0);
        buttonRecord.setLayoutY(210.0);
        buttonRecord.setMnemonicParsing(false);
        buttonRecord.setPrefHeight(45.0);
        buttonRecord.setPrefWidth(147.0);
        buttonRecord.setStyle("-fx-background-color: #ccaa11; -fx-background-radius: 10; -fx-text-fill: #cc0000");
        buttonRecord.setText("Records");
        buttonRecord.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        buttonRecord.setTextFill(javafx.scene.paint.Color.valueOf("#fcf6f6"));
        buttonRecord.setFont(new Font("Arial Black", 18.0));
        buttonRecord.setCursor(Cursor.CLOSED_HAND);

        buttonRecord.setEffect(glow2);

        buttonRecord.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigation.navigate(stage, new FXMLGameOnlineBase(stage));
            }
        });

        buttonOnline.setOnAction((ActionEvent event) -> {

          //  NetworkConnection network = new NetworkConnection();
            navigationLogic.Navigation.navigate(stage, new FXMLOnlineScreenBase(stage));
        });

        buttonOnePlayer.setOnAction((ActionEvent event) -> {
            Scene scene = new Scene(new FXMLGameOnePlayerBase(stage));
            scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            stage.setScene(scene);
        });
        buttonTwoPlayer.setOnAction((event) -> {

            readingPlayerName(stage);

        });

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#f5de2c"));
        rectangle0.setHeight(171.0);
        rectangle0.setLayoutX(277.0);
        rectangle0.setLayoutY(163.0);
        rectangle0.setStroke(javafx.scene.paint.Color.valueOf("#ff9900"));
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(236.0);

        label0.setLayoutX(299.0);
        label0.setLayoutY(168.0);
        label0.setText("X");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#ff0707"));
        label0.setFont(new Font("Arial Black", 31.0));

        label0.setEffect(glow2);

        line.setEndX(106.0);
        line.setLayoutX(401.0);
        line.setLayoutY(217.0);
        line.setStartX(-121.0);
        line.setStroke(javafx.scene.paint.Color.valueOf("#fffafa"));
        line.setStrokeWidth(3.0);

        line0.setEndX(107.0);
        line0.setLayoutX(401.0);
        line0.setLayoutY(281.0);
        line0.setStartX(-121.0);
        line0.setStroke(javafx.scene.paint.Color.valueOf("#fffafa"));
        line0.setStrokeWidth(3.0);

        line1.setEndX(19.0);
        line1.setEndY(33.0);
        line1.setLayoutX(420.0);
        line1.setLayoutY(299.0);
        line1.setStartX(19.0);
        line1.setStartY(-134.0);
        line1.setStroke(javafx.scene.paint.Color.valueOf("#fffafa"));
        line1.setStrokeWidth(3.0);

        line2.setEndX(-59.0);
        line2.setEndY(102.0);
        line2.setLayoutX(409.0);
        line2.setLayoutY(229.0);
        line2.setStartX(-59.0);
        line2.setStartY(-63.0);
        line2.setStroke(javafx.scene.paint.Color.valueOf("#fffafa"));
        line2.setStrokeWidth(3.0);

        label1.setLayoutX(379.0);
        label1.setLayoutY(284.0);
        label1.setText("O");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#ff5d06"));
        label1.setFont(new Font("Arial Black", 35.0));

        label1.setEffect(glow3);

        label2.setLayoutX(463.0);
        label2.setLayoutY(228.0);
        label2.setText("X");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#ff0707"));
        label2.setFont(new Font("Arial Black", 31.0));

        label2.setEffect(glow4);

        getChildren().add(imageViewLogo);
        anchorPane.getChildren().add(rectangle);
        anchorPane.getChildren().add(label);
        anchorPane0.getChildren().add(buttonOnePlayer);
        anchorPane0.getChildren().add(buttonTwoPlayer);
        anchorPane0.getChildren().add(buttonOnline);
        anchorPane.getChildren().add(anchorPane0);
        anchorPane0.getChildren().add(buttonRecord);
        getChildren().add(anchorPane);
        getChildren().add(rectangle0);
        getChildren().add(label0);
        getChildren().add(line);
        getChildren().add(line0);
        getChildren().add(line1);
        getChildren().add(line2);
        getChildren().add(label1);
        getChildren().add(label2);

    }

    private void readingPlayerName(Stage stage) {
        textFieldFirstPlayer.clear();
        textFieldSecondPlayer.clear();

        Optional<ButtonType> clickedButton = dialog.showAndWait();

        if (clickedButton.get() == OkButtonType) {
            firstPlayer = textFieldFirstPlayer.getText();
            secondPlayer = textFieldSecondPlayer.getText();

            if (firstPlayer.equals("")) {
                firstPlayer = "Player 1";
            }
            if (secondPlayer.equals("")) {
                secondPlayer = "Player 2";
            }

            Scene scene = new Scene(new FXMLGameTwoPlayerBase(stage, firstPlayer, secondPlayer));
            scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            stage.setScene(scene);

        } else if (clickedButton.get() == cancelButtonType) {
            //gridPane.getChildren().clear();
        }
    }

    private void initializeDialogTwoPlayers() {

        dialogPaneName.setPadding(new Insets(0, 10, 0, 10));

        labelFirstPlayer.setFont(new Font("Comic Sans MS Bold", 15.0));
        labelFirstPlayer.setTextFill(Color.WHITE);
        labelSecondPlayer.setFont(new Font("Comic Sans MS Bold", 15.0));
        labelSecondPlayer.setTextFill(Color.WHITE);

        textFieldFirstPlayer.setPromptText("First player name");
        textFieldSecondPlayer.setPromptText("Second player name");

        if (gridPane.getChildren().size() < 4) {
            gridPane.add(labelFirstPlayer, 0, 0);
            gridPane.add(textFieldFirstPlayer, 1, 0);
            gridPane.add(labelSecondPlayer, 0, 1);
            gridPane.add(textFieldSecondPlayer, 1, 1);

        }

        dialogPaneName.setContent(gridPane);

        dialog = new Dialog<>();
        dialog.setDialogPane(dialogPaneName);
        dialog.setTitle("player names");

        OkButtonType = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        if (!buttonAdded) {
            dialogPaneName.getButtonTypes().addAll(OkButtonType, cancelButtonType);

            Node okButton = dialogPaneName.lookupButton(OkButtonType);
            okButton.setStyle("-fx-background-color: #ff9900; -fx-border-radius: 15; -fx-background-radius: 15; -fx-fontfamily: 'Comic-Sans MS'");

            Node cancelButton = dialogPaneName.lookupButton(cancelButtonType);
            cancelButton.setStyle("-fx-background-color: #ff9900; -fx-border-radius: 15; -fx-background-radius: 15;");

            buttonAdded = true;
        }
    }
}
