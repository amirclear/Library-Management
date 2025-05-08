package datastructures.lists;
import datastructures.interfaces.LinkedList;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements LinkedList<T>{

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;
    private int size = 0;

    @Override
    public void addFirst(T t) throws NullPointerException {
        if ( t == null ) {
            throw new NullPointerException();
        }
        Node<T> newNode = new Node<>(t);
        if ( head == null ) {
            head = newNode = tail;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T t) throws NullPointerException {
        if ( t == null ) {
            throw new NullPointerException();
        }
        Node<T> newNode = new Node<>(t);
        if ( tail == null ) {
            head = newNode = tail;
        } else {
            tail.next = newNode ;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;

    }

    @Override
    public T removeFirst() throws NoSuchElementException {
        if ( head == null ) throw new NoSuchElementException();
        T data = head.data;
        head = head.next;
        if ( head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    @Override
    public T removeLast() throws NoSuchElementException {
        if ( tail == null ) throw new NoSuchElementException();
        T data = tail.data;
        tail = tail.prev;
        if ( tail != null ) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return data;
    }

    @Override
    public T getFirst() throws NoSuchElementException {
        if ( head == null ) throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public T getLast() throws NoSuchElementException {
        if ( tail == null ) throw new NoSuchElementException();
        return tail.data;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        if ( index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        for ( int i = 0 ; i < size ; i++ ) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public Object set(int index, Object element) throws IndexOutOfBoundsException {
        if ( index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        for ( int i = 0 ; i < size ; i++ ) {
            current = current.next;
        }
        T data = current.data;
        current.data = (T) element;
        return data;
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
        if ( o == null) throw new NullPointerException();
        Node<T> newNode = new Node<>((T)o);
        if ( tail == null ) {
            tail = head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = head;
        for ( int i  = 0 ; i < size ; i++ ) {
            if (head.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if ( o == null) throw new NullPointerException();
        Node<T> current = head;
        for ( int i = 0 ; i < size ; i++ ) {
            if (current.equals(o)) {
                if (current.prev != null) current.prev.next = current.next;
                else head = current.next;
                if (current.next != null) current.next.prev = current.prev;
                else tail = current.prev;
                size--;
                return true;
            }
        }
        return false;
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}