import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Insertion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            num.add(Integer.parseInt(sc.next()));
        }
        sc.close();
        printArr(num);
        sort(num);
    }

    static void printArr(List<Integer> num) {
        for (int i = 0; i < num.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.printf("%d", num.get(i));
        }
        System.out.println();
    }

    static void sort(List<Integer> num) {
        for (int i = 1; i < num.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (num.get(j) < num.get(j - 1)) {
                    int temp = num.get(j);
                    num.set(j, num.get(j - 1));
                    num.set(j - 1, temp);
                }
            }
            printArr(num);
        }
    }
}