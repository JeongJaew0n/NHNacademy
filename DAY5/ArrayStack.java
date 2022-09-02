package day5;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> implements MyStack<E> {

    E[] dataArray;

    int top;
    boolean trace;

    final int DEFAULT_SIZE = 16;

    {
        E[] dataArray = null;
        top = -1;
        trace = false;
    }

    ArrayStack() {
        dataArray = (E[]) new Object[this.DEFAULT_SIZE];
    }

    ArrayStack(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("1이상의 크기를 할당해 주세요!");
        }
        dataArray = (E[]) new Object[size];

    }

    public void setTrace(boolean trace) {
        this.trace = trace;
    }

    // 역순으로 변경하기
    @Override
    public void reverse() {
        MyStack<E> tempStack = new ArrayStack<>();

        System.out.println(this.size());

        while (this.size() != 0) {
            tempStack.push(this.pop());
        }

    }

    @Override
    public E penultimate() {
        return null;
    }

    @Override
    public E popPenultimate() {
        return null;
    }

    @Override
    public E bottom() {
        return null;
    }

    @Override
    public E popBottom() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        if (trace) {
            if (top < 0) {
                System.out.println("Stack is empty");
            } else {
                System.out.println("Stack is not empty");
            }
        }
        return top < 0 ? true : false;
    }

    @Override
    public void push(E element) {
        if (this.size() >= dataArray.length * 0.75) {
            E[] temp = (E[]) new Object[dataArray.length * 2];
            System.arraycopy(dataArray, 0, temp, 0, dataArray.length);
            dataArray = temp;
        }

        ++top;
        dataArray[top] = element;

        if (trace) {
            System.out.println("Push: " + element.toString());
        }
    }

    @Override
    public E peek() {
        if (top < 0) {
            throw new EmptyStackException();
        }
        if (trace) {
            System.out.println("Peek: " + dataArray[top].toString());
        }
        return dataArray[top];
    }

    @Override
    public E pop() {
        if (top < 0) {
            throw new EmptyStackException();
        }

        E returnValue = dataArray[top];
        dataArray[top] = null;
        top--;

        if (trace) {
            System.out.println("Pop: " + returnValue.toString());
        }

        return returnValue;
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public String toString() {
        StringBuilder printString = new StringBuilder();
        for (E e : dataArray) {
            printString.append(e == null ? "" : e + " ");
        }
        return printString.toString().replaceAll("\\s$", "");
    }

    /*        Stack의 push(), peek(), pop(), isEmpty() 메소드만을 사용하여 클라이언트 메소드를 작성합니
           다. 반환되는 Stack에는 인수로 주어진 Stack의 데이터가 역순으로 포함됩니다
     */
//    public static <E> MyStack<E> reversed(MyStack<E> stack) {
//
//        MyStack<E> tempStack = new ArrayStack<>();
//
//        while(stack.size()!=0) {
//            tempStack.push(stack.pop());
//        }
//
//        return tempStack;
//    }

    /*
    4. Stack의 push(), peek(), pop(), isEmpty() 메소드만을 사용하여 클라이언트 메소드를 작성합니
    다. 반환되는 Stack에는 인수로 주어진 Stack의 데이터가 역순으로 포함되고, 인수로 주어진 Stack에
    는 원래의 데이터가 원래의 순서로 남아 있습니다
     */
    public static <E> MyStack<E> reversed(MyStack<E> stack) {
        MyStack<E> returnStack = new ArrayStack<>();
        MyStack<E> tempStack = new ArrayStack<>();

        tempStack = stack;

        while (tempStack.size() != 0) {
            returnStack.push(tempStack.pop());
        }

        return returnStack;
    }

    /*
    5. Stack의 push(), peek(), pop(), isEmpty() 메소드만을 사용하여 클라이언트 메소드를 작성합니
    다. 인수로 주어진 Stack의 데이터는 역순으로 변경됩니다
     */
    public static <E> void reverse(MyStack<E> stack) {
        MyStack<E> tempStack = new ArrayStack<>();

        tempStack = stack;

        while (stack.size() != 0) {
            tempStack.push(stack.pop());
        }

        stack = tempStack;
    }

    /*
    6. Stack의 push(), peek(), pop(), isEmpty() 메소드만을 사용하여 클라이언트 메소드를 작성합니
다. 인수로 주어진 Stack의 위에서 두번째 데이터를 돌려 줍니다.
     */
    public static <E> E penultimate(MyStack<E> stack) {
        E element = stack.pop();

        E returnValue = stack.peek();

        stack.push(element);

        return returnValue;
    }

    /*
        7. Stack의 push(), peek(), pop(), isEmpty() 메소드만을 사용하여 클라이언트 메소드를 작성합니
다. 인수로 주어진 Stack의 위에서 두번째 데이터를 돌려주고, 제거합니다.
     */
    public static <E> E popPenultimate(MyStack<E> stack) {
        E element = stack.pop();

        E returnValue = stack.pop();

        stack.push(element);

        return returnValue;
    }

    /*
    8. Stack의 push(), peek(), pop(), isEmpty() 메소드만을 사용하여 클라이언트 메소드를 작성합니
다. 인수로 주어진 Stack의 제일 아래 데이터를 돌려 줍니다.
     */
    public static <E> E bottom(MyStack<E> stack) {
        MyStack<E> tempStack = stack;
        while(tempStack.size() != 1) {
            tempStack.pop();
        }

        return tempStack.peek();
    }

    /*
    9. Stack의 push(), peek(), pop(), isEmpty() 메소드만을 사용하여 클라이언트 메소드를 작성합니
다. 인수로 주어진 Stack의 제일 아래 데이터를 돌려 주고, 제거합니다
     */
    public static <E> E popBottom(MyStack<E> stack) {
        MyStack<E> tempStack = new ArrayStack<>();

        while (stack.size() != 0) {
            tempStack.push(stack.pop());
        }

        E returnValue = tempStack.pop();

        while(stack.size() != 0) {
            stack.push(tempStack.pop());
        }

        return returnValue;
    }

}
