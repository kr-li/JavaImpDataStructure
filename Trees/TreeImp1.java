package Trees;

import java.util.Arrays;

public class TreeImp1 {

    public static void main(String[] args) {
        //测试
        TreeImp1 t = new TreeImp1(10);
        //添加跟结点
        t.setRootNode(10);
        //为某个结点添加结点
        t.addNode(10,-1,100);
        t.addNode(10,-1,200);
        t.addNode(200,0,1000);
        t.addNode(200,0,200);
        t.addNode(200,0,200);
        t.addNode(200,0,200);
        t.addNode(200,0,200);
        t.addNode(100,0,20);
        System.out.println(t);
        System.out.println(t.degreeForTree());
    }

    @Override
    public String toString() {
        return "TreeImp1{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }

    private int capacity;//树容量

    private int nodeCount;//树结点数量

    private Node[] elements;//存放Node类型的数组

    //查询树的结点数量
    public int getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Node[] getElements() {
        return elements;
    }

    public void setElements(Node[] elements) {
        this.elements = elements;
    }

    //设置数组容量的构造方法
    public TreeImp1(int capacity) {
        this.capacity = capacity;
        this.elements = new Node[capacity];
    }

    //是否空树
    public boolean isEmpty(){
        return nodeCount == 0;
    }

    //设置根结点
    public Node setRootNode(int a){
        this.elements[0] = new Node(a,-1);
        nodeCount++;
        return new Node(a, -1);
    }

    //查询根结点
    public Node getRootNode(){
        return this.elements[0];
    }

    //为某个结点添加结点
    /**
     *
     * @param data 父结点数据
     * @param parent    父节点的指向
     * @param newData   新结点的数据
     * 这三个数据能先由前两个数据准确找到某一个结点，之后为这个结点添加新结点
     */
    public void addNode(int data, int parent, int newData){
        if (nodeCount > capacity){
            throw new RuntimeException("超出容量");
        }
        else{
            for (int i = 0; i < nodeCount; i++) {
                Node oldNode = new Node(data, parent);
                if (this.elements[i].equals(oldNode)){
                    this.elements[nodeCount] = new Node(newData,i);
                    nodeCount++;
                    break;
                }
            }
        }
    }

    //查找第一个存放数值为data的结点的索引位置，有的话返回该数据结点索引，否则返回-1
    public int indexNode(int data){
        for (int i = 0; i < nodeCount; i++) {
            if (this.elements[i].getData() == data){
                return i;
            }
        }
        return -1;
    }

    //查询某个结点的所有子结点,并将他们放入一个新的数组中
    public TreeImp1 arrayChildren(int data, int parent){
        Node oldNode = new Node(data,parent);
        TreeImp1 t = new TreeImp1(this.capacity);
        for (int i = 0; i < nodeCount; i++) {
            if (this.elements[i].equals(oldNode)){
                for (int j = 0; j < nodeCount; j++) {
                    if (this.elements[j].getParent() == i){
                        t.elements[t.nodeCount] = elements[j];
                        t.nodeCount++;
                    }
                }
                return t;
            }
        }
        return new TreeImp1(0);
    }

    //求树的度
    public int degreeForTree(){
        int max = 0;
        for (int i = 0; i < nodeCount; i++) {
            TreeImp1 x = arrayChildren(this.elements[i].getData(), this.elements[i].getParent());
            int z = x.nodeCount;
            max = z > max ? z : max;
        }
        return max;
    }


}

//结点类
class Node{
    private int data;//结点中存放的数据

    private int parent;//结点的父结点的索引

    //两个参数构造方法
    public Node(int data, int parent) {
        this.setData(data);
        this.setParent(parent);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return data == node.data &&
                parent == node.parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", parent=" + parent +
                '}';
    }
}
