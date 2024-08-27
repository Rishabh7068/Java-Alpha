import java.util.ArrayList;
import java.util.Stack;

public class Topology {
    static class Edge {
        int src;
        int des;
        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }
    static void creategraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
    public static void topsort(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
    public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.des]) {
                topSortUtil(graph, e.des, vis, s);
            }
        }
        s.push(curr);
    }
    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        System.out.println("Hello Topo");
        creategraph(graph);
        topsort(graph);
        return;
    }
}
