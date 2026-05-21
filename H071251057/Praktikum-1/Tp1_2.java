import java.util.Scanner;

public class Tp1_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("(dd-mm-yy): "); //input, tipe data string
        String tanggal = input.nextLine();
        String[] bagian = tanggal.split("-"); //lalu dipecah dgn split, jd array string
        int hari = Integer.parseInt(bagian[0]); //ubah string ke int
        int bulan = Integer.parseInt(bagian[1]);
        int tahun = Integer.parseInt(bagian[2]);

        if (tahun < 26) { //jika tahun < 26, maka dianggap 2000an
            tahun += 2000;
        } else { //jika tidak, maka dianggap 1900an
            tahun += 1900;
        }
        String[] nambul = {"Januari","Februari","Maret","April","Mei","Juni","Juli","Agustus","September","Oktober","November","Desember"}; //array bentuk string
        System.out.println(hari + " " + nambul[bulan - 1] + " " + tahun); //
    } //bulan -1 krn array mulai dari 0
}