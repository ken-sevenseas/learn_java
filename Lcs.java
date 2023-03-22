import java.io.PrintWriter;
import java.util.Scanner;

public class Lcs {
    static final int N = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        String str1, str2;
        int n = Integer.parseInt(sc.next());

        for (int i = 0; i < n; i++) {
            str1 = sc.next();
            str2 = sc.next();
            pw.println(lcs(str1, str2));
        }
        sc.close();
        pw.flush();
    }

    public static int lcs(String X, String Y) {
        int[][] c = new int[N + 1][N + 1];
        int m = X.length();
        int n = Y.length();
        int maxl = 0;

        X = ' ' + X;
        Y = ' ' + Y;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i) == Y.charAt(j)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = max(c[i - 1][j], c[i][j - 1]);
                }
                maxl = max(maxl, c[i][j]);
            }
        }
        return maxl;
    }

    public static int max(int a, int b) {
        if (a < b) {
            return b;
        }
        if (b < a) {
            return a;
        }
        return a;
    }
}
