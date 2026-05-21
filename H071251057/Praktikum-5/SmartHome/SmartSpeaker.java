public class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {
    
    public SmartSpeaker(String merk, int dayaListrik){
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi(){
        System.out.println("Speaker sebagai pemutar musik dan asisten suara.");
    }

    @Override
    public void  hubungkanWifi() {
        System.out.println("Speaker terhubung ke WiFi.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("Memproses perintah: " + perintah);
    }
}
