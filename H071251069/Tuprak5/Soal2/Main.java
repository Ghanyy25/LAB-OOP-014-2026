package Tuprak5.Soal2;

public class Main {
    public static void main(String[] args) {

        System.out.println("==SMART LAMP==");
        SmartLamp lamp = new SmartLamp("Xiaomi", 07);
        lamp.cekFungsi();
        lamp.infoPower();
        lamp.prosesPerintah("NYALA");

        System.out.println("\n==SMART CCTV==");
        SmartCCTV cctv = new SmartCCTV("LG", 24);
        cctv.cekFungsi();
        cctv.infoPower();
        cctv.hubungkanWiFi();

        System.out.println("\n==SMART SPEAKER==");
        SmartSpeaker speaker = new SmartSpeaker("DJ", 25);
        speaker.cekFungsi();
        speaker.infoPower();
        speaker.hubungkanWiFi();
        speaker.prosesPerintah("Putar musik Pop");
    }
}
