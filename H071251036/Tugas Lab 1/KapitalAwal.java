import java.util.Scanner;

public class KapitalAwal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan kalimat: ");
        String kalimat = input.nextLine();

        String[] kata = kalimat.split(" ");
        String hasil = "";

        for (String k : kata) {
            hasil += Character.toUpperCase(k.charAt(0)) + k.substring(1).toLowerCase()+ " ";
        }

        System.out.println("Output: " + hasil.trim());
    }
}