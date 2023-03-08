import java.io.PrintWriter;
import java.util.Scanner;

public class Stack {
    private static int top = 0;
    private static int[] stack = new int[200];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int a, b;
        while (sc.hasNext()) {
            String stock = sc.next();
            if (stock.equals("+")) {
                a = pop();
                b = pop();
                push(a + b);
            } else if (stock.equals("-")) {
                a = pop();
                b = pop();
                push(b - a);
            } else if (stock.equals("*")) {
                a = pop();
                b = pop();
                push(a * b);
            } else {
                push(Integer.parseInt(stock));
            }
        }
        sc.close();
        System.out.println(pop());
    }

    private static void push(int num) {
        stack[++top] = num;
    }

    private static int pop() {
        top--;
        return stack[top + 1];
    }
}
