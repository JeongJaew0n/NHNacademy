import org.w3c.dom.Node;

import java.util.Comparator;
import java.util.List;

public abstract class MyNode<T,K> implements Comparator<K> {
    T value;
    MyNode leftChild;
    MyNode rightChild;

    MyNode(T _value) {
        this.value = _value;
        this.leftChild = null;
        this.rightChild = null;
    }

    MyNode(T _value, MyNode _leftChild) {
        this.value = _value;
        this.leftChild = _leftChild;
        this.rightChild = null;
    }

    MyNode(T _value, MyNode _leftChild, MyNode _rightChild) {
        this.value = _value;
        this.leftChild = _leftChild;
        this.rightChild = _rightChild;
    }

    public T getValue() {
        return  this.value;
    }

    public MyNode getLeftChildNode() {
        return this.leftChild;
    }

    public MyNode getRightChildNode() {
        return this.rightChild;
    }

    public abstract T search(K _key) throws Exception;

    public abstract void getList(List<T> list);

    public abstract void add(MyNode _node);

    protected abstract void remove(K key);
}