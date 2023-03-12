import java.io.PrintWriter;
import java.util.Scanner;

public class Merge {
    final static int MAX = 500000;
    final static int SENTINEL = 2000000000;
    static int[] L, R;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int N;
        N = Integer.parseInt(sc.next());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(sc.next());
        }
        mergeSort(A, N, 0, N);
        for (int i = 0; i < N; i++) {
            if (i > 0) {
                pw.print(" ");
            }
            pw.print(A[i]);
        }
        pw.println();
        pw.println(cnt);
        pw.flush();
        sc.close();
    }

    public static void merge(int[] A, int n, int left, int mid, int right) {
        int n1 = mid - left;
        int n2 = right - mid;
        L = new int[n / 2 + 2];
        R = new int[n / 2 + 2];
        for (int i = 0; i < n1; i++) {
            L[i] = A[left + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = A[mid + i];
        }
        L[n1] = SENTINEL;
        R[n2] = SENTINEL;
        int i = 0;
        int j = 0;
        for (int k = left; k < right; k++) {
            cnt++;
            if (L[i] <= R[j]) {
                A[k] = L[i++];
            } else {
                A[k] = R[j++];
            }
        }
    }

    public static void mergeSort(int[] A, int n, int left, int right) {
        if (left + 1 < right) {// 次の探索にmidが含まれる場合は、+1する。
            int mid = (left + right) / 2;
            mergeSort(A, n, left, mid);
            mergeSort(A, n, mid, right);
            merge(A, n, left, mid, right);
        }
    }
}
