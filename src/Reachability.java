import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y, boolean[] visited) {
        explore(x, visited, adj);
        if(visited[y]) return 1;
        else return 0;
    }

    private static void explore (int x, boolean[] visited, ArrayList<Integer>[] adj){
        visited[x] = true;
        for (int i = 0; i < adj[x].size(); i++){
            int w=adj[x].get(i);
            if(!visited[w]) explore(w, visited, adj);
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y, visited));
    }
}

