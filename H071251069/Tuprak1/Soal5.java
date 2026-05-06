package Tuprak1;

import java.util.Scanner;

public class Soal5 {
    public static void main(String[] args) {

        int[][] nums = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        Scanner scan = new Scanner(System.in);
        System.out.print("Input :\n");

        try {
            int cari = scan.nextInt();
            boolean ketemu = false;

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == cari) {
                        System.out.println("Found " + cari + " at [" + i + "][" + j + "]");
                        ketemu = true;
                        break;
                    }
                }
                if (ketemu) {
                    break;
                }
            }
            if (!ketemu) {
                System.out.println("Angka tidak ditemukan.");
            }

        } catch (Exception e) {
            System.out.println("Error: Input harus berupa angka!");
        }
    }
}