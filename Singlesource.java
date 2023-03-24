import java.io.PrintWriter;
import java.util.Scanner;

public class Singlesource {
    static final int INFTY = 2000000000;
    static final int WHITE = 0;
    static final int GRAY = 1;
    static final int BLACK = 2;
    static int N;
    static int[][] matrix;

    public static void dijkstra() {
        PrintWriter pw = new PrintWriter(System.out);
        int[] cost = new int[N];
        int[] color = new int[N];
        int minv;

        for (int i = 0; i < N; i++) {
            cost[i] = INFTY;
        }

        cost[0] = 0;
        color[0] = GRAY;

        while (true) {
            minv = INFTY;
            int u = -1;

            for (int i = 0; i < N; i++) {
                if (minv > cost[i] && color[i] != BLACK) {
                    u = i;
                    minv = cost[i];
                }
            }

            if (u == -1) {
                break;
            }
            color[u] = BLACK;

            for (int v = 0; v < N; v++) {
                if (color[v] != BLACK && matrix[u][v] != INFTY) {
                    if (cost[v] > cost[u] + matrix[u][v]) {
                        cost[v] = cost[u] + matrix[u][v];
                        color[v] = GRAY;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            pw.print(i);
            pw.print(" ");
            pw.println(cost[i] == INFTY ? -1 : cost[i]);
        }
        pw.flush();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.next());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = INFTY;
            }
        }

        for (int i = 0; i < N; i++) {
            int id = Integer.parseInt(sc.next());
            int outdeg = Integer.parseInt(sc.next());
            for (int j = 0; j < outdeg; j++) {
                int vertex = Integer.parseInt(sc.next());
                int arrowcost = Integer.parseInt(sc.next());
                matrix[id][vertex] = arrowcost;
            }
        }

        dijkstra();
    }
}
