package day5;

public class LinkedQueue<E> implements MyQueue<E> {

    static class Node<E> {
        E data;

        Node<E> nextNode;
        Node<E> preNode;

        Node(E data, Node preNode, Node nextNode) {
            this.data = data;
            this.preNode = preNode;
            this.nextNode = nextNode;
        }

        public Node<E> getPreNode() {
            return preNode;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }
    }
    // node


    Node<E> head;
    Node<E> tail;

    int size;

    {
        head = null;
        tail = null;
        size = 0;
    }
    // 더미 데이터 생성.

    LinkedQueue() {
        tail = new Node(null, null, null);

        head = tail;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0 ? true : false;
    }

    @Override
    public void add(E element) {
        if(head.equals(tail)) {
            head.preNode = new Node<>(element,null,head);
            head = head.preNode;
        }
        else {
            tail.data = element;
            tail.preNode = tail;
        }
        tail.nextNode = new Node<>(null,null,null);
        tail = tail.nextNode;
        size++;
    }

    @Override
    public E element() {
        return this.tail.preNode.data;
    }

    @Override
    public E remove() {
        if (head.equals(tail)) {
            throw new IllegalArgumentException("삭제 할 노드가 없습니다!");
        }

        Node<E> removedNode = head;
        head = head.nextNode;
        head.preNode = null;

        return removedNode.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder printString = new StringBuilder();
        if (head.equals(tail)) {
            return "";
        } else {
            Node<E> temp = head;
            while (!temp.equals(tail)) {
                printString.append(temp.data == null ? "" : temp.data + ", ");
                temp = temp.nextNode;
            }
        }
        return printString.toString().replaceAll(",\\s$", "");
    }
}
