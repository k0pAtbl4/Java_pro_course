package lesson8.homework1;

public class Point {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Point() {
        this(0.0, 0.0);
    }

    double getDistance(Point b) {
        double dist = Math.sqrt(Math.pow(x - b.x, 2) + Math.pow(y - b.y, 2));
        return dist;
    }
}
