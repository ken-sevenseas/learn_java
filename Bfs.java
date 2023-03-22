import java.io.PrintWriter;
import java.util.Scanner;

public class Bfs {

    static int N;
    static final int WHITE = 0;
    static final int GRAY = 1;
    static final int BLACK = 2;

    static int[][] matrix;
    static int[] color, discover, complete;
    static int count;

    public static void dfs() {
        PrintWriter pw = new PrintWriter(System.out);

        count = 0;

        for (int vertex = 0; vertex < N; vertex++) {
            if (color[vertex] == WHITE) {
                dfsVisit(vertex);
            }
        }
        for (int vertex = 0; vertex < N; vertex++) {
            pw.print(vertex + 1);
            pw.print(" ");
            pw.print(discover[vertex]);
            pw.print(" ");
            pw.println(complete[vertex]);
        }
        pw.flush();
    }

    public static void dfsVisit(int vertex) {
        color[vertex] = GRAY;
        discover[vertex] = ++count;

        for (int i = 0; i < N; i++) {
            if (matrix[vertex][i] == 0) {
                continue;
            }
            if (color[i] == WHITE) {
                dfsVisit(i);
            }
        }

        color[vertex] = BLACK;
        complete[vertex] = ++count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertex, outdeg;

        N = Integer.parseInt(sc.next());
        matrix = new int[N][N];
        discover = new int[N];
        complete = new int[N];
        color = new int[N];

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
        dfs();
        sc.close();
    }
}
