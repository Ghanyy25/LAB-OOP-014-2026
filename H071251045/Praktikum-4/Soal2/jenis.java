
class hp extends product{
    double screenSize;
    int storageCapacity;
    
    public hp(String brand, int seriesnumber, double price, double screenSize, int storageCapacity) {
        // super(brand, seriesnumber, price);
        this.screenSize = screenSize;
        this.storageCapacity = storageCapacity;
    }

    void displayInfo() {
        System.out.println("\nNAMA BRAND: " + brand );
        System.out.println("SERIES NUMBER: " + seriesnumber );
        System.out.println("PRICE: " +"Rp "+ price );    
        System.out.println("SCREEN SIZE: " + screenSize +" Inches" );
        System.out.println("STORAGE CAPACITY: " + storageCapacity + "GB" );
    }

}
class laptop extends product {
    double RamSize;
    String processorType;

    public laptop(String brand, int seriesnumber, double price, double RamSize, String processorType) {
        super(brand, seriesnumber, price);
        this.RamSize = RamSize;
        this.processorType = processorType;
    }

    void displayInfo() {

        System.out.println("\nNAMA BRAND: " + brand ) ;
        System.out.println("SERIES NUMBER: " + seriesnumber ) ;
        System.out.println("PRICE: " +"Rp "+ price );
        System.out.println("RAM SIZE: " + RamSize +"GB");
        System.out.println("PROCESSOR TYPE: " + processorType );
        
    }
}

class camera extends product {
    double resolution;
    String lensType;

    public camera(String brand, int seriesnumber, double price, double resolution, String lensType) {
        super(brand, seriesnumber, price);
        this.resolution = resolution;
        this.lensType = lensType;
    }

    void displayInfo() {
        System.out.println("\nNAMA BRAND: " + brand );
        System.out.println("SERIES NUMBER: " + seriesnumber );
        System.out.println("PRICE: " +"Rp "+ price) ;
        System.out.println("RESOLUTION: " + resolution +"MP"    );
        System.out.println("LENS TYPE: " + lensType );
    }

}
