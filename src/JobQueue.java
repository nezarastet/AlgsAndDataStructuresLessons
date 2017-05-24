import java.io.*;
import java.util.StringTokenizer;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    private void assignJobs() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        workers[] Workers = new workers[numWorkers];
        for (int i = 0; i < numWorkers; i++) {
            Workers[i] = new workers(i, 0);
        }

        for (int i = 0; i < jobs.length; i++) {
            int duration = jobs[i];
            assignedWorker[i] = Workers[0].id;
            startTime[i] = Workers[0].nextFreeTime;
            Workers[0].nextFreeTime += duration;
            siftDown(Workers, 0);
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    public class workers {
        int id;
        long nextFreeTime;

        public workers(int id, long nextFreeTime) {
            this.id = id;
            this.nextFreeTime = nextFreeTime;
        }
    }

    public void swapElements(workers[] Workers, int idx1, int idx2){
        workers tmp=Workers[idx1];
        Workers[idx1] = Workers[idx2];
        Workers[idx2] = tmp;
    }

    public void siftDown(workers[] Workers, int i){
        // for min-heap
        int minIdx = i;
        int l = 2*i+1; // leftchild
        if (l<=Workers.length-1 && Workers[l].nextFreeTime == Workers[minIdx].nextFreeTime && Workers[l].id < Workers[minIdx].id) minIdx = l;
        else if (l<=Workers.length-1 && Workers[l].nextFreeTime < Workers[minIdx].nextFreeTime) minIdx = l;


        int r =2*i+2; //rightchild
        if (r <= Workers.length-1 && Workers[r].nextFreeTime == Workers[minIdx].nextFreeTime && Workers[r].id < Workers[minIdx].id) minIdx = r;
        else if (r <= Workers.length-1 && Workers[r].nextFreeTime < Workers[minIdx].nextFreeTime) minIdx = r;

        if (i != minIdx){
            swapElements(Workers, i, minIdx);
            siftDown(Workers, minIdx);
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
