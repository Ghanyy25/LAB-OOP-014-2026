class Kubus extends Persegi {

    Kubus(double sisi) {
        super(sisi);
    }

    double volume() {
        return sisi * sisi * sisi;
    }

    double luasPermukaan() {
        return 6 * luas();
    }
}

class Balok extends PersegiPanjang {
    double t;

    Balok(double p, double l, double t) {
        super(p, l);
        this.t = t;
    }

    double volume() {
        return p * l * t;
    }

    double luasPermukaan() {
        return 2 * ((p * l) + (p * t) + (l * t));
    }
}

class Bola extends Lingkaran {

    Bola(double r) {
        super(r);
    }

    double volume() {
        return (4.0 / 3.0) * Math.PI * r * r * r;
    }

    double luasPermukaan() {
        return 4 * luas();
    }
}

class Tabung extends Lingkaran {
    double t;

    Tabung(double r, double t) {
        super(r);
        this.t = t;
    }

    double volume() {
        return luas() * t;
    }

    double luasPermukaan() {
        return 2 * luas() + keliling() * t;
    }
}
