import java.util.Scanner;
public class TugasNo4 {
    public static void main(String[] args) {
        Scanner bro = new Scanner(System.in);
        double angka = bro.nextDouble();
        double faktorial = faktorial(angka);
        // for (int i = 1 ; i<= angka; i++) {
        //     faktorial *= i;
        // }
        System.out.println(faktorial);
        bro.close();
    }
    public static double faktorial(double n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * faktorial(n - 1);
        }
    }
}