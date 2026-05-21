import java.util.Scanner;

public class Tp1_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = input.nextLine(); //mngambil semua teks dlm satu baris
        //ppenanda bhwa blm ditemukan
        boolean besar = false; 
        boolean kecil = false;
        boolean angka = false;

        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i); //mengecek 1/1 karakter
                if (c >= 'A' && c <= 'Z') { //kapital
                    besar = true;
                } else if (c >= 'a' && c <= 'z') { //kecil
                    kecil = true;
                } else if (c >= '0' && c <= '9') {
                    angka = true;
                }
            }
            if (besar && kecil && angka) {
                System.out.println("Password valid");
            } else {
                System.out.println("Password tidak valid");
            }
        } else {
            System.out.println("Password minimal 8 karakter");
        }
    }
}