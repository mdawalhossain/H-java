class Order {
    String name;
    private double price;
    private int quantity;

    
    Order(String name, double price, int quantity) throws Exception {

        if (price <= 0)
            throw new Exception("Price must be greater than 0!");

        if (quantity <= 0)
            throw new Exception("Quantity must be greater than 0!");

        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Setter
    public void setUnitPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Unit price cannot be negative");
        }
        this.price = price;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        this.quantity = quantity;
    }

    // Total price method
    public double totalPrice() {
        return price * quantity;
    }

    // toString override
    @Override
    public String toString() {
        return name + " - " + quantity + " pcs x " + price +
                " = " + totalPrice();
    }
}

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("--- Order Test ---");

            Order  o1 = new Order("Gaming Mouse", 25.75, 3);
            Order o2 = new Order("Mechanical Keyboard", 120.0, 1);

            System.out.println(o1);
            System.out.println(o2);

            System.out.println("\n--- Invalid Order Attempt ---");

            Order o3 = new Order("Laptop", -1000, 1); // ❌ error

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
