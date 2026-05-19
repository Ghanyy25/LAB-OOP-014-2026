package Soal1;

import java.util.Scanner;
class kubus extends Persegi{
    kubus(){}
    kubus(double sisi) {
        super(sisi);
    }

    public void volume(){
        double volume = sisi * sisi * sisi;
        System.out.println("Volume Kubus: " + volume);
    }
    public void luas_permukaan(){
        double luas_permukaan = 6 * sisi * sisi;
        System.out.println("Luas Permukaan Kubus: " + luas_permukaan);
    }

    public void view(){
        System.out.println(  "Hitung Volume dan Luas Permukaan Kubus");
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan sisi kubus (cm): ");
        double sisi = x.nextDouble();
        kubus k = new kubus(sisi);
        k.volume();
        k.luas_permukaan();
    }
}

class balok extends PersegiPanjang{
    double tinggi;
    balok(){}
    balok(double panjang, double lebar, double tinggi) {
        super(panjang, lebar);
        this.tinggi = tinggi;
    }

    public void volume(){
        double volume = panjang * lebar * tinggi;
        System.out.println("Volume Balok: " + volume);
    }
    public void luas_permukaan(){
        double luas_permukaan = 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
        System.out.println("Luas Permukaan Balok: " + luas_permukaan);
    }

    public void view(){
        System.out.println(  "Hitung Volume dan Luas Permukaan Balok");
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan panjang balok (cm): ");
        double panjang = x.nextDouble();
        System.out.print("Masukkan lebar balok (cm)   : ");
        double lebar = x.nextDouble();
        System.out.print("Masukkan tinggi balok (cm)  : ");
        double tinggi = x.nextDouble();
        balok k = new balok(panjang, lebar, tinggi);
        k.volume();
        k.luas_permukaan();
    }
}

class bola extends Lingkaran{
    bola(double jari_jari) {
        super(jari_jari);
    }
    bola(){}
    public void volume(){
        double volume = (4.0/3.0) * Math.PI * jari_jari * jari_jari * jari_jari;
        System.out.printf("Volume Bola: %.2f\n", volume);
    }
    public void luas_permukaan(){
        double luas_permukaan = 4 * Math.PI * jari_jari * jari_jari;
        System.out.printf("Luas Permukaan Bola: %.2f\n" , luas_permukaan);
    }
    public void view(){
        System.out.println(  "Hitung Volume dan Luas Permukaan Bola");
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan jari-jari bola (cm) : ");
        double r = x.nextDouble();
        bola k = new bola(r);
        k.volume();
        k.luas_permukaan();
    }
}

class tabung extends Lingkaran{
    double tinggi;
    tabung(){}
    tabung(double jari_jari, double tinggi) {
        super(jari_jari);
        this.tinggi = tinggi;
    }

    public void volume(){
        double volume = Math.PI * jari_jari * jari_jari * tinggi;
        System.out.printf("Volume Tabung: %.2f\n", volume);
    }
    public void luas_permukaan(){
        double luas_permukaan = 2 * Math.PI * jari_jari * (jari_jari + tinggi);
        System.out.printf("Luas Permukaan Tabung: %.2f\n" , luas_permukaan);
    }

    public void view(){
        System.out.println(  "Hitung Volume dan Luas Permukaan Tabung");
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan jari-jari tabung (cm): ");
        double sisi = x.nextDouble();
        System.out.print("Masukkan tinggi tabung (cm)   : ");
        double tinggi = x.nextDouble();
        tabung k = new tabung(sisi, tinggi);
        k.volume();
        k.luas_permukaan();
    }
}