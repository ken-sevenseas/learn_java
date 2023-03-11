import java.io.PrintWriter;
import java.util.Scanner;

public class LinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        List list = new List();
        for (int i = 0; i < N; i++) {
            String command = sc.next();
            if (command.charAt(0) == 'i') {
                list.insert(Integer.parseInt(sc.next()));
            } else if (command.length() > 6) {
                if (command.charAt(6) == 'F') {
                    list.deleteFirst();
                } else {
                    list.deleteLast();
                }
            } else {
                list.deleteKey(Integer.parseInt(sc.next()));
            }
        }
        list.printList();
        sc.close();
    }
}

class List {

    Node nil;

    List() {
        nil = new Node();
        nil.prev = nil;
        nil.next = nil;
    }

    public Node listSerch(int key) {
        Node cur = nil.next;
        while (cur != nil && cur.key != key) {
            cur = cur.next;
        }
        return cur;
    }

    public void insert(int key) {
        Node node = new Node();
        node.key = key;
        node.prev = nil;
        node.next = nil.next;
        nil.next.prev = node;
        nil.next = node;
    }

    public void deleteNode(Node node) {
        if (node == nil) {
            return;
        }
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void deleteFirst() {
        deleteNode(nil.next);
    }

    public void deleteLast() {
        deleteNode(nil.prev);
    }

    public void deleteKey(int key) {
        deleteNode(listSerch(key));
    }

    public void printList() {
        PrintWriter pw = new PrintWriter(System.out);
        Node cur = nil.next;
        int i = 0;
        while (true) {
            if (cur == nil) {
                break;
            }
            if (i++ > 0) {
                // System.out.print(" ");
                pw.print(" ");
            }
            pw.print(cur.key);
            cur = cur.next;
        }
        pw.println();
        pw.flush();
    }
}

class Node {
    int key;
    Node prev, next;
}