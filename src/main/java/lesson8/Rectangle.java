package lesson8;

public class Rectangle extends Figure {
    double aSide;
    double bSide;

    Rectangle(double a, double b) {
        aSide = a;
        bSide = b;
    }
    Rectangle() {
        this(1.0, 1.0);
    }

    double getArea() {
        return aSide * bSide;
    }
}
