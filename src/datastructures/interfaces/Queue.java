package datastructures.interfaces;

import java.util.Collection;
import java.util.NoSuchElementException;

public interface Queue<T> {
    boolean add(Object t) throws IllegalStateException;

    boolean offer(Object t);

    T remove() throws NoSuchElementException;

    T poll();

    T element() throws NoSuchElementException;

    T peek();

    boolean isEmpty();

    int size();
}
