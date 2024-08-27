import java.util.ArrayList;

public class Allpaths {
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
        graph[0].add(new Edge(0, 3));
    }


    public static void printAllpath(ArrayList<Edge> graph[] , int src , int des , String path){
        if(src == des){
            System.out.println(path+des);
            return;
        }
        for(int  i = 0 ; i < graph[src].size() ; i++){
            Edge e = graph[src].get(i);
            printAllpath(graph , e.des , des , path+src);
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        System.out.println("Hello Topo");
        creategraph(graph);
        int src = 5 , des =1 ;
        printAllpath(graph, src, des, "");
        
        return;
    }
}
