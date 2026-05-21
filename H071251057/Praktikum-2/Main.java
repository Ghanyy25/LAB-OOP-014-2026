import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Membuat objek tanaman
        Tanaman strawberry = new Tanaman("Strawberry", 10, 1);
        Tanaman cherry = new Tanaman("Cherry", 15, 2);
        // Input energi Daisy Lily
        System.out.print("Masukkan energi Daisy: ");
        int energiDaisy = input.nextInt();

        System.out.print("Masukkan energi Lily: "); 
        int energiLily = input.nextInt();
        // Membuat objek farmer
        Farmer farmer1 = new Farmer("Daisy", energiDaisy, strawberry);
        Farmer farmer2 = new Farmer("Lily", energiLily, cherry);
        // Input cuaca
        System.out.print("Masukkan cuaca hari 1 (Hujan/Terik): ");
        String cuaca1 = input.next();

        System.out.print("Masukkan cuaca hari 2 (Hujan/Terik): ");
        String cuaca2 = input.next();
        // Membuat objek cuaca
        Cuaca hari1 = new Cuaca(cuaca1);
        Cuaca hari2 = new Cuaca(cuaca2);

        System.out.println("\n=== TINY FARM WITH DAILY ===\n");
        // Day 1
        System.out.println("= HARI KE-1 = ");
        hari1.pengaruh(strawberry);
        hari1.pengaruh(cherry);
        farmer1.menyiram();
        farmer2.menyiram();
        // Day 2
        System.out.println("\n= HARI KE-2 =");
        hari2.pengaruh(strawberry);
        hari2.pengaruh(cherry);
        farmer1.kerjaBareng(farmer2);
        // Panen
        System.out.println("\n= WAKTU PANEN =");
        farmer1.panen();
        farmer2.panen();
        // Hasil akhir
        System.out.println("\n= HASIL AKHIR =");
        farmer1.infoFarmer();
        farmer2.infoFarmer();

        if (strawberry.umur > 3) {
            System.out.println("\nStrawberry sudah terlalu tua untuk dipanen.");
        }
        if (cherry.umur > 3) {
            System.out.println("\nCherry sudah terlalu tua untuk dipanen.");
        }
    }
}