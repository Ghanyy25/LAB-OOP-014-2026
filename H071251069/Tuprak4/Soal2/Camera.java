package Soal2;

public class Camera extends Produk {
    int resolusi;
    String tipeLensa;

    public Camera(String merk, int nomorSeri, double harga, int resolusi, String tipeLensa) {
        super(merk, nomorSeri, harga);
        this.resolusi = resolusi;
        this.tipeLensa = tipeLensa;
    }

    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("Resolution: " + resolusi + "MP");
        System.out.println("Lens Type: " + tipeLensa);
    }
}