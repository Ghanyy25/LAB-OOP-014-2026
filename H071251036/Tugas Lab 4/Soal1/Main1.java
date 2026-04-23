import java.util.Scanner;

// ===== BANGUN DATAR =====
class Persegi {
    double sisi;

    Persegi(double sisi) {
        this.sisi = sisi;
    }

    double luas() {
        return sisi * sisi;
    }

    double keliling() {
        return 4 * sisi;
    }
}

class PersegiPanjang {
    double p, l;

    PersegiPanjang(double p, double l) {
        this.p = p;
        this.l = l;
    }

    double luas() {
        return p * l;
    }

    double keliling() {
        return 2 * (p + l);
    }
}

class Lingkaran {
    double r;

    Lingkaran(double r) {
        this.r = r;
    }

    double luas() {
        return Math.PI * r * r;
    }

    double keliling() {
        return 2 * Math.PI * r;
    }
}

class Trapesium {
    double a, b, t;

    Trapesium(double a, double b, double t) {
        this.a = a;
        this.b = b;
        this.t = t;
    }

    double luas() {
        return 0.5 * (a + b) * t;
    }
}

// ===== BANGUN RUANG (INHERITANCE) =====
class Kubus extends Persegi {

    Kubus(double sisi) {
        super(sisi);
    }

    double volume() {
        return sisi * sisi * sisi;
    }

    double luasPermukaan() {
        return 6 * luas(); // pakai dari Persegi
    }
}

class Balok extends PersegiPanjang {
    double t;

    Balok(double p, double l, double t) {
        super(p, l);
        this.t = t;
    }

    double volume() {
        return p * l * t;
    }
}

class Bola extends Lingkaran {

    Bola(double r) {
        super(r);
    }

    double volume() {
        return (4.0 / 3) * Math.PI * r * r * r;
    }
}

class Tabung extends Lingkaran {
    double t;

    Tabung(double r, double t) {
        super(r);
        this.t = t;
    }

    double volume() {
        return Math.PI * r * r * t;
    }
}

// ===== MAIN =====
public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("======================================");
            System.out.println("            BANGUN RUANG              ");
            System.out.println("======================================");
            System.out.println("1. KUBUS");
            System.out.println("2. BALOK");
            System.out.println("3. BOLA");
            System.out.println("4. TABUNG");
            System.out.println("======================================");
            System.out.println("            BANGUN DATAR              ");
            System.out.println("======================================");
            System.out.println("5. PERSEGI");
            System.out.println("6. PERSEGI PANJANG");
            System.out.println("7. LINGKARAN");
            System.out.println("8. TRAPESIUM");
            System.out.println("0. KELUAR");
            System.out.println("======================================");
            System.out.print("Pilihan: ");

            pilihan = Integer.parseInt(input.nextLine());

            switch (pilihan) {

                case 1:
                    System.out.print("Masukkan sisi: ");
                    double s = Double.parseDouble(input.nextLine());
                    Kubus k = new Kubus(s);
                    System.out.println("Volume: " + k.volume());
                    System.out.println("Luas Permukaan: " + k.luasPermukaan());
                    break;

                case 2:
                    System.out.print("Panjang: ");
                    double p = Double.parseDouble(input.nextLine());
                    System.out.print("Lebar: ");
                    double l = Double.parseDouble(input.nextLine());
                    System.out.print("Tinggi: ");
                    double t = Double.parseDouble(input.nextLine());
                    Balok b = new Balok(p, l, t);
                    System.out.println("Volume: " + b.volume());
                    break;

                case 3:
                    System.out.print("Jari-jari: ");
                    double r = Double.parseDouble(input.nextLine());
                    Bola bo = new Bola(r);
                    System.out.println("Volume: " + bo.volume());
                    break;

                case 4:
                    System.out.print("Jari-jari: ");
                    double r2 = Double.parseDouble(input.nextLine());
                    System.out.print("Tinggi: ");
                    double t2 = Double.parseDouble(input.nextLine());
                    Tabung tb = new Tabung(r2, t2);
                    System.out.println("Volume: " + tb.volume());
                    break;

                case 5:
                    System.out.print("Sisi: ");
                    double sp = Double.parseDouble(input.nextLine());
                    Persegi ps = new Persegi(sp);
                    System.out.println("Luas: " + ps.luas());
                    System.out.println("Keliling: " + ps.keliling());
                    break;

                case 6:
                    System.out.print("Panjang: ");
                    double pp = Double.parseDouble(input.nextLine());
                    System.out.print("Lebar: ");
                    double lp = Double.parseDouble(input.nextLine());
                    PersegiPanjang pj = new PersegiPanjang(pp, lp);
                    System.out.println("Luas: " + pj.luas());
                    System.out.println("Keliling: " + pj.keliling());
                    break;

                case 7:
                    System.out.print("Jari-jari: ");
                    double rl = Double.parseDouble(input.nextLine());
                    Lingkaran li = new Lingkaran(rl);
                    System.out.println("Luas: " + li.luas());
                    System.out.println("Keliling: " + li.keliling());
                    break;

                case 8:
                    System.out.print("Sisi atas: ");
                    double a = Double.parseDouble(input.nextLine());
                    System.out.print("Sisi bawah: ");
                    double bb = Double.parseDouble(input.nextLine());
                    System.out.print("Tinggi: ");
                    double tt = Double.parseDouble(input.nextLine());
                    Trapesium tr = new Trapesium(a, bb, tt);
                    System.out.println("Luas: " + tr.luas());
                    break;

                case 0:
                    System.out.println("Keluar program...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 0);
    }
}