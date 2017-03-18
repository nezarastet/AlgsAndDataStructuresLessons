import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    private static long getFibonacciSumFast(long n) {
        if (n <= 1)
            return n;
        long period = getPeriodFibModuloM (10); // calculate period for deviding by 10
        if (n < period){
            return (getFibonacciSumNaive(n));
        }
        else{
            long periodsCount = n/period;
            long addCount = n % period;
            return (periodsCount * getFibonacciSumNaive(period) + getFibonacciSumNaive(addCount));
        }


    }

    private static long getPeriodFibModuloM (long m){
        long previous = 0;
        long current  = 1;
        long period = 0;

        while (true) {
            period++;

            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;

            if (current == 1 && previous == 0) break;
        }
        return period;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
//        long s = getFibonacciSumNaive(n);
          long s = getFibonacciSumFast(n);
        System.out.println(s);
    }
}

