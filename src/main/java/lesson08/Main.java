package lesson08;

public class Main {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle(13.0, 8.0);
        Triangle tri = new Triangle(1.0, 1.0, 1.0);
        Figure defFig = new Figure();

        defFig = rec;
        System.out.println(defFig.getArea());
        defFig = tri;
        System.out.println(defFig.getArea());
    }
}
