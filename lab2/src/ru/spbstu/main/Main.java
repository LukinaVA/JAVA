package ru.spbstu.main;

import ru.spbstu.main.shapes.*;

public class Main {
    public static void main(String[] args) {
        Circle cir1 = new Circle(0, 0, 3);
        Circle cir2 = new Circle(1, 1, 6);
        Circle cir3 = new Circle(2, 2, 9);
        Rectangle rec1 = new Rectangle(3, 3, 10, 10, 90);
        Rectangle rec2 = new Rectangle(4, 4, 15, 15, 180);
        Rectangle rec3 = new Rectangle(5, 5, 20, 20, 360);
        Triangle tr1 = new Triangle(1, 2, 5, 11, 10, 2, 30);
        Triangle tr2 = new Triangle(4, 4, 4, 13, 14, 4, 45);
        Triangle tr3 = new Triangle(0, 0, 0, 2, 2, 0, 60);
        Triangle tr4 = new Triangle(0, 0, 0, 12, 15, 0, 120);

        Shape[] shapes = {cir1, cir2, cir3, rec1, rec2, rec3, tr1, tr2, tr3, tr4};

        findMaxAreaShape(shapes);
    }

    static void findMaxAreaShape(Shape[] figures) {
        float maxArea = 0;
        Shape maxShape = figures[0];
        for (Shape figure : figures) {
            if (figure.getArea() > maxArea) {
                maxArea = figure.getArea();
                maxShape = figure;
            }
        }
        maxShape.printInfo();
    }
}
