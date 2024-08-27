import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Biparthi {
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
        // graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 2, 1));
        // graph[4].add(new Edge(4, 3, 1));
    }

    public static boolean isBiparthi(ArrayList<Edge> graph[]) {
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                return bfs(graph, i, col);
            }
        }
        return true;
    }
    public static boolean bfs(ArrayList<Edge> graph[], int in, int col[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        col[0] = 0;// yellow
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i); // edes
                if (col[e.des] == -1) {
                    int nextcol = col[curr] == 0 ? 1 : 0;
                    col[e.des] = nextcol;
                    q.add(e.des);
                } else if (col[e.des] == col[curr]) {
                    return false;
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        int vertice = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertice];
        creategraph(graph);
        System.out.println(isBiparthi(graph));

    }
}
