import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {

    static long getMaxPairwiseProduct(long[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (numbers[i] * numbers[j] > result) {
                    result = numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }

    static long getMaxPairwiseProductFast(long[] numbers) {
        long result = 0;
        int n = numbers.length;

        int idxMAxValue=0;
        long maxVal1=-1;
        long maxVal2=-1;

// find max value in numbers
        for (int i = 0; i < n; ++i) {
            if(numbers[i]>maxVal1){
                maxVal1 = numbers[i];
                idxMAxValue=i;
            }

        }

// find max value  in nubmers exept maxVal1
        for (int i = 0; i < n; ++i) {
            if(numbers[i]>maxVal2 && i!=idxMAxValue){
                maxVal2 = numbers[i];
            }

        }

        result=maxVal1*maxVal2;

        return result;
    }

    static void stresstest(int maxIter){
        int i = 0;
        Random rand = new Random(1987);  // init from the same start value gives always the same sequence of rand numbers
        while ( i < maxIter){
                i++;
                int n  = rand.nextInt(10) + 2;  // получим от 2х до 11ти
                System.out.printf( n + "\n");
                long[] numbers = new long[n];
                for (int j = 0; j < n; j++){
                    numbers[j]=rand.nextInt(10);
                    System.out.printf(numbers[j] + " ");
                }
                System.out.printf("\n");
                long res1 = getMaxPairwiseProduct(numbers);
                long res2 = getMaxPairwiseProductFast(numbers);

                if (res1 != res2){
                    System.out.printf("Wrong answer:" + res1 + " " + res2 + "\n");
                    break;
                }
                else{
                    System.out.println("OK");
                }


            }

    }



    public static void main(String[] args) {
// for stress test implementation
        //stresstest(10000);
        //System.out.println("stress test end");

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
//for testing
        //numbers = new long[200000];
        //System.out.println(getMaxPairwiseProduct(numbers) + "\n");
        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}