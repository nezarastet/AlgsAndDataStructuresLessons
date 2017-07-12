import java.util.*;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        ArrayDeque<Integer> Q  = new ArrayDeque<Integer>();
        int[] dist = new int[adj.length];
        for (int i = 0; i < adj.length; i++) dist[i] = 100001;
        dist[s] = 0;
        Q.addLast(s);
        while (!Q.isEmpty()){
            int u = Q.pop();
            for (int i = 0; i < adj[u].size(); i++){
                if(dist[adj[u].get(i)] == 100001){
                    Q.addLast(adj[u].get(i));
                    dist[adj[u].get(i)] =  dist[u]+1;
                }
            }
        }
        if (dist[t] == 100001) return -1;
        else return dist[t];
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
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

