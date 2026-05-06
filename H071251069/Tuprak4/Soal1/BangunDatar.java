package Soal1;

class BangunDatar extends Bangun {
    double luas;
    double keliling;
}

class Persegi extends BangunDatar {
    double sisi;

    Persegi(double s) {
        this.sisi = s;
        this.nama = "Persegi";
        hitungLuas();
        hitungKeliling();
    }

    void hitungLuas() {
        luas = sisi * sisi;
    }

    void hitungKeliling() {
        keliling = 4 * sisi;
    }

    void tampil() {
        System.out.println("Luas Persegi: " + luas);
        System.out.println("Keliling Persegi: " + keliling);
    }
}

class PersegiPanjang extends BangunDatar {
    double panjang, lebar;

    PersegiPanjang(double p, double l) {
        this.panjang = p;
        this.lebar = l;
        this.nama = "Persegi Panjang";
        hitungLuas();
        hitungKeliling();
    }

    void hitungLuas() {
        luas = panjang * lebar;
    }

    void hitungKeliling() {
        keliling = 2 * (panjang + lebar);
    }

    void tampil() {
        System.out.println("Luas Persegi Panjang: " + luas);
        System.out.println("Keliling Persegi Panjang: " + keliling);
    }
}

class Lingkaran extends BangunDatar {
    double jariJari;

    Lingkaran(double r) {
        this.jariJari = r;
        this.nama = "Lingkaran";
        hitungLuas();
        hitungKeliling();
    }

    void hitungLuas() {
        luas = 3.14 * jariJari * jariJari;
    }

    void hitungKeliling() {
        keliling = 2 * 3.14 * jariJari;
    }

    void tampil() {
        System.out.println("Luas Lingkaran: " + luas);
        System.out.println("Keliling Lingkaran: " + keliling);
    }
}

class Trapesium extends BangunDatar {
    double sisiAtas, sisiBawah, sisiKiri, sisiKanan, tinggi;

    Trapesium(double sa, double sb, double skiri, double skanan, double t) {
        this.sisiAtas = sa;
        this.sisiBawah = sb;
        this.sisiKiri = skiri;
        this.sisiKanan = skanan;
        this.tinggi = t;
        this.nama = "Trapesium";
        hitungLuas();
        hitungKeliling();
    }

    void hitungLuas() {
        luas = 0.5 * (sisiAtas + sisiBawah) * tinggi;
    }

    void hitungKeliling() {
        keliling = sisiAtas + sisiBawah + sisiKiri + sisiKanan;
    }

    void tampil() {
        System.out.println("Luas Trapesium: " + luas);
        System.out.println("Keliling Trapesium: " + keliling);
    }
}
