package day5;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements MyQueue<E>{

    E[] elements;

    final int DEFAULT_SIZE = 16;

    int head;
    int tail;

    {
        head = 0;
        tail = 0;
    }

    ArrayQueue() {
        elements = (E[]) new Object[this.DEFAULT_SIZE];
    }

    @Override
    public boolean isEmpty() {
        return head == tail ? true : false;
    }



    @Override
    public void add(E element) {
        if(tail == elements.length) {
            if(elements[0] != null) {
                tail = 0;
            }
        }

        elements[tail] = element;
        tail++;
    }

    @Override
    public E element() {
        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements[head];
    }

    @Override
    public E remove() {
        if(this.isEmpty()) {
            throw new NoSuchElementException();
        }
        E returnElement = elements[head];
        elements[head] = null;
        head++;
        if(head == elements.length) {
            if(elements[0] != null) {
                head = 0;
            }
        }
        return returnElement;
    }
    @Override
    public int size() {
        int size = (elements.length + tail - head) % elements.length;
        return size;
    }

    @Override
    public String toString() {
        StringBuilder printString = new StringBuilder();
        for(E e:elements) {
            if(e != null) {
                printString.append(e + ", ");
            }
        }

        return printString.toString().replaceAll(",\\s$","");
    }
}
