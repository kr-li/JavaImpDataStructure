package Graph;

//邻接矩阵实现有向带权重图
public class AdjacencyMatrixGraph2 {

    private int verticesNumber; //结点数量

    private int edgesNumber; //边数量

    private int[][] adjacency; //邻接矩阵

    static final int EDGE_NONE = 0;

    //set和get方法
    public int getVerticesNumber() {
        return verticesNumber;
    }

    public void setVerticesNumber(int verticesNumber) {
        this.verticesNumber = verticesNumber;
    }

    public int getEdgesNumber() {
        return edgesNumber;
    }

    public void setEdgesNumber(int edgesNumber) {
        this.edgesNumber = edgesNumber;
    }

    public int[][] getAdjacency() {
        return adjacency;
    }

    public void setAdjacency(int[][] adjacency) {
        this.adjacency = adjacency;
    }

    //构造方法,全是0的邻接矩阵
    public AdjacencyMatrixGraph2(int giveVerticesNumber) {
        this.setVerticesNumber(giveVerticesNumber);
        this.setEdgesNumber(0);
        this.setAdjacency(new int[giveVerticesNumber][giveVerticesNumber]);
        for (int i = 0; i < giveVerticesNumber; i++) {
            for (int j = 0; j < giveVerticesNumber; j++) {
                this.adjacency[i][j] = AdjacencyMatrixGraph2.EDGE_NONE;
            }
        }
    }

    //判断结点是否存在
    public boolean verticesExist(int num){
        if (num >= 0 && num < getVerticesNumber()) return true;
        return false;
    }

    //判断边是否存在
    public boolean edgeExist(int from, int to){
        if (verticesExist(from) && verticesExist(to)){
            return this.adjacency[from][to] != AdjacencyMatrixGraph.EDGE_NONE;
        }
        return false;
    }

    //在from和to两个结点间添加权重为weight的有向边
    public void addEdge(int from, int to, int weight){
        if (verticesExist(from) && verticesExist(to)){
            this.adjacency[from][to] = weight;
        }
    }

    //删除from和to结点间的边
    public void deleteEdge(int from, int to){
        if (verticesExist(from) && verticesExist(to)){
            if (this.adjacency[from][to] != 0){
                this.adjacency[from][to] = AdjacencyMatrixGraph.EDGE_NONE;
            }
        }
    }

    //重写toString，打印矩阵
    @Override
    public String toString() {
        for (int i = 0; i < this.adjacency.length; i++) {
            for (int j = 0; j < this.adjacency[i].length; j++) {
                System.out.print("结点" + this.adjacency[i][j] + " ");
            }
            System.out.println();
        }
        return "AdjacencyMatrixGraph{}";
    }

    public static void main(String[] args) {
        AdjacencyMatrixGraph2 adjacencyMatrixGraph = new AdjacencyMatrixGraph2(3);
        adjacencyMatrixGraph.addEdge(0,2,20);
        adjacencyMatrixGraph.deleteEdge(0,2);
        adjacencyMatrixGraph.addEdge(0,1,12);
        adjacencyMatrixGraph.addEdge(1,2, 17);
        adjacencyMatrixGraph.addEdge(2,1,10);
        adjacencyMatrixGraph.toString();
    }

}
