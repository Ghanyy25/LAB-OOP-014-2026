

import java.util.Scanner;
public class TugasNo2 {
    public static void main(String[] args) {
        Scanner bega = new Scanner(System.in);
        System.out.println("Masukkan sebuah tanggal :");
        String[] kalender = bega.nextLine().split("-");

        int tanggal = Integer.parseInt(kalender[0]);
        if (tanggal > 31 || tanggal < 1) {
            System.out.println("tanggal tidak walid");
        }
        int bulan = Integer.parseInt(kalender[1]);
        int tahun = Integer.parseInt(kalender[2]);
        String kebulanan = "";
        int n = 31;
        switch (bulan) {
            case 1: kebulanan = "Januari"; break;
            case 2:
                kebulanan = "Februari";
                n = 28;
                if (tahun % 4 == 0 && tahun % 100 != 0) {
                    n = 29;
                }
                break;
            case 3: kebulanan = "Maret"; break;
            case 4: kebulanan = "April"; n = 30; break;
            case 5: kebulanan = "Mei"; break;
            case 6: kebulanan = "Juni"; n = 30; break;
            case 7: kebulanan = "Juli"; break;
            case 8: kebulanan = "Agustus"; break;
            case 9: kebulanan = "September"; n = 30; break;
            case 10: kebulanan = "Oktober"; break;
            case 11: kebulanan = "November"; n = 30; break;
            case 12: kebulanan = "Desember"; break;
        }
        boolean kevalidan = true;
        if (bulan < 1 || bulan > 12){
            kevalidan = false;
            System.out.println("bulan tidak kevalidan");
        }
        if (tanggal < 1 || tanggal > n) {
            kevalidan = false;
            System.out.println("tanggal tidak kevalidan.");
        }
        if (tahun >= 0 && tahun <= 26) {
            tahun += 2000;
        } else if (tahun >= 27 && tahun <= 99) {
            tahun += 1900;
        } else {
            kevalidan = false;
            System.out.println("tahun tidak kevalidan.");
        }
        if (kevalidan){
            System.out.println(tanggal + " " + kebulanan + " " + tahun);
        }
        bega.close();
    }
}