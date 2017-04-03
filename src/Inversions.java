import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a) {
        long numberOfInversions = 0;
        int[] aSorted = mergeSort(a);

        for (int j = 0; j < aSorted.length; j++) {
            System.out.print(aSorted[j] + " ");
        }
        System.out.println("\n");

        return numberOfInversions;
    }

    private static int[] mergeSort(int[] a){
        int left =0;
        int right = a.length-1;
        if(left>=right) return a;
        else {
            int mid = (right+left)/2;
            int[] aLeft = new int[mid+1];
            System.arraycopy(a, 0, aLeft, 0, mid+1);

            int[] aRight = new int[right-mid];
            System.arraycopy(a, mid+1, aRight, 0, right-mid);

            int[] aLeftSorted = mergeSort(aLeft);
            int[] aRightSorted = mergeSort(aRight);

            int[] aSorted = merge(aLeftSorted, aRightSorted);
            return aSorted;
        }
    }


    private static int[] merge(int[] aLeft, int[] aRight){
        int[] aMerged = new int[aLeft.length+aRight.length];

        int idx_left=0;
        int idx_right=0;
        while (idx_left < aLeft.length || idx_right < aRight.length){
            int leftCur=0;
            int rightCur=0;
            if(idx_left == aLeft.length) leftCur = 1000000001;
            else leftCur = aLeft[idx_left];

            if (idx_right == aRight.length) rightCur = 1000000001;
            else rightCur = aRight[idx_right];

            if (leftCur > rightCur){
                aMerged[idx_left+idx_right] = rightCur;
                idx_right++;
            }
            else {
                aMerged[idx_left+idx_right] = leftCur;
                idx_left++;
            }

        }

        return aMerged;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(getNumberOfInversions(a));
    }
}

