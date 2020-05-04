package Graph;

import java.util.ArrayList;

public class AdjacnecyListGraph {
    ArrayList<Vertex> vertexArrayList;

    public AdjacnecyListGraph() {
        vertexArrayList = new ArrayList<>();
    }

    //结点之间添加边
    public boolean addEdge(String from, String to){
        Vertex fromV = null;
        Vertex toV = null;
        for (Vertex item: vertexArrayList) {
            //如果from结点存在
            if (item.vertexName.equals(from)){
                fromV = item;
            }
            //如果to结点存在
            else if (item.vertexName.equals(to)){
                toV = item;
            }
            if (fromV != null && toV != null) break;
        }
        //如果from结点不存在
        if (fromV == null){
            fromV = new Vertex(from);
            vertexArrayList.add(fromV);
        }
        //to结点不存在
        if (toV == null){
            toV = new Vertex(to);
            vertexArrayList.add(toV);
        }
        return fromV.addAdjacencyVertex(toV);
    }

    //结点之间删除边
    public boolean removeEdge(String from, String to) {
        Vertex fromV = null, toV = null;
        for (Vertex v : vertexArrayList) {
            if (v.vertexName.equals(from)) {
                fromV = v;
                break;
            }
        }
        for (Vertex v : vertexArrayList) {
            if (v.vertexName.equals(to)){
                toV = v;
                break;
            }
        }
        if (fromV == null) return false;
        if (toV == null) return false;
        return fromV.removeAdjacentVertex(toV);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex v : vertexArrayList) {
            sb.append("Vertex: ");
            sb.append(v.vertexName);
            sb.append("\n");
            sb.append("Adjacent verticies: ");
            for (Vertex v2 : v.adjacnecyVertices) {
                sb.append(v2.vertexName);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        AdjacnecyListGraph g = new AdjacnecyListGraph();
        g.addEdge("结点1", "结点2");
        g.addEdge("结点3", "结点4");
        g.addEdge("结点1" , "结点5");
        g.addEdge("结点1", "结点3");
        g.addEdge("结点2", "结点3");
        g.removeEdge("结点2", "结点3");
        System.out.println(g.toString());
    }
}


//结点类
class Vertex{
    //结点名
    String vertexName;

    ArrayList<Vertex> adjacnecyVertices;

    public Vertex(String vertexName) {
        adjacnecyVertices = new ArrayList<>();
        this.vertexName = vertexName;
    }

    public boolean addAdjacencyVertex(Vertex to){
        for (Vertex item: adjacnecyVertices) {
            if (item.vertexName.compareTo(to.vertexName) == 0){
                return false;
            }
        }
        return adjacnecyVertices.add(to);
    }

    public boolean removeAdjacentVertex(Vertex to) {
        // use indexes here so it is possible to
        // remove easily without implementing
        // equals method that ArrayList.remove(Object o) uses
        for (int i = 0; i < adjacnecyVertices.size(); i++) {
            if (adjacnecyVertices.get(i).vertexName.compareTo(to.vertexName) == 0) {
                adjacnecyVertices.remove(i);
                return true;
            }
        }
        return false;
    }


}