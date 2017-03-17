import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }

  private static int gcd_fast(int a, int b) {
    int MaxVal = Math.max(a,b);
    int MinVal = Math.min(a, b);

    if(MaxVal % MinVal ==0){
      return MinVal;
    }
    else{
      MaxVal = MaxVal % MinVal;
      return gcd_fast( MaxVal  ,MinVal);
    }

  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

//    System.out.println(gcd_naive(a, b));
      System.out.println(gcd_fast(a, b));
  }
}
