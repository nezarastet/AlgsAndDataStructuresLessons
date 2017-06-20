import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Toposort {

    private boolean[] sink;

    private  ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        sink = new boolean[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();

        for (int i = 0; i < adj.length; i++){
            if (sink[i]) continue;
            order = dfs(i, adj, sink, order);
        }

        return order;
    }

    private  ArrayList<Integer> dfs(int currentVertex, ArrayList<Integer>[] adj, boolean[] sink, ArrayList<Integer> order) {

        for (int i = 0; i < adj[currentVertex].size(); i++) {
            if (sink[adj[currentVertex].get(i)]) continue;
            order = dfs(adj[currentVertex].get(i), adj, sink, order);
        }
        sink[currentVertex] = true;
        order.add(currentVertex);
        adj[currentVertex].clear();

       return order;
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
        ArrayList<Integer> order = new Toposort().toposort(adj);
        for (int i = order.size()-1; i >= 0; i--) {
            int x = order.get(i);
            System.out.print((x + 1) + " ");
        }
    }
}

