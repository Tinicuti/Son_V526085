package Buoi3;

import java.util.ArrayList;
import java.util.List;

// ================= LOP DIEM 2D =================
class Diem2D {
    protected double x, y;

    public Diem2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Tinh khoang cach giua hai diem 2D
    public double khoangCach(Diem2D p) {
        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Tim diem doi xung qua goc toa do
    public Diem2D doiXung() {
        return new Diem2D(-x, -y);
    }

    // Tinh tien diem
    public void tinhTien(double dx, double dy) {
        x += dx;
        y += dy;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// ================= LOP DIEM 3D =================
class Diem3D extends Diem2D {
    protected double z;

    public Diem3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    // Tinh khoang cach giua hai diem 3D
    @Override
    public double khoangCach(Diem2D p) {
        if (!(p instanceof Diem3D)) {
            throw new IllegalArgumentException(
                    "Can truyen vao mot diem 3D");
        }

        Diem3D q = (Diem3D) p;
        double dx = x - q.x;
        double dy = y - q.y;
        double dz = z - q.z;

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    // Doi xung diem 3D qua goc toa do
    @Override
    public Diem3D doiXung() {
        return new Diem3D(-x, -y, -z);
    }

    // Tinh tien diem 3D
    public void tinhTien(double dx, double dy, double dz) {
        x += dx;
        y += dy;
        z += dz;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}

// ================= CHUONG TRINH CHINH =================
public class btap2 {
    public static void main(String[] args) {
        List<Diem2D> danhSach = new ArrayList<>();

        // Tao danh sach gom diem 2D va 3D
        danhSach.add(new Diem2D(1, 2));
        danhSach.add(new Diem2D(3, 4));
        danhSach.add(new Diem3D(1, 2, 3));
        danhSach.add(new Diem3D(4, 5, 6));

        // Tinh tong khoang cach giua cac cap diem 2D
        double tong2D = 0;
        int soCap2D = 0;

        for (int i = 0; i < danhSach.size(); i++) {
            if (!(danhSach.get(i) instanceof Diem3D)) {
                for (int j = i + 1; j < danhSach.size(); j++) {
                    if (!(danhSach.get(j) instanceof Diem3D)) {
                        tong2D += danhSach.get(i)
                                .khoangCach(danhSach.get(j));
                        soCap2D++;
                    }
                }
            }
        }

        // Tinh tong khoang cach giua cac cap diem 3D
        double tong3D = 0;
        int soCap3D = 0;

        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i) instanceof Diem3D) {
                for (int j = i + 1; j < danhSach.size(); j++) {
                    if (danhSach.get(j) instanceof Diem3D) {
                        tong3D += danhSach.get(i)
                                .khoangCach(danhSach.get(j));
                        soCap3D++;
                    }
                }
            }
        }

        System.out.printf(
                "Tong khoang cach cac cap diem 2D: %.2f%n",
                tong2D);

        System.out.printf(
                "Tong khoang cach cac cap diem 3D: %.2f%n",
                tong3D);

        // Them cac diem doi xung vao danh sach
        int soLuongBanDau = danhSach.size();

        for (int i = 0; i < soLuongBanDau; i++) {
            danhSach.add(danhSach.get(i).doiXung());
        }

        // Hien thi danh sach
        System.out.println("\nDanh sach diem sau khi them diem doi xung:");

        for (Diem2D p : danhSach) {
            System.out.println(p);
        }
    }
}
