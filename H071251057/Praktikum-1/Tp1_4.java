import java.util.Scanner;

public class Tp1_4 {
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
        System.out.print("");
        double n = input.nextInt();
        double hasil = faktorial(n); //memanggil fungsi faktorial
        // int hasil = 1; //dibuat dgn nilai 1, dgunakan utk mnyimpan hasil perkalian
        // for (int i = 1; i <= n; i++) { //start 1, akn trs brjln jika </= n
        //     hasil = hasil * i;
        // }
        // static int faktorial(int n) { //fungsi rekursif, memanggil dirinya sendiri
        //     if (n == 0 || n == 1) { //faktorial 0 dan 1 = 1
        //         return 1;
        //     } else {
        //         return n * faktorial(n - 1); //faktorial n = n * faktorial (n-1)
        //     }
        // }
        System.out.println(hasil);
    }
    static double faktorial(double n) { //fungsi rekursif, memanggil dirinya sendiri
            if (n == 0 || n == 1) { //faktorial 0 dan 1 = 1
                return 1;
            } else {
                return n * faktorial(n - 1); //faktorial n = n * faktorial (n-1)
            }
        }
}