import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj) {
        boolean hasLoop = false;
        int[] traceVertex = new int[adj.length];
        for (int i = 0; i < traceVertex.length; i++) traceVertex[i] = -1;
        for (int i = 0; i < adj.length; i++){
            hasLoop = DFS(i, i, adj, hasLoop, traceVertex);
            if (hasLoop) break;
        }
        if (hasLoop) return 1;
        else return 0;
    }

    private static boolean DFS(int startVertex, int currentVertex, ArrayList<Integer>[] adj, boolean hasLoop, int[] traceVertex){

        traceVertex[currentVertex] = startVertex;
        for (int i = 0; i < adj[currentVertex].size(); i++){
            if (traceVertex[adj[currentVertex].get(i)] == -5) continue; // next Vertex is a sink
            if (traceVertex[adj[currentVertex].get(i)] == startVertex){
                hasLoop = true;
                break;
            }
            else {
               hasLoop = DFS(startVertex, adj[currentVertex].get(i), adj, hasLoop, traceVertex);
            }
        }
        traceVertex[currentVertex] = -5; // this vertex is a sink now
        adj[currentVertex].clear();

        return hasLoop;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
    }
}

