import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return a[left];
        }

        int mid = left + (right-left)/2;
        int leftMajority = getMajorityElement(a,left, mid);
        int rightMajority = getMajorityElement(a,mid+1, right);

        if (leftMajority == -1 && rightMajority == -1) return -1;
        else {
            int countLeftMajority = 0;
            int countRightMajority = 0;
            for (int  i = left; i<=right; i++){
                if(a[i] == leftMajority) countLeftMajority++;
                if(a[i] == rightMajority) countRightMajority++;
            }

            if(countLeftMajority > (right-left +1)/2) return leftMajority;
            if(countRightMajority > (right-left +1)/2) return rightMajority;

        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length-1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
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

