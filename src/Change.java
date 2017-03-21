import java.util.Scanner;

public class Change {
    private static int getChange(int m, int[] coinDenominations, int coinCount) {
        for(int i = 0; i < coinDenominations.length; i++){
            if( m >= coinDenominations[i]){
                coinCount = coinCount + m/coinDenominations[i];
                m = m % coinDenominations[i];
                getChange(m, coinDenominations, coinCount);
            }
        }
        return coinCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int [] coinDenominations = new int[3];
        coinDenominations[0]=10;
        coinDenominations[1]=5;
        coinDenominations[2]=1;
        int coinCount = 0;

        System.out.println(getChange(m, coinDenominations, coinCount));


    }
}

