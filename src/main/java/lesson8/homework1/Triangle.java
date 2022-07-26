package lesson8.homework1;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;
    private boolean rectangular;
    private boolean equilateral;
    private boolean isosceles;
    private boolean arbitrary;

    public boolean isEquilateral() {
        return equilateral;
    }

    public void setEquilateral(boolean equilateral) {
        this.equilateral = equilateral;
    }

    public boolean isIsosceles() {
        return isosceles;
    }

    public void setIsosceles(boolean isosceles) {
        this.isosceles = isosceles;
    }

    public boolean isArbitrary() {
        return arbitrary;
    }

    public void setArbitrary(boolean arbitrary) {
        this.arbitrary = arbitrary;
    }

    Triangle(Point aDot, Point bDot, Point cDot) {
        a = aDot;
        b = bDot;
        c = cDot;
        rectangular = this.ifRectangularFunction();
        equilateral = this.ifEquilateralFunction();
        isosceles = this.ifIsoscelesFunction();
        arbitrary = this.ifArbitraryFunction();
    }

    Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        a = new Point(x1, y1);
        b = new Point(x2, y2);
        c = new Point(x3, y3);
        rectangular = this.ifRectangularFunction();
        equilateral = this.ifEquilateralFunction();
        isosceles = this.ifIsoscelesFunction();
        arbitrary = this.ifArbitraryFunction();
    }

    Triangle() {
        a = new Point(0, 0);
        b = new Point(0, 0);
        c = new Point(0, 0);
    }

    double getArea() {
        double determinant = ((a.getX() - c.getX()) * (b.getY() - c.getY())) - ((a.getY() - c.getY()) * (b.getX() - c.getX()));
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
    boolean ifRectangularFunction() {
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
                return cathetusSum - hypotenuseSquared < 0.01;
            } else {
                return hypotenuseSquared - cathetusSum < 0.01;
            }
        }
    }

    //Если равносторонний
    boolean ifEquilateralFunction() {
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
    boolean ifIsoscelesFunction() {
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
    boolean ifArbitraryFunction() {
        if (this.ifIsoscelesFunction() || this.ifRectangularFunction() || this.ifEquilateralFunction()) {
            return false;
        } else {
            return true;
        }
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public boolean isRectangular() {
        return rectangular;
    }

    public void setRectangular(boolean rectangular) {
        this.rectangular = rectangular;
    }
}
