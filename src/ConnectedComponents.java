import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {

    private static int numberOfComponents(ArrayList<Integer>[] adj, boolean[] visited) {
        int result = 0;
        for (int i = 0; i < adj.length; i++){
            if (visited[i] == false){
                result++;
                explore(i, adj, visited);
            }
        }
        return result;
    }

    private static void explore (int x, ArrayList<Integer>[] adj, boolean[] visited) {
        visited[x] = true;
        for (int i = 0; i < adj[x].size(); i++) {
            int w = adj[x].get(i);
            if (!visited[w]) explore(w, adj, visited);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            visited[i] = false;
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj, visited));
    }
}

