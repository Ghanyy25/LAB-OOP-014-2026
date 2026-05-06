package Tuprak1;

import java.util.Scanner;

public class Soal4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Input : ");
        int n = scan.nextInt();

        int hasil = faktorial(n);

        System.out.println("Output : " + hasil);
    }

    public static int faktorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * faktorial(n - 1);
        }
    }
}