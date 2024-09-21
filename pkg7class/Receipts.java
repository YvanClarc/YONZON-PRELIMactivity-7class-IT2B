package pkg7class;

public class Receipts {
    String id;
    String name;
    double stock;
    double price;
    double sold;

    public void storage(String id, String name, double stock, double price, double sold) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.sold = sold;
    }

    public void display() {
        double totalProfit = this.sold * this.price;
        double expectedProfit = this.stock * this.price;

        System.out.println("Product ID: " + this.id);
        System.out.println("------------------------------------------");
        System.out.println("Product Name: " + this.name);
        System.out.println("Stock: " + this.stock);
        System.out.println("Price: " + this.price);
        System.out.println("Sold: " + this.sold);
        System.out.println("------------------------------------------");
        System.out.printf("Total Profit: %.2f\n", totalProfit);
        System.out.println("Status: " + (this.stock > this.sold ? "Available" : "Unavailable"));
        System.out.printf("Total Expected Profit: %.2f\n", expectedProfit);
    }
}
