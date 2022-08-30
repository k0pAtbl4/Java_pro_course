package lesson12;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {
    private final Node<T> head;

    public LinkedListIterator(LinkedList<T> list) {
        this.head = list.getHead();
    }

    @Override
    public T next() {
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            return head.getNext().getData();
        }
    }

    @Override
    public boolean hasNext() {
        return head != null;
    }
}
