import java.util.Random;
import java.util.Scanner;

public class PointsAndSegments {

    private static Random random = new Random();

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        //write your code here
        int[] startsInitIdx = new int[starts.length];
        int[] endsInitIdx = new int[ends.length];
        int[] pointsInitIdx = new int [points.length];

        for(int i = 0; i < starts.length; i++) startsInitIdx[i] = i;
        for(int i = 0; i < ends.length; i++) endsInitIdx[i] = i;
        for(int i = 0; i < points.length; i++) pointsInitIdx[i]=i;

        randomizedQuickSort(starts, 0, starts.length-1, startsInitIdx);
        randomizedQuickSort(ends, 0, ends.length-1, endsInitIdx);
        randomizedQuickSort(points, 0, points.length-1, pointsInitIdx);

        int starts_idx=0;
        int ends_idx=0;
        int points_idx=0;

        int start_cur = starts[0];
        int ends_cur = ends[0];
        int points_cur = points[0];
        int currentOpenSegments = 0;


        while (starts_idx < starts.length || ends_idx < ends.length || points_idx < points.length){

            if(starts_idx < starts.length) start_cur = starts[starts_idx];
            else start_cur = 1000000001;
            if(ends_idx < ends.length) ends_cur = ends[ends_idx];
            else ends_cur = 1000000001;
            if(points_idx < points.length) points_cur = points[points_idx];
            else points_cur = 1000000001;

            if(start_cur <= ends_cur && start_cur <= points_cur){
                starts_idx++;
                currentOpenSegments++;
            }
            else {
                if(points_cur <= start_cur && points_cur <= ends_cur){
                    cnt[points_idx] = currentOpenSegments;
                    points_idx++;
                }
                else{
                    if(ends_cur <= points_cur && ends_cur <= start_cur){
                        ends_idx++;
                        currentOpenSegments--;
                    }
                }
            }
        }

        int[] cntInitIdx = new int[cnt.length];
        for (int i = 0; i < cnt.length; i++)cntInitIdx[pointsInitIdx[i]]=cnt[i];

        return cntInitIdx;
    }

    private static void randomizedQuickSort(int[] a, int l, int r, int[] aInitIdx) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        swap(a, l , k);
        swap(aInitIdx, l ,k);

        //partition3
        int[] m = partition3(a, l, r, aInitIdx);
        randomizedQuickSort(a, l, m[0] - 1, aInitIdx);
        randomizedQuickSort(a, m[1] + 1, r, aInitIdx);

    }

    private static int[] partition3(int[] a, int l, int r, int[] aInitIdx) {
        //write your code here
        int[] m ={l, l};
        int x = a[l];

        for (int i = l + 1; i <= r; i++) {
            int a_i_copy=a[i];
            if (a_i_copy < x) {
                m[0]++;
                m[1]++;
                swap(a, i ,m[1]);
                swap(aInitIdx, i, m[1]);

                swap(a, m[0], m[1]);
                swap(aInitIdx, m[0], m[1]);
            }
            if(a_i_copy == x){
                m[1]++;
                swap(a, i, m[1]);
                swap(aInitIdx, i, m[1]);
            }
        }
        swap(a, l ,m[0]);
        swap(aInitIdx, l, m[0]);
        return m;
    }

    private static int[] swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
        return a;
    }



    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

