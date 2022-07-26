package lesson8.homework1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double maxArea = 0;
        double minArea = 0;
        double maxPerimeter = 0;
        double minPerimeter = 0;
        int amount = 0;
        Triangle[] triangles = new Triangle[8];
        triangles[0] = new Triangle(new Point(0, 0), new Point(3, 0), new Point(3, 5));
        triangles[1] = new Triangle(new Point(0, 0), new Point(2, 5), new Point(6, 3));
        triangles[2] = new Triangle(new Point(0, 0), new Point(6, 0), new Point(3, 5));
        triangles[3] = new Triangle(new Point(0, 0), new Point(10, 0), new Point(5, 8.6602540378));
        triangles[4] = new Triangle(new Point(1, 0), new Point(1, 6), new Point(5, 0));
        triangles[5] = new Triangle(new Point(0, 0), new Point(0, 8), new Point(5, 0));
        triangles[6] = new Triangle(new Point(0, 0), new Point(20, 0), new Point(10, 8));
        triangles[7] = new Triangle(new Point(1, 1), new Point(4, 5), new Point(2, 7));


        for (int i = 0; i < triangles.length; i++) {
            if (triangles[i].isRectangular()) {
                maxArea = triangles[i].getArea();
                minArea = maxArea;
                maxPerimeter = triangles[i].getPerimeter();
                minPerimeter = maxPerimeter;
                break;
            }
        }
        for (int i = 0; i < triangles.length; i++) {
            if (triangles[i].isRectangular()) {
                if (triangles[i].getArea() > maxArea) {
                    maxArea = triangles[i].getArea();
                }
                if (triangles[i].getArea() < minArea) {
                    minArea = triangles[i].getArea();
                }
                if (triangles[i].getPerimeter() > maxPerimeter) {
                    maxPerimeter = triangles[i].getPerimeter();
                }
                if (triangles[i].getPerimeter() < minPerimeter) {
                    minPerimeter = triangles[i].getPerimeter();
                }
                amount++;
            }
        }
        System.out.println("==========Rectangular check==========\nAmount: " + amount + "\nMax area: " + maxArea +
                "\nMin area: " + minArea + "\nMax perimeter: " + maxPerimeter +
                "\nMin perimeter: " + minPerimeter);


        amount = 0;
        for (int i = 0; i < triangles.length; i++) {
            if (triangles[i].isEquilateral()) {
                maxArea = triangles[i].getArea();
                minArea = maxArea;
                maxPerimeter = triangles[i].getPerimeter();
                minPerimeter = maxPerimeter;
                break;
            }
        }
        for (int i = 0; i < triangles.length; i++) {
            if (triangles[i].isEquilateral()) {
                if (triangles[i].getArea() > maxArea) {
                    maxArea = triangles[i].getArea();
                }
                if (triangles[i].getArea() < minArea) {
                    minArea = triangles[i].getArea();
                }
                if (triangles[i].getPerimeter() > maxPerimeter) {
                    maxPerimeter = triangles[i].getPerimeter();
                }
                if (triangles[i].getPerimeter() < minPerimeter) {
                    minPerimeter = triangles[i].getPerimeter();
                }
                amount++;
            }
        }
        System.out.println("==========Equilateral check==========\nAmount: " + amount + "\nMax area: " + maxArea +
                "\nMin area: " + minArea + "\nMax perimeter: " + maxPerimeter +
                "\nMin perimeter: " + minPerimeter);


        amount = 0;
        for (int i = 0; i < triangles.length; i++) {
            if (triangles[i].isIsosceles()) {
                maxArea = triangles[i].getArea();
                minArea = maxArea;
                maxPerimeter = triangles[i].getPerimeter();
                minPerimeter = maxPerimeter;
                break;
            }
        }
        for (int i = 0; i < triangles.length; i++) {
            if (triangles[i].isIsosceles()) {
                if (triangles[i].getArea() > maxArea) {
                    maxArea = triangles[i].getArea();
                }
                if (triangles[i].getArea() < minArea) {
                    minArea = triangles[i].getArea();
                }
                if (triangles[i].getPerimeter() > maxPerimeter) {
                    maxPerimeter = triangles[i].getPerimeter();
                }
                if (triangles[i].getPerimeter() < minPerimeter) {
                    minPerimeter = triangles[i].getPerimeter();
                }
                amount++;
            }
        }
        System.out.println("==========Isosceles check==========\nAmount: " + amount + "\nMax area: " + maxArea +
                "\nMin area: " + minArea + "\nMax perimeter: " + maxPerimeter +
                "\nMin perimeter: " + minPerimeter);


        amount = 0;
        for (int i = 0; i < triangles.length; i++) {
            if (triangles[i].isArbitrary()) {
                maxArea = triangles[i].getArea();
                minArea = maxArea;
                maxPerimeter = triangles[i].getPerimeter();
                minPerimeter = maxPerimeter;
                break;
            }
        }
        for (int i = 0; i < triangles.length; i++) {
            if (triangles[i].isArbitrary()) {
                if (triangles[i].getArea() > maxArea) {
                    maxArea = triangles[i].getArea();
                }
                if (triangles[i].getArea() < minArea) {
                    minArea = triangles[i].getArea();
                }
                if (triangles[i].getPerimeter() > maxPerimeter) {
                    maxPerimeter = triangles[i].getPerimeter();
                }
                if (triangles[i].getPerimeter() < minPerimeter) {
                    minPerimeter = triangles[i].getPerimeter();
                }
                amount++;
            }
        }
        System.out.println("==========Arbitrary check==========\nAmount: " + amount + "\nMax area: " + maxArea +
                "\nMin area: " + minArea + "\nMax perimeter: " + maxPerimeter +
                "\nMin perimeter: " + minPerimeter);
    }
}
