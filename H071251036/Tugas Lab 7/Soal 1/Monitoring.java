public class Monitoring implements Runnable {

    private final Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            try {

                System.out.println("\n===== STATUS GUDANG =====");
                System.out.println(
                        "Stok : "
                                + gudang.getStok()
                                + "/"
                                + gudang.getKapasitasMaksimal());
                System.out.println("=========================\n");

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                System.out.println("Monitoring dihentikan.");
                Thread.currentThread().interrupt();
            }
        }
    }
}