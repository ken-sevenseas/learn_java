import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Bfs {

    static int N;
    static final int INFTY = 2000000000;
    static final int WHITE = 0;
    static final int GRAY = 1;
    static final int BLACK = 2;

    static int[][] matrix;
    static int[] distance;// 距離で訪問状態を管理

    public static void bfs(int vertex) {
        PrintWriter pw = new PrintWriter(System.out);
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        dq.addLast(vertex);
        for (int i = 0; i < N; i++) {
            distance[i] = INFTY;
        }
        distance[vertex] = 0;

        int u;
        while (!dq.isEmpty()) {
            u = dq.pollFirst();
            for (int v = 0; v < N; v++) {
                if (matrix[u][v] == 0) {
                    continue;
                }
                if (distance[v] != INFTY) {
                    continue;
                }
                distance[v] = distance[u] + 1;
                dq.addLast(v);
            }
        }
        for (int i = 0; i < N; i++) {
            pw.print(i + 1);
            pw.print(" ");
            if (distance[i] != INFTY) {
                pw.println(distance[i]);
            } else {
                pw.println(-1);
            }
        }
        pw.flush();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertex, outdeg;

        N = Integer.parseInt(sc.next());
        matrix = new int[N][N];
        distance = new int[N];

        for (int i = 0; i < N; i++) {
            vertex = Integer.parseInt(sc.next());
            outdeg = Integer.parseInt(sc.next());
            vertex--;

            for (int j = 0; j < outdeg; j++) {
                int deg = Integer.parseInt(sc.next());
                deg--;
                matrix[vertex][deg] = 1;
            }
        }
        bfs(0);
        sc.close();
    }
}
