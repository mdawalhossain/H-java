import java.util.Scanner;

public class basicshop {

    public static void main(String[] args) {
        System.out.println("--Welcome BaseCase Shop---");

        Scanner input = new Scanner(System.in);

        int n;
        double subtotal = 0;
        double discount = 0;

        System.out.print("How many items do you want to purchase? ");
        n = input.nextInt();

        if (n > 5) {
            System.out.println("Maximum 5 items are valid");
            return; 
        }

        String[] productNames = new String[n];
        double[] prices = new double[n];
        int[] quantities = new int[n];

        
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for item " + (i + 1));

            System.out.print("Product name: ");
            productNames[i] = input.next();

            System.out.print("Price: ");
            prices[i] = input.nextDouble();

            if (prices[i] <= 0) {
                System.out.println("Invalid price!");
                return;
            }

            System.out.print("Quantity: ");
            quantities[i] = input.nextInt();

            if (quantities[i] <= 0) {
                System.out.println("Invalid quantity!");
                return;
            }
        }

        
        for (int i = 0; i < n; i++) {
            double itemTotal = prices[i] * quantities[i];
            subtotal += itemTotal;
        }

        
        if (subtotal > 100) {
            discount = subtotal * 0.20;
        } else if (subtotal > 50) {
            discount = subtotal * 0.10;
        } else {
            discount = 0;
        }

        
        double deliveryFee = (subtotal < 50) ? 10 : 0;

        double finalTotal = subtotal - discount + deliveryFee;

          System.out.println("********");

        
        System.out.println("\n--- Final Receipt ---");

        for (int i = 0; i < n; i++) {
            System.out.println(productNames[i] + " - " + prices[i] + " x " 
                    + quantities[i] + " = " + (prices[i] * quantities[i]));
        }

        System.out.println("-------------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount: " + discount);
        System.out.println("Delivery Fee: " + deliveryFee);
        System.out.println("Final Total: " + finalTotal);
        System.out.println("-------------------------");
    }
}