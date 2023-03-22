import java.io.PrintWriter;
import java.util.Scanner;

public class Quick {
    static Card[] A;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        N = Integer.parseInt(sc.next());
        A = new Card[N];
        for (int i = 0; i < N; i++) {
            char key = sc.next().charAt(0);
            int num = Integer.parseInt(sc.next());
            A[i] = new Card(key, num);
            // A[i].key = sc.next().charAt(0);
            // A[i].num = Integer.parseInt(sc.next());
        }
        quickSort(0, N - 1);
        for (int i = 0; i < N; i++) {
            pw.println(A[i].key + " " + A[i].num);
        }
        pw.flush();
        sc.close();
    }

    public static int partition(int p, int r) {
        int i;
        Card temp, x;
        x = A[r];
        i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j].num <= x.num) {
                i++;
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;
        return i + 1;
    }

    public static void quickSort(int p, int r) {
        int stn;
        if (p < r) {
            stn = partition(p, r);
            quickSort(p, stn - 1);
            quickSort(stn + 1, r);
        }
    }
}

class Card {
    char key;
    int num;

    Card(char key, int num) {
        this.key = key;
        this.num = num;
    }
}
