import java.io.PrintWriter;
import java.util.Scanner;

public class BinaryTree {
    static int N;
    static TreeNode[] T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.next());
        T = new TreeNode[N];
        int id, left_id, right_id, root = 0;
        for (int i = 0; i < N; i++) {
            T[i] = new TreeNode();
        }
        for (int i = 0; i < N; i++) {
            id = Integer.parseInt(sc.next());
            left_id = Integer.parseInt(sc.next());
            right_id = Integer.parseInt(sc.next());
            if (left_id != -1) {
                T[id].setLeft_id(left_id);
                T[left_id].setParent(id);
            }
            if (right_id != -1) {
                T[id].setRigth(right_id);
                T[right_id].setParent(id);
            }
        }
        for (int i = 0; i < N; i++) {
            if (T[i].getPrent() == -1) {
                root = i;
            }
        }
        calucDepth(root, 0);
        calucHeight(root);
        for (int i = 0; i < N; i++) {
            print(i);
        }
        sc.close();
    }

    public static void calucDepth(int id, int depth) {
        if (id == -1) {
            return;
        }
        T[id].setDepth(depth);
        calucDepth(T[id].getLeft_id(), depth + 1);
        calucDepth(T[id].getRight_id(), depth + 1);
    }

    public static int calucHeight(int id) {
        int h1 = 0, h2 = 0;
        if (T[id].getLeft_id() != -1) {
            h1 = calucHeight(T[id].left_id) + 1;
        }
        if (T[id].getRight_id() != -1) {
            h2 = calucHeight(T[id].right_id) + 1;
        }
        T[id].setHeight((h1 > h2 ? h1 : h2));
        return T[id].getHeight();
    }

    public static int getSibling(int id) {
        if (T[id].parent_id == -1) {
            return -1;
        }
        if (T[T[id].getPrent()].left_id != id && T[T[id].getPrent()].left_id != -1) {
            return T[T[id].getPrent()].left_id;
        }
        if (T[T[id].getPrent()].right_id != id && T[T[id].getPrent()].right_id != -1) {
            return T[T[id].getPrent()].right_id;
        }
        return -1;
    }

    public static int getDegree(int id) {
        int deg = 0;
        if (T[id].getLeft_id() != -1) {
            deg++;
        }
        if (T[id].getRight_id() != -1) {
            deg++;
        }
        return deg;
    }

    public static void print(int id) {
        PrintWriter pw = new PrintWriter(System.out);
        pw.print("node " + id + ": ");
        pw.print("parent = " + T[id].getPrent());
        pw.print(", sibling = " + getSibling(id));
        pw.print(", degree = " + getDegree(id));
        pw.print(", depth = " + T[id].getDepth());
        pw.print(", height = " + T[id].getHeight());
        if (T[id].parent_id == -1) {
            pw.println(", root");
        } else if (getDegree(id) == 0) {
            pw.println(", leaf");
        } else {
            pw.println(", internal node");
        }
        pw.flush();
    }
}

class TreeNode {
    int parent_id;
    int right_id;
    int left_id;
    int depth;
    int height;

    TreeNode() {
        this.parent_id = -1;
        this.left_id = -1;
        this.right_id = -1;
    }

    public void setParent(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getPrent() {
        return this.parent_id;
    }

    public void setRigth(int right_id) {
        this.right_id = right_id;
    }

    public int getRight_id() {
        return this.right_id;
    }

    public void setLeft_id(int left_id) {
        this.left_id = left_id;
    }

    public int getLeft_id() {
        return this.left_id;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return this.depth;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }
}