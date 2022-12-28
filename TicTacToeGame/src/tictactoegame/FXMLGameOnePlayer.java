package tictactoegame;

import com.jfoenix.controls.JFXToggleButton;
import static java.awt.Color.red;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public  class FXMLGameOnePlayer extends AnchorPane {

    protected final Rectangle rectangleBordGameOnePlayer;
    protected final Line line;
    protected final Line line0;
    protected final Line line1;
    protected final Line line2;
    protected final Label label2;
    protected final JFXToggleButton toggleButtonRecord;
    protected final ImageView imageViewPlayAgin;
    protected final Label labelVS;
    protected final Label labelCumputer;
    protected final Label label3;
    protected final Label label6;
    protected final Label label4;
    protected final Label label7;
    protected final Label label1;
    protected final Label label5;
    protected final Label label8;
    protected final Label label9;
    protected final ImageView imageViewHome;
    protected final Label labelPlayer;

    Image pathImagePlayAgin;
    Image pathImageHome;
    public FXMLGameOnePlayer() {

        rectangleBordGameOnePlayer = new Rectangle();
        line = new Line();
        line0 = new Line();
        line1 = new Line();
        line2 = new Line();
        label2 = new Label();
        toggleButtonRecord = new JFXToggleButton();
        imageViewPlayAgin = new ImageView();
        labelVS = new Label();
        labelCumputer = new Label();
        label3 = new Label();
        label6 = new Label();
        label4 = new Label();
        label7 = new Label();
        label1 = new Label();
        label5 = new Label();
        label8 = new Label();
        label9 = new Label();
        imageViewHome = new ImageView();
        labelPlayer = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(650.0);
        setPrefWidth(674.0);
        this.getStyleClass().add("AnchorPane");

        rectangleBordGameOnePlayer.setArcHeight(5.0);
        rectangleBordGameOnePlayer.setArcWidth(5.0);
        rectangleBordGameOnePlayer.setFill(javafx.scene.paint.Color.valueOf("#fedb39"));
        rectangleBordGameOnePlayer.setHeight(387.0);
        rectangleBordGameOnePlayer.setId("border");
        rectangleBordGameOnePlayer.setLayoutX(65.0);
        rectangleBordGameOnePlayer.setLayoutY(132.0);
        rectangleBordGameOnePlayer.setStroke(javafx.scene.paint.Color.valueOf("#22726e"));
        rectangleBordGameOnePlayer.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangleBordGameOnePlayer.setWidth(544.0);

        line.setEndX(455.0);
        line.setFill(javafx.scene.paint.Color.valueOf("#22726e"));
        line.setLayoutX(155.0);
        line.setLayoutY(261.0);
        line.setStartX(-90.0);
        line.setStroke(javafx.scene.paint.Color.valueOf("#22726e"));
        line.setStrokeWidth(6.0);

        line0.setEndX(348.0);
        line0.setFill(javafx.scene.paint.Color.valueOf("#22726e"));
        line0.setLayoutX(263.0);
        line0.setLayoutY(390.0);
        line0.setStartX(-199.0);
        line0.setStroke(javafx.scene.paint.Color.valueOf("#22726e"));
        line0.setStrokeWidth(6.0);

        line1.setEndX(17.0);
        line1.setEndY(272.0);
        line1.setFill(javafx.scene.paint.Color.valueOf("#22726e"));
        line1.setLayoutX(211.0);
        line1.setLayoutY(247.0);
        line1.setStartX(17.0);
        line1.setStartY(-115.0);
        line1.setStroke(javafx.scene.paint.Color.valueOf("#22726e"));
        line1.setStrokeWidth(6.0);

        line2.setEndX(16.0);
        line2.setEndY(215.0);
        line2.setFill(javafx.scene.paint.Color.valueOf("#22726e"));
        line2.setLayoutX(406.0);
        line2.setLayoutY(304.0);
        line2.setStartX(16.0);
        line2.setStartY(-172.0);
        line2.setStroke(javafx.scene.paint.Color.valueOf("#22726e"));
        line2.setStrokeWidth(6.0);

        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setGraphicTextGap(0.0);
        label2.setId("labelCharX");
        label2.setLayoutX(228.0);
        label2.setLayoutY(132.0);
        label2.setPrefHeight(103.0);
        label2.setPrefWidth(190.0);
        label2.setText("x");
        label2.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label2.setFont(new Font("System Bold", 89.0));

        toggleButtonRecord.setId("Record");
        toggleButtonRecord.setLayoutX(505.0);
        toggleButtonRecord.setLayoutY(-2.0);
        toggleButtonRecord.setFont(new Font("System Bold", 23.0));
        toggleButtonRecord.setText("Record");
        Font boldFontBold23  = Font.font("Bold", FontWeight.BOLD, 23);
        toggleButtonRecord.setFont(boldFontBold23);
        
        toggleButtonRecord.setToggleLineColor(Paint.valueOf("#e06666"));
        toggleButtonRecord.setToggleColor(Paint.valueOf("#d63333"));
        
        labelVS.setId("labelVS");
        labelVS.setLayoutX(296.0);
        labelVS.setLayoutY(55.0);
        labelVS.setText("VS");
        labelVS.setFont(new Font("System Bold Italic", 51.0));

        labelCumputer.setId("labelCumputer");
        labelCumputer.setLayoutX(428.0);
        labelCumputer.setLayoutY(64.0);
        labelCumputer.setText("Computer");
        labelCumputer.setFont(new Font("System Bold Italic", 39.0));

        label3.setAlignment(javafx.geometry.Pos.CENTER);
        label3.setGraphicTextGap(0.0);
        label3.setId("labelCharX");
        label3.setLayoutX(422.0);
        label3.setLayoutY(132.0);
        label3.setPrefHeight(103.0);
        label3.setPrefWidth(190.0);
        label3.setText("x");
        label3.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label3.setFont(new Font("System Bold", 89.0));

        label6.setAlignment(javafx.geometry.Pos.CENTER);
        label6.setGraphicTextGap(0.0);
        label6.setId("labelCharX");
        label6.setLayoutX(423.0);
        label6.setLayoutY(261.0);
        label6.setPrefHeight(103.0);
        label6.setPrefWidth(190.0);
        label6.setText("x");
        label6.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label6.setFont(new Font("System Bold", 89.0));

        label4.setAlignment(javafx.geometry.Pos.CENTER);
        label4.setGraphicTextGap(0.0);
        label4.setId("labelCharX");
        label4.setLayoutX(64.0);
        label4.setLayoutY(261.0);
        label4.setPrefHeight(129.0);
        label4.setPrefWidth(164.0);
        label4.setText("x");
        label4.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label4.setFont(new Font("System Bold", 89.0));

        label7.setAlignment(javafx.geometry.Pos.CENTER);
        label7.setGraphicTextGap(0.0);
        label7.setId("labelCharX");
        label7.setLayoutX(67.0);
        label7.setLayoutY(387.0);
        label7.setPrefHeight(129.0);
        label7.setPrefWidth(164.0);
        label7.setText("x");
        label7.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label7.setFont(new Font("System Bold", 89.0));

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setGraphicTextGap(0.0);
        label1.setId("labelCharO");
        label1.setLayoutX(67.0);
        label1.setLayoutY(132.0);
        label1.setPrefHeight(129.0);
        label1.setPrefWidth(164.0);
        label1.setText("o");
        label1.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label1.setFont(new Font("System Bold", 89.0));

        label5.setAlignment(javafx.geometry.Pos.CENTER);
        label5.setGraphicTextGap(0.0);
        label5.setId("labelCharO");
        label5.setLayoutX(232.0);
        label5.setLayoutY(261.0);
        label5.setPrefHeight(129.0);
        label5.setPrefWidth(190.0);
        label5.setText("o");
        label5.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label5.setFont(new Font("System Bold", 89.0));

        label8.setAlignment(javafx.geometry.Pos.CENTER);
        label8.setGraphicTextGap(0.0);
        label8.setId("labelCharO");
        label8.setLayoutX(232.0);
        label8.setLayoutY(393.0);
        label8.setPrefHeight(129.0);
        label8.setPrefWidth(190.0);
        label8.setText("o");
        label8.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label8.setFont(new Font("System Bold", 89.0));

        label9.setAlignment(javafx.geometry.Pos.CENTER);
        label9.setGraphicTextGap(0.0);
        label9.setId("labelCharO");
        label9.setLayoutX(423.0);
        label9.setLayoutY(387.0);
        label9.setPrefHeight(129.0);
        label9.setPrefWidth(181.0);
        label9.setText("o");
        label9.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        label9.setFont(new Font("System Bold", 89.0));

        imageViewHome.setFitHeight(98.0);
        imageViewHome.setFitWidth(117.0);
        imageViewHome.setLayoutX(35.0);
        imageViewHome.setLayoutY(538.0);
        imageViewHome.setPickOnBounds(true);
        imageViewHome.setPreserveRatio(true);
        
        imageViewPlayAgin.setFitHeight(98.0);
        imageViewPlayAgin.setFitWidth(117.0);
        imageViewPlayAgin.setLayoutX(550.0);
        imageViewPlayAgin.setLayoutY(538.0);
        imageViewPlayAgin.setPickOnBounds(true);
        imageViewPlayAgin.setPreserveRatio(true);

        labelPlayer.setId("labelPlayer");
        labelPlayer.setLayoutX(80.0);
        labelPlayer.setLayoutY(64.0);
        labelPlayer.setText("Player");
        labelPlayer.setFont(new Font("System Bold Italic", 39.0));

        getChildren().add(rectangleBordGameOnePlayer);
        getChildren().add(line);
        getChildren().add(line0);
        getChildren().add(line1);
        getChildren().add(line2);
        getChildren().add(label2);
        getChildren().add(toggleButtonRecord);
        getChildren().add(imageViewPlayAgin);
        getChildren().add(labelVS);
        getChildren().add(labelCumputer);
        getChildren().add(label3);
        getChildren().add(label6);
        getChildren().add(label4);
        getChildren().add(label7);
        getChildren().add(label1);
        getChildren().add(label5);
        getChildren().add(label8);
        getChildren().add(label9);
        getChildren().add(imageViewHome);
        getChildren().add(labelPlayer);
        
        //image
        pathImagePlayAgin=new Image(getClass().getResourceAsStream("Resources/playAgin.png"));
        imageViewPlayAgin.setImage(pathImagePlayAgin);
        
        pathImageHome=new Image(getClass().getResourceAsStream("Resources/homeIcon.png"));
        imageViewHome.setImage(pathImageHome);

        imageViewHome.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
                public void handle(ActionEvent e){
                
                }});
    }
}
