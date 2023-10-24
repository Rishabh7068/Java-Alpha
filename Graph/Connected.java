import java.util.*;

public class Connected{
     static class Edge {
        int src;
        int des;
        int wet;

        public Edge(int src, int des, int wet) {
            this.src = src;
            this.des = des;
            this.wet = wet;
        }
    }

    static void creategraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));
        graph[7].add(new Edge(7, 8, 1));
        graph[7].add(new Edge(8, 7, 1));
    }

    public static void dfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length ;i++){
            if(!vis[i]){
                dfsutil(graph,i,vis);
            }
        }
    }

    public static void dfsutil(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.des]) {
                dfsutil(graph, e.des, vis);
            }
        }
    }

    
    
    public static void main(String[] args) {
        int vertice = 9;
        ArrayList<Edge>[] graph = new ArrayList[vertice];
        creategraph(graph);
        dfs(graph);
    }
}
