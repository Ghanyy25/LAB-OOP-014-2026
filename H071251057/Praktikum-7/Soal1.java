import java.util.Random; 

class Gudang { 
    private int stok; 
    private int kapasitasMaksimal; 

    public Gudang(int kapasitasMaksimal) { 
        this.kapasitasMaksimal = kapasitasMaksimal;
        this.stok = 0;
    }
    
    public synchronized void tambahStok(int jumlah, String namaPemasok) 
        throws InterruptedException {
        while (stok + jumlah > kapasitasMaksimal) { 
            System.out.println(namaPemasok + " mohon menunggu, gudang sedang penuh...\n");
            wait(); 
        }
        stok += jumlah;
        System.out.println(namaPemasok + " menambahkan " + jumlah + " barang");
        System.out.println("Stok: " + stok + "\n");
        notifyAll(); 
    }

    public synchronized void ambilStok(int jumlah, String namaKurir)
        throws InterruptedException {
        while (stok < jumlah) {
            System.out.println(namaKurir + " mohon menunggu, stok tidak cukup...\n");
            wait();
        }
        stok -= jumlah;
        System.out.println(namaKurir + " mengambil " + jumlah + " barang " );
        System.out.println("Stok: " + stok + "\n");
        notifyAll();
    }

    public synchronized int getStok() {
        return stok; 
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal; 
    }
}

class Pemasok extends Thread {
    private Gudang gudang; 
    private Random random; 

    public Pemasok(Gudang gudang, String namaThread) {
        this.gudang = gudang;
        random = new Random();
        setName(namaThread); 
    }
    
    @Override 
    public void run() { 
        while (true) {
            try {
                int jumlah = random.nextInt(10) + 1; 
                gudang.tambahStok(jumlah, getName());
                int waktu = (random.nextInt(2) + 1) * 1000; 
                Thread.sleep(waktu); 
            } catch (InterruptedException e) { 
                System.out.println(getName() + " berhenti.");
                break;
            }
        }
    }
}

class Kurir extends Thread {
    private Gudang gudang;
    private Random random;

    public Kurir(Gudang gudang, String namaThread) {
        this.gudang = gudang;
        random = new Random();
        setName(namaThread);
    }

    @Override
    public void run() {
        while (true) {
            try {
                int jumlah = random.nextInt(8) + 1; 
                gudang.ambilStok(jumlah, getName());
                int waktu = (random.nextInt(2) + 2) * 1000; 
                Thread.sleep(waktu);
            } catch (InterruptedException e) {
                System.out.println(getName() + " berhenti.");
                break;
            }
        }
    }
}

class Monitoring extends Thread {
    private Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override 
    public void run() {
        while (true) {
            try {
                int stok = gudang.getStok();
                int kapasitas = gudang.getKapasitasMaksimal();
                int persen = (stok * 100) / kapasitas; 
                int jumlahBar = persen / 5;
                String visual = "[";
                for (int i = 0; i < 20; i++) {
                    if (i < jumlahBar) {
                        visual += "#";
                    } else {
                        visual += "-";
                    }
                }
                visual += "]";
                System.out.println("Status Gudang: " + visual + " " + persen + "%\n");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Monitoring berhenti.");
                break;
            }
        }
    }
}

public class Soal1 {
    public static void main(String[] args) {
        Gudang gudang = new Gudang(100);
        Pemasok pemasok1 = new Pemasok(gudang, "Pemasok-1");
        Pemasok pemasok2 = new Pemasok(gudang,"Pemasok-2");
        Kurir kurir1 = new Kurir(gudang,"Kurir-1");
        Kurir kurir2 = new Kurir(gudang,"Kurir-2");
        Kurir kurir3 = new Kurir(gudang,"Kurir-3");
        Monitoring monitoring = new Monitoring(gudang);

        pemasok1.start();
        pemasok2.start();
        kurir1.start();
        kurir2.start();
        kurir3.start();
        monitoring.start();

        try {
            Thread.sleep(5000);
            pemasok1.interrupt();
            pemasok2.interrupt();
            kurir1.interrupt();
            kurir2.interrupt();
            kurir3.interrupt();
            monitoring.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}