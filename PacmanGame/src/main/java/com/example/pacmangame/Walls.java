package com.example.pacmangame;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Walls extends Rectangle {

    private double x;
    private double y;
    private double width;
    private double height;
    private Paint color;


    public Walls(int x) {
    }



    public Walls(double x, double y, double width, double height, Paint color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

    }



    public void render(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, width, height);
    }


    public Paint getColor() {
        return color;
    }

    public void setColor(Paint color) {
        this.color = color;
    }

}
