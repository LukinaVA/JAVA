package ru.spbstu.main.shapes;

public class Circle implements Point, Shape, Ellipse {
    private Point_t center_;
    private float radius_;

    public Circle(float x, float y, float radius) {
        center_ = new Point_t(x, y);
        radius_ = radius;
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * radius_ * radius_);
    }

    @Override
    public float getLength() {
        return (float) (2 * Math.PI * radius_);
    }

    public Point_t getCenter_() {
        return center_;
    }

    public void setCenter_(Point_t center_) {
        this.center_ = center_;
    }

    public float getRadius_() {
        return radius_;
    }

    public void setRadius_(float radius_) {
        this.radius_ = radius_;
    }

    @Override
    public void printInfo() {
        System.out.println("CIRCLE");
        System.out.print("Area: ");
        System.out.println(getArea());
        System.out.print("Length: ");
        System.out.println(getLength());
    }
}
