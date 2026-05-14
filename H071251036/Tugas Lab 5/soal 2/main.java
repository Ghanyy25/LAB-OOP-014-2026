public class main {
    public static void main(String[] args) {

        SmartLamp lamp = new SmartLamp("Philips", 10);
        lamp.cekFungsi();
        lamp.infoPower();
        lamp.prosesPerintah("NYALA");

        System.out.println();

        SmartCCTV cctv = new SmartCCTV("Xiaomi", 20);
        cctv.cekFungsi();
        cctv.infoPower();
        cctv.hubungkanWiFi();

        System.out.println();

        SmartSpeaker speaker = new SmartSpeaker("Google", 15);
        speaker.cekFungsi();
        speaker.infoPower();
        speaker.hubungkanWiFi();
        speaker.prosesPerintah("Putar musik");
    }
}