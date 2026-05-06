package Soal1;

import java.util.Scanner;

class Bangun {
    String nama;

    void tampilkanNama() {
        System.out.println("Bangun: " + nama);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        System.out.println("-------------------------------------------");
        System.out.println("    ====== BANGUN RUANG ======");
        System.out.println("1. KUBUS");
        System.out.println("2. BALOK");
        System.out.println("3. BOLA");
        System.out.println("4. TABUNG");
        System.out.println();
        System.out.println("    ====== BANGUN DATAR ======");
        System.out.println("5. PERSEGI");
        System.out.println("6. PERSEGI PANJANG");
        System.out.println("7. LINGKARAN");
        System.out.println("8. TRAPESIUM");
        System.out.println("-------------------------------------------");
        System.out.print("Pilihan: ");
        pilihan = input.nextInt();

        System.out.println("-------------------------------------------");

        if (pilihan == 1) {
            System.out.print("Masukkan sisi kubus: ");
            double sisi = input.nextDouble();
            Kubus kubus = new Kubus(sisi);
            kubus.tampil();
        } else if (pilihan == 2) {
            System.out.print("Masukkan panjang balok: ");
            double p = input.nextDouble();
            System.out.print("Masukkan lebar balok: ");
            double l = input.nextDouble();
            System.out.print("Masukkan tinggi balok: ");
            double t = input.nextDouble();
            Balok balok = new Balok(p, l, t);
            balok.tampil();
        } else if (pilihan == 3) {
            System.out.print("Masukkan jari-jari bola: ");
            double r = input.nextDouble();
            Bola bola = new Bola(r);
            bola.tampil();
        } else if (pilihan == 4) {
            System.out.print("Masukkan jari-jari tabung: ");
            double r = input.nextDouble();
            System.out.print("Masukkan tinggi tabung: ");
            double t = input.nextDouble();
            Tabung tabung = new Tabung(r, t);
            tabung.tampil();
        } else if (pilihan == 5) {
            System.out.print("Masukkan sisi persegi: ");
            double s = input.nextDouble();
            Persegi persegi = new Persegi(s);
            persegi.tampil();
        } else if (pilihan == 6) {
            System.out.print("Masukkan panjang persegi panjang: ");
            double p = input.nextDouble();
            System.out.print("Masukkan lebar persegi panjang: ");
            double l = input.nextDouble();
            PersegiPanjang pp = new PersegiPanjang(p, l);
            pp.tampil();
        } else if (pilihan == 7) {
            System.out.print("Masukkan jari-jari lingkaran: ");
            double r = input.nextDouble();
            Lingkaran lingkaran = new Lingkaran(r);
            lingkaran.tampil();
        } else if (pilihan == 8) {
            System.out.print("Masukkan sisi 1 trapesium: ");
            double s1 = input.nextDouble();
            System.out.print("Masukkan sisi 2 trapesium: ");
            double s2 = input.nextDouble();
            System.out.print("Masukkan sisi 3 trapesium: ");
            double s3 = input.nextDouble();
            System.out.print("Masukkan sisi 4 trapesium: ");
            double s4 = input.nextDouble();
            System.out.print("Masukkan tinggi trapesium: ");
            double t = input.nextDouble();
            Trapesium trapesium = new Trapesium(s1, s2, s3, s4, t);
            trapesium.tampil();
        } else {
            System.out.println("Pilihan tidak valid!");
        }

        System.out.println("-------------------------------------------");
        input.close();
    }
}