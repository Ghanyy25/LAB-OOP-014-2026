package Soal1;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("========== BANGUN RUANG ==========");
            System.out.println("1. KUBUS");
            System.out.println("2. BALOK");
            System.out.println("3. BOLA");
            System.out.println("4. TABUNG");
            System.out.println("========== BANGUN DATAR ==========");
            System.out.println("5. PERSEGI");
            System.out.println("6. PERSEGI PANJANG");
            System.out.println("7. LINGKARAN");
            System.out.println("8. TRAPESIUM");
            System.out.println("0. KELUAR");
            System.out.println("----------------------------------------");
            System.out.print("Pilihan: ");
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    kubus k = new kubus();
                    k.view();
                    break;
                case 2:
                    balok b = new balok();
                    b.view();
                    break;
                case 3:
                    bola bo = new bola();
                    bo.view();
                    break;
                case 4:
                    tabung t = new tabung();
                    t.view();
                    break;
                case 5:
                    Persegi p = new Persegi();
                    p.view();
                    break;
                case 6:
                    PersegiPanjang pp = new PersegiPanjang();
                    pp.view();
                    break;
                case 7:
                    Lingkaran l = new Lingkaran();
                    l.view();
                    break;
                case 8:
                    Trapesium tr = new Trapesium();
                    tr.view();
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    input.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
                
            
            }
        }
       

        
    }
    
}
