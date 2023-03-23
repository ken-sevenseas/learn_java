import java.util.Scanner;

public class TreeWalk {
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
        sc.close();
        for (int i = 0; i < N; i++) {
            if (T[i].getPrent() == -1) {
                root = i;
            }
        }
        System.out.println("Preorder");
        preParse(root);
        System.out.println();
        System.out.println("Inorder");
        inParse(root);
        System.out.println();
        System.out.println("Postorder");
        postParse(root);
        System.out.println();

    }

    public static void preParse(int id) {
        if (id == -1) {
            return;
        }
        System.out.print(" " + id);
        preParse(T[id].left_id);
        preParse(T[id].right_id);
    }

    public static void inParse(int id) {
        if (id == -1) {
            return;
        }
        inParse(T[id].left_id);
        System.out.print(" " + id);
        inParse(T[id].right_id);
    }

    public static void postParse(int id) {
        if (id == -1) {
            return;
        }
        postParse(T[id].left_id);
        postParse(T[id].right_id);
        System.out.print(" " + id);
    }
}
