class Product {
    String brand;
    int seriesNumber;
    double price;

    public Product(String brand, int seriesNumber, double price) {
        this.brand = brand;
        this.seriesNumber = seriesNumber;
        this.price = price;
    }

    public int SeriesNumber() {
        return seriesNumber;
    }
    public void displayInfo() {
        System.out.println("\nBrand: " + brand);
        System.out.println("Serial Number: " + seriesNumber);
        System.out.println("Price: $" + price); 
    }
}