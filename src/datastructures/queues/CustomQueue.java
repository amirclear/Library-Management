package datastructures.queues;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

import java.util.NoSuchElementException;

public class CustomQueue<T> implements Queue<T> {
    private CustomLinkedList<T> list;

    public CustomQueue() {
        list = new CustomLinkedList<>();
    }

    @Override
    public boolean add(Object t) throws IllegalStateException {
        if (list.add(t)) return true;
        throw new IllegalStateException();
    }

    @Override
    public boolean offer(Object t) {
        return list.add(t);
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (list.isEmpty()) throw new NoSuchElementException();
        return list.removeFirst();
    }

    @Override
    public T poll() {
        if (list.isEmpty()) return null;
        return list.removeFirst();
    }

    @Override
    public T element() throws NoSuchElementException {
        if (list.isEmpty()) throw new NoSuchElementException();
        return list.getFirst();
    }

    @Override
    public T peek() {
        if (list.isEmpty()) return null;
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public int size() {
        return list.size();
    }

    public void display() {
        list.display();
    }


}