import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
//        int[] points = new int[2 * segments.length];
//        for (int i = 0; i < segments.length; i++) {
//            points[2 * i] = segments[i].start;
//            points[2 * i + 1] = segments[i].end;
//        }
        int[] points = new int[0];
        points = calcOptimalPoints(segments, points);
        return points;
    }

    public static int[] calcOptimalPoints (Segment[] segments, int[] points){
        int countNotVisitedSegments = 0;
        for(int i = 0; i < segments.length; i++){
            if (segments[i].visited == false) countNotVisitedSegments = countNotVisitedSegments+1;
        }
        if (countNotVisitedSegments == 0) return points;
        else {
            int[] points_new = new int[points.length + 1]; // add one point
            System.arraycopy(points, 0, points_new, 0, points.length);


            int minRightEnd = 1000000001;
            int idx_minRightEnd = -1;
             for (int i = 0; i <segments.length; i++){
                 if (segments[i].end < minRightEnd && segments[i].visited == false){
                     minRightEnd = segments[i].end;
                     idx_minRightEnd = i;
                 }
            }
            for (int i = 0; i<segments.length;i++){
                 if (segments[i].start <= minRightEnd && segments[i].end >= minRightEnd) segments[i].visited=true;
            }


            points_new[points_new.length-1] = segments[idx_minRightEnd].end;
            points = calcOptimalPoints(segments, points_new);
            return points;
        }
    }

    private static class Segment {
        int start, end;
        boolean visited;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
            this.visited = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
