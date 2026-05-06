package Soal1;

class BangunRuang extends Bangun {
    double luasPermukaan;
    double volume;
}

class Kubus extends BangunRuang {
    double sisi;

    Kubus(double sisi) {
        this.sisi = sisi;
        this.nama = "Kubus";
        hitungLuas();
        hitungVolume();
    }

    void hitungLuas() {
        luasPermukaan = 6 * sisi * sisi;
    }

    void hitungVolume() {
        volume = sisi * sisi * sisi;
    }

    void tampil() {
        System.out.println("Luas Permukaan Kubus: " + luasPermukaan);
        System.out.println("Volume Kubus: " + volume);
    }
}

class Balok extends BangunRuang {
    double panjang, lebar, tinggi;

    Balok(double p, double l, double t) {
        this.panjang = p;
        this.lebar = l;
        this.tinggi = t;
        this.nama = "Balok";
        hitungLuas();
        hitungVolume();
    }

    void hitungLuas() {
        luasPermukaan = 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
    }

    void hitungVolume() {
        volume = panjang * lebar * tinggi;
    }

    void tampil() {
        System.out.println("Luas Permukaan Balok: " + luasPermukaan);
        System.out.println("Volume Balok: " + volume);
    }
}

class Bola extends BangunRuang {
    double jariJari;

    Bola(double r) {
        this.jariJari = r;
        this.nama = "Bola";
        hitungLuas();
        hitungVolume();
    }

    void hitungLuas() {
        luasPermukaan = 4 * 3.14 * jariJari * jariJari;
    }

    void hitungVolume() {
        volume = (4.0 / 3.0) * 3.14 * jariJari * jariJari * jariJari;
    }

    void tampil() {
        System.out.println("Luas Permukaan Bola: " + luasPermukaan);
        System.out.println("Volume Bola: " + volume);
    }
}

class Tabung extends BangunRuang {
    double jariJari, tinggi;

    Tabung(double r, double t) {
        this.jariJari = r;
        this.tinggi = t;
        this.nama = "Tabung";
        hitungLuas();
        hitungVolume();
    }

    void hitungLuas() {
        luasPermukaan = 2 * 3.14 * jariJari * (jariJari + tinggi);
    }

    void hitungVolume() {
        volume = 3.14 * jariJari * jariJari * tinggi;
    }

    void tampil() {
        System.out.println("Luas Permukaan Tabung: " + luasPermukaan);
        System.out.println("Volume Tabung: " + volume);
    }
}