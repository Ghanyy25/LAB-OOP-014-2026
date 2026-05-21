public class SmartCctv extends PerangkatElektronik implements InteraksiInternet {
    
    public SmartCctv(String merk, int dayaListrik){
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi(){
        System.out.println("CCTV sebagai pengawasan rumah.");
    }

    @Override
    public void hubungkanWifi() {
        System.out.println("Mengirim data ke server...");
    }
}
