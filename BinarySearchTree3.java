import java.util.Scanner;

public class BinarySearchTree3 {
    static int N;
    static Bnode root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.next());
        String command;
        for (int i = 0; i < N; i++) {
            command = sc.next();

            if (command.equals("insert")) {
                insert(Integer.parseInt(sc.next()));
            } else if (command.equals("print")) {
                inParse(root);
                System.out.println();
                preParse(root);
                System.out.println();
            } else if (command.equals("find")) {
                int x = Integer.parseInt(sc.next());
                Bnode n = find(root, x);
                if (n != null) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            } else if (command.equals("delete")) {
                int x = Integer.parseInt(sc.next());
                delete(find(root, x));
            }
        }
        sc.close();
    }

    public static Bnode getMinimum(Bnode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static Bnode getSuccessor(Bnode node) {
        if (node.right != null) {
            return getMinimum(node.right);
        }
        Bnode temp = node.parent;
        while (temp != null && node == temp.right) {
            node = temp;
            temp = temp.parent;
        }
        return temp;
    }

    public static void delete(Bnode node) {
        Bnode deleted;
        Bnode x;

        if (node.left == null || node.right == null) {
            deleted = node;
        } else {
            deleted = getSuccessor(node);
        }

        if (deleted.left != null) {
            x = deleted.left;
        } else {
            x = deleted.right;
        }

        if (x != null) {
            x.parent = deleted.parent;
        }

        if (deleted.parent == null) {
            root = x;
        } else {
            if (deleted == deleted.parent.left) {
                deleted.parent.left = x;
            } else {
                deleted.parent.right = x;
            }
        }

        if (deleted != node) {
            node.key = deleted.key;
        }
    }

    public static Bnode find(Bnode node, int key) {
        while (node != null && key != node.key) {
            if (key < node.key) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    public static void insert(int key) {
        Bnode x = root;
        Bnode y = root;
        Bnode z = new Bnode();

        z.key = key;

        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        z.parent = y;

        if (y == null) {
            root = z;
        } else {
            if (z.key < y.key) {
                y.left = z;
            } else {
                y.right = z;
            }
        }
    }

    public static void inParse(Bnode node) {
        if (node == null) {
            return;
        }
        inParse(node.left);
        System.out.print(" " + node.key);
        inParse(node.right);
    }

    public static void preParse(Bnode node) {
        if (node == null) {
            return;
        }
        System.out.print(" " + node.key);
        preParse(node.left);
        preParse(node.right);
    }
}

class Bnode {
    int key;
    Bnode right, left, parent;
}
