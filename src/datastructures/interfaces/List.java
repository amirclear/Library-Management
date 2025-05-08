package datastructures.interfaces;

public interface List<T> extends Collection {
    T get(int index) throws IndexOutOfBoundsException;
    T set(int index, T element) throws IndexOutOfBoundsException;
}
