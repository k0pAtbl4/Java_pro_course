package lesson08;

public class Triangle extends Figure {
    double aSide;
    double bSide;
    double cSide;

    Triangle(double a, double b, double c) {
        aSide = a;
        bSide = b;
        cSide = c;
    }
    Triangle() {
        this(1.0, 1.0, 1.0);
    }

    double getArea() {
        double p = (aSide + bSide + cSide) / 2;
        return Math.sqrt(p * (p - aSide) * (p - bSide) * (p - cSide));
    }
}
