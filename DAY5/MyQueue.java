package day5;

public interface MyQueue<E> {
    public boolean isEmpty();
    public void add(E element);
    public E element();
    public E remove();
    public int size();
}
