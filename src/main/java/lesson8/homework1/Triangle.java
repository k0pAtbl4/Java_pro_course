package lesson8.homework1;

public class Triangle {
    Point a;
    Point b;
    Point c;

    Triangle(Point aDot, Point bDot, Point cDot) {
        a = new Point(aDot.x, aDot.y);
        b = new Point(bDot.x, bDot.y);
        c = new Point(cDot.x, cDot.y);
    }

    Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        a = new Point(x1, y1);
        b = new Point(x2, y2);
        c = new Point(x3, y3);
    }

    Triangle() {
        a = new Point(0, 0);
        b = new Point(0, 0);
        c = new Point(0, 0);
    }

    double getArea() {
        double determinant = ((a.x - c.x) * (b.y - c.y)) - ((a.y - c.y) * (b.x - c.x));
        if (determinant < 0) {
            determinant *= -1;
        }
        determinant *= 0.5;
        return determinant;
    }

    double getPerimeter() {
        double ab = a.getDistance(b);
        double bc = b.getDistance(c);
        double ac = a.getDistance(c);
        return ab + bc + ac;
    }

    //Если прямоугольный
    boolean ifRectangular() {
        double ab = a.getDistance(b);
        double bc = b.getDistance(c);
        double ac = a.getDistance(c);
        double hypotenuse, cathetus1, cathetus2;
        if (ab > bc) {
            if (ab > ac) {
                hypotenuse = ab;
                cathetus1 = bc;
                cathetus2 = ac;
            } else {
                hypotenuse = ac;
                cathetus1 = bc;
                cathetus2 = ab;
            }
        } else {
            if (bc > ac) {
                hypotenuse = bc;
                cathetus1 = ab;
                cathetus2 = ac;
            } else {
                hypotenuse = ac;
                cathetus1 = ab;
                cathetus2 = bc;
            }
        }
        double cathetusSum = Math.pow(cathetus1, 2) + Math.pow(cathetus2, 2);
        double hypotenuseSquared = Math.pow(hypotenuse, 2);
        if (cathetusSum == hypotenuseSquared) {
            return true;
        } else {
            if (cathetusSum > hypotenuseSquared) {
                if (cathetusSum - hypotenuseSquared < 0.01) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (hypotenuseSquared - cathetusSum < 0.01) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    //Если равносторонний
    boolean ifEquilateral() {
        double ab = a.getDistance(b);
        double bc = b.getDistance(c);
        double ac = a.getDistance(c);
        if (ab > bc) {
            if (ab - bc < 0.01) {
                return bc == ac;
            } else {
                return false;
            }
        } else {
            if (bc - ab < 0.01) {
                return bc == ac;
            } else {
                return false;
            }
        }

    }

    //Если равнобедренный
    boolean ifIsosceles() {
        double[] sides = {a.getDistance(b), b.getDistance(c), a.getDistance(c)};
        for (int i = 0; i < sides.length; i++) {
            for (int k = 0; k < sides.length; k++) {
                if (i != k) {
                    if (sides[i] == sides[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //Еслии произвольный
    boolean ifArbitrary() {
        if (this.ifIsosceles() || this.ifRectangular() || this.ifEquilateral()) {
            return false;
        } else {
            return true;
        }
    }
}
