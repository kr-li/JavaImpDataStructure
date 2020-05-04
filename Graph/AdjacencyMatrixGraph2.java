package Graph;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//邻接矩阵实现有向带权重图,及bfs，dfs，prim算法、kruskal算法、dijkstra算法、floyd算法
public class AdjacencyMatrixGraph2 {
    private ArrayList<Node> nodeArrayList;//存放结点数组

    private int nodeNumbers;//结点数量

    public boolean[] visited;//遍历的时候检查该结点是否已经遍历；

    private int[][] edgeMatrix;//存放边的邻接矩阵

    static final int EDGE_NONE = 65535;//边不存在

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

    public AdjacencyMatrixGraph2(int numbers) {
        this.setNodeNumbers(numbers);
        this.setNodeArrayList(new ArrayList<Node>(numbers));
        this.visited = new boolean[numbers];
        this.setEdgeMatrix(new int[numbers][numbers]);
        this.queue = new LinkedList<Node>();
        for (int i = 0; i < edgeMatrix.length; i++) {
            for (int j = 0; j < edgeMatrix.length; j++) {
                edgeMatrix[i][j] = AdjacencyMatrixGraph2.EDGE_NONE;
            }
        }
    }
    //打印邻接矩阵和结点列表
    @Override
    public String toString() {
        System.out.println("结点列表：" + this.nodeArrayList);
        System.out.println("邻接矩阵：");
        System.out.print("   ");
        for (int i = 0; i < nodeArrayList.size(); i++) {
            System.out.printf( "%12s  " , nodeArrayList.get(i));
        }
        System.out.println();
        for (int i = 0; i < getNodeNumbers(); i++) {
            System.out.print(nodeArrayList.get(i) + "  ");
            for (int j = 0; j < getNodeNumbers(); j++) {
                System.out.printf( "%12d " , this.edgeMatrix[i][j]);
            }
            System.out.println();
        }
        return "";
    }

    //添加顶点
    public boolean addNode(String name){
        if (this.nodeArrayList.contains(new Node(name))) return false;
        else {
            nodeArrayList.add(new Node(name));
            return true;
        }
    }

    //添加边
    public void addEdge(String from, String to, int weight){
        if (nodeArrayList.contains(new Node(from)) && nodeArrayList.contains(new Node(to))){
            this.edgeMatrix[nodeArrayList.indexOf(new Node(from))][nodeArrayList.indexOf(new Node(to))]
                    = weight;
            this.edgeMatrix[nodeArrayList.indexOf(new Node(to))][nodeArrayList.indexOf(new Node(from))]
                    = weight;
        }
        else {
            System.out.println("请先添加结点，再添加边");
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
            if (this.edgeMatrix[i][j] != AdjacencyMatrixGraph2.EDGE_NONE && !this.visited[j]){
                depthFirstSearch(j);
            }
        }
    }

    //bfs遍历图
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
                if (this.edgeMatrix[i][j] != AdjacencyMatrixGraph2.EDGE_NONE && !visited[j]){
                    queue.add(this.nodeArrayList.get(j));
                    visited[j] = true;
                }
            }
            Node a = queue.poll();
            System.out.print("顶点" + a + "-->");
        }
        System.out.println();
    }

    //prim算法找最小生成树
    public void prim(){
        Arrays.fill(visited, false);
        visited[0] = true;
        int x = -1, y = -1;
        for (int i = 0; i < nodeNumbers - 1; i++) {
            int count = 65535;
            for (int j = 0; j < nodeArrayList.size(); j++) {
                for (int k = 0; k < nodeArrayList.size(); k++) {
                    if (visited[j] && !visited[k] && count > edgeMatrix[j][k]){
                        count = edgeMatrix[j][k];
                        x = j;
                        y = k;
                    }
                }
            }
            visited[y] = true;
            System.out.println(nodeArrayList.get(x) + "-->" + nodeArrayList.get(y) + ": " + edgeMatrix[x][y]);
        }
    }

    //kruskal算法找最小生成树
    public void kruskal(){
        Arrays.fill(visited, false);
        int x = -1, y = -1;
        for (int i = 0; i < nodeNumbers; i++) {
            int count = 65535;
            for (int j = 0; j < nodeArrayList.size(); j++) {
                for (int k = 0; k < nodeArrayList.size(); k++) {
                    if ((!visited[j] || !visited[k]) && count > edgeMatrix[j][k]){
                        count = edgeMatrix[j][k];
                        x = j;
                        y = k;
                    }
                }
            }
            visited[x] = true;
            visited[y] = true;
            System.out.println(nodeArrayList.get(x) + "-->" + nodeArrayList.get(y) + ": " + edgeMatrix[x][y]);
        }
    }

    //dijkstra算法
    public void dijkstra(String s){
        //确定s结点在结点数组里的位置
        int start = nodeArrayList.indexOf(new Node(s));
        //判断是否遍历过的点数组
        Arrays.fill(visited, false);

        //s点到其他点距离数组
        int[] dis = new int[nodeNumbers];
        //初始距离都是∞
        Arrays.fill(dis, AdjacencyMatrixGraph2.EDGE_NONE);
        //s结点到自己的距离为0
        dis[start] = 0;

        //循环结点数量次才能不断更新
        for (int i = 0; i < nodeNumbers; i++) {
            int minIndex = -1;
            //找到没遍历过的点距离s的最小距离的索引
            for (int v = 0; v < dis.length; v++) {
                if (!visited[v] && dis[v] < AdjacencyMatrixGraph2.EDGE_NONE){
                    minIndex = v;
                    break;
                }
            }

            //在邻接矩阵中找到更小的距离，去更新距离数组dis
            for (int j = 0; j < nodeArrayList.size(); j++) {
                for (int k = 0; k < nodeArrayList.size(); k++) {
                    if (!visited[k] && dis[j] + edgeMatrix[j][k] <= dis[k]){
                        dis[k] = dis[j] + edgeMatrix[j][k];//如果s点到j点再到k点的距离比s点直接到k点距离短，那么更新s点到k点的距离为更短的那个
                    }
                }
            }
            //此时距离s最小的点算是被遍历过，为true
            visited[minIndex] = true;
        }

        //打印
        for (int i = 0; i < dis.length; i++) {
            System.out.println("结点" + nodeArrayList.get(start) + "到结点" + nodeArrayList.get(i) + "的最短路径距离为" + dis[i]);
        }
    }

    //floyd算法
    public void floyd() {
        int[][] distance = new int[nodeArrayList.size()][nodeArrayList.size()];

        // 初始化距离矩阵
        for (int i = 0; i < nodeArrayList.size(); i++) {
            for (int j = 0; j < nodeArrayList.size(); j++) {
                distance[i][j] = edgeMatrix[i][j];
            }
        }

        //循环更新矩阵的值
        for (int k = 0; k < nodeArrayList.size(); k++) {
            for (int i = 0; i < nodeArrayList.size(); i++) {
                for (int j = 0; j < nodeArrayList.size(); j++) {
                    int temp = (distance[i][k] == AdjacencyMatrixGraph2.EDGE_NONE ||
                            distance[k][j] == AdjacencyMatrixGraph2.EDGE_NONE) ?
                            AdjacencyMatrixGraph2.EDGE_NONE : distance[i][k] + distance[k][j];
                    if (distance[i][j] > temp) {
                        distance[i][j] = temp;
                    }
                }
            }
        }
        //打印
        System.out.print("floyd: \n");
        for (int i = 0; i < nodeArrayList.size(); i++) {
            for (int j = 0; j < nodeArrayList.size(); j++) {
                System.out.printf("%12d  ", distance[i][j]);
            }
            System.out.print("\n");
        }
    }



    public static void main(String[] args) {
        AdjacencyMatrixGraph2 a = new AdjacencyMatrixGraph2(9);

        //测试 添加结点
        a.addNode("v0");
        a.addNode("v1");
        a.addNode("v2");
        a.addNode("v3");
        a.addNode("v4");
        a.addNode("v5");
        a.addNode("v6");
        a.addNode("v7");
        a.addNode("v8");

        //添加边
        a.addEdge("v0", "v1", 1);
        a.addEdge("v0", "v2", 5);
        a.addEdge("v1", "v2", 3);
        a.addEdge("v1", "v3", 7);
        a.addEdge("v1", "v4", 5);
        a.addEdge("v2", "v4", 1);
        a.addEdge("v2", "v5", 7);
        a.addEdge("v3", "v4", 2);
        a.addEdge("v3", "v6", 3);
        a.addEdge("v4", "v5", 3);
        a.addEdge("v4", "v6", 6);
        a.addEdge("v4", "v7", 9);
        a.addEdge("v5", "v7", 10);
        a.addEdge("v6", "v7", 2);
        a.addEdge("v6", "v8", 7);
        a.addEdge("v7", "v8", 4);
        //算法
        a.dijkstra("v4");
        a.floyd();
        System.out.println(a);

    }
}
