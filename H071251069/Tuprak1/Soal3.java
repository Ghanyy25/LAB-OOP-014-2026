package Tuprak1;

import java.util.Scanner;

public class Soal3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String passwordBenar = "Abc12345";

        System.out.print("Masukkan password: ");
        String pass = scan.next();

        boolean valid = true;

        if (!pass.equals(passwordBenar)) {
            valid = false;
            System.out.println("Output : Password tidak valid (password salah)");
        } else {

            if (pass.length() < 8) {
                valid = false;
            } else {
                boolean adaBesar = false;
                boolean adaKecil = false;
                boolean adaAngka = false;

                for (int i = 0; i < pass.length(); i++) {
                    char huruf = pass.charAt(i);

                    if (Character.isUpperCase(huruf))
                        adaBesar = true;
                    if (Character.isLowerCase(huruf))
                        adaKecil = true;
                    if (Character.isDigit(huruf))
                        adaAngka = true;
                }

                if (!adaBesar || !adaKecil || !adaAngka) {
                    valid = false;
                }
            }

            if (valid) {
                System.out.println("Output : Password valid");
            } else {
                System.out.println("Output : Password tidak valid");
            }
        }
    }
}