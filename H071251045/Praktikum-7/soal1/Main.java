package soal1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) {
        Gudang gudang = new Gudang(20);
        ExecutorService eksekutor = Executors.newFixedThreadPool(6);

        eksekutor.execute(new Pemasok(gudang));
        eksekutor.execute(new Pemasok(gudang));

        eksekutor.execute(new Kurir(gudang));
        eksekutor.execute(new Kurir(gudang));
        eksekutor.execute(new Kurir(gudang));

        eksekutor.execute(new Monitoring(gudang));

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        eksekutor.shutdownNow();
        try {
            if (eksekutor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Semua thread berhasil dihentikan.");
            } else {
                System.out.println("Masih ada thread yang berjalan.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Program selesai.");
    }
}