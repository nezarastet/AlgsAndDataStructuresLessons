import java.util.*;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
        int n = adj.length;
        int[] colour = new int[n];
        //1 - black, 2 - white, 0 - not colored
        for (int i = 0; i < n; i++){
            if (colour[i]==0)  colour = BFS(adj, colour, i);
        }
        for (int i = 0;  i < n; i++){
            if (colour[i] == 42) return 0;
        }
        return 1;
    }

    private static int[] BFS(ArrayList<Integer>[] adj, int[] colour, int s) {
        ArrayDeque<Integer> Q  = new ArrayDeque<Integer>();
        colour[s] = 1;
        Q.addLast(s);
        while (!Q.isEmpty()){
            int u = Q.pop();
            for (int i = 0; i < adj[u].size(); i++){
                if(colour[adj[u].get(i)] == 0){
                    Q.addLast(adj[u].get(i));
                    if (colour[u] == 1) colour[adj[u].get(i)] = 2;
                    else colour[adj[u].get(i)] = 1;
                }
                else if (colour[adj[u].get(i)] == colour[u]) colour[u] = 42;
            }
        }
        return colour;
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
        System.out.println(bipartite(adj));
    }
}

