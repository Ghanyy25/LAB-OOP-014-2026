import java.util.ArrayList;
import java.util.Scanner;

public class DompetDihgital {
    Scanner bega = new Scanner(System.in);
    private int pin;
    protected int norek;
    String nama;
    private int saldo;
    ArrayList <String> log = new ArrayList<>(){};

    public DompetDihgital(String nama, int norek, int pin) {
        this.nama = nama;
        this.norek = norek;
        this.pin = pin;
    }


    public void getDataNasabah() {
        System.out.println("=========DATA NASABAH=========");
        System.out.println("Nama: " + this.nama);
        System.out.println("No Rekening: " + this.norek);
        System.out.println("isi Saldo: "+ this.saldo);
    }

    public void getSaldo() {
        System.out.println("Isi Saldo: "+this.saldo);
    }

    public void setPin(int newPin) {
        System.out.print("Masukkan Pin Lama: ");
        int validasiSetPin = bega.nextInt();
        if (this.pin != validasiSetPin) {
            System.out.println("Pin Lama Salah!");
        }
        else{
            String pinStr = String.valueOf(newPin);

            if (pinStr.length() != 6) {
                System.out.println("Input Invalid!");
            }
            else {
                this.pin = newPin;
                System.out.println("Pin Berhasil Diganti");
            }
        }
    }

    public void setorTunai(int jumlah) {
        System.out.print("Masukkan Pin: ");
        int validasiSetor = bega.nextInt();
        if (validasiPin(validasiSetor)) {
            System.out.println("Pin Salah!");
        }
        else{
            this.saldo += jumlah;
            System.out.println("Setor Tunai Berhasil Sebesar: " + jumlah);
        }
    }

    public boolean validasiPin(int pin){
        if (this.pin == pin) {
            
            return false;
        }
        else{
            return true;
        }
    }

    public void tarikTunai(int jumlah) {
        System.out.print("Masukkan Pin: ");
        int validasiSetor = bega.nextInt();

        if (validasiPin(validasiSetor)) {
            
             System.out.println("Pin Salah!");
        }
        else{
           if (this.saldo < jumlah) {
                System.out.println("Saldo Anda Tidak Cukup!");
            }
            else {
                this.saldo -= jumlah;
                System.out.println("Tarik Tunai Berhasil Sebesar: " + jumlah);
                logRiwayat(this.nama +" Menarik tunai");
            }
        }
    }

    void logRiwayat(String log1) {
        this.log.add(log1);
        System.out.println(log.size());
        // System.out.println(log.get(0));
    }

    public void getLog(){
        for (int i = 0; i < log.size() ; i++){
            System.out.println(log.get(i));
            System.out.println("p");
        }
        // for (int index = 0; index < array.length; index++) {
            
        // }
        
    }
}
