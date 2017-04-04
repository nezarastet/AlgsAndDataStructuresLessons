import java.util.*;

public class Inversions {

    public static class SortedArray{
        int[] sortedArray;
        long inversionsCount;

        public SortedArray(int[] sortedArray, long inversionsCount) {
            this.sortedArray = sortedArray;
            this.inversionsCount = inversionsCount;
        }
    }

    private static long getNumberOfInversions(int[] a) {
        SortedArray b = mergeSort(a);

//        for (int j = 0; j < b.sortedArray.length; j++) {
//            System.out.print(b.sortedArray[j] + " ");
//        }
//        System.out.println("\n");

        return b.inversionsCount;
    }

    private static SortedArray mergeSort(int[] a){
        int left = 0;
        int right = a.length-1;
        if(left>=right){
            SortedArray aSorted =  new SortedArray(a, 0);
            return aSorted;
        }
        else {
            int mid = (right+left)/2;
            int[] aLeft = new int[mid+1];
            System.arraycopy(a, 0, aLeft, 0, mid+1);

            int[] aRight = new int[right-mid];
            System.arraycopy(a, mid+1, aRight, 0, right-mid);

            SortedArray aLeftSorted = mergeSort(aLeft);
            SortedArray aRightSorted = mergeSort(aRight);

            SortedArray aSorted = merge(aLeftSorted, aRightSorted);
            aSorted.inversionsCount = aSorted.inversionsCount + aLeftSorted.inversionsCount+aRightSorted.inversionsCount;

            return aSorted;
        }
    }


    private static SortedArray merge(SortedArray aLeft, SortedArray aRight){
        SortedArray aMerged = new SortedArray(new int[aLeft.sortedArray.length+aRight.sortedArray.length], 0);

        int idx_left=0;
        int idx_right=0;
        while (idx_left < aLeft.sortedArray.length || idx_right < aRight.sortedArray.length){
            int leftCur=0;
            int rightCur=0;
            if(idx_left == aLeft.sortedArray.length) leftCur = 1000000001;
            else leftCur = aLeft.sortedArray[idx_left];

            if (idx_right == aRight.sortedArray.length) rightCur = 1000000001;
            else rightCur = aRight.sortedArray[idx_right];

            if (leftCur <= rightCur){
                aMerged.sortedArray[idx_left+idx_right] = leftCur;
                aMerged.inversionsCount = aMerged.inversionsCount+idx_right;
                idx_left++;

            }
            else {
                aMerged.sortedArray[idx_left+idx_right] = rightCur;
                idx_right++;
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

