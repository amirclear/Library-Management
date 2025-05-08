package datastructures.interfaces;

public interface Collection<T> {
    int size() throws NullPointerException;
    boolean isEmpty() throws NullPointerException;
    boolean add(T t);
    boolean contains(Object o);
    boolean remove(Object o);
}
