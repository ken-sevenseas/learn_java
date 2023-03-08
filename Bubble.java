import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bubble {
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

    private static void printArr(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.printf("%d", nums.get(i));
        }
        System.out.println();
    }

    private static void sort(List<Integer> nums) {
        boolean flag = true;
        int i = 0;
        int cnt = 0;
        while (flag) {
            flag = false;
            for (int j = nums.size() - 1; j >= i + 1; j--) {// (j-1)番目とj番目を交換するためi+1までのループで良い。
                if (nums.get(j) < nums.get(j - 1)) {
                    cnt++;
                    swap(nums, j - 1, j);
                    flag = true;
                }
            }
            i++;
        }
        printArr(nums);
        System.out.println(cnt);
    }

    private static void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
