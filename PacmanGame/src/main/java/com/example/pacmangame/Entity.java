package com.example.pacmangame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class Entity {

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
            setY(getY() - velocity);
        }

        if (input.contains("s")) {
            setY(getY() + velocity);
        }
        if (input.contains("a")) {
            setX(getX() - velocity);
        }
        if (input.contains("d")) {
            setX(getX() + velocity);
        }
    }

    public void render(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, width, height);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

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

    public Paint getColor() {
        return color;
    }

    public void setColor(Paint color) {
        this.color = color;
    }

}
