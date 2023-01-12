package tictactoegame;

import com.jfoenix.controls.JFXListView;
import game.GameInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import navigationLogic.Navigation;

public class FXMLGameHistoryBase extends AnchorPane {

    protected final JFXListView listViewGameHistory;
    protected final Rectangle rectangle;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Button buttonBackHome;
    ArrayList<GameInfo> gameInfoList;

    public FXMLGameHistoryBase(Stage stage) {

        listViewGameHistory = new JFXListView();
        rectangle = new Rectangle();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        buttonBackHome = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");
        getStylesheets().add("/tictactoegame/View/Style.css");

        listViewGameHistory.setLayoutX(9.0);
        listViewGameHistory.setLayoutY(75.0);
        listViewGameHistory.setPrefSize(620, 260);
        listViewGameHistory.setStyle("-fx-background-color: #12947F; -fx-border-color: white; -fx-background-radius: 10; -fx-border-radius: 10;");
        listViewGameHistory.setOpaqueInsets(new Insets(0.0));

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle.setHeight(46.0);
        rectangle.setLayoutX(9.0);
        rectangle.setLayoutY(14.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(625.0);

        label.setLayoutX(26.0);
        label.setLayoutY(23.0);
        label.setText("Player one");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Arial Black", 20.0));

        label0.setLayoutX(255.0);
        label0.setLayoutY(23.0);
        label0.setText("Game Date");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#fffdfd"));
        label0.setFont(new Font("Arial Black", 20.0));

        label1.setLayoutX(490.0);
        label1.setLayoutY(23.0);
        label1.setText("Player two");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#fffafa"));
        label1.setFont(new Font("Arial Black", 20.0));

        buttonBackHome.setLayoutX(26.0);
        buttonBackHome.setLayoutY(343.0);
        buttonBackHome.setMnemonicParsing(false);
        buttonBackHome.setPrefHeight(26.0);
        buttonBackHome.setPrefWidth(42.0);
        buttonBackHome.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonBackHome.setText("<");
        buttonBackHome.setFont(new Font("Arial Black", 20.0));
        buttonBackHome.setCursor(Cursor.CLOSED_HAND);

        getChildren().add(listViewGameHistory);
        getChildren().add(rectangle);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(buttonBackHome);

        if (getListOfFiles() != null) {
            gameInfoList = getlistOfGameInfo(getListOfFiles());
            listViewGameHistory.getItems().addAll(Adapter.getitems(gameInfoList));
        }

        listViewGameHistory.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {

//            System.out.println("clicked on " + String.valueOf(listViewGameHistory.getSelectionModel().getSelectedIndices().get(0)));
            if (gameInfoList != null) {
                int index = Integer.parseInt(String.valueOf(listViewGameHistory.getSelectionModel().getSelectedIndices().get(0)));

                int size = getListOfFiles().size();
                if (index >= 0) {
                    Navigation.navigate(stage, new FXMLRecordShowBase(stage, getListOfFiles().get(size - index - 1)));
                }
            }
        });

        buttonBackHome.setOnAction((ActionEvent event) -> {
            Scene scene = new Scene(new FXMLHomeBase(stage));
            scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            stage.setScene(scene);
        });
    }

    List<String> getListOfFiles() {
        File dir = new File("recordedGames");
        if (dir.exists()) {
            return Arrays.asList(dir.list());
        }
        return null;
    }

    ArrayList<GameInfo> getlistOfGameInfo(List<String> files) {
        ArrayList<GameInfo> gameInfos = new ArrayList<>();
        for (int i = 0; i < files.size(); i++) {
            gameInfos.add(new GameInfo(files.get(files.size() - 1 - i)));
        }
        return gameInfos;
    }

}

class Adapter {

    public static ArrayList<FXMLGameHistoryItemBase> getitems(ArrayList<GameInfo> gamesInfo) {
        ArrayList<FXMLGameHistoryItemBase> historyItems = new ArrayList<>();
        for (int i = 0; i < gamesInfo.size(); i++) {
            historyItems.add(new FXMLGameHistoryItemBase(gamesInfo.get(i)));
        }
        return historyItems;
    }
}
