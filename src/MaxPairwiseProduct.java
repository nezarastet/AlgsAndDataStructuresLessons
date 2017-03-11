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



    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

//for testing        numbers = new long[200000];
//for testing        System.out.println(getMaxPairwiseProduct(numbers) + "\n");
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