package fib;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = Integer.parseInt(sc.next());

        // final Fib ffib= ForFib.create(n);
        final Fib rfib = RecursionFib.create(n);
        System.out.println(rfib.compute());
    }
}
