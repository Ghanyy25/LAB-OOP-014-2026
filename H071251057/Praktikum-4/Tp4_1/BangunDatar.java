class Persegi {
    double sisi;

    Persegi(double sisi) {
        this.sisi = sisi;
    }

    double luas() {
        return sisi * sisi;
    }

    double keliling() {
        return 4 * sisi;
    }
}

class PersegiPanjang {
    double p, l;

    PersegiPanjang(double p, double l) {
        this.p = p;
        this.l = l;
    }

    double luas() {
        return p * l;
    }

    double keliling() {
        return 2 * (p + l);
    }
}

class Lingkaran {
    double r;

    Lingkaran(double r) {
        this.r = r;
    }

    double luas() {
        return Math.PI * r * r;
    }

    double keliling() {
        return 2 * Math.PI * r;
    }
}

class Trapesium {
    double a;
    double b;
    double c;
    double d;
    double t;

    Trapesium(double a, double b, double c, double d, double t) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.t = t;
    }

    double luas() {
        return 0.5 * (a + b) * t;
    }

    double keliling() {
        return a + b + c + d;
    }
}