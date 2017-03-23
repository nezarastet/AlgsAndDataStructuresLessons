import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        //write your code here
        long result = 0;
//        for (int i = 0; i < a.length; i++) {
//            result += a[i] * b[i];
 //       }
        result = calcMaxDotProduct(a, b, result);


        return result;
    }

    public static long calcMaxDotProduct(int[] a, int[] b, long result){
        if (a.length == 0) return result;

        int max_a = -1000000;
        int max_b = -1000000;
        int idx_max_a = -1;
        int idx_max_b = -1;

        for (int i = 0; i < a.length; i++){
            if (a[i] > max_a){
                max_a = a[i];
                idx_max_a = i;
            }
            if (b[i] > max_b){
                max_b = b[i];
                idx_max_b = i;
            }
        }
        result = result + (long)max_a*(long)max_b;
        int [] a_new = new int[a.length-1];
        int [] b_new = new int[b.length-1];

        for(int i=0; i < (a.length-1); i++){
            if (i < idx_max_a){
                a_new[i] = a[i];
            }
            else {
                a_new[i]=a[i+1];
            }
        }

        for(int i=0; i < (b.length-1); i++){
            if (i < idx_max_b){
                b_new[i] = b[i];
            }
            else {
                b_new[i]=b[i+1];
            }
        }

        result = calcMaxDotProduct(a_new, b_new, result);
        return result;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

