import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();

        int[] minStepCount = new int[n+1];
        minStepCount[0]=0;
        minStepCount[1]=0;

        int idxMinOneStepCount = 0;
        int idxDiv2StepCount = 0;
        int idxDiv3StepCount = 0;

        for (int i = 2; i <= n; i++){
            if (i % 2 == 0) idxDiv2StepCount = minStepCount[i/2];
            else idxDiv2StepCount = n+1;

            if (i % 3 ==0) idxDiv3StepCount = minStepCount[i/3];
            else idxDiv3StepCount = n+1;

            idxMinOneStepCount = minStepCount[i-1];
            minStepCount[i] = Math.min(Math.min(idxDiv2StepCount, idxDiv3StepCount), idxMinOneStepCount)+1;
        }

        // reconsrtuction
        int idx = n;
        sequence.add(n);
        while (idx != 1){
            if (idx % 3 == 0 && minStepCount[idx/3] < minStepCount[idx-1]) {
                if (idx % 2 == 0 && minStepCount[idx / 2] < minStepCount[idx / 3]) idx = idx / 2;
                else idx = idx / 3;
            }
            else{
                    if (idx % 2 == 0 && minStepCount[idx/2] < minStepCount[idx-1]) idx = idx/2;
                    else idx--;
                }
                sequence.add(idx);
            }

        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
