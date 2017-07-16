import java.util.*;

public class Dijkstra {
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        int[] dist = new int[adj.length];
        int[] prev = new int[adj.length];
        boolean[] visited = new boolean[adj.length];

        for (int i = 0; i < adj.length; i++){
            dist[i] = 1000000001;
            prev[i] = -1;
            visited[i] = false;
        }
        dist[s] = 0;
        while (true){
            int minVal = 1000000001;
            int minValIdx = -1;
            for (int i = 0; i < adj.length; i++){
                if (dist[i] < minVal && !visited[i]){
                    minVal = dist[i];
                    minValIdx = i;
                }
            }

            if (minValIdx != -1){
                visited[minValIdx] = true;
                for (int i = 0; i < adj[minValIdx].size(); i++){
                    int v = adj[minValIdx].get(i);
                    if(dist[v] > (dist[minValIdx] + cost[minValIdx].get(i))){
                        dist[v] = dist[minValIdx] + cost[minValIdx].get(i);
                        prev[v] = minValIdx;
                    }
                }
            }
            else break;
        }
        if(dist[t] == 1000000001) return -1;
        else return dist[t];
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

