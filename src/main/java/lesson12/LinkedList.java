package lesson12;

public class LinkedList<T> {
    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    public LinkedList(T[] array) {
        for (T t : array) {
            pushBack(t);
        }
    }

    public void pushBack(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(null);

        if (ifEmpty()) {
            head = newNode;
        } else {
            Node<T> last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }

            last.setNext(newNode);
        }
    }

    public void pushForward(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void insert(T data, int index) {
        if (index < getListLength() && index >= 0) {
            Node<T> newNode = new Node<>(data);
            Node<T> current = head;

            if (index != 0) {
                for (int i = 0; i <= index; i++) {
                    if (i == index - 1) {
                        Node<T> temp = current.getNext();
                        current.setNext(newNode);
                        newNode.setNext(temp);
                    }
                    current = current.getNext();
                }
            } else {
                pushForward(data);
            }

        } else {
            System.err.println("Incorrect index");
        }
    }

    public void deleteFirst() {
        head = head.getNext();
    }

    public void deleteLast() {
        Node<T> iterator = head;
        Node<T> previous = iterator;
        while (iterator.getNext() != null) {
            previous = iterator;
            iterator = iterator.getNext();
        }
        previous.setNext(null);
    }

    public void deleteByIndex(int index) {
        if (!ifEmpty()) {
            int i = 0;
            if (index == 0) {
                deleteFirst();
                return;
            }
            if (index == getListLength() - 1) {
                deleteLast();
                return;
            }
            Node<T> iterator = head;
            Node<T> previous;
            do {
                previous = iterator;
                iterator = iterator.getNext();
                i++;
            } while (i != index);
            previous.setNext(iterator.getNext());
        }
    }

    @Override
    public String toString() {
        Node<T> iterator = head;
        StringBuilder result = new StringBuilder();
        do {
            result.append(iterator.getData()).append(" ");
            iterator = iterator.getNext();
        } while (iterator != null);
        return result.toString();
    }

    public void swap(int index1, int index2) {
        if (!ifEmpty()) {
            int i = 0;
            Node<T> iterator1 = head;
            Node<T> previous1;
            do {
                previous1 = iterator1;
                iterator1 = iterator1.getNext();
                i++;
            } while (i != index1);

            int k = 0;
            Node<T> iterator2 = head;
            Node<T> previous2;
            do {
                previous2 = iterator2;
                iterator2 = iterator2.getNext();
                k++;
            } while (k != index2);
            Node<T> temp = iterator2.getNext();
            previous1.setNext(iterator2);
            iterator2.setNext(iterator1.getNext());
            previous2.setNext(iterator1);
            iterator1.setNext(temp);
        }
    }

    public int getListLength() {
        int amount = 0;
        Node<T> iterator;
        if (head != null) {
            iterator = head;
            amount++;
        } else {
            return 0;
        }
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
            amount++;
        }
        return amount;
    }

    public boolean ifEmpty() {
        return head == null;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}
