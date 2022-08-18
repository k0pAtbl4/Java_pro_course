package lesson12;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 12, 43, 56, 34};
        LinkedList<Integer> list = new LinkedList<Integer>(array);
        list.pushForward(123);
        list.pushBack(321);
        list.insert(333, 4);
        System.out.println(list.getListLength());
        System.out.println(list);
        list.deleteFirst();
        list.deleteLast();
        System.out.println(list);
        list.deleteByIndex(3);
        System.out.println(list);
        list.swap(3, 6);
        System.out.println(list);

        System.out.println("\n\n\n\n");

        String[] arr = {"Hello", "word", "i", "love", "you"};
        LinkedList<String> listStr = new LinkedList<String>(arr);
        listStr.pushForward("forward");
        listStr.pushBack("back");
        listStr.insert("insert-on-3", 3);
        System.out.println(listStr.getListLength());
        System.out.println(listStr);
        listStr.deleteFirst();
        listStr.deleteLast();
        System.out.println(listStr);
        listStr.deleteByIndex(3);
        System.out.println(listStr);
        listStr.swap(1, 3);
        System.out.println(listStr);
    }
}
