import java.io.PrintWriter;
import java.util.Scanner;

public class Dictionary {
    static final int M = 1046527;
    static final int L = 14;
    static char H[][] = new char[M][L];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(sc.next());
        String cmd, s;
        for (int i = 0; i < N; i++) {
            char[] str = new char[L];
            cmd = sc.next();
            s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                str[j] = s.charAt(j);
            }
            if (cmd.charAt(0) == 'i') {
                insert(str);
            } else {
                if (search(str)) {
                    pw.println("yes");
                } else {
                    pw.println("no");
                }
                pw.flush();
            }
        }
        sc.close();
    }

    public static boolean search(char[] str) {
        long key;
        int h;
        key = getKey(str);
        for (int i = 0;; i++) {
            h = (hash1(key) + i * hash2(key)) % M;
            if (strcmp(H[h], str)) {
                return true;
            } else if (H[h][0] == '\0') {
                return false;
            }
        }
    }

    public static int hash1(long key) {
        return (int) key % M;
    }

    public static int hash2(long key) {
        return (int) (1 + (key % (M - 1)));
    }

    public static boolean insert(char[] str) {
        long key;
        key = getKey(str);
        for (int i = 0;; i++) {
            int h = (hash1(key) + i * hash2(key)) % M;
            if (strcmp(H[h], str)) {
                return true;
            } else if (H[h][0] == '\0') {
                strcpy(H[h], str);
                return false;
            }
        }
    }

    public static int charToInt(char ch) {
        if (ch == 'A') {
            return 1;
        } else if (ch == 'C') {
            return 2;
        } else if (ch == 'G') {
            return 3;
        } else if (ch == 'T') {
            return 4;
        }
        return 0;
    }

    public static long getKey(char[] str) {
        long sum = 0;
        long p = 1;
        for (int i = 0; i < L; i++) {
            sum += p * charToInt(str[i]);
            p *= 5;
        }
        return sum;
    }

    public static boolean strcmp(char[] str1, char[] str2) {
        for (int i = 0; i < L; i++) {
            if (str2[i] != str1[i]) {
                return false;
            }
        }
        return true;
    }

    public static void strcpy(char[] str1, char[] str2) {
        for (int i = 0; i < str2.length; i++) {
            str1[i] = str2[i];
        }
    }
}
