package datastructures.lists;

import datastructures.interfaces.List;

import java.util.Arrays;

public class CustomArrayList<T> implements List<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public CustomArrayList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if ( index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException {
        if ( index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        elements[index] = element;
        return (T) elements[index];
    }

    @Override
    public int size() throws NullPointerException {
        return size;
    }

    @Override
    public boolean isEmpty() throws NullPointerException {
        return size == 0;
    }

    @Override
    public boolean add(Object o) {
        if ( o == null ) {
            throw new NullPointerException();
        }
        ensureCapacity();
        elements[size++] = o;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for ( int i = 0 ; i < size ; i++ ) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) throw new NullPointerException();
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
    }

}