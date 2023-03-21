import java.io.PrintWriter;
import java.util.Scanner;

public class Graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(sc.next());
        int[][] matrix = new int[N][N];

        int vertex;
        int outdeg;

        for (int i = 0; i < N; i++) {
            vertex = Integer.parseInt(sc.next());// 頂点
            outdeg = Integer.parseInt(sc.next());// 出次数
            vertex--;// 頂点は1-origin,配列は0-origin

            for (int j = 0; j < outdeg; j++) {
                int tover = Integer.parseInt(sc.next());// tover: to vertex : 出次先;
                tover--;
                matrix[vertex][tover] = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j > 0) {
                    pw.print(" ");
                }
                pw.print(matrix[i][j]);
            }
            pw.println();
        }
        sc.close();
        pw.flush();
    }
}
