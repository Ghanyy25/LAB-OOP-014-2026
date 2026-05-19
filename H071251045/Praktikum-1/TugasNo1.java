import java.util.Scanner; // ini untuk import scannernya agar bisa dapakai untuk inputan
public class TugasNo1 { // ini untuk membuat class dengan nama No1
    public static void main(String[] args) { // ini adalah main method dari class No1 yang tidak akan mereturnn sebuah nilai apapun (void)
        Scanner x = new Scanner(System.in); // ini untuk mendeklarasikan sebuah Scanner type dengan nama x
        System.out.print("Masukkan Judul : ");
        String[] kalimat = x.nextLine().split(" ");// menginisialisasi sebuah tipe data string yang mana adalah array [] yang berisi  sebuah inputan yang dipisah oleh " "
        String hasil = ""; // menginisialisais sebuah string kosong sebagai wadah untuk string nanti
        for (String kata : kalimat) { // mengulang setiap iisi dari array kalimat dan menjadikannya string kata setiap inputannya
            if (kata.length() > 0) { // mengecek panjang huruf kata yang diinput
                hasil += Character.toUpperCase(kata.charAt(0)) + kata.substring(1).toLowerCase()+ " "; // jika panjang kata lebih dari 0 maka akan menambahkan hasil dengan huruf pertama kata yang diubah menjadi huruf besar dan sisanya diubah menjadi huruf kecil lalu ditambah dengan spasi
            }
        }
        System.out.println(hasil);
        x.close();
    }
}