import java.util.Scanner;
public class TugasNo4 {
    public static void main(String[] args) {
        Scanner bro = new Scanner(System.in);
        int angka = bro.nextInt();
        int faktorial = 1;
        for (int i = 1 ; i<= angka; i++) {
            faktorial *= i;
        }
        System.out.println(faktorial);
        bro.close();
    }
}