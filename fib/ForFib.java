package part2.page252;

public class ForFib implements Fib {
    private final int end;
    private final Integer[] F;
    public static final int MIN_INPUT = 0;
    public static final int MAX_INPUT = 44;

    private ForFib(final int end) {
        if (end < MIN_INPUT)
            throw new IllegalArgumentException("input should be [" + MIN_INPUT + ":" + MAX_INPUT + "]");
        if (end > MAX_INPUT)
            throw new IllegalArgumentException("input should be [" + MIN_INPUT + ":" + MAX_INPUT + "]");
        this.end = end;
        this.F = new Integer[end + 1];
    }

    public int compute() {
        F[0] = 1;
        if (end == 0) return 1;

        F[1] = 1;
        for (int i = 0; i < end - 1; i++) {
            F[i + 2] = F[i + 1] + F[i];
        }
        return F[end];
    }

    public static ForFib create(final int end) {
        return new ForFib(end);
    }
}
