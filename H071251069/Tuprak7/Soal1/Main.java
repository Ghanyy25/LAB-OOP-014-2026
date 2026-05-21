package Tugas7.soal1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("========================================");
        System.out.println("   SISTEM GUDANG PUSAT DIMULAI");
        System.out.println("========================================");

        Gudang gudang = new Gudang(50);

        ExecutorService poolPemasok = Executors.newFixedThreadPool(2);
        ExecutorService poolKurir = Executors.newFixedThreadPool(3);

        poolPemasok.submit(new Pemasok(gudang, "Pemasok-1"));
        poolPemasok.submit(new Pemasok(gudang, "Pemasok-2"));

        poolKurir.submit(new Kurir(gudang, "Kurir-1"));
        poolKurir.submit(new Kurir(gudang, "Kurir-2"));
        poolKurir.submit(new Kurir(gudang, "Kurir-3"));

        Thread threadMonitoring = new Thread(new Monitoring(gudang));
        threadMonitoring.start();

        System.out.println("Sistem berjalan selama 15 detik...\n");
        Thread.sleep(15000);

        System.out.println("\n========================================");
        System.out.println("   MENGHENTIKAN SISTEM...");
        System.out.println("========================================");

        poolPemasok.shutdownNow();
        poolKurir.shutdownNow();
        threadMonitoring.interrupt();

        poolPemasok.awaitTermination(5, TimeUnit.SECONDS);
        poolKurir.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("\nSemua thread telah berhenti. Program selesai.");
        System.out.println("Stok akhir di gudang: " + gudang.getStok());
    }
}