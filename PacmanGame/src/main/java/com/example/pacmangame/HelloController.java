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
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

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
    Walls wall1;
    Walls wall2;
    Walls wall3;
    Walls wall4;
    Walls wall5;
    Walls wall6;
    Walls wall7;
    Walls wall8;
    Walls wall9;
    Walls wall10;
    Walls wall11;
    Walls wall12;
    Walls wall13;
    Walls wall14;
    Walls wall15;
    Walls wall16;
    Walls wall17;
    Walls wall18;
    Entity entity;
    AnimationTimer mainLoop;
    ArrayList<String> inputList;
    ArrayList<Entity> entitiesList;
    ArrayList<Walls> wallsList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inputList = new ArrayList<>();
        entitiesList = new ArrayList<>();
        wallsList = new ArrayList<>();
        gc = canvas.getGraphicsContext2D();

 //block = false;
//if (canvas.equals(wall1)) {
   // block = true;
//}

      wall1 = new Walls(40,80,80,90,Paint.valueOf("BLUE"));
        wall2 = new Walls(160,80,80,90,Paint.valueOf("BLUE"));
        wall3 = new Walls(340,80,80,90,Paint.valueOf("BLUE"));
        wall9 = new Walls(460, 80 , 80, 90,Paint.valueOf("BLUE"));
        wall4 = new Walls(40, 250 , 80, 90,Paint.valueOf("BLUE"));
        wall5 = new Walls(340, 250 , 80, 90,Paint.valueOf("BLUE"));
        wall6 = new Walls(460, 250 , 80, 90,Paint.valueOf("BLUE"));
        wall7 = new Walls(90, 500 , 130, 110,Paint.valueOf("BLUE"));
        wall8 = new Walls(290, 500 , 160, 110,Paint.valueOf("BLUE"));
        wall10 = new Walls(460, 250 , 80, 90,Paint.valueOf("BLUE"));
        wall11 = new Walls(90, 500 , 130, 110,Paint.valueOf("BLUE"));
        wall12 = new Walls(290, 500 , 160, 110,Paint.valueOf("BLUE"));
        wall13 = new Walls(640, 80 , 80, 90,Paint.valueOf("BLUE"));
        wall14 = new Walls(760, 80 , 80, 90,Paint.valueOf("BLUE"));
        wall15 = new Walls(640, 250 , 80, 90,Paint.valueOf("BLUE"));
        wall16 = new Walls(760, 250 , 80, 90,Paint.valueOf("BLUE"));
        wall17 = new Walls(760, 500 , 130, 110,Paint.valueOf("BLUE"));
        wall18 = new Walls(500, 500 , 160, 110,Paint.valueOf("BLUE"));
        entity = new Entity(40,40,20,20, Paint.valueOf("YELLOW"), 5.1f);

        Platform.runLater(() -> {
            mainLayout.requestFocus();
        });

        mainLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //clear canvas
                clearCanvas();
                checkCollision(entity,wall1);
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
      gc.strokeLine(290, 0, 290, 80  );

      gc.strokeLine(290, 440, 290, 320);

       gc.strokeLine(590, 440, 590, 320);
        gc.strokeLine(200, 400, 400, 400);
        gc.setLineWidth(10);
        gc.setStroke(Paint.valueOf("BLUE")); //Object color

        gc.stroke();
        /*
       Rectangle w1 = new Rectangle(40, 80 , 80, 90);
       gc.rect(160, 80 , 80, 90);
        gc.rect(340, 80 , 80, 90);
        gc.rect(460, 80 , 80, 90);
        gc.setLineWidth(5);
      gc.rect(40, 250 , 80, 90);

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

*/
    }

    public void update() {
        entity.update(inputList);

    }

    public void render() {
        entity.render(gc);
        wall1.render(gc);
        wall2.render(gc);
        wall3.render(gc);
        wall4.render(gc);
        wall5.render(gc);
        wall6.render(gc);
        wall7.render(gc);
        wall8.render(gc);
        wall9.render(gc);
        wall10.render(gc);
        wall11.render(gc);
        wall12.render(gc);
        wall13.render(gc);
        wall14.render(gc);
        wall15.render(gc);
        wall16.render(gc);
        wall17.render(gc);
        wall18.render(gc);
    }
/*
    private void spawnEntities(int number) {
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            entitiesList.add(new Entity(random.nextInt()));
        }
    }
*/
    public void onMouseMove() {
       // if (gc.equals())
        gc.setFill(Paint.valueOf("BLACK"));

    }

    public void getCoords() {
    }


    public void keyPressed(KeyEvent keyEvent) {


    // if (gc.equals(Paint.valueOf("BLACK"))){
//if (block = false){
        if (!inputList.contains(keyEvent.getText())) {
            inputList.add(keyEvent.getText());
        }


        if (keyEvent.getText().equalsIgnoreCase("w")) {
            entity.setY2(entity.getY2() - 1);

        }

        if (keyEvent.getText().equalsIgnoreCase("s")) {
            entity.setY2(entity.getY2() + 1);


        }
        if (keyEvent.getText().equalsIgnoreCase("a")) {
            entity.setX2(entity.getX2() - 1);

        }
        if (keyEvent.getText().equalsIgnoreCase("d")) {

            entity.setX2(entity.getX2() + 1);
        }

        gc.setFill(Paint.valueOf("WHITE"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(entity.getColor());
        gc.fillRect(entity.getX2(), entity.getY2(), entity.getWidth(), entity.getHeight());

        }





    public void keyReleased(KeyEvent keyEvent) {
        inputList.remove(keyEvent.getText());
    }

    public void checkCollision(Entity entity, Walls wall2) {

if  (entity.getBoundsInParent().intersects(wall2.getBoundsInParent())){
    System.out.println("collision");
}

    }
     }