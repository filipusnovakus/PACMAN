package com.example.pacmangame;



import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;





public class HelloController implements Initializable {


    @FXML
    Canvas canvas;

    GraphicsContext gc;
    public Label label;
    public VBox mainLayout;
    Entity entity;
    AnimationTimer mainLoop;
    ArrayList<String> inputList;
    ArrayList<Entity> entitiesList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inputList = new ArrayList<>();
        entitiesList = new ArrayList<>();

        gc = canvas.getGraphicsContext2D();
        gc.setFill(Paint.valueOf("RED"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());



        entity = new Entity(10, 10, 20, 20, Paint.valueOf("YELLOW"), 5.1f);

        Platform.runLater(() -> {
            mainLayout.requestFocus();
        });

        mainLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //clear canvas
                clearCanvas();
                //update
                update();
                //render
                render();
            }
        };
        mainLoop.start();
    }

    private void clearCanvas() {
        gc.setFill(Paint.valueOf("BLACK"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.strokeLine(290, 0, 290, 80);
        gc.strokeLine(290, 440, 290, 320);

        gc.strokeLine(590, 440, 590, 320);
        gc.strokeLine(200, 400, 400, 400);
        gc.setLineWidth(10);
        gc.setStroke(Paint.valueOf("BLUE")); //Object color
        gc.stroke();
       gc.rect(40, 80 , 80, 90);
        gc.rect(160, 80 , 80, 90);
        gc.rect(340, 80 , 80, 90);
        gc.rect(460, 80 , 80, 90);
        gc.setLineWidth(5);
        gc.rect(40, 250 , 80, 90);
        gc.rect(160, 250 , 80, 90);
        gc.rect(340, 250 , 80, 90);
        gc.rect(460, 250 , 80, 90);
        gc.rect(90, 500 , 130, 110);
        gc.rect(290, 500 , 160, 110);
        gc.rect(640, 80 , 80, 90);
        gc.rect(760, 80 , 80, 90);
        gc.rect(640, 250 , 80, 90);
        gc.rect(760, 250 , 80, 90);
        gc.rect(760, 500 , 130, 110);
        gc.rect(500, 500 , 160, 110);


    }

    public void update() {
        entity.update(inputList);
    }

    public void render() {
        entity.render(gc);
    }

    private void spawnEntities(int number) {
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            entitiesList.add(new Entity(random.nextInt()));
        }
    }

    public void onMouseMove(MouseEvent mouseEvent) {
        gc.setFill(Paint.valueOf("BLACK"));
        gc.fillOval(mouseEvent.getX(), mouseEvent.getY(), 5, 5);
    }

    public void getCoords(MouseEvent mouseEvent) {
        label.setText(String.valueOf(mouseEvent.getX()));
    }


    public void keyPressed(KeyEvent keyEvent) {



        if (!inputList.contains(keyEvent.getText())) {
            inputList.add(keyEvent.getText());
        }


        if (keyEvent.getText().equalsIgnoreCase("w")) {
            entity.setY(entity.getY() - 6);

        }

        if (keyEvent.getText().equalsIgnoreCase("s")) {
            entity.setY(entity.getY() + 6);


        }
        if (keyEvent.getText().equalsIgnoreCase("a")) {
            entity.setX(entity.getX() - 6);

        }
        if (keyEvent.getText().equalsIgnoreCase("d")) {

            entity.setX(entity.getX() + 6);
        }

        gc.setFill(Paint.valueOf("WHITE"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(entity.getColor());
        gc.fillRect(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());


    }

    public void keyReleased(KeyEvent keyEvent) {
        inputList.remove(keyEvent.getText());
    }


}