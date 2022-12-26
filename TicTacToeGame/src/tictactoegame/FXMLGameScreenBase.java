package tictactoegame;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class FXMLGameScreenBase extends AnchorPane {

    protected final BorderPane borderPane;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final ToggleButton toggleButton;
    protected final BorderPane borderPane0;
    protected final Button button;
    protected final Button button0;

    public FXMLGameScreenBase() {

        borderPane = new BorderPane();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        toggleButton = new ToggleButton();
        borderPane0 = new BorderPane();
        button = new Button();
        button0 = new Button();

        getStyleClass().add("AnchorPane");
        borderPane.setMaxHeight(USE_PREF_SIZE);
        borderPane.setMaxWidth(USE_PREF_SIZE);
        borderPane.setMinHeight(USE_PREF_SIZE);
        borderPane.setMinWidth(USE_PREF_SIZE);
        borderPane.setOpacity(0.0);
        borderPane.setPrefHeight(400.0);
        borderPane.setPrefWidth(600.0);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setPrefHeight(247.0);
        gridPane.setPrefWidth(565.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        borderPane.setCenter(gridPane);

        BorderPane.setAlignment(toggleButton, javafx.geometry.Pos.CENTER);
        toggleButton.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        toggleButton.setMnemonicParsing(false);
        toggleButton.setText("ToggleButton");
        borderPane.setTop(toggleButton);

        BorderPane.setAlignment(borderPane0, javafx.geometry.Pos.CENTER);

        BorderPane.setAlignment(button, javafx.geometry.Pos.CENTER);
        button.setMnemonicParsing(false);
        button.setText("Button");
        borderPane0.setLeft(button);

        BorderPane.setAlignment(button0, javafx.geometry.Pos.CENTER);
        button0.setMnemonicParsing(false);
        button0.setText("Button");
        borderPane0.setRight(button0);
        BorderPane.setMargin(borderPane0, new Insets(0.0, 40.0, 20.0, 40.0));
        borderPane.setBottom(borderPane0);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        getChildren().add(borderPane);

    }
}
