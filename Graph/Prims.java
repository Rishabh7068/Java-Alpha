import java.util.*;

public class Prims {

    static class Edge {
        int src;
        int des;
        int wt;

        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }

    static void creategraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair> {
        int v;
        int cost;
        int parent; // Added to track the parent vertex
        public Pair(int v, int cost, int parent) {
            this.v = v;
            this.cost = cost;
            this.parent = parent;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }
    public static void mst(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, -1)); // Start from vertex 0, no parent (-1)
        int finalcost = 0;
        ArrayList<Edge> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalcost += curr.cost;
                // Add the edge that brought us to this vertex to the ans list
                if (curr.parent != -1) { // Skip adding the first vertex's edge as it doesn't have a parent
                    ans.add(new Edge(curr.parent, curr.v, curr.cost));
                }

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    if (!vis[e.des]) {
                        pq.add(new Pair(e.des, e.wt, curr.v)); 
                    }
                }
            }
        }
        System.out.println("Final min cost " + finalcost);
        for (Edge edge : ans) {
            System.out.println(edge.src + " - " + edge.des + " with weight " + edge.wt);
        }
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        creategraph(graph);
        mst(graph);
    }
}
