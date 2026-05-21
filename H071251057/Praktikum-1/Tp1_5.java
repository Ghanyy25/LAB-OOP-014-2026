import java.util.Scanner;

public class Tp1_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //sistem input
        int[][] nums = {{1, 2, 3},{4, 5, 6},{7, 8, 9}}; //0,1,2

        System.out.print("Input : ");
        try {
    
        int cari = input.nextInt();
        boolean ada = false; //belum ditemukan
        for (int i = 0; i < nums.length; i++) { //indx 0, trs brjalan if < jumlah bris, maka +1 tiap perulngn utk pngcekan brktny
            for (int j = 0; j < nums[i].length; j++) { //dobel krn array 2d
                if (nums[i][j] == cari) { //i baris, j kolom
                    System.out.println("Found " + cari + " at " + i + "|" + j);
                    ada = true; //jika ketemu
                    break; //loop dalam(menelusuri isi kolom pertama-akhir secara berurutan)
                }
            }
            if (ada) {
                break; //loop luar(untuk berpindah dari baris ke baris)
            }
        }
        if (!ada) { //tidak ada
            System.out.println("Angka tidak ditemukan");
        }
    }catch (Exception e) {
        System.out.println("Input tidak valid");
        }
    }
}