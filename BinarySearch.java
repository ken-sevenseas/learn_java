import java.io.PrintWriter;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int sum = 0;
        int N = Integer.parseInt(sc.next());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sc.next());
        }
        int M = Integer.parseInt(sc.next());
        for (int i = 0; i < M; i++) {
            if (search(arr, Integer.parseInt(sc.next()))) {
                sum++;
            }
        }
        sc.close();
        pw.println(sum);
        pw.flush();
    }

    public static boolean search(int[] arr, int key) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (key == arr[mid]) {
                return true;
            }
            if (arr[mid] < key) {
                left = mid + 1;
            } else if (arr[mid] > key) {
                right = mid;
            }
        }
        return false;
    }
}
