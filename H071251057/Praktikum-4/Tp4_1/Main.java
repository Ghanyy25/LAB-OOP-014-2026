import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------------------------------");
        System.out.println("====== BANGUN RUANG ======");
        System.out.println("1. KUBUS");
        System.out.println("2. BALOK");
        System.out.println("3. BOLA");
        System.out.println("4. TABUNG");
        System.out.println("\n====== BANGUN DATAR ======");
        System.out.println("5. PERSEGI");
        System.out.println("6. PERSEGI PANJANG");
        System.out.println("7. LINGKARAN");
        System.out.println("8. TRAPESIUM");
        System.out.println("--------------------------------------------------");
        System.out.print("Pilihan: ");
        int pilihan = scanner.nextInt();
        System.out.println("--------------------------------------------------");

        switch (pilihan) {

            case 1:
                System.out.print("Sisi kubus: ");
                double s = scanner.nextDouble();

                Kubus kubus = new Kubus(s);

                System.out.println("Luas permukaan kubus: " + kubus.luasPermukaan());
                System.out.println("Volume kubus: " + kubus.volume());
                break;

            case 2:
                System.out.print("Panjang balok: ");
                double p = scanner.nextDouble();
                System.out.print("Lebar balok: ");
                double l = scanner.nextDouble();
                System.out.print("Tinggi balok: ");
                double t = scanner.nextDouble();

                Balok balok = new Balok(p, l, t);

                System.out.println("Luas permukaan balok: " + balok.luasPermukaan());
                System.out.println("Volume balok: " + balok.volume());
                break;

            case 3:
                System.out.print("Jari-jari bola: ");
                double r = scanner.nextDouble();

                Bola bola = new Bola(r);

                System.out.println("Luas permukaan bola: " + bola.luasPermukaan());
                System.out.println("Volume bola: " + bola.volume());
                break;

            case 4:
                System.out.print("Jari-jari tabung: ");
                r = scanner.nextDouble();
                System.out.print("Tinggi tabung: ");
                t = scanner.nextDouble();

                Tabung tabung = new Tabung(r, t);

                System.out.println("Luas permukaan tabung: " + tabung.luasPermukaan());
                System.out.println("Volume tabung: " + tabung.volume());
                break;

            case 5:
                System.out.print("Sisi persegi: ");
                s = scanner.nextDouble();

                Persegi persegi = new Persegi(s);

                System.out.println("Luas persegi: " + persegi.luas());
                System.out.println("Keliling persegi: " + persegi.keliling());
                break;

            case 6:
                System.out.print("Panjang persegi panjang: ");
                p = scanner.nextDouble();
                System.out.print("Lebar persegi panjang: ");
                l = scanner.nextDouble();

                PersegiPanjang pp = new PersegiPanjang(p, l);

                System.out.println("Luas persegi panjang: " + pp.luas());
                System.out.println("Keliling persegi panjang: " + pp.keliling());
                break;

            case 7:
                System.out.print("Jari-jari lingkaran: ");
                r = scanner.nextDouble();

                Lingkaran lingkaran = new Lingkaran(r);

                System.out.println("Luas lingkaran: " + lingkaran.luas());
                System.out.println("Keliling lingkaran: " + lingkaran.keliling());
                break;

            case 8:
                System.out.print("Sisi 1 trapesium: ");
                double a = scanner.nextDouble();
                System.out.print("Sisi 2 trapesium: ");
                double b = scanner.nextDouble();
                System.out.print("Sisi 3 trapesium: ");
                double c = scanner.nextDouble();
                System.out.print("Sisi 4 trapesium: ");
                double d = scanner.nextDouble();
                System.out.print("Tinggi trapesium: ");
                t = scanner.nextDouble();

                Trapesium trapesium = new Trapesium(a, b, c, d, t);

                System.out.println("Luas trapesium: " + trapesium.luas());
                System.out.println("Keliling trapesium: " + trapesium.keliling());
                break;

            default:
                System.out.println("Pilihan tidak tersedia.");
        }

        System.out.println("--------------------------------------------------");
        scanner.close();
    }
}