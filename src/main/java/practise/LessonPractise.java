package practise;

public class LessonPractise {
    public static void main(String[] args) {
        Animal tiger = new Animal(10, "tiger");
        Animal elephant = new Animal(12, "elephant");
        Animal lion = new Animal(10, "lion");
        Animal frog = new Animal(3, "frog");
        System.out.println(tiger.compareTo(elephant));
        System.out.println(tiger.compareTo(lion));
        System.out.println(tiger.compareTo(frog));
        Animal[] array = {tiger, elephant, lion, frog};
        sort(array);
        for (Animal animal : array) {
            System.out.println(animal.getName());
        }
    }

    public static void sort(Animal[] array) {
        for(int k = 0; k < array.length; k++) {
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1].compareTo(array[i]) > 0) {
                    Animal temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
        }
    }
}
