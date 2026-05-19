package Soal1;
import java.util.Scanner;
class Persegi{
    double sisi;
    Persegi(){}
    Persegi(double sisi){
        this.sisi = sisi;
    }

    public void luas(){
        double luas = sisi * sisi;
        System.out.println("Luas Persegi: " + luas);
    }

    public void keliling(){
        double keliling = 4 * sisi;
        System.out.println("Keliling Persegi: " + keliling);
    }

    public void view(){
        System.out.println(  "Hitung Luas dan Keliling Persegi");
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan sisi persegi (cm) : ");
        double sisi = x.nextDouble();
        Persegi k = new Persegi(sisi);
        k.luas();
        k.keliling();
    }
}

class PersegiPanjang{
    double panjang;
    double lebar;
    PersegiPanjang(){}
    PersegiPanjang(double panjang, double lebar){
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public void luas(){
        double luas = panjang * lebar;
        System.out.println("Luas Persegi Panjang: " + luas);
    }

    public void keliling(){
        double keliling = 2 * (panjang + lebar);
        System.out.println("Keliling Persegi Panjang: " + keliling);
    }

    public void view(){
        System.out.println(  "Hitung Luas dan Keliling Persegi Panjang");
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan panjang (cm) : ");
        double panjang = x.nextDouble();
        System.out.print("Masukkan lebar (cm)   : ");
        double lebar = x.nextDouble();
        PersegiPanjang k = new PersegiPanjang(panjang, lebar);
        k.luas();
        k.keliling();
    }
}

class Lingkaran {
    double jari_jari;
    Lingkaran(){}
    Lingkaran(double jari_jari){
        this.jari_jari = jari_jari;
    }

    public void luas(){
        double luas = Math.PI * jari_jari * jari_jari;
        System.out.printf("Luas Lingkaran: %.2f\n",luas);
    }

    public void keliling(){
        double keliling = 2 * Math.PI * jari_jari;
        System.out.printf("Keliling Lingkaran: %.2f\n", keliling);
    }

    public void view(){
        System.out.println(  "Hitung Luas dan Keliling Lingkaran");
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan jari-jari lingkaran (cm) : ");
        double r = x.nextDouble();
        Lingkaran k = new Lingkaran(r);
        k.luas();
        k.keliling();
    }
}

class Trapesium {
    double sisi_a;
    double sisi_b;
    double sisi_c;
    double sisi_d;
    double tinggi;
    Trapesium(){}
    Trapesium(double sisi_a, double sisi_b, double sisi_c, double sisi_d, double tinggi){
        this.sisi_a = sisi_a;
        this.sisi_b = sisi_b;
        this.sisi_c = sisi_c;
        this.sisi_d = sisi_d;
        this.tinggi = tinggi;
    }

    public void luas(){
        double luas = 0.5 * (sisi_a + sisi_b) * tinggi;
        System.out.println("Luas Trapesium: " + luas);
    }

    public void keliling(){
        double keliling = sisi_a + sisi_b + sisi_c + sisi_d;
        System.out.println("Keliling Trapesium: " + keliling);
    }
    public void view(){
        System.out.println(  "Hitung Luas dan Keliling Trapesium");
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan sisi 1 trapesium (cm): ");
        double sisi1 = x.nextDouble();
        System.out.print("Masukkan sisi 2 trapesium (cm): ");
        double sisi2 = x.nextDouble();
        System.out.print("Masukkan sisi 3 trapesium (cm): ");
        double sisi3 = x.nextDouble();
        System.out.print("Masukkan sisi 4 trapesium (cm): ");
        double sisi4 = x.nextDouble();
        System.out.print("Masukkan tinggi trapesium (cm): ");
        double tinggi = x.nextDouble();
        Trapesium k = new Trapesium(sisi1, sisi2, sisi3, sisi4, tinggi);
        k.luas();
        k.keliling();
    } 
}
