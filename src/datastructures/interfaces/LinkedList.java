package datastructures.interfaces;

import java.util.NoSuchElementException;

public interface LinkedList<T> extends List{
    void addFirst(T t) throws NullPointerException;
    void addLast(T t) throws NullPointerException;
    T removeFirst() throws NoSuchElementException;
    T removeLast() throws NoSuchElementException;
    T getFirst() throws NoSuchElementException;
    T getLast() throws NoSuchElementException;
    void clear();
}
