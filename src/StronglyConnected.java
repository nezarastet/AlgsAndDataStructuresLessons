import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StronglyConnected {
    int compCount = 0;
    class order{
        int vertexIndex;
        int preOrder;
        int postOrder;
        boolean visited;

        public order(int vertexIndex) {
            this.vertexIndex = vertexIndex;
        }
    }

    ArrayList<order> dfsVertexOrder = new ArrayList<order>();
    int clock;


    private  int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
        int n = adj.length;
        for (int i = 0; i < n; i++){
            dfsVertexOrder.add(new order(i));
        }
        // do reverse graph
        ArrayList<Integer>[] adjRG = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjRG[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < adj[i].size(); j++){
                int cur = adj[i].get(j);
                adjRG[cur].add(i);
            }
        }
        // run dfs with pre-post order for RG
        for (int i = 0; i < n; i++){
            if (dfsVertexOrder.get(i).visited) continue;
            dfs(adjRG, i);
        }
        // sort dfsVertexOrder
        ArrayList<order> dfsVertexOrderSorted = new ArrayList<order>();
        dfsVertexOrderSorted = dfsVertexOrder;

        Collections.sort(dfsVertexOrderSorted, new Comparator<order>(){
            public int compare(order o1, order o2){
                return o2.postOrder - o1.postOrder;
            }
        });
        // calc number of components
        for (int i = 0; i < n; i++) dfsVertexOrder.get(i).visited = false;
        compCount = 0;

        for (int i = 0; i < n; i++){
            int j = dfsVertexOrderSorted.get(i).vertexIndex;
            if (dfsVertexOrder.get(j).visited) continue;
            compCount++;
            dfs(adj, j);
        }

        return compCount;
    }

    private void dfs (ArrayList<Integer>[]adj, int vertex){
        dfsVertexOrder.get(vertex).visited = true;
        dfsVertexOrder.get(vertex).preOrder = clock;
        clock++;
        for (int i = 0; i < adj[vertex].size(); i++){
            if (dfsVertexOrder.get(adj[vertex].get(i)).visited) continue;
            this.dfs(adj, adj[vertex].get(i));
        }
        dfsVertexOrder.get(vertex).postOrder = clock;
        clock++;
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
        System.out.println(new StronglyConnected().numberOfStronglyConnectedComponents(adj));
    }
}

