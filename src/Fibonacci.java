import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  private static long calc_fibFast(int n, long[] M) {
    if (n <= 1)
    {
      M[n]=n;
      return n;
    }


    if (M[n]<0)
    {
      M[n]=calc_fibFast(n - 1, M) + calc_fibFast(n - 2, M);
      return M[n];
    }
    else
    {
      return M[n]; // calculated yet
    }
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long[] M = new long[n+1];
    for (int i=0; i<=n; i++)
    {
      M[i]=-1;
    }

//    System.out.println(calc_fib(n));
      System.out.println(calc_fibFast(n, M));
  }
}
