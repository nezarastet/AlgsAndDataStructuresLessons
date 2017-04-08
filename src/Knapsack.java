import java.util.*;

public class Knapsack {

    private static List<Integer> hashW = new ArrayList<Integer>();

    static private int optimalWeight(int W, int[] w) {
        //write you code here
        if(hashW.get(W) != -1) return hashW.get(W);

        if (w.length == 1){
            if(w[0] <= W) return w[0];
            else return 0;
        }
        else {
            int[] w_without_last = new int[w.length-1];
            System.arraycopy(w, 0, w_without_last, 0, w.length-1);
            if (w[w.length-1] <= W){
                int whenUse_w_end = optimalWeight(W-w[w.length-1], w_without_last)+w[w.length-1];
                int whenDontUse_w_end = optimalWeight(W, w_without_last);

                hashW.set(W, Math.max(whenUse_w_end, whenDontUse_w_end));
                return hashW.get(W);
            }
            else
            {
                hashW.set(W, optimalWeight(W, w_without_last));
                return hashW.get(W);
            }


        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        for (int i = 0; i <= W;i++) hashW.add(-1);

        System.out.println(optimalWeight(W, w));
    }


}

