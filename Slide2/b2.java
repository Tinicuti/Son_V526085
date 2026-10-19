import java.util.Arrays;

public class b2 {

    public static int[] tongHaiMang(int[] a, int[] b) {
        int n = Math.max(a.length, b.length);
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            int x = 0;
            int y = 0;

            if (i < a.length) {
                x = a[i];
            }

            if (i < b.length) {
                y = b[i];
            }

            c[i] = x + y;
        }

        return c;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4 };
        int[] b = { 13, 21 };

        int[] c = tongHaiMang(a, b);

        System.out.println(Arrays.toString(c));
    }
}