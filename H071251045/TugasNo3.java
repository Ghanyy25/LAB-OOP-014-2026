import java.util.Scanner;
public class TugasNo3 {
    public static void main(String[] args) {
        Scanner anu = new Scanner(System.in);

        System.out.print("Masukkan password: ");
        String password = anu.nextLine();

        boolean hurufKapital = false;
        boolean hurufKecil = false;
        boolean angka = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                hurufKapital = true;
            } else if (Character.isLowerCase(c)) {
                hurufKecil = true;
            } else if (Character.isDigit(c)) {
                angka = true;
            }
        }

        if (password.length() >= 8 && hurufKapital && hurufKecil && angka) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
        anu.close();
    }
}