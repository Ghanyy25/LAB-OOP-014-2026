class product {
    protected String brand;
    protected int seriesnumber;
    double price;

    public product(){
        
    }

    public product(String brand, int seriesnumber, double price) {
        this.brand = brand;
        this.seriesnumber = seriesnumber;
        this.price = price;
    }

    void displayInfo() {
        System.out.println("NAMA BRAND: " + brand );
        System.out.println("SERIES NUMBER: " + seriesnumber );
        System.out.println("PRICE: " +"Rp "+ price );
    }

    void validasi(int n){
        if (n <= 0) {
            System.out.println("Input tidak valid. Harap masukkan angka positif.");
        }
    }

}

