package ru.spbstu.main.shapes;

public class Rectangle implements Point, Shape {
    private Point_t center_;
    private float width_;
    private float height_;
    private int angle_;

    public Rectangle(float x, float y, float w, float h, int angle) {
        center_ = new Point_t(x, y);
        width_ = w;
        height_ = h;
        angle_ = angle;
    }

    @Override
    public float getArea() {
        return width_ * height_;
    }

    @Override
    public int getRotation() {
        return angle_;
    }

    public Point_t getCenter_() {
        return center_;
    }

    public void setCenter_(Point_t center_) {
        this.center_ = center_;
    }

    public float getWidth_() {
        return width_;
    }

    public void setWidth_(float width_) {
        this.width_ = width_;
    }

    public float getHeight_() {
        return height_;
    }

    public void setHeight_(float height_) {
        this.height_ = height_;
    }

    public int getAngle_() {
        return angle_;
    }

    public void setAngle_(int angle_) {
        this.angle_ = angle_;
    }

    @Override
    public void printInfo() {
        System.out.println("RECTANGLE");
        System.out.print("Area: ");
        System.out.println(getArea());
        System.out.print("Angle of rotation: ");
        System.out.println(getRotation());
    }
}
