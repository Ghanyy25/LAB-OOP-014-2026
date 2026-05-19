import java.util.Scanner;

abstract class Karyawan {
    private String nama;
    private int idKaryawan;
    private int jumlahKehadiran;

    public Karyawan(String nama, int idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0;
    }

    void absen(){
        jumlahKehadiran++;
    }

    int getInfoHadir(){
        return jumlahKehadiran;
    }

    abstract int hitungGaji();
    
     void tampilkanInfo(){
        System.out.println("Nama       : " + nama);
        System.out.println("ID Karyawan: " + idKaryawan);
    }

}

class KaryawanTetap extends Karyawan{
    int gajiPokok;
    int tunjanganMakan;

    public KaryawanTetap(String nama, int idKaryawan, int gajiPokok, int tunjanganMakan) {
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    int hitungGaji() {
        return gajiPokok + (tunjanganMakan * getInfoHadir());
    }

    double hitungGaji(double bonusKinerja){
        return hitungGaji()+ bonusKinerja;
    }

    void tampilkanInfo() {
        super.tampilkanInfo();
        Scanner anu = new Scanner(System.in);
        System.out.println("Bonus Kinerja: ");anu.nextInt();
        System.out.println("Gaji Pokok     : " + gajiPokok);
        System.out.println("Tunjangan Makan: " + tunjanganMakan);
        System.out.println("total gaji : " + hitungGaji());
        System.out.println();
    }
}

class KaryawanKontrak extends Karyawan{
    int upahPerHari;

    public KaryawanKontrak(String nama, int idKaryawan, int upahPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    @Override
    int hitungGaji() {
        int totalGaji = upahPerHari * getInfoHadir();
        if (getInfoHadir()>20){
            totalGaji += 500000;
        }
        return totalGaji;
    }

    void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Upah Per Hari: " + upahPerHari);
        System.out.println("Hitung gaji : "+ hitungGaji());
    }

    
}
    
