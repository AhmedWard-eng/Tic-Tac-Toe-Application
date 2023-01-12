package tictactoegame;

import beans.UserOnline;
import com.google.gson.Gson;
import beans.LoginBean;
import beans.LogoutBean;
import beans.RequestGameBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jfoenix.controls.JFXListView;
import java.util.ArrayList;
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
import tictactoegame.FXMLHomeBase;
import tictactoegame.FXMLUserItemBase;

public class FXMLAvailableUsersBase extends AnchorPane {

    protected final JFXListView listViewAvailableUsers;
    protected final Rectangle rectangle;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Button buttonBackHome;
    NetworkConnection networkConnection;

    //  Gson g = new Gson();
//    ArrayList<UserOnline> users;
    public FXMLAvailableUsersBase(Stage stage, ArrayList<UserOnline> users) {

        System.out.println("userssssssssssssssssssssssssssssssss"+users);
        
        listViewAvailableUsers = new JFXListView();
        rectangle = new Rectangle();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        buttonBackHome = new Button();
        networkConnection = NetworkConnection.getInstance();

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

        System.out.println("Size: " + users.size());
         for (int i = 0; i < users.size(); i++) {
            System.out.println("drcftgvh" + users.get(i).getUserName());
            listViewAvailableUsers.getItems().add(new FXMLUserItemBase("    " + users.get(i).getUserName(), users.get(i).getStatus(), users.get(i).getScore()));

        }
        listViewAvailableUsers.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            int index = Integer.parseInt(String.valueOf(listViewAvailableUsers.getSelectionModel().getSelectedIndices().get(0)));

            String s = new Gson().toJson(new RequestGameBean("requestPlaying", "Ward", users.get(index).getUserName(), "192.168.1.8", users.get(index).getIp()));

            networkConnection.sendMessage(s);
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

//            Gson gson = new GsonBuilder().create();
//            LogoutBean logoutBean = new LogoutBean("logout", FXMLLoginBase.playerOneName);
//            String h = gson.toJson(logoutBean);
//            System.out.println(h);
//            networkConnection.sendMessage(h);
//            System.out.println("data is sent ");
//            //dialog
//            Scene scene = new Scene(new FXMLHomeBase(stage));
//            scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
//            stage.setScene(scene);
            RepeatedUserDialog r = new RepeatedUserDialog();
            r.logoutDialog("Do you want to logout?");

            //   userOnline.getUserName();
            //  networkConnection=new NetworkConnection();
            //  NetworkConnection.listPlayer.toArray();
            //   System.out.println("NetworkConnection.list.get(0).getUserName();.."+NetworkConnection.listPlayer.get(1).toString());
//        String str = NetworkConnection.listPlayer.get(0).toString();
//        UserOnline p = g.fromJson(str, UserOnline.class);
//        for (int i = 0; i < networkConnection.listPlayer.size(); i++) {
//                System.out.println((networkConnection.listPlayer.get(i)).toString());
//            }
//            online = new OnlineBean();
//            online.getScore();
//            online.getStatus();
//            online.getUserName();
//            System.out.println("avaliable user online: " + online.getStatus() + online.getUserName());
//
//            network.list.get(0);
//             OnlineBean onlineBean = new OnlineBean();
//              onlineBean.getUserName();
//            for (int i = 0; i < network.listPlayer.size(); i++) {
//                System.out.println((network.listPlayer.get(i)).toString());
//            }
//             System.out.println("NETWORK...Array.." + network.list.get(0) + "onlineBean.getUserName();" + onlineBean.getUserName());
//
//            NetworkConnection.listPlayer.get(0);
//             NetworkConnection.list.get(0);
//            System.out.println(" network.listPlayer.get(0);.."+ NetworkConnection.listPlayer.get(0));
//            for(int i=0;i<NetworkConnection.listPlayer.size();i++){
//                System.out.println("list player online...\n"+NetworkConnection.listPlayer.get(i));
//            }
//         
//            UserOnline p = g.fromJson(networkConnection.listPlayer.get(0), UserOnline.class);
            // System.out.println("OnlineBean...avaliable user.." + p.getUserName());
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
}
