package com.spring.assignment.task3;

public class DrawShape {
    private Shape shape;

    public DrawShape() {}
    public DrawShape(Shape shape) { this.shape = shape; }

    public void setShape(Shape shape) { this.shape = shape; }

    public void draw() {
        if (shape != null) {
            shape.draw();
        }
    }
}