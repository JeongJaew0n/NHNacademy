//import java.util.List;
//
//public class InOderTreeNode extends MyNode{
//
//    public InOderTreeNode(Integer _value) {
//        super(_value);
//    }
//
//    public InOderTreeNode(Integer _value, MyNode _leftChild) {
//        super(_value, _leftChild);
//    }
//
//    public InOderTreeNode(Integer _value, MyNode _leftChild, MyNode _rightChild) {
//        super(_value, _leftChild, _rightChild);
//    }
//
//    @Override
//    public Integer serach(Integer key) {
//
//        if(leftChild != null) {
//            try {
//                return leftChild.serach(key);
//            }
//            catch (Exception ignore) {
//            }
//        }
//
//        if(this.equals(key)) {
//            return value;
//        }
//
//        if(rightChild != null) {
//            try {
//                return rightChild.serach(key);
//            }
//            catch (Exception ignore){
//            }
//        }
//
//        return null;
//    }
//
//    @Override
//    public List<Integer> getList() {
//        return null;
//    }
//
//    @Override
//    public void add(Integer _value) {
//
//        if(_value.compareTo(value) < 0) {
//            if(this.leftChild != null) {
//                leftChild.add(_value);
//            }
//            else {
//                this.leftChild = new InOderTreeNode(_value);
//            }
//        }
//
//        else {
//            if(this.rightChild != null) {
//                rightChild.add(_value);
//            }
//            else {
//                this.rightChild = new InOderTreeNode(_value);
//            }
//        }
//    }
//
//    public Integer remove(Integer key) {
//
//        InOderTreeNode currentNode = null;
//
//        if(leftChild != null) {
//            try {
//                leftChild.serach(key);
//            }
//            catch (Exception ignore) {
//            }
//        }
//
//        if(this.equals(key)) {
//            currentNode = this;
//            return value;
//        }
//
//        if(rightChild != null) {
//            try {
//                rightChild.serach(key);
//            }
//            catch (Exception ignore){
//            }
//        }
//
//        // 삭제 후 빈자리를 채워준다. 오른쪽 자식이 부모로 올라오며 삭제된 노드의 왼쪽 자식이 있을 경우 다시 추가해준다.
//        if(currentNode != null) {
//
//            InOderTreeNode tempLeftChildNode = null;
//
//            // 왼쪽 자식이 있는 경우
//            if (currentNode.leftChild != null) {
//                tempLeftChildNode = (InOderTreeNode) currentNode.leftChild;
//
//                currentNode = (InOderTreeNode) currentNode.rightChild;
//            }
//
//            if(tempLeftChildNode != null) {
//                if(tempLeftChildNode.leftChild != null) {
//
//                }
//                currentNode.add(tempLeftChildNode.value);
//            }
//        }
//
//
//
//        return null;
//    }
//
//}
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InorderTreeNode<T, K> extends MyNode<T, K> {
    public InorderTreeNode(T value) {
        super(value, null, null);
    }

    public InorderTreeNode(T value, InorderTreeNode leftChildNode) {
        super(value, leftChildNode, null);
    }

    public InorderTreeNode(T value, InorderTreeNode leftChildNode, InorderTreeNode rightChildNode) {
        super(value, leftChildNode, rightChildNode);
    }

    public T search(K key) throws Exception {
        if (this.leftChild != null) {
            try {
                return (T)this.leftChild.search(key);
            }
            catch (Exception ignore) {
            }
        }

        if (this.value.equals(key))  {
            return  this.value;
        }

        if (this.rightChild != null) {
            try {
                return (T)this.rightChild.search(key);
            }
            catch (Exception ignore) {
            }
        }

        throw new Exception("Not found!");
    }

    public void add(K _value) {
        if (this.compare((K) this.value,_value) > 0) {
            if (this.leftChild != null) {
                ((InorderTreeNode)this.leftChild).add(_value);
            } else {
                this.leftChild = new InorderTreeNode(_value) ;
            }
        } else {
            if (this.rightChild != null) {
                ((InorderTreeNode)this.rightChild).add(_value);
            } else {
                this.rightChild = new InorderTreeNode(_value) ;
            }
        }
    }

    public void add(MyNode _node) {
        if (this.compare((K)this.value, (K) _node.getValue()) > 0) {
            if (this.leftChild != null) {
                ((InorderTreeNode)this.leftChild).add(_node);
            } else {
                this.leftChild = _node;
            }
        } else {
            if (this.rightChild != null) {
                ((InorderTreeNode)this.rightChild).add(_node);
            } else {
                this.rightChild = _node;
            }
        }
    }

    public void remove(K key) {
        if (this.leftChild != null) {
            try {
                this.leftChild.search(key);
                if (this.leftChild.getValue().equals(key)) {
                    if (this.leftChild.getLeftChildNode() != null) {
                        MyNode rightNode = this.leftChild.getRightChildNode();
                        this.leftChild = this.leftChild.getLeftChildNode();
                        this.leftChild.add(rightNode);
                    } else {
                        this.leftChild = this.leftChild.getRightChildNode();
                    }
                } else {
                    this.leftChild.remove(key);
                }
            } catch (Exception e) {
                System.out.println(e + ": left");
            }
        }
        if (this.rightChild != null) {
            try {
                this.rightChild.search(key);
                if (this.rightChild.getValue().equals(key)) {
                    if (this.rightChild.getLeftChildNode() != null)  {
                        MyNode rightNode = this.rightChild.getRightChildNode();
                        this.rightChild = this.rightChild.getLeftChildNode();
                        this.rightChild.add(rightNode);
                    } else  {
                        this.rightChild = this.rightChild.getRightChildNode();
                    }
                } else {
                    this.rightChild.remove(key);
                }
            } catch (Exception e) {
                System.out.println(e + ": right");
            }
        }
    }

    public void getList(List<T> list) {
        if (this.leftChild != null) {
            this.leftChild.getList(list);
        }

        list.add(this.value);

        if (this.rightChild != null) {
            this.rightChild.getList(list);
        }
    }

    public String toString() {
        List<String>  list = new ArrayList<>();

        if ((this.leftChild != null) || (this.rightChild != null)) {
            if (this.leftChild != null) {
                list.add(this.leftChild.toString());
            } else {
                list.add("null");
            }

            list.add(this.value.toString());

            if (this.rightChild != null) {
                list.add(this.rightChild.toString());
            } else {
                list.add("null");
            }

            return  list.toString();
        }
        else {
            return   this.value.toString();
        }

    }

    @Override
    public int compare(K o1, K o2) {
        try {
            if(o1 instanceof Number && o2 instanceof  Number) {
                if((Double)o1 > (Double) o2) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        }
        catch (Exception e) {
            throw new InvalidParameterException("Can't Compare!");
        }
        return 0;
    }
}

