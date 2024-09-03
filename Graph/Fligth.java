import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Fligth {
    // Class for the Graph
    static class Edge {
        int src;
        int dst;
        int cost;
        public Edge(int src , int dst , int cost){
            this.cost =cost;
            this.src =src;
            this.dst =dst;
        }
    }

    //Creating Graph
    public static void Creategraph(int flights[][], ArrayList<Edge> graph[]){
        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < flights.length ; i++){
            int src = flights[i][0];
            int dst = flights[i][1];
            int cost = flights[i][2];

            Edge e = new Edge(src, dst, cost);
            
            graph[src].add(e);
        }
    }

    static class Info {
        int v; 
        int cost;
        int stops;

        public Info(int v , int cost , int stops){
            this.v = v;
            this.cost =cost;
            this.stops = stops;
        }
        
    }


    //Chepest Flight
    public static int cheapestFlights( int flights[][] , int src ,int dst ,int k ,int n){
        ArrayList<Edge> graph[] = new ArrayList[n];
        Creategraph(flights, graph);
        
        int dist[] = new int[n];

        for(int i = 0 ; i < n ; i ++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();

        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.stops > k){
                break;
            }
            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int v =e.dst;
                int cost =e.cost;
                // if(dist[u] != Integer.MAX_VALUE && dist[u] + cost < dist[v] && curr.stops <= k){
                //     dist[v] = dist[u] + cost;
                //     q.add(new Info(v, dist[v], curr.stops+1));
                // }
                if( curr.cost + cost < dist[v] && curr.stops <= k){
                    dist[v] = curr.cost + cost;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }

        }

        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[dst];
    }


    public static void main(String[] args) {
        int n =4;
        int flights[][] = {{0,1,100} , {1,2,100} , {2,0,100} , {1,3,600} , {2,3,200}};
        int src = 0 , dst = 3 , k =1 ;
        System.out.println(cheapestFlights(flights, src, dst, k , n));
    }
}
