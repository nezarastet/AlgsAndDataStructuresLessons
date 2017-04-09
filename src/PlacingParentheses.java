import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      //write your code here
        int n = (exp.length()+1)/2;
        long[][] m = new long[n][n];
        long[][] M = new long[n][n];

        int[] d = new int[n];

        for (int i = 0; i < n; i++){
            d[i] = Character.getNumericValue(exp.charAt(2*i));
        }
        for (int i = 0; i < n; i++){
            M[i][i] = d[i];
            m[i][i] = d[i];
        }

        for (int s = 1; s < n; s++){
            for (int i = 0; i < (n-s); i++){
                int j = i+s;
                long[] anw = MinMax(i, j, exp, m, M);
                m[i][j] = anw[0];
                M[i][j] = anw[1];
            }

        }

      return M[0][n-1];
    }

    private static long[] MinMax(int i, int j, String exp, long[][]m, long[][]M){
        long min = 9223372036854775807L;
        long max = -9223372036854775808L;
        long a;
        long b;
        long c;
        long d;

        for(int k = i; k<j;k++){
            a = eval(M[i][k], M[k+1][j], exp.charAt(2*k+1));
            b = eval(M[i][k], m[k+1][j], exp.charAt(2*k+1));
            c = eval(m[i][k], M[k+1][j], exp.charAt(2*k+1));
            d = eval(m[i][k], m[k+1][j], exp.charAt(2*k+1));

            min = Math.min(min, a);
            min = Math.min(min, b);
            min = Math.min(min, c);
            min = Math.min(min, d);

            max =  Math.max(max, a);
            max = Math.max(max, b);
            max = Math.max(max, c);
            max = Math.max(max, d);
        }


        long[] MinMax = new long[2];
        MinMax[0] = min;
        MinMax[1] = max;
        return MinMax;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

