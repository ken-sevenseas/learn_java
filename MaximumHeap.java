import java.io.PrintWriter;
import java.util.Scanner;

public class MaximumHeap {
    static int N;
    static int[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        N = Integer.parseInt(sc.next());
        A = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            A[i] = Integer.parseInt(sc.next());
        }

        for (int i = N / 2; i >= 1; i--) {
            maxHeapify(i);
        }
        for (int i = 1; i < N + 1; i++) {
            pw.print(" " + A[i]);
        }
        pw.println();
        pw.flush();
        sc.close();
    }

    public static void maxHeapify(int i) {
        int largest;

        if (getLeft(i) <= N && A[getLeft(i)] > A[i]) {
            largest = getLeft(i);
        } else {
            largest = i;
        }
        if (getRight(i) <= N && A[getRight(i)] > A[largest]) {
            largest = getRight(i);
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    public static void swap(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static int getParent(int i) {
        return i / 2;
    }

    public static int getLeft(int i) {
        return 2 * i;
    }

    public static int getRight(int i) {
        return 2 * i + 1;
    }
}
