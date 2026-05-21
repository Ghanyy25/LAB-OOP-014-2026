public class Main2 {
    public static void main(String[] args) {
        SmartLamp lampu = new SmartLamp("Philips", 12);
        SmartCctv cctv = new SmartCctv("Eyesec", 20 );
        SmartSpeaker speaker = new SmartSpeaker("Jbl", 15);

        System.out.println("=== Smart Lamp ===");
        lampu.cekFungsi();
        lampu.infoPower();  
        lampu.prosesPerintah("NYALA");
        
        System.out.println("\n=== Smart CCTV ===");
        cctv.cekFungsi();   
        cctv.infoPower();
        cctv.hubungkanWifi();

        System.out.print("\n=== Smart Speaker ===");
        speaker.cekFungsi();
        speaker.infoPower();
        speaker.hubungkanWifi();
        speaker.prosesPerintah("Putar lagu LNGSHOT");
    }
}