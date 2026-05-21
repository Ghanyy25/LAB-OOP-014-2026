// 3.
// Untuk mengatur kondisi cuaca yang mempengaruhi pertumbuhan tanaman
public class Cuaca {
    String kondisi;

    // Constructor
    // Kondisi : "Hujan" / "Terik"
    public Cuaca(String kondisi) {
        this.kondisi = kondisi;
    }

    // Hujan mempercepat pertumbuhan tanaman  +10
    // Terik memperlambat pertumbuhan tanaman +2
    public void pengaruh(Tanaman tanaman) {
        if (kondisi.equalsIgnoreCase("Hujan")) {
            System.out.println("Hujan turun deras!");
            tanaman.tumbuh(10);
        } else if (kondisi.equalsIgnoreCase("Terik")) {
            System.out.println("Matahari sangat terik!");
            tanaman.tumbuh(2);
        } else {
            System.out.println("Cuaca tidak dikenali, tanaman tidak bertumbuh.");
        }
    }
}