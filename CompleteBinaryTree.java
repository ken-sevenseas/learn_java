import java.io.PrintWriter;
import java.util.Scanner;

public class CompleteBinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();

        int N;
        int[] A;
        String str;

        N = Integer.parseInt(sc.next());
        A = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            A[i] = Integer.parseInt(sc.next());
        }
        sc.close();

        for (int i = 1; i < N + 1; i++) {
            if (i > 1) {
                sb.append("\n");
            }
            sb.append("node ");
            sb.append(i);
            sb.append(": ");
            sb.append("key = ");
            sb.append(A[i]);
            sb.append(", ");
            if (getParent(i) >= 1) {
                sb.append("parent key = ");
                sb.append(A[getParent(i)]);
                sb.append(", ");
            }
            if (getLeft(i) <= N) {
                sb.append("left key = ");
                sb.append(A[getLeft(i)]);
                sb.append(", ");
            }
            if (getRight(i) <= N) {
                sb.append("right key = ");
                sb.append(A[getRight(i)]);
                sb.append(", ");
            }
        }
        str = sb.toString();
        pw.println(str);
        pw.flush();
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
