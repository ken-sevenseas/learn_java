import java.io.PrintWriter;
import java.util.Scanner;

public class Allocation {
    public static int N;
    public static int k;
    public static int MAX = 100000;
    public static int[] T = new int[MAX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        N = Integer.parseInt(sc.next());
        k = Integer.parseInt(sc.next());
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(sc.next());
        }
        long ans = solve();
        pw.println(ans);
        pw.flush();
        sc.close();
    }

    private static int check(long p) {
        int i = 0;
        for (int j = 0; j < k; j++) {
            long s = 0l;
            while (s + T[i] <= p) {
                s += T[i];
                i++;
                if (i == N) {
                    return N;
                }
            }
        }
        return i;
    }

    private static long solve() {
        long mid;
        long left = 0l;
        long right = 100000l * 10000l;
        while (1 < right - left) {
            mid = (left + right) / 2;
            int v = check(mid);
            if (v >= N) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

}
