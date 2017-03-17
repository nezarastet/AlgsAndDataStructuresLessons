import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    private static long getFibonacciHugeFast(long n, long m) {
// determine period pisano
        if(n == 1) return 1;

        long previous = 0;
        long current  = 1;
        long period = 1;

        for (long i = 2; i <= n; i++) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;

            if (current == 1 && previous == 0) break;
            else {
                period++;
            }

            if (i == n) return current;
        }

        n = n % period;
        if (n == 0) return 0;
        if (n == 1) return 1;

        previous = 0;
        current  = 1;
        for (long i = 2; i <= n; i++) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;
        }
        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
//        System.out.println(getFibonacciHugeNaive(n, m));
        System.out.println(getFibonacciHugeFast(n, m));
    }
}

