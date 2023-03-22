import java.io.PrintWriter;
import java.util.Scanner;

public class PrioritQueue {
    static final int INFTY = 2000000000;
    static int N = 2000000;
    static int H = 0;
    static int[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        String str;
        A = new int[N + 1];

        while (true) {
            str = sc.next();
            if (str.charAt(0) == 'e' && str.charAt(1) == 'n') {
                break;
            }
            if (str.charAt(0) == 'i') {
                int key = Integer.parseInt(sc.next());
                insert(key);
            } else {
                pw.println(extract());
            }
        }
        pw.flush();
        sc.close();
    }

    public static int extract() {
        int maxv;
        if (H < 1) {
            return -1 * INFTY;
        }
        maxv = A[1];
        A[1] = A[H--];
        maxHeapify(1);
        return maxv;
    }

    public static void insert(int key) {
        H++;
        A[H] = -1 * INFTY;
        increseKey(H, key);
    }

    public static void swap(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void increseKey(int i, int key) {
        if (key < A[i]) {
            return;
        }
        A[i] = key;
        while (i > 1 && A[i / 2] < A[i]) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    public static void maxHeapify(int i) {
        int largest;

        if (getLeft(i) <= H && A[getLeft(i)] > A[i]) {
            largest = getLeft(i);
        } else {
            largest = i;
        }
        if (getRight(i) <= H && A[getRight(i)] > A[largest]) {
            largest = getRight(i);
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
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
