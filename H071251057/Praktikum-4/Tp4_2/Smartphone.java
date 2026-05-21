class Smartphone extends Product {
    double screenSize;
    int storageCapacity;

    public Smartphone(String brand, int seriesNumber, double price, double screenSize, int storageCapacity) {
        super(brand, seriesNumber, price); 
        this.screenSize = screenSize; 
        this.storageCapacity = storageCapacity;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Screen Size: " + screenSize + " inch");
        System.out.println("Storage Capacity: " + storageCapacity + "GB\n");
    }
}