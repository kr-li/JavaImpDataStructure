package Trees;

import java.util.Arrays;

public class ArrayBinaryTree {

    public static void main(String[] args) {
        ArrayBinaryTree a = new ArrayBinaryTree(10);
        a.setRootNode(0);
        a.addLeftNode(10,0);
        a.addRightNode(20,0);
        a.addLeftNode(30,1);
        a.addRightNode(40,1);
        a.delete(1);
        System.out.println(a.getNodeCount());


    }

    private int capacity;//树容量

    private int nodeCount;//树结点数量

    private BinaryNode[] elements;//存放BinaryNode类型的数组

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //树的结点数量
    public int getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }

    public BinaryNode[] getElements() {
        return elements;
    }

    public void setElements(BinaryNode[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayBinaryTree that = (ArrayBinaryTree) o;
        return capacity == that.capacity &&
                nodeCount == that.nodeCount &&
                Arrays.equals(elements, that.elements);
    }

    @Override
    public String toString() {
        return "ArrayBinaryTree{" +
                Arrays.toString(elements) +
                '}';
    }

    //构造方法给定数组长度
    public ArrayBinaryTree(int capacity) {
        this.capacity = capacity;
        this.elements = new BinaryNode[capacity];
    }

    public ArrayBinaryTree() {
    }

    //判断是否为空树
    public boolean isEmpty(){
        return nodeCount == 0;
    }

    //设置根结点
    public void setRootNode(int data){
        if (nodeCount == 0){
            BinaryNode rootNode = new BinaryNode(data);
            this.elements[0] = rootNode;
            rootNode.setLeftChild(-1);
            rootNode.setRightChild(-1);
            nodeCount++;
        }
        else{
            throw new RuntimeException("the tree has a root!");
        }
    }

    //为索引为i的结点添加左孩子结点
    /**
     *
     * @param data 新结点存储的数据
     * @param i 为索引为i的结点添加左孩子
     *          新结点在数组中的索引为2*index+1
     */
    public void addLeftNode(int data, int index){
        BinaryNode newNode = new BinaryNode(data);
        if (index < 0 || index > capacity-1){
            throw new RuntimeException("索引超出范围");
        }
        if (this.elements[index].getLeftChild() != -1){
            throw new RuntimeException("该结点已有左孩子");
        }
        this.elements[index].setLeftChild(2*index+1);
        this.elements[2*index+1] = newNode;
        nodeCount++;
    }

    //为索引为i的结点添加右孩子结点
    /**
     *
     * @param data 新结点存储的数据
     * @param i 为索引为i的结点添加右孩子
     *          新结点在数组中的索引为2*index+2
     */
    public void addRightNode(int data, int index){
        BinaryNode newNode = new BinaryNode(data);
        if (index < 0 || index > capacity-1){
            throw new RuntimeException("索引超出范围");
        }
        if (this.elements[index].getRightChild() != -1){
            throw new RuntimeException("该结点已有左孩子");
        }
        this.elements[index].setRightChild(2*index+2);
        this.elements[2*index+2] = newNode;
        nodeCount++;
    }

    //递归删除某一索引的结点及其孩子(子树)
    public void deleteNode(int index){
        //先改变其父结点的索引值为-1；
        for (int i = 0; i < capacity; i++) {
            if (elements[i] != null){
                if (elements[i].getRightChild() == index){
                    elements[i].setRightChild(-1);
                }
                if (elements[i].getLeftChild() == index){
                    elements[i].setLeftChild(-1);
                }
            }
        }
        //递归删除该结点的子树
        int l = elements[index].getLeftChild();
        int r = elements[index].getRightChild();
        if (l == -1 && r == -1){
            elements[index] = null;
        }
        else if (l == -1 && r != -1){
            elements[index] = null;
            nodeCount--;
            deleteNode(r);
        }
        else if (l != -1 && r == -1){
            elements[index] = null;
            nodeCount--;
            deleteNode(l);
        }
        else if (l != -1 && r != -1){
            deleteNode(l);
            deleteNode(r);
        }
        nodeCount--;
        elements[index] = null;
    }

    public void delete(int index){
        if (index != -1){
            int l = elements[index].getLeftChild();
            int r = elements[index].getRightChild();
            //改变其父结点的索引值为-1；
            for (int i = 0; i < capacity; i++) {
                if (elements[i] != null){
                    if (elements[i].getRightChild() == index){
                        elements[i].setRightChild(-1);
                    }
                    if (elements[i].getLeftChild() == index){
                        elements[i].setLeftChild(-1);
                    }
                }
            }
            nodeCount--;
            elements[index] = null;
            delete(l);
            delete(r);
        }
    }

    //取得树中某一值的在数组的索引
    public void getNode(int data){
        for (int i = 0; i < capacity; i++) {
            if (elements[i] != null){
                if (elements[i].getData() == data){
                    System.out.println(i);
                }
                else{
                    System.out.println("树中没有该值的结点");
                }
            }
        }
    }

    //前序遍历
    /**
     * 从某一结点索引开始遍历
     * @param index 某一结点索引值
     */
    public void frontTraversing(int index){
        if (index != -1){
            System.out.println(elements[index]);//输出中间结点
            frontTraversing(elements[index].getLeftChild());//递归左子树
            frontTraversing(elements[index].getRightChild());//递归右子树
        }
    }

    //中序遍历
    public void midTraversing(int index){
        if (index != -1){
            midTraversing(elements[index].getLeftChild());//递归左子树
            System.out.println(elements[index]);//输出中间结点
            midTraversing(elements[index].getRightChild());//递归右子树
        }
    }

    //后序遍历
    public void rareTraversing(int index){
        if (index != -1){
            rareTraversing(elements[index].getLeftChild());//递归左子树
            rareTraversing(elements[index].getRightChild());//递归右子树
            System.out.println(elements[index]);
        }
    }
}

/**
 * 孩子表示法实现结点
 * data存储int类数据
 * leftChild 存储左孩子在数组中的索引
 * RightChild存储右孩子在数组中的索引
 * 若没有孩子时，索引均为-1
 */

class BinaryNode{
    private int data;

    private int leftChild;

    private int rightChild;

    /**
     * 三种构造方法
     */
    public BinaryNode(int data) {
        this.data = data;
        this.leftChild = -1;
        this.rightChild = -1;
    }

    public BinaryNode() {
    }

    public BinaryNode(int data, int leftChild, int rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(int leftChild) {
        this.leftChild = leftChild;
    }

    public int getRightChild() {
        return rightChild;
    }

    public void setRightChild(int rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryNode that = (BinaryNode) o;
        return data == that.data &&
                leftChild == that.leftChild &&
                rightChild == that.rightChild;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
