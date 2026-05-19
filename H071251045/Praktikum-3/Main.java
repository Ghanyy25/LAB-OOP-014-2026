public class Main {
    public static void main(String[] args) {
        DompetDihgital dompet1 = new DompetDihgital("Rifat UI",123456677, 123456);

        dompet1.getDataNasabah();
        // dompet1.getSaldo();
        // dompet1.getSaldo();
        dompet1.setorTunai(500000);
        dompet1.getSaldo();
        dompet1.tarikTunai(500000);
        dompet1.getSaldo();
        // dompet1.getLog();
    }

}
