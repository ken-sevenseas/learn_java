import java.io.PrintWriter;
import java.util.Scanner;

public class Minimumspanning {
    static final int INFTY = 2000000000;
    static final int WHITE = 0;
    static final int GRAY = 1;
    static final int BLACK = 2;
    static int N;
    static int[][] matrix;

    public static int prim() {
        int u, minv;
        int[] distance = new int[N];//辺の重みをdistanceと解釈する, costにした方がわかりやすいかも。
        int[] parent = new int[N];
        int[] color = new int[N];//色で来訪したかどうかを判断する

        for (int i = 0; i < N; i++) {
            distance[i] = INFTY;
            parent[i] = -1;
            color[i] = WHITE;
        }

        distance[0] = 0;//移動の必要がないから0

        while (true) {
            minv = INFTY;
            u = -1;
            for (int i = 0; i < N; i++) {
                if (minv > distance[i] && color[i] != BLACK) {//来訪済みでないかつコストが最小
                    u = i;
                    minv = distance[i];
                }
            }

            if (u == -1) {//u=-1のままならノードは孤立していることになる
                break;
            }

            color[u] = BLACK;//来訪済みにする

            for (int v = 0; v < N; v++) {
                if (color[v] != BLACK && matrix[u][v] != INFTY) {//来訪済みでないかつ、辿り着けるノードを探索
                    if (distance[v] > matrix[u][v]) {//辺の重みの更新する
                        distance[v] = matrix[u][v];
                        parent[v] = u;
                        color[v] = GRAY;//探索したことを表すために灰色に設定
                    }
                }
            }
        }

        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (parent[i] != -1) {
                sum += matrix[i][parent[i]];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        N = Integer.parseInt(sc.next());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int e = Integer.parseInt(sc.next());
                matrix[i][j] = (e == -1) ? INFTY : e;//-1なら辿り着けない
            }
        }

        pw.println(prim());
        pw.flush();
    }
}
