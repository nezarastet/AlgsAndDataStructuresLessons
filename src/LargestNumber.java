import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
 //       for (int i = 0; i < a.length; i++) {
 //           result += a[i];
 //       }


        while (a.length>0){
            int maxDigit = Integer.parseInt(a[0]);
            int idx_maxDigit=0;
            int curDigit = 0;

            for(int i=0;i<a.length;i++){
                curDigit = Integer.parseInt(a[i]);
                if(IsGreaterOrEqual(curDigit, maxDigit)){
                    maxDigit = curDigit;
                    idx_maxDigit = i;
                }
            }
            result = result + a[idx_maxDigit];

            String [] a_new = new String[a.length-1];
            System.arraycopy(a,0,a_new,0,idx_maxDigit);
            System.arraycopy(a,idx_maxDigit+1,a_new,idx_maxDigit,a.length-idx_maxDigit-1);
            a = a_new;
        }

        return result;
    }


    private static boolean IsGreaterOrEqual (int digit1, int digit2){
        // return true when digit1 should place first then digit2
        String dig1dig2 = "";
        dig1dig2 = dig1dig2 + digit1 + digit2;

        String dig2dig1 = "";
        dig2dig1 = dig2dig1 + digit2 + digit1;

        int d1d2 = Integer.parseInt(dig1dig2);
        int d2d1 = Integer.parseInt(dig2dig1);

        if(d1d2 >= d2d1) return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

