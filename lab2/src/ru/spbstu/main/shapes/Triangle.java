package ru.spbstu.main.shapes;

public class Triangle implements Point, Shape, Polygon{
    private Point_t top1_;
    private Point_t top2_;
    private Point_t top3_;
    private int angle_;

    public Triangle(float x1, float y1, float x2, float y2, float x3, float y3, int angle) {
        top1_ = new Point_t(x1, y1);
        top2_ = new Point_t(x2, y2);
        top3_ = new Point_t(x3, y3);
        angle_ = angle;
    }

    public float getDistance (Point_t point1, Point_t point2) {
        return (float) Math.sqrt(Math.pow((point2.x_ - point1.x_), 2) + Math.pow((point2.y_ - point1.y_), 2));
    }

    @Override
    public float getArea() {
        float p = getPerimeter() / 2;
        return (float) Math.sqrt(p * (p - getDistance(top1_, top2_)) *
                                (p - getDistance(top2_, top3_)) * (p - getDistance(top1_, top3_)));
    }

    @Override
    public int getRotation() {
        return angle_;
    }

    @Override
    public float getPerimeter() {
        return getDistance(top1_, top2_) + getDistance(top2_, top3_) + getDistance(top3_, top1_);
    }

    public Point_t getTop1_() {
        return top1_;
    }

    public void setTop1_(Point_t top1_) {
        this.top1_ = top1_;
    }

    public Point_t getTop2_() {
        return top2_;
    }

    public void setTop2_(Point_t top2_) {
        this.top2_ = top2_;
    }

    public Point_t getTop3_() {
        return top3_;
    }

    public void setTop3_(Point_t top3_) {
        this.top3_ = top3_;
    }

    public int getAngle_() {
        return angle_;
    }

    public void setAngle_(int angle_) {
        this.angle_ = angle_;
    }

    @Override
    public void printInfo() {
        System.out.println("TRIANGLE");
        System.out.print("Area: ");
        System.out.println(getArea());
        System.out.print("Perimeter: ");
        System.out.println(getPerimeter());
        System.out.print("Angle of rotation: ");
        System.out.println(getRotation());
    }
}
