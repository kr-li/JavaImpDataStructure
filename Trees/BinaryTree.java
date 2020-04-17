package Trees;

import java.util.Objects;
import java.util.SplittableRandom;

public class BinaryTree {
    //结点个数
    private int nodeCount = 0;
    //根结点
    private BinaryTreeNode root;

    /*set 和get方法
     */
    public int getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    //重写equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTree that = (BinaryTree) o;
        return nodeCount == that.nodeCount &&
                Objects.equals(root, that.root);
    }

    //重写toString


    @Override
    public String toString() {
        return "BinaryTree{" +
                "nodeCount=" + nodeCount +
                ", root=" + root +
                '}';
    }

    //添加根结点
    public BinaryTreeNode setRoot(int data){
        if (this.root != null){
            throw new RuntimeException("the tree has a root!");
        }
        else{
            BinaryTreeNode root = new BinaryTreeNode(data);
            this.root = root;
            nodeCount++;
            return root;
        }
    }

    //为rootNode结点添加左孩子
    public BinaryTreeNode addLeftChild(int data, BinaryTreeNode rootNode){
        if (rootNode.getLeftChild() != null){
            throw new RuntimeException("the root has a left child!");
        }
        else{
            BinaryTreeNode newLeftNode = new BinaryTreeNode(data);
            rootNode.setLeftChild(newLeftNode);
            nodeCount++;
            return newLeftNode;
        }
    }

    //为rootNode结点添加右孩子
    public BinaryTreeNode addRightChild(int data, BinaryTreeNode rootNode){
        if (rootNode.getRightChild() != null){
            throw new RuntimeException("the root has a right child!");
        }
        else{
            BinaryTreeNode newRightNode = new BinaryTreeNode(data);
            rootNode.setRightChild(newRightNode);
            nodeCount++;
            return newRightNode;
        }
    }

    //从node结点前序遍历
    public void frontTraversing(BinaryTreeNode node){
        if (node != null){
            System.out.println(node);
            frontTraversing(node.getLeftChild());
            frontTraversing(node.getRightChild());
        }
    }

    //从node结点中序遍历
    public void midTraversing(BinaryTreeNode node){
        if (node != null){
            midTraversing(node.getLeftChild());
            System.out.println(node);
            midTraversing(node.getRightChild());
        }
    }

    //从node结点后序遍历
    public void rareTraversing(BinaryTreeNode node){
        if (node != null){
            rareTraversing(node.getLeftChild());
            rareTraversing(node.getRightChild());
            System.out.println(node);
        }
    }

    public static void main(String[] args) {
        //测试
        BinaryTree tree = new BinaryTree();
        BinaryTreeNode root = tree.setRoot(0);
        tree.addLeftChild(1, root);
        BinaryTreeNode t = tree.addRightChild(2,root);
        tree.addRightChild(10, t);
        tree.frontTraversing(root);
    }
}


/**
 * 二叉树结点有三个属性；
 * 一个int存放数据，leftchild指向左孩子，rightchild指向右孩子
 */
class BinaryTreeNode{
    private int data;

    private BinaryTreeNode leftChild;

    private BinaryTreeNode rightChild;

    //有参数构造方法，传入数据data
    public BinaryTreeNode(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    /*set 和get方法
    */
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    //重写equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTreeNode that = (BinaryTreeNode) o;
        return data == that.data &&
                Objects.equals(leftChild, that.leftChild) &&
                Objects.equals(rightChild, that.rightChild);
    }

    //重写toString
    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "data=" + data +
                '}';
    }
}
