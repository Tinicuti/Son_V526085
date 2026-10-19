
import java.util.Scanner;

public class b3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap cac so nguyen: ");
        String s = sc.nextLine();

        String[] parts = s.trim().split("\\s+");

        int n = parts.length;
        int tong = 0;

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(parts[i]);
            tong += x;
        }

        System.out.println("So phan tu: " + n);
        System.out.println("Tong: " + tong);

        sc.close();
    }
}
