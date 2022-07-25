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
        triangles[0] = new Triangle(0, 0, 3, 0, 3, 5);
        triangles[1] = new Triangle(0, 0, 2, 5, 6, 3);
        triangles[2] = new Triangle(0, 0, 6, 0, 3, 5);
        triangles[3] = new Triangle(0, 0, 10, 0, 5, 8.6602540378);
        triangles[4] = new Triangle(1, 0, 1, 6, 5, 0);
        triangles[5] = new Triangle(0, 0, 0, 8, 5, 0);
        triangles[6] = new Triangle(0, 0, 20, 0, 10, 8);
        triangles[7] = new Triangle(1, 1, 4, 5, 2, 7);

        boolean[] rect = new boolean[triangles.length];
        for (int i = 0; i < triangles.length; i++) {
            if (triangles[i].ifRectangular()) {
                rect[i] = true;
            }
        }

        boolean[] equilateral = new boolean[triangles.length];
        for (int i = 0; i < triangles.length; i++) {
            if (triangles[i].ifEquilateral()) {
                equilateral[i] = true;
            }
        }

        boolean[] isosceles = new boolean[triangles.length];
        for (int i = 0; i < triangles.length; i++) {
            if (triangles[i].ifIsosceles()) {
                isosceles[i] = true;
            }
        }

        boolean[] arbitrary = new boolean[triangles.length];
        for (int i = 0; i < triangles.length; i++) {
            if (triangles[i].ifArbitrary()) {
                arbitrary[i] = true;
            }
        }

        for (int i = 0; i < triangles.length; i++) {
            if (rect[i]) {
                maxArea = triangles[i].getArea();
                minArea = maxArea;
                maxPerimeter = triangles[i].getPerimeter();
                minPerimeter = maxPerimeter;
                break;
            }
        }
        for (int i = 0; i < triangles.length; i++) {
            if (rect[i]) {
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
            if (equilateral[i]) {
                maxArea = triangles[i].getArea();
                minArea = maxArea;
                maxPerimeter = triangles[i].getPerimeter();
                minPerimeter = maxPerimeter;
                break;
            }
        }
        for (int i = 0; i < triangles.length; i++) {
            if (equilateral[i]) {
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
            if (isosceles[i]) {
                maxArea = triangles[i].getArea();
                minArea = maxArea;
                maxPerimeter = triangles[i].getPerimeter();
                minPerimeter = maxPerimeter;
                break;
            }
        }
        for (int i = 0; i < triangles.length; i++) {
            if (isosceles[i]) {
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
            if (arbitrary[i]) {
                maxArea = triangles[i].getArea();
                minArea = maxArea;
                maxPerimeter = triangles[i].getPerimeter();
                minPerimeter = maxPerimeter;
                break;
            }
        }
        for (int i = 0; i < triangles.length; i++) {
            if (arbitrary[i]) {
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
