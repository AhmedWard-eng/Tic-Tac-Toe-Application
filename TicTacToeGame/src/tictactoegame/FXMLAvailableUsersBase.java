package tictactoegame;

import beans.UserOnline;
import com.google.gson.Gson;
import beans.LoginBean;
import beans.LogoutBean;
import beans.RequestGameBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jfoenix.controls.JFXListView;
import interfaces.OnlineUsersList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
import javafx.stage.WindowEvent;
import tictactoegame.FXMLHomeBase;
import tictactoegame.FXMLUserItemBase;

public class FXMLAvailableUsersBase extends AnchorPane implements OnlineUsersList {

    protected final JFXListView listViewAvailableUsers;
    protected final Rectangle rectangle;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Button buttonBackHome;
    NetworkConnection networkConnection;
    Thread t;
    public static RepeatedUserDialog repeatedUserDialog;

    //  Gson g = new Gson();
    public static ArrayList<UserOnline> usersList;

    public FXMLAvailableUsersBase(Stage stage, ArrayList<UserOnline> users) {

        //System.out.println("userssssssssssssssssssssssssssssssss" + users);
        listViewAvailableUsers = new JFXListView();
        rectangle = new Rectangle();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        buttonBackHome = new Button();
        networkConnection = new NetworkConnection(this);
        //t=new Thread();
        usersList = users;
        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");
        getStylesheets().add("/tictactoegame/View/Style.css");

        listViewAvailableUsers.setLayoutX(12.0);
        listViewAvailableUsers.setLayoutY(70.0);
        listViewAvailableUsers.setStyle("-fx-background-color: #12947F; -fx-border-color: white; -fx-background-radius: 10; -fx-border-radius: 10;");
        //listViewAvailableUsers.setOpaqueInsets(new Insets(0.0));
        listViewAvailableUsers.setPrefSize(585, 290);

        //System.out.println("Size: " + users.size());
        reload();

        listViewAvailableUsers.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            int index = Integer.parseInt(String.valueOf(listViewAvailableUsers.getSelectionModel().getSelectedIndices().get(0)));
            System.out.println("usersList size = " + usersList.size() + "===========");
            String s = new Gson().toJson(new RequestGameBean("requestPlaying", NetworkConnection.userOnline.getUserName(), usersList.get(index).getUserName(), networkConnection.getIp(), usersList.get(index).getIp(), NetworkConnection.userOnline.getScore()));

            networkConnection.sendMessage(s);
//            if(usersList.get(i).)
            repeatedUserDialog = new RepeatedUserDialog();
            repeatedUserDialog.loadingDialog();
            System.out.println("clicked on " + listViewAvailableUsers.getSelectionModel().getSelectedIndices());
        });

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(8.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle.setHeight(46.0);
        rectangle.setLayoutX(10.0);
        rectangle.setLayoutY(12.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(583.0);

        label.setLayoutX(54.0);
        label.setLayoutY(20.0);
        label.setText("Score");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Arial Black", 20.0));

        label0.setLayoutX(266.0);
        label0.setLayoutY(20.0);
        label0.setText("Name");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#fffdfd"));
        label0.setFont(new Font("Arial Black", 20.0));

        label1.setLayoutX(478.0);
        label1.setLayoutY(20.0);
        label1.setText("Status");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#fffafa"));
        label1.setFont(new Font("Arial Black", 20.0));

        buttonBackHome.setOnAction((ActionEvent event) -> {
            RepeatedUserDialog r = new RepeatedUserDialog();
            r.logoutDialog("Do you want to logout?", null);
        });

        buttonBackHome.setLayoutX(18.0);
        buttonBackHome.setLayoutY(362.0);
        buttonBackHome.setMnemonicParsing(false);
        buttonBackHome.setPrefHeight(26.0);
        buttonBackHome.setPrefWidth(42.0);
        buttonBackHome.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonBackHome.setText("<");
        buttonBackHome.setFont(new Font("Arial Black", 20.0));
        buttonBackHome.setCursor(Cursor.CLOSED_HAND);

        getChildren().add(listViewAvailableUsers);
        getChildren().add(rectangle);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(buttonBackHome);

    }

    private void reload() {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (networkConnection.getSocket().isConnected() && !networkConnection.getSocket().isClosed()) {
                    try {
                        if (networkConnection.getSocket().isConnected() && !networkConnection.getSocket().isClosed()) {
                            System.out.println("kll");
                            Map<String, String> map = new HashMap<>();
                            map.put("operation", "reloadUsersList");
                            String message = new Gson().toJson(map);
                            networkConnection.sendMessage(message);

                        }
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                }
            }

        });
        t.start();
    }

    @Override
    public void getUsers(ArrayList<UserOnline> users) {
        usersList = users;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                listViewAvailableUsers.getItems().clear();
                for (int i = 0; i < users.size(); i++) {
//                    if (!usersList.get(i).getUserName().equals(NetworkConnection.userOnline.getUserName())) {
                    listViewAvailableUsers.getItems().add(new FXMLUserItemBase("    " + users.get(i).getUserName(), users.get(i).getStatus(), users.get(i).getScore()));
//                    }
                    System.out.println("users count = " + usersList.size());
                }
            }
        });

    }
}
