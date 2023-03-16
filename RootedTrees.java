import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RootedTrees {
    static Tnode[] T;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id, degree;
        N = Integer.parseInt(sc.next());
        T = new Tnode[N];
        for (int i = 0; i < N; i++) {
            T[i] = new Tnode();
        }
        for (int i = 0; i < N; i++) {
            id = Integer.parseInt(sc.next());
            degree = Integer.parseInt(sc.next());
            for (int j = 0; j < degree; j++) {
                int child_id = Integer.parseInt(sc.next());
                T[id].children.add(child_id);
                T[child_id].setParent(id);
            }
        }
        for (int i = 0; i < N; i++) {
            if (T[i].getParent() == -1) {
                calucDepth(i, 0);
            }
        }
        for (int i = 0; i < N; i++) {
            print(i);
        }
        sc.close();
    }

    public static void print(int id) {
        PrintWriter pw = new PrintWriter(System.out);
        pw.print("node " + id + ": ");
        pw.print("parent = " + T[id].getParent() + ", ");
        pw.print("depth = " + T[id].getDepth() + ", ");

        if (T[id].getParent() == -1) {
            pw.print("root, ");
        } else if (T[id].children.size() == 0) {
            pw.print("leaf, ");
        } else {
            pw.print("internal node, ");
        }
        pw.flush();
        T[id].printChildren();
    }

    public static void calucDepth(int id, int depth) {
        T[id].setDepth(depth);
        for (int i = 0; i < T[id].children.size(); i++) {
            calucDepth(T[id].children.get(i), depth + 1);
        }
    }
}

class Tnode {
    int parent_id;
    int depth;
    ArrayList<Integer> children;

    Tnode() {
        this.parent_id = -1;
        children = new ArrayList<>();
    }

    public void setParent(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getParent() {
        return this.parent_id;
    }

    public void setChildren(int child) {
        children.add(child);
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return this.depth;
    }

    public void printChildren() {
        PrintWriter pw = new PrintWriter(System.out);
        pw.print("[");
        for (int i = 0; i < children.size(); i++) {
            if (i > 0) {
                pw.print(", ");
            }
            pw.print(children.get(i));
        }
        pw.println("]");
        pw.flush();
    }
}