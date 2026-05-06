package Tuprak1;

import java.util.Scanner;

public class Soal2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Input (dd-mm-yy): ");
        String input = scan.next();

        String[] parts = input.split("-");

        int tanggal = Integer.parseInt(parts[0]);
        int bulan = Integer.parseInt(parts[1]);
        int tahun = Integer.parseInt(parts[2]);

        String namaBulan = "";

        if (bulan == 1) {
            namaBulan = "Januari";
        } else if (bulan == 2) {
            namaBulan = "Februari";
        } else if (bulan == 3) {
            namaBulan = "Maret";
        } else if (bulan == 4) {
            namaBulan = "April";
        } else if (bulan == 5) {
            namaBulan = "Mei";
        } else if (bulan == 6) {
            namaBulan = "Juni";
        } else if (bulan == 7) {
            namaBulan = "Juli";
        } else if (bulan == 8) {
            namaBulan = "Agustus";
        } else if (bulan == 9) {
            namaBulan = "September";
        } else if (bulan == 10) {
            namaBulan = "Oktober";
        } else if (bulan == 11) {
            namaBulan = "November";
        } else if (bulan == 12) {
            namaBulan = "Desember";
        }

        int tahunLengkap;
        if (tahun < 27) {
            tahunLengkap = 2000 + tahun;
        } else {
            tahunLengkap = 1900 + tahun;
        }

        System.out.println("Output: " + tanggal + " " + namaBulan + " " + tahunLengkap);
    }
}