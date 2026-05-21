import java.util.Scanner;

public class Tp1_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Judul Film: "); //input
        String judul = input.nextLine(); //membaca input sbg string, lalu disimpan k dlm variabel judul
        String[] kata = judul.split(" "); //: string > array string, dgn " " sbg -
        String hasil = ""; 
        for (int i = 0; i < kata.length; i++) { //perulangan utk mengakses setiap kata dlm array kata
            hasil += Character.toUpperCase(kata[i].charAt(0)) //mgbh hruf pertama jd kapital
                    + kata[i].substring(1).toLowerCase();  //lalu ditambah dgn sisa kata yg diubah jd huruf kecil
            if (i < kata.length - 1) { 
                hasil += " "; //spasi hanya ditambahkn jika diantara kata
            }
        }
        System.out.println(hasil);
    }
}