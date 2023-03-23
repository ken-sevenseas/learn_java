import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Connectedcomp {
    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> color = new ArrayList<>();
    static int friend;

    public static void dfs(int r, int c) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.addLast(r);
        color.set(r, c);
        while (!dq.isEmpty()) {
            int u = dq.pollLast();
            for (int i = 0; i < list.get(u).size(); i++) {
                int v = list.get(u).get(i);
                if (color.get(v) == -1) {
                    color.set(v, c);
                    dq.addLast(v);
                } else {
                    color.set(r, color.get(v));
                }
            }
        }
    }

    public static void assignColor() {
        int id = 1;
        for (int i = 0; i < friend; i++) {
            color.add(-1);
        }
        for (int i = 0; i < friend; i++) {
            if (color.get(i) == -1) {
                dfs(i, id++);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int relation;

        friend = Integer.parseInt(sc.next());
        relation = Integer.parseInt(sc.next());

        // 隣接リストを表すarraylistのlistを作る。
        for (int i = 0; i < friend; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < relation; i++) {
            int num, rel;
            num = Integer.parseInt(sc.next());
            rel = Integer.parseInt(sc.next());
            list.get(num).add(rel);
        }

        assignColor();

        int question = Integer.parseInt(sc.next());
        for (int i = 0; i < question; i++) {
            int s = Integer.parseInt(sc.next());
            int t = Integer.parseInt(sc.next());

            if (color.get(s) == color.get(t)) {
                pw.println("yes");
            } else {
                pw.println("no");
            }
        }
        pw.flush();
        sc.close();
    }
}
