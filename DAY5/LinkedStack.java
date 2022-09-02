package day5;

public class LinkedStack<E> implements MyStack<E> {

    // 링크드 리스트를 구성할 노드.
    static class LinkedNode<E> {
        E value;
        LinkedNode leftNode;
        LinkedNode rightNode;

        LinkedNode(E value, LinkedNode leftNode, LinkedNode rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public void add(E value) {
            if (this.rightNode != null) {
                rightNode.add(value);
            } else {
                this.rightNode = new LinkedNode(value, this, null);
            }
        }

        public E remove() {
            if (this == null) {
                throw new NullPointerException("노드가 없습니다.");
            }

            if (this.rightNode != null) {
                return (E) this.rightNode.remove();
            } else {
                LinkedNode removedNode = this;
                if (this.leftNode == null && this.rightNode == null) {
                    this.value = null;
                }
                else {
                    this.leftNode.rightNode = null;
                }
                return (E) removedNode;
            }
        }

        public E peek() {
            if (this.rightNode == null) {
                return (E) this;
            } else {
                return (E) this.rightNode.peek();
            }
        }

        public int size() {
            int size = 0;
            if (this.rightNode == null) {
                return 1;
            } else {
                return this.rightNode.size() + 1;
            }
        }

        @Override
        public String toString() {
            StringBuilder printString = new StringBuilder();

            if (rightNode == null) {
                printString.append(this.value + ", ");
            }
            LinkedNode temp = this;
            while (temp.rightNode != null) {
                printString.append(temp.value + ", ");
                temp = temp.rightNode;
                if (temp.rightNode == null) {
                    printString.append(temp.value + ", ");
                }
            }
            return printString.toString().replaceAll(",\\s$", "");
        }
    }

    LinkedNode<E> linkedNode;
    boolean trace;

    {
        trace = false;
    }

    LinkedStack() {
        linkedNode = null;
    }

    @Override
    public boolean isEmpty() {
        if (linkedNode == null) return true;
        return linkedNode.size() == 0 ? true : false;
    }

    @Override
    public void push(E element) {
        if (linkedNode == null) {
            linkedNode = new LinkedNode<>(element, null, null);
        } else {
            linkedNode.add(element);
        }
    }

    //NoSuchElementException
    @Override
    public E peek() {
        return linkedNode.peek();
    }

    @Override
    public E pop() {
        return linkedNode.remove();
    }

    // *계속 계산하지 말고 있는 함수 갖다 쓰기.
    @Override
    public int size() {
        return linkedNode.size();
    }

    @Override
    public void setTrace(boolean b) {
    }

    // 역순으로 변경하기
    @Override
    public void reverse() {
        MyStack<E> tempStack = new ArrayStack<>();

        tempStack = this;

        while (tempStack.size() != 0) {
            tempStack.push(this.pop());
        }

        while(tempStack.size() != 0) {
            this.push(tempStack.pop());
        }
    }

    @Override
    public E penultimate() {
        E element = this.pop();

        E returnValue = this.peek();

        this.push(element);

        return returnValue;
    }

    @Override
    public E popPenultimate() {

        E element = this.pop();

        E returnValue = this.pop();

        this.push(element);

        return returnValue;
    }

    @Override
    public E bottom() {
        MyStack<E> tempStack = this;
        while(tempStack.size() != 1) {
            tempStack.pop();
        }

        return tempStack.peek();
    }

    @Override
    public E popBottom() {
        MyStack<E> tempStack = new ArrayStack<>();

        while (this.size() != 0) {
            tempStack.push(this.pop());
        }

        E returnValue = tempStack.pop();

        while(this.size() != 0) {
            this.push(tempStack.pop());
        }

        return returnValue;
    }

    @Override
    public String toString() {
        if(linkedNode == null) {
            return "";
        }
        return linkedNode.toString();
    }
}
