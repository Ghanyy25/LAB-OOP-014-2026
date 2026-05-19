public class Main {
    public static void main(String[] args) {
        SmartLamp lampu = new SmartLamp("Philips", 10);
        SmartCCTV cctv = new SmartCCTV("Xiaomi", 15);
        SmartSpeaker speaker = new SmartSpeaker("Google Home", 25);

        System.out.println("--- Demo SmartLamp ---");
        lampu.infoPower();
        lampu.prosesPerintah("NYALA");

        System.out.println("\n--- Demo SmartCCTV ---");
        cctv.infoPower();
        cctv.hubungkanWiFi();

        System.out.println("\n--- Demo SmartSpeaker ---");
        speaker.infoPower();
        speaker.cekFungsi();        
        speaker.hubungkanWiFi();   
        speaker.prosesPerintah("Putar Musik"); 
    }
}
