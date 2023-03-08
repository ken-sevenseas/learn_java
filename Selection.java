import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Selection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(sc.next()));
        }
        sc.close();
        sort(nums);
    }

    static void printArr(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.printf("%d", nums.get(i));
        }
        System.out.println();
    }

    static void sort(List<Integer> nums) {
        int cnt = 0;
        for (int i = 0; i < nums.size(); i++) {
            int minv = i;
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(minv) > nums.get(j)) {
                    minv = j;
                }
            }
            swap(nums, i, minv);
            if (minv != i) {
                cnt++;
            }
        }
        printArr(nums);
        System.out.println(cnt);
    }

    static void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
