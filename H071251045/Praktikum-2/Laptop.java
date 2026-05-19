package Baru;
import java.util.Scanner;

public class Laptop {
    String merk;
    Tugas tugas;

    public Laptop() {
        this.merk = "Non-brand";
        this.tugas = new Tugas("Mudah", 0);
    }

    public Laptop(String merk, Tugas tugas) {
        this.merk = merk;
        this.tugas = tugas;
    }

    public void menuTugas() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Apakah anda ingin mengerjakan tugas? y/n: ");
        String jawaban = scanner.nextLine();
        
        if (jawaban.equals("y")) {
            tugas.tampilkanInfoTugas(); 
            System.out.println("Laptop " + merk + " sedang memproses tugas");
        } else {
            System.out.println("Anda tidak mengerjakan tugas.");
        }
        scanner.close();
    }
    public void setMerk(String merkBaru){
        this.merk = merkBaru;
    }
    
    public String getMerk(){
        return merk;
    }
}