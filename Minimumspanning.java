import java.io.PrintWriter;
import java.util.Scanner;

public class Minimumspanning{
	static final int INFTY = 2000000000;
	static final int WHITE = 0;
	static final int GRAY = 1;
	static final int BLACK = 2;

	static int N;
	static int[][] matrix;

	public static int prim() {
		int u, minv;
		int[] distance = new int[N];
		int[] parent = new int[N];
		int[] color = new int[N];

		for (int i = 0; i < N; i++) {
			distance[i] = INFTY;
			parent[i] = -1;
			color[i] = WHITE;
		}

		distance[0] = 0;

		while (true) {
			minv = INFTY;
			u = -1;
			for (int i = 0; i < N; i++) {
				if (minv > distance[i] && color[i] != BLACK) {
					u = i;
					minv = distance[i];
				}
			}

			if (u == -1) {
				break;
			}
			color[u] = BLACK;
			for (int v = 0; v < N; v++) {
				if (color[v] != BLACK && matrix[u][v] != INFTY) {
					if (distance[v] > matrix[u][v]) {
						distance[v] = matrix[u][v];
						parent[v] = u;
						color[v] = GRAY;
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
				matrix[i][j] = (e == -1) ? INFTY : e;
			}
		}

		pw.println(prim());
		pw.flush();
	}
}
