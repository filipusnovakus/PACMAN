package com.example.pacmangame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Entity extends Rectangle {

    private double x;
    private double y;
    private double width;
    private double height;
    private Paint color;
    private float velocity;

    public Entity(int x) {
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public Entity(double x, double y, double width, double height, Paint color, float velocity) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.velocity = velocity;
    }

    public void update(ArrayList<String> input) {
        if (input.contains("w")) {
            setY2(getY2() - velocity);
        }

        if (input.contains("s")) {
            setY2(getY2() + velocity);
        }
        if (input.contains("a")) {
            setX2(getX2() - velocity);
        }
        if (input.contains("d")) {
            setX2(getX2() + velocity);
        }
    }

    public void render(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, width, height);
    }

    public double getX2() {
        return x;
    }

    public void setX2(double x) {
        this.x = x;
    }

    public double getY2() {
        return y;
    }

    public void setY2(double y) {
        this.y = y;
    }
/*
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
*/
    public Paint getColor() {
        return color;
    }

    public void setColor(Paint color) {
        this.color = color;
    }

}
