import java.util.Scanner;

public class ConnectingPoints {
    private static double minimumDistance(int[] x, int[] y) {
        double[] cost = new double[x.length];
        int[] parent = new int[x.length];
        boolean[] visited = new boolean[x.length];

        for (int i = 0; i < x.length; i++){
            cost[i] = 3000.0;
            parent[i] = -1;
            visited[i] = false;
        }
        cost[0] = 0.0;

        while (true){
            double minVal = 3000.0;
            int minValIdx = -1;
            for (int i = 0; i < x.length; i++){
                if (cost[i] < minVal && !visited[i]){
                    minVal = cost[i];
                    minValIdx = i;
                }
            }
            if (minValIdx == -1) break;
            else visited[minValIdx] = true;

            for (int j = 0; j < x.length; j++){
                if (j==minValIdx) continue;
                if (!visited[j]){
                    double w = Math.sqrt(Math.pow(x[minValIdx] - x[j],2) + Math.pow(y[minValIdx] - y[j],2));
                    if (cost[j] > w){
                        cost[j] = w;
                        parent[j] = minValIdx;
                    }
                }
            }
        }

        double result = 0.;
        for (int i = 0; i < x.length; i++) result += cost[i];
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        System.out.println(minimumDistance(x, y));
    }
}

