package day5;

public interface MyStack<E> {
    public boolean isEmpty();
    public void push(E element);
    public E peek();
    public E pop();
    public int size();

    void setTrace(boolean b);

    public void reverse();
    public E penultimate();
    public E popPenultimate();
    public E bottom();
    public E popBottom();

}
