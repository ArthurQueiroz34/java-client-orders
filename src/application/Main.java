package application;

import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.Client;
import enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);

        System.out.println("How many items to this order? ");
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(productName, productPrice);

            OrderItem it = new OrderItem(quantity, productPrice, product);

            order.addItem(it);
        }
        System.out.println();
        System.out.println(order);

        sc.close();
    }
}