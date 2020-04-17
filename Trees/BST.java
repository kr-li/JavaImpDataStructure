package Trees;

//二叉查找树
import java.util.Objects;

public class BST {
    private BSTNode root;

    private int nodeCount;

    public BST() {
        this.nodeCount = 0;
        this.root = null;
    }

    public BSTNode getRoot() {
        return root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BST bst = (BST) o;
        return nodeCount == bst.nodeCount &&
                Objects.equals(root, bst.root);
    }

    //查找某一结点
    public BSTNode find(int data) {
        BSTNode item = this.getRoot();
        while (item != null) {
            if (data < item.getData()) {
                if (item.getLeftChild() == null) {
                    return item; //返回父节点
                }
                item = item.getLeftChild();
            }
            else if (data > item.getData()) {
                if (item.getRightChild() == null) {
                    return item; //返回父节点
                }
                item = item.getRightChild();
            }
            else {
                return item;
            }
        }
        return null;
    }

    //添加数值为data的结点在合适位置
    public void append(int data) {
        BSTNode newNode = new BSTNode(data);
        if (this.root == null) {
            setRoot(new BSTNode(data));
            nodeCount++;
        } else {
            BSTNode parent = find(data);
            if (data < parent.getData()) {
                parent.setLeftChild(newNode);
                nodeCount++;
                parent.getLeftChild().setParent(parent);
            } else {
                parent.setRightChild(newNode);
                nodeCount++;
                parent.getRightChild().setParent(parent);
            }
        }
    }

    //从node结点前序遍历
    public void frontTraversing(BSTNode node){
        if (node != null){
            System.out.println(node);
            frontTraversing(node.getLeftChild());
            frontTraversing(node.getRightChild());
        }
    }

    //从node结点中序遍历
    public void midTraversing(BSTNode node){
        if (node != null){
            midTraversing(node.getLeftChild());
            System.out.println(node);
            midTraversing(node.getRightChild());
        }
    }

    //从node结点后序遍历
    public void rareTraversing(BSTNode node){
        if (node != null){
            rareTraversing(node.getLeftChild());
            rareTraversing(node.getRightChild());
            System.out.println(node);
        }
    }



    public static void main(String[] args) {
        BST tree = new BST();
        tree.append(100);
        tree.append(123);
        tree.append(1);

    }
}


/**
 * 一个结点存有四个属性
 * int类型的数据
 * 左孩子、右孩子、以及父节点
 */
class BSTNode{
    private int data;

    private BSTNode leftChild;

    private BSTNode rightChild;

    private BSTNode parent;

    //有参数构造方法，传入数据data
    public BSTNode(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BSTNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild;
    }

    public BSTNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
    }

    public BSTNode getParent() {
        return parent;
    }

    public void setParent(BSTNode parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BSTNode btsNode = (BSTNode) o;
        return data == btsNode.data &&
                Objects.equals(leftChild, btsNode.leftChild) &&
                Objects.equals(rightChild, btsNode.rightChild) &&
                Objects.equals(parent, btsNode.parent);
    }

    @Override
    public String toString() {
        return "BSTNode{data = " + data + "}";
    }
}
