package tictactoegame;

import beans.SignUpBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static com.sun.javafx.scene.control.skin.Utils.getResource;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXMLSignUpBase extends AnchorPane {

    protected final Rectangle rectangle;
    protected final Rectangle rectangle0;
    protected final Rectangle rectangle1;
    protected final Rectangle rectangle2;
    protected final Pane pane;
    protected final Rectangle rectangle3;
    protected final Text text;
    protected final TextField TextFieldUserName;
    protected final Button ButtonSignUp;
    protected final PasswordField TextFieldpassword;
    protected final PasswordField TextFieldConfirmPassword;
    protected final Button buttonBackHome;

    protected final DialogPane dialogPaneName;
    protected final GridPane gridPane;
    protected final Label labelmatched;
    protected final Label labelempty;

    NetworkConnection network;
    boolean checkRegExPassward;
    boolean checkRegExName;
    String regexPassword = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{5,10}";
    String regexUserName = "^[A-Za-z]\\w.{5,30}$";

    public FXMLSignUpBase(Stage stage) throws UnknownHostException, IOException {

        dialogPaneName = new DialogPane();
        gridPane = new GridPane();
        labelmatched = new Label("Password Doesn't match Confirm password.");
        labelempty = new Label("Please Enter all Cells.");
        rectangle = new Rectangle();
        rectangle0 = new Rectangle();
        rectangle1 = new Rectangle();
        rectangle2 = new Rectangle();
        pane = new Pane();
        rectangle3 = new Rectangle();
        text = new Text();
        TextFieldUserName = new TextField();
        ButtonSignUp = new Button();
        TextFieldpassword = new PasswordField();
        TextFieldConfirmPassword = new PasswordField();
        buttonBackHome = new Button();

        buttonBackHome.setOnAction((ActionEvent event) -> {
            navigationLogic.Navigation.navigate(stage, new FXMLHomeBase(stage));
        });

        ButtonSignUp.setOnAction((ActionEvent event) -> {
            Gson gson = new GsonBuilder().create();
            boolean check;
            checkRegExName = isValidUsername(TextFieldUserName.getText());
            if ((!TextFieldUserName.getText().equals("")) && (!TextFieldpassword.getText().equals("")) && (!TextFieldConfirmPassword.getText().equals(""))) {
                if (checkRegExName) {
                    check = checkPassword(TextFieldpassword.getText(),
                            TextFieldConfirmPassword.getText());
                    checkRegExPassward = isValidPassword(TextFieldpassword.getText());
                    if (checkRegExPassward) {
                        if (check) {
                            SignUpBean person = new SignUpBean("signup", TextFieldUserName.getText(),
                                    TextFieldpassword.getText(),
                                    TextFieldConfirmPassword.getText());

                            network = new NetworkConnection();
                            network.sendMessage(gson.toJson(person));

                            System.out.println("data is sent ");

                        } else {
                            System.out.println("not matched paass");
                            ///1
                            RepeatedUserDialog.dialogSinUp("Passwort Not Match.");
                        }

                    } else {
                        ////////**
                        System.out.println("enter world from 5to 10 contain number and small,capital litter,@#$%^&+= and number from 0to 9");
                        RepeatedUserDialog.dialogSinUp(" Enter password from 5 to 10 contains\n characters small, capital ,number from 0 to 9 and\n any symbol(@#$%^&+=) without any space between.");
                    }

                } else {
                    System.out.println(" Invalid name.\n please,enter name start with characters and\n lenght from 5 to 30 \n");
                    //2
                    RepeatedUserDialog.dialogSinUp(" Invalid name.\n please,enter name start with letter and lenght from 7 to 30.");
                }
            } else {
                System.out.println("enter all cells");
                //3
                RepeatedUserDialog.dialogSinUp("Enter All Cells.");
            }

        });

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #22726e;");

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#cf0e0c"));
        rectangle.setHeight(111.0);
        rectangle.setLayoutX(-135.0);
        rectangle.setLayoutY(59.0);
        rectangle.setRotate(-119.1);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#cf0e0c"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(201.0);

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle0.setHeight(111.0);
        rectangle0.setLayoutX(-135.0);
        rectangle0.setLayoutY(37.0);
        rectangle0.setRotate(-121.0);
        rectangle0.setStroke(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(201.0);

        rectangle1.setArcHeight(5.0);
        rectangle1.setArcWidth(5.0);
        rectangle1.setFill(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle1.setHeight(111.0);
        rectangle1.setLayoutX(486.0);
        rectangle1.setLayoutY(345.0);
        rectangle1.setRotate(-45.0);
        rectangle1.setStroke(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle1.setWidth(201.0);

        rectangle2.setArcHeight(5.0);
        rectangle2.setArcWidth(5.0);
        rectangle2.setFill(javafx.scene.paint.Color.valueOf("#12947f"));
        rectangle2.setHeight(111.0);
        rectangle2.setLayoutX(500.0);
        rectangle2.setLayoutY(345.0);
        rectangle2.setRotate(-48.0);
        rectangle2.setStroke(javafx.scene.paint.Color.valueOf("#12947f"));
        rectangle2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle2.setWidth(201.0);

        pane.setLayoutX(138.0);
        pane.setPrefHeight(408.0);
        pane.setPrefWidth(325.0);
        pane.setStyle("-fx-background-color: #12947F; -fx-border-color: white;");

        rectangle3.setArcHeight(5.0);
        rectangle3.setArcWidth(5.0);
        rectangle3.setFill(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle3.setHeight(54.0);
        rectangle3.setLayoutX(4.0);
        rectangle3.setLayoutY(42.0);
        rectangle3.setStroke(javafx.scene.paint.Color.valueOf("#d0880b"));
        rectangle3.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle3.setWidth(317.0);

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(97.0);
        text.setLayoutY(79.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Sign Up");
        text.setFont(new Font("Comic Sans MS Bold", 35.0));

        TextFieldUserName.setLayoutX(49.0);
        TextFieldUserName.setLayoutY(134.0);
        TextFieldUserName.setPrefHeight(41.0);
        TextFieldUserName.setPrefWidth(237.0);

        TextFieldUserName.setPromptText("User Name");

        TextFieldUserName.setStyle("-fx-background-color: #12947F; -fx-border-radius: 15; -fx-background-radius: 15; -fx-border-color: white;");
        TextFieldUserName.setFont(new Font(16.0));

        ButtonSignUp.setLayoutX(243.0);
        ButtonSignUp.setLayoutY(330.0);
        ButtonSignUp.setMnemonicParsing(false);
        ButtonSignUp.setPrefHeight(49.0);
        ButtonSignUp.setPrefWidth(120.0);
        ButtonSignUp.setStyle("-fx-background-color: #ff9900; -fx-border-radius: 15; -fx-background-radius: 15;");
        ButtonSignUp.setText("Sign Up");
        ButtonSignUp.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        ButtonSignUp.setFont(new Font("Comic Sans MS", 18.0));
        ButtonSignUp.setOpaqueInsets(new Insets(0.0));
        ButtonSignUp.setCursor(Cursor.CLOSED_HAND);

        TextFieldpassword.setLayoutX(187.0);
        TextFieldpassword.setLayoutY(200.0);
        TextFieldpassword.setPrefHeight(41.0);
        TextFieldpassword.setPrefWidth(237.0);
        TextFieldpassword.setPromptText("Password");
        TextFieldpassword.setStyle("-fx-background-color: #12947F; -fx-border-radius: 15; -fx-background-radius: 15; -fx-border-color: white;");
        TextFieldpassword.setFont(new Font(16.0));

        TextFieldConfirmPassword.setLayoutX(187.0);
        TextFieldConfirmPassword.setLayoutY(266.0);
        TextFieldConfirmPassword.setPrefHeight(41.0);
        TextFieldConfirmPassword.setPrefWidth(237.0);
        TextFieldConfirmPassword.setPromptText("Confirm Password");
        TextFieldConfirmPassword.setStyle("-fx-background-color: #12947F; -fx-border-radius: 15; -fx-background-radius: 15; -fx-border-color: white;");
        TextFieldConfirmPassword.setFont(new Font(16.0));

        buttonBackHome.setLayoutX(20.0);
        buttonBackHome.setLayoutY(340.0);
        buttonBackHome.setMnemonicParsing(false);
        buttonBackHome.setPrefHeight(26.0);
        buttonBackHome.setPrefWidth(42.0);
        buttonBackHome.setStyle("-fx-background-radius: 50; -fx-background-color: #ff9900; -fx-border-radius: 50;");
        buttonBackHome.setText("<");
        buttonBackHome.setFont(new Font("Arial Black", 20.0));
        buttonBackHome.setCursor(Cursor.CLOSED_HAND);

        getChildren().add(rectangle);
        getChildren().add(rectangle0);
        getChildren().add(rectangle1);
        getChildren().add(rectangle2);
        pane.getChildren().add(rectangle3);
        pane.getChildren().add(text);
        pane.getChildren().add(TextFieldUserName);
        getChildren().add(pane);
        getChildren().add(ButtonSignUp);
        getChildren().add(TextFieldpassword);
        getChildren().add(TextFieldConfirmPassword);
        getChildren().add(buttonBackHome);

    }

    public boolean isValidPassword(String password) {
        if (password.matches(regexPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidUsername(String name) {
        if (name.matches(regexUserName)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPassword(String password, String confirmpassword) {
        if (password.equals(confirmpassword) && password.matches(regexPassword)) {
            return true;
        } else {
            return false;
        }
    }

//    private void dialogLength() {
//        Alert alert = new Alert(AlertType.INFORMATION);
//        alert.setTitle("MESSAGE...!");
//        alert.setHeaderText("Look, an Information Dialog");
//        alert.setContentText("invaild length");
//        alert.showAndWait().ifPresent(rs -> {
//            if (rs == ButtonType.OK) {
//                System.out.println("Pressed OK.");
//            }
//        });
//
//    }
//    private void dialogEmptyCell() {
//        Alert alert = new Alert(AlertType.INFORMATION);
//        alert.setTitle("MESSAGE...!");
//        alert.setHeaderText("Look, an Information Dialog");
//        alert.setContentText("Enter All Cells");
//        alert.showAndWait().ifPresent(rs -> {
//            if (rs == ButtonType.OK) {
//                System.out.println("Pressed OK.");
//            }
//        });
//    }
}
