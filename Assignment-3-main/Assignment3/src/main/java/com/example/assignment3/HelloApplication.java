package com.example.assignment3;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {
    ImageView cloud3 = new ImageView("s.png");
    ImageView cloud2 = new ImageView("cloud2.png");
    ImageView cloud4 = new ImageView("cloud3.png");
    ImageView cloud5 = new ImageView("cloud3.png");
    ImageView image = new ImageView(new Image("R.png"));
    ImageView gameOver = new ImageView("g.png");
    ImageView coin = new ImageView("dollar.png");
    ImageView coin1 = new ImageView("5.png");
    Label score1 = new Label("Score:");
    int x1 = 0;

    TranslateTransition t2 = new TranslateTransition(Duration.millis(8000), cloud2);
    TranslateTransition t3 = new TranslateTransition(Duration.millis(5000), cloud3);
    TranslateTransition t4 = new TranslateTransition(Duration.millis(30000), cloud4);
    TranslateTransition t7 = new TranslateTransition(Duration.millis(10000), cloud5);
    TranslateTransition t5 = new TranslateTransition(Duration.millis(7000), coin);
    TranslateTransition t6 = new TranslateTransition(Duration.millis(30000), coin1);
    Button button = new Button("START THE GAME");


    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 900, 400);
        scene.getStylesheets().add("style.css");
        Image img = new Image("gi.gif");


        ImageView cloud2 = MyCloud1(scene);
        ImageView cloud3 = MyCloud3(scene);
        ImageView cloud4 = MyCloud4(scene);
        ImageView cloud5 = MyCloud5(scene);
        ImageView coin = coinFunction(scene);
        ImageView coin1 = coin1Function(scene);

        ImageView aeroplane = createShip(scene);
        root.getChildren().addAll(button);


        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {

            double y = aeroplane.getY();

            switch (event.getCode()){

                case UP -> aeroplane.setY(y - 10);
                case DOWN -> aeroplane.setY(y + 10);
                case RIGHT, LEFT -> aeroplane.setY(x1 + 10);
            }
            if (aeroplane.getBoundsInParent().intersects(cloud2.getBoundsInParent())||aeroplane.getBoundsInParent().intersects(cloud3.getBoundsInParent())||aeroplane.getBoundsInParent().intersects(cloud4.getBoundsInParent())||aeroplane.getBoundsInParent().intersects(cloud5.getBoundsInParent())){

                gameOver.setFitWidth(900);
                gameOver.setFitHeight(400);


                scene.addEventFilter(KeyEvent.KEY_PRESSED, event2 -> {

                    double y2 = aeroplane.getY();

                    switch (event.getCode()){
                        case UP -> aeroplane.setY(y - 0);
                        case DOWN -> aeroplane.setY(y + 0);
                        case RIGHT, LEFT -> aeroplane.setY(x1 + 0);
                    }
                    t3.stop();
                    t2.stop();
                    t4.stop();
                    t5.stop();
                    t6.stop();
                    t7.stop();

                    root.getChildren().add(gameOver);

                });
            }

            if(aeroplane.getBoundsInParent().intersects(coin.getBoundsInParent())|| aeroplane.getBoundsInParent().intersects(coin1.getBoundsInParent())){
                //score2.setText(" " + x1);
                x1 = x1+2;
            }
        });

        button.setOnMouseClicked((event) ->{
            root.getChildren().addAll(aeroplane,cloud2,cloud3,cloud4,cloud5,coin,score1,coin1);
            button.setLayoutX(10000);
        });
        button.setAlignment(Pos.CENTER);
        button.setLayoutY(200);
        button.setLayoutX(445);
        button.setScaleX(3);
        button.setScaleY(1.5);

        score1.setTranslateX(440);





        stage.setTitle("HELICOPTER Game");
        stage.setScene(scene);
        stage.show();
    }

    private ImageView MyCloud1(Scene scene){

        cloud2.setFitHeight(100);
        cloud2.setPreserveRatio(true);
        cloud2.setY(100);
        t2.setFromX(scene.getWidth()+300);
        t2.setCycleCount(Integer.MAX_VALUE);
        t2.setToX(-200);
        t2.play();

        return cloud2;
    }
    private ImageView MyCloud3(Scene scene){

        cloud3.setFitHeight(100);
        cloud3.setPreserveRatio(true);
        cloud3.setY(200);
        t3.setFromX(scene.getWidth()+300);
        t3.setCycleCount(Integer.MAX_VALUE);
        t3.setToX(-200);
        t3.play();

        return cloud3;
    }
    private ImageView MyCloud4(Scene scene){

        cloud4.setFitHeight(100);
        cloud4.setPreserveRatio(true);
        cloud4.setY(30);
        t4.setFromX(scene.getWidth()+300);
        t4.setCycleCount(Integer.MAX_VALUE);
        t4.setToX(-200);
        t4.play();

        return cloud4;
    }
    private ImageView MyCloud5(Scene scene){

        cloud5.setFitHeight(100);
        cloud5.setPreserveRatio(true);
        cloud5.setY(40);
        t7.setFromX(scene.getWidth()+300);
        t7.setCycleCount(Integer.MAX_VALUE);
        t7.setToX(-200);
        t7.play();

        return cloud5;
    }
    private ImageView coinFunction(Scene scene){

        coin.setFitHeight(50);
        coin.setPreserveRatio(true);
        coin.setY(100);
        t5.setFromX(scene.getWidth()+300);
        t5.setCycleCount(Integer.MAX_VALUE);
        t5.setToX(-200);
        t5.play();

        return coin;
    }

    private ImageView coin1Function(Scene scene){

        coin1.setFitHeight(50);
        coin1.setPreserveRatio(true);
        coin1.setY(200);
        t6.setFromX(scene.getWidth()+300);
        t6.setCycleCount(Integer.MAX_VALUE);
        t6.setToX(-200);
        t6.play();

        return coin1;
    }

    private ImageView createShip(Scene scene) {

        image.setFitWidth(150);
        image.setFitHeight(90);
        image.setY(scene.getHeight() / image.getFitHeight());
        return image;
    }

    public static void main(String[] args) {
        launch();
    }
}