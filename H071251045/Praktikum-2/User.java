package Baru;

public class User {
    String nama;
    String nim;
    Laptop laptop;

    public User() {
        this.nama = "User";
        this.nim = "H071251000";
        this.laptop = new Laptop();
    }
    public User(String nama, String nim, Laptop laptop) {
        this.nama = nama;
        this.nim = nim;
        this.laptop = laptop;
    }

    public void selamatDatang() {
        System.out.println("Selamat datang " + nama + " dengan NIM " + nim);
    }
    
    public void bandingkanLaptop(User teman) {
        System.out.println(this.nama + " membandingkan laptop " + this.laptop.merk + " dengan laptop " + teman.nama + " yang mana adalah" + teman.laptop.merk);
    }
}