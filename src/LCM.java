import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static long lcm_fast(int a, int b) {
   long gcd = gcd_fast(a, b);
   return (long) a*b/gcd;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

//    System.out.println(lcm_naive(a, b));
    System.out.println(lcm_fast(a, b));
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

}
