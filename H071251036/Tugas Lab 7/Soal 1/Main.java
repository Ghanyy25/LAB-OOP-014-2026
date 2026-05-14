import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        Gudang gudang = new Gudang(50);

        // Thread Pool
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 2 pemasok
        executor.execute(new Pemasok(gudang));
        executor.execute(new Pemasok(gudang));

        // 3 kurir
        executor.execute(new Kurir(gudang));
        executor.execute(new Kurir(gudang));
        executor.execute(new Kurir(gudang));

        // Thread monitoring
        Thread monitor = new Thread(new Monitoring(gudang));
        monitor.start();

        try {

            // Sistem berjalan 15 detik
            Thread.sleep(15000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Hentikan executor
        executor.shutdown();

        try {

            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Masih ada thread aktif.");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Hentikan monitoring
        monitor.interrupt();

        System.out.println("\nSistem gudang selesai.");
    }
}