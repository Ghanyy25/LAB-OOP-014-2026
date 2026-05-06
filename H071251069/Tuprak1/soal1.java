package Tuprak1;

import java.util.Scanner;

public class soal1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Masukkan Judul Film :");
        System.out.print("> ");
        String kalimat = scan.nextLine();
        String[] kata = kalimat.split(" ");

        System.out.print("Output: ");
        for (int i = 0; i < kata.length; i++) {
            String hurufDepan = kata[i].substring(0, 1).toUpperCase();
            String hurufSisa = kata[i].substring(1).toLowerCase();
            System.out.print(hurufDepan + hurufSisa + " ");
        }
    }
}
