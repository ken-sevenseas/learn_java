public class A {
    public static void main(String[] args) {
        int N = 10;
        int M = 10;
        int[][] arr = new int[N][M];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = i;
            }
        }
        System.out.println(arr[1]);
    }
}
