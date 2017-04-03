import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
      //write your code here
        int[] m ={l, l};
        int x = a[l];

        for (int i = l + 1; i <= r; i++) {
            if (a[i] < x) {
                m[0]++;
                m[1]++;
                swap(a, i ,m[0]);
            }
            if(a[i] == x){
                m[1]++;
                swap(a,i,m[1]);
            }
        }
        swap(a, l ,m[0]);
        return m;
    }

    private static int[] swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
        return a;
    }


    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                swap(a, i ,j);
            }
        }
        swap(a, l ,j);
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r, int partNum) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        swap(a, l , k);

        if(partNum == 2) {
            //partition2
            int m = partition2(a, l, r);
            randomizedQuickSort(a, l, m - 1, 2);
            randomizedQuickSort(a, m + 1, r, 2);
        }
        else
        {
            //partition3
            int[] m = partition3(a, l, r);
            randomizedQuickSort(a, l, m[0] - 1, 3);
            randomizedQuickSort(a, m[1] + 1, r, 3);
        }
    }

    public static void main(String[] args) {
/*        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1, 3);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
       }
*/
        stresstest(100);
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

    static void stresstest(int maxIter){
        int i = 0;
        Random rand = new Random(1987);  // init from the same start value gives always the same sequence of rand numbers
        while ( i < maxIter){
            i++;
            int n  = rand.nextInt(10) + 2;  // получим от 2х до 11ти
            System.out.printf( n + "\n");
            int[] numbers = new int[n];
            for (int j = 0; j < n; j++){
                numbers[j]=rand.nextInt(10);
                System.out.printf(numbers[j] + " ");
            }
            System.out.printf("\n");
            int[] numbers_copy = numbers;
            randomizedQuickSort(numbers, 0, n - 1, 2);
            int[] res1 = numbers;
            randomizedQuickSort(numbers_copy, 0, n - 1, 3);
            int[] res2 = numbers_copy;


            boolean badAns = false;
            for(int j =0; j<numbers.length;j++){
                if(res1[j]!=res2[j]) badAns = true;
            }
            if (badAns){
                System.out.printf("Wrong answer:" + res1 + " " + res2 + "\n");
                break;
            }
            else{
                System.out.println("OK");
            }


        }

    }


}

