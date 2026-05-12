import java.util.ArrayList;
import java.util.Scanner;


public class OrderMain {
    public static void main(String[] args) {

        class Order {
    String product;
    private double price;
    private int quantity;

    Order(String product, double price, int quantity) throws Exception {

        if (price <= 0)
            throw new Exception("Unit price must be greater than zero.");

        if (quantity <= 0)
            throw new Exception("Quantity must be greater than zero.");

        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    
    public double calculateTotal() {
        return price * quantity;
    }

    
    @Override
    public String toString() {
        return product + " - " + quantity + " pcs x " + price + " = " + calculateTotal();
    }
}


        Scanner sc = new Scanner(System.in);
        ArrayList<Order> orders = new ArrayList<>();

        System.out.println("--- Welcome to BaseCase Shop ---");

        System.out.print("How many items do you want to purchase? ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        if (n > 5) {
            System.out.println("Maximum 5 items allowed. Setting to 5.");
            n = 5;
        }

        for (int i = 1; i <= n; i++) {

            System.out.print("Enter Product " + i + " Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();
            sc.nextLine(); // clear buffer

            try {
                Order order = new Order(name, price, qty);
                orders.add(order);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + " Skipping item.");
            }
        }


        double subtotal = 0;
        for (Order o : orders) {
            subtotal += o.calculateTotal();
        }

        
        double discountRate;
        if (subtotal > 100) {
            discountRate = 0.20;
        } else if (subtotal > 50) {
            discountRate = 0.10;
        } else {
            discountRate = 0.05;
        }

        double discountAmount = subtotal * discountRate;

       
        double deliveryFee = (subtotal < 50) ? 10 : 0;

     
        double finalTotal = subtotal - discountAmount + deliveryFee;

     
        System.out.println("\n--- Final Receipt ---");

        int count = 1;
        for (Order o : orders) {
            System.out.println("Item " + count + ": " + o);
            count++;
        }

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount Applied (" + (int)(discountRate * 100) + "%): " + discountAmount);
        System.out.println("Delivery Fee: " + deliveryFee);
        System.out.println("Final Total: " + finalTotal);
        System.out.println("--------------------------");
    }
}