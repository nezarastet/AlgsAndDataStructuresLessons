import java.util.ArrayList;
import java.util.Scanner;

public class NegativeCycle {
    private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {

        int[] dist = new int[adj.length];
        int[] prev = new int[adj.length];
        for (int i = 0; i < adj.length; i++){
            dist[i] = 1000000001;
            prev[i] = -1;
        }
        dist[0] = 0;
        int anw = 0;
        for (int j = 0; j <= adj.length; j++) {
            for (int idx = 0; idx < adj.length; idx++) {
                for (int i = 0; i < adj[idx].size(); i++) {
                    int v = adj[idx].get(i);
                    if (dist[v] > (dist[idx] + cost[idx].get(i))) {
                        dist[v] = dist[idx] + cost[idx].get(i);
                        prev[v] = idx;
                        if (j == adj.length) anw = 1;
                    }
                }
            }
        }

        return anw;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        System.out.println(negativeCycle(adj, cost));
    }
}

