
import java.util.Scanner;

public class Awalhossain {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        String product;
        double price, subtotal;
        double discount_amount;
        double final_amount;
        int quantity;

        System.out.println("Welcome to my shop");

        System.out.println("Enter product name: ");
        product = input.next();

        System.out.println("Enter price: ");
        price = input.nextDouble();

        System.out.print("Enter quantity: ");
        quantity = input.nextInt();

        System.out.println("----- Final Receipt -----");

        subtotal = price * quantity;
        System.out.println("Subtotal: $" + subtotal);

       discount_amount = 0.15 * subtotal;
        System.out.println("Discount Amount: $" + discount_amount);

        final_amount =subtotal - discount_amount;
        System.out.println("Total (Rounded Down): " + (int)final_amount);
    }
}
