class Diem {
    private double x, y;

    // Ham tao
    public Diem(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Setter
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}

class DuongThang {
    private Diem A, B;

    // Ham tao
    public DuongThang(Diem A, Diem B) {
        this.A = A;
        this.B = B;
    }

    // Getter
    public Diem getA() {
        return A;
    }

    public Diem getB() {
        return B;
    }

    // Tinh do dai AB
    public double tinhDoDai() {
        double dx = B.getX() - A.getX();
        double dy = B.getY() - A.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }
}

public class b1slide3 {
    public static void main(String[] args) {
        Diem A = new Diem(1, 2);
        Diem B = new Diem(4, 6);

        DuongThang d = new DuongThang(A, B);

        System.out.println("Do dai duong thang AB = " + d.tinhDoDai());
    }
}