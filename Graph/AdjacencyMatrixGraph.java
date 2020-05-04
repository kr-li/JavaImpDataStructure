package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;


//邻接矩阵实现无向图已经dfs遍历
public class AdjacencyMatrixGraph {
    private ArrayList<Node> nodeArrayList;//存放结点的数组

    private int nodeNumbers;//结点数量

    public boolean[] visited;//遍历的时候检查该结点是否已经遍历；

    private int[][] edgeMatrix;//存放边的邻接矩阵

    static final int EDGE_NONE = 0;//边不存在

    static final int EDGE_EXIST = 1;//边存在

    public Queue<Node> queue;//辅助队列



    public ArrayList<Node> getNodeArrayList() {
        return nodeArrayList;
    }

    public void setNodeArrayList(ArrayList<Node> nodeArrayList) {
        this.nodeArrayList = nodeArrayList;
    }

    public int getNodeNumbers() {
        return nodeNumbers;
    }

    public void setNodeNumbers(int nodeNumbers) {
        this.nodeNumbers = nodeNumbers;
    }

    public int[][] getEdgeMatrix() {
        return edgeMatrix;
    }

    public void setEdgeMatrix(int[][] edgeMatrix) {
        this.edgeMatrix = edgeMatrix;
    }

    @Override
    public String toString() {
        System.out.println("结点列表：" + this.nodeArrayList);
        System.out.println("邻接矩阵：");
        System.out.print("   ");
        for (int i = 0; i < nodeArrayList.size(); i++) {
            System.out.print(nodeArrayList.get(i) + "         ");
        }
        System.out.println();
        for (int i = 0; i < getNodeNumbers(); i++) {
            System.out.print(nodeArrayList.get(i) + "  ");
            for (int j = 0; j < getNodeNumbers(); j++) {
                System.out.print(this.edgeMatrix[i][j] + "         ");
            }
            System.out.println();
        }
        return "";

    }

    //构造方法设置结点数量
    public AdjacencyMatrixGraph(int numbers) {
        this.nodeArrayList = new ArrayList<Node>(numbers);
        this.setNodeNumbers(numbers);
        this.setEdgeMatrix(new int[numbers][numbers]);
        this.visited = new boolean[numbers];
        this.queue = new LinkedList<Node>();
        for (int i = 0; i < numbers; i++) {
            for (int j = 0; j < numbers; j++) {
                this.edgeMatrix[i][j] = AdjacencyMatrixGraph.EDGE_NONE;
            }
        }
    }

    //添加结点
    public boolean addNodes(String nodeName){
        for (Node i : nodeArrayList) {
            if (i.getName().equals(nodeName)){
                return false;
            }
        }
        nodeArrayList.add(new Node(nodeName));
        return true;
    }

    //删除结点
    public void deleteNodes(String nodeName){
        nodeArrayList.removeIf(i -> i.getName().equals(nodeName));
    }

    //添加边
    public void addEdge(String from, String to){
        if (nodeArrayList.contains(new Node(from)) && nodeArrayList.contains(new Node(to))){
            this.edgeMatrix[nodeArrayList.indexOf(new Node(from))][nodeArrayList.indexOf(new Node(to))] =
                    AdjacencyMatrixGraph.EDGE_EXIST;
            this.edgeMatrix[nodeArrayList.indexOf(new Node(to))][nodeArrayList.indexOf(new Node(from))] =
                    AdjacencyMatrixGraph.EDGE_EXIST;
        }
        if (nodeArrayList.contains(new Node(from)) && !(nodeArrayList.contains(new Node(to)))){
            nodeArrayList.add(new Node(to));
            this.edgeMatrix[nodeArrayList.indexOf(new Node(from))][nodeArrayList.indexOf(new Node(to))] =
                    AdjacencyMatrixGraph.EDGE_EXIST;
            this.edgeMatrix[nodeArrayList.indexOf(new Node(to))][nodeArrayList.indexOf(new Node(from))] =
                    AdjacencyMatrixGraph.EDGE_EXIST;
        }
        if (!(nodeArrayList.contains(new Node(from))) && nodeArrayList.contains(new Node(to))){
            nodeArrayList.add(new Node(from));
            this.edgeMatrix[nodeArrayList.indexOf(new Node(from))][nodeArrayList.indexOf(new Node(to))] =
                    AdjacencyMatrixGraph.EDGE_EXIST;
            this.edgeMatrix[nodeArrayList.indexOf(new Node(to))][nodeArrayList.indexOf(new Node(from))] =
                    AdjacencyMatrixGraph.EDGE_EXIST;
        }
        if (!(nodeArrayList.contains(new Node(from))) && !(nodeArrayList.contains(new Node(to)))){
            nodeArrayList.add(new Node(from));
            nodeArrayList.add(new Node(to));
            this.edgeMatrix[nodeArrayList.indexOf(new Node(from))][nodeArrayList.indexOf(new Node(to))] =
                    AdjacencyMatrixGraph.EDGE_EXIST;
            this.edgeMatrix[nodeArrayList.indexOf(new Node(to))][nodeArrayList.indexOf(new Node(from))] =
                    AdjacencyMatrixGraph.EDGE_EXIST;
        }
    }

    //dfs遍历图
    public void DFS(){
        System.out.println("DFS顺序：");
        for (int i = 0; i < nodeArrayList.size(); i++) {
            visited[i] = false;
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]){
                depthFirstSearch(i);
            }
        }
        System.out.println();
    }
    private void depthFirstSearch(int i) {
        this.visited[i] = true;
        System.out.print("顶点" + this.nodeArrayList.get(i) + "-->");
        for (int j = 0; j < nodeArrayList.size(); j++) {
            if (this.edgeMatrix[i][j] == 1 && !this.visited[j]){
                depthFirstSearch(j);
            }
        }
    }

    //广度优先搜索
    public void BFS(){
        System.out.println("BFS顺序:");
        for (int i = 0; i < nodeArrayList.size(); i++) {
            this.visited[i] = false;//判断数组全为false
        }
        for (int i = 0; i < nodeArrayList.size(); i++) {
            if (!queue.contains(this.nodeArrayList.get(i)) && !visited[i]){
                queue.add(nodeArrayList.get(i));
                visited[i] = true;
            }
            for (int j = 0; j < nodeArrayList.size(); j++) {
                if (this.edgeMatrix[i][j] == 1 && !visited[j]){
                    queue.add(this.nodeArrayList.get(j));
                    visited[j] = true;
                }
            }
            Node a = queue.poll();
            System.out.print("顶点" + a + "-->");
        }
        System.out.println();
    }




    public static void main(String[] args) {
        AdjacencyMatrixGraph a = new AdjacencyMatrixGraph(11);
        a.addNodes("a");
        a.addNodes("b");
        a.addNodes("c");
        a.addNodes("d");
        a.addNodes("e");
        a.addNodes("f");
        a.addNodes("g");
        a.addNodes("h");
        a.addNodes("i");
        a.addNodes("x");
        a.addNodes("y");

        a.addEdge("a", "b");
        a.addEdge("a", "e");
        a.addEdge("a", "c");
        a.addEdge("a", "d");
        a.addEdge("b", "f");
        a.addEdge("f", "h");
        a.addEdge("d", "g");
        a.addEdge("g", "i");
        a.addEdge("c", "x");
        a.addEdge("x", "y");
        a.addEdge("e", "i");
        a.addEdge("c", "f");
        a.addEdge("x", "i");
        a.DFS();
        a.BFS();
        System.out.println(a);
    }
}

//结点
class Node{
    private String name;

    private boolean visited;//遍历时候检查该结点是否已经遍历

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node(String name) {
        this.name = name;
        this.visited = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
