import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {

    private static int acyclic(ArrayList<Integer>[] adj) {
        boolean pizdets = false;

        for (int i = 0; i < adj.length; i++)
        {
            pizdets =   DFS(i, i, adj, pizdets);
            if (pizdets) return 1;
        }
        return 0;
    }

    public static boolean DFS(int startVertex, int vertex, ArrayList<Integer>[] adj, boolean pizdets){

        for (int i = 0; i < adj[vertex].size(); i++){
            if (adj[vertex].get(i) == startVertex){
                pizdets = true;
                continue;
            }
            pizdets =  DFS(startVertex, adj[vertex].get(i),adj, pizdets);
        }
        for (int i = 0; i < adj[vertex].size(); i++)  adj[vertex].remove(i);

        return pizdets;
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

