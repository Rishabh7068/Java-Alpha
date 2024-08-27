import java.util.*;

public class BellmanFord {
    static class Edge {
        int src;
        int des;
        int wt;
        public Edge(int src, int des , int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }
    static void creategraph( ArrayList<Edge> edge) {
       
        edge.add(new Edge(0,1,2));
        edge.add(new Edge(0,2,4));
        edge.add(new Edge(1,2,-4));
        edge.add(new Edge(2,3,2));
        edge.add(new Edge(3,4,4));
        edge.add(new Edge(4,1,-1));
    }
    
    public static void bellmanFord( ArrayList<Edge> graph ,int src , int V){
        int dist[] = new int[V];
        for(int i = 0; i < dist.length ; i++){
            if( i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 0 ; i < V-1 ; i++){
            // edges - O(E)
                for(int j = 0 ; j < graph.size() ; j++){
                    Edge e = graph.get(j);
                    int u = e.src;
                    int v = e.des;
                    int wt = e.wt;
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v] = dist[u] +wt;
                    }
                }
            
        }
        for (int i : dist) {
            System.out.print(i +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> edge = new ArrayList<>();
        creategraph(edge);
        int src = 0;
        bellmanFord(edge, src , V);
        return;
    }
}
