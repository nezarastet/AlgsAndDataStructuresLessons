import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights, double value) {

        if(capacity ==0) return value;
        int valuesSum = 0;
        for( int num : values) {
            valuesSum = valuesSum+num;
        }
        if(valuesSum == 0) return value;
        else{
            double minWeightPerUnit = 10e7;
            int idx=-1;
            for (int i =0; i < values.length; i++){
                if(values[i] != 0 && (double)weights[i]/(double)values[i] < minWeightPerUnit){
                    minWeightPerUnit = (double)weights[i]/(double)values[i];
                    idx = i;
                }
            }
            if(capacity >= weights[idx]){
                capacity = capacity - weights[idx];
                value = value + values[idx];
                values[idx] = 0;
                value = getOptimalValue(capacity, values, weights,value);
            }
            else{
                value = value +  ((double)values[idx]/(double)weights[idx]) * (double)capacity;
            }
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        double value = 0;
        System.out.println(getOptimalValue(capacity, values, weights,value));
    }
} 
