import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner anu = new Scanner(System.in);

        KaryawanTetap jack = new KaryawanTetap("Jack", 123456, 20000000, 1000000);
        System.out.print("angka kehadiran: ");
        int jumlahAbsen2 = anu.nextInt();
        for (int i = 0; i < jumlahAbsen2; i++ ){
            jack.absen();
        }
        jack.tampilkanInfo();

        KaryawanKontrak ogi = new KaryawanKontrak("Oggy", 140906, 500000);
        System.out.print("\n angka kehadiran: ");
        int jumlahAbsen1 = anu.nextInt();
        for (int i = 0; i < jumlahAbsen1; i++ ){
            ogi.absen();
        }
        ogi.tampilkanInfo();
    }
}