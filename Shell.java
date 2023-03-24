import java.util.Scanner;

public class Shell {
    static int count = 0;
    static int[] data = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.next());
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(sc.next());
        }
        sc.close();

        int n = shellSort(arr);
        System.out.println(n);

        for (int i = n - 1; i >= 0; i--) {
            if (i != n - 1) {
                System.out.print(" ");
            }
            System.out.print(data[i]);
        }

        System.out.println();
        System.out.println(count);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void insertionSort(int[] nums, int num) {//間隔を指定した挿入ソート
        for (int i = num; i < nums.length; i++) {
            int value = nums[i];
            int j = i - num;
            while (j >= 0 && value < nums[j]) {
                swap(nums, j + num, j);
                j -= num;
                count++;
            }
            // nums[j + num] = value;
        }
    }

    private static int shellSort(int[] nums) {
        int n = 1;
        int i = 0;

        while (true) {
            if (n > nums.length) {// 間隔が配列より長い場合はbreak
                break;
            }
            data[i] = n; //整列する間隔を格納する。
            n = 3 * n + 1;
            i++;
        }

        for (int j = i - 1; j >= 0; j--) {
            insertionSort(nums, data[j]);
        }

        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
