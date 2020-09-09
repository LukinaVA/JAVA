package ru.spbstu.main.shapes;

public interface Point {
    final class Point_t {
        float x_;
        float y_;

        public Point_t(float x, float y) {
            x_ = x;
            y_ = y;
        }
    }

    default  float getX(Point_t point) {
        return point.x_;
    }

    default  float getY(Point_t point) {
        return point.y_;
    }
}
