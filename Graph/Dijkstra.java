import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
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
    static void creategraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));
        
        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n , int path){
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path;
        }
    }

    public static void shortPath(ArrayList<Edge> graph[] , int src){
        int distance[] = new int[graph.length];

        for(int i = 0 ; i < graph.length ; i++){
            if(i != src ){
                distance[i] = Integer.MAX_VALUE;
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n] = true;
                for(int  i = 0 ; i < graph[curr.n].size() ; i++){
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.des;
                    int wt = e.wt;

                    if(distance[u] + wt < distance[v]){
                        distance[v] = distance[u] + wt;
                        pq.add(new Pair(v, distance[v]));
                    }
                }
            }
        }

        for (int i : distance) {
            System.out.println(i+" ");
        }

        System.out.println();

    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        System.out.println("Hello Topo");
        creategraph(graph);
        int src = 0;
        shortPath(graph, src);
        return;
    }
}
