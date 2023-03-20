package fib;

public class RecursionFib implements Fib {
    private final int end;
    private final Integer[] dp;
    public static final int MIN_INPUT = 0;
    public static final int MAX_INPUT = 44;

    private int computeFibOf(int n) {
        if (n == 0 || n == 1)
            return 1;
        if (dp[n] != null)
            return dp[n];
        dp[n] = computeFibOf(n - 1) + computeFibOf(n - 2);
        return dp[n];
    }

    private RecursionFib(final int end) {
        if (end < MIN_INPUT)
            throw new IllegalArgumentException("input should be [" + MIN_INPUT + ":" + MAX_INPUT + "]");
        if (end > MAX_INPUT)
            throw new IllegalArgumentException("input should be [" + MIN_INPUT + ":" + MAX_INPUT + "]");
        this.end = end;
        this.dp = new Integer[end + 1];
    }

    public int compute() {
        return computeFibOf(end);
    }

    public static RecursionFib create(final int end) {
        return new RecursionFib(end);
    }
}
