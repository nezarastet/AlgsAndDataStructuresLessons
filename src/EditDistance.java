import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int n = s.length()+1;
    int m = t.length()+1;
    int[][] D = new int[n][m];
     for(int i = 0; i < n; i++) D[i][0] = i;
     for(int i = 0; i < m; i++) D[0][i] = i;

    int match = 0;
    int dismatch = 0;
    int insertion = 0;
    int delition = 0;

    for (int i = 1; i < n; i++){
      for (int j = 1; j < m; j++){
        insertion = D[i][j-1]+1;
        delition = D[i-1][j]+1;
        match = D[i-1][j-1];
        dismatch = D[i-1][j-1]+1;

        if (s.charAt(i-1) == t.charAt(j-1)) D[i][j] = Math.min(insertion, Math.min(delition, match));
        else D[i][j] = Math.min(insertion, Math.min(delition,dismatch));
      }
    }

    return D[n-1][m-1];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
