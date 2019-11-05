package assignment01;

import java.util.Scanner;

public class Product {
    private static int idCounter = 1;
    private String name;
    private int id;
    private int price;
    private int quantity;

    public Product() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter product's name:");
        setName(scan.nextLine());
        System.out.println("Enter product's price:");
        setPrice(getInt());
        System.out.println("Enter product's quantity:");
        setQuantity(getInt());
        setId(idCounter++);
    }

    public Product(String name, int price, int quantity) {
        setName(name);
        setId(idCounter++);
        setPrice(price);
        setQuantity(quantity);
    }

    private int getInt() {
        Scanner scan = new Scanner(System.in);
        int n = 0;
        while (n <= 0) {
            if (!scan.hasNextInt()) {
                System.out.println("Data must a number. Enter again: ");
            }
            n = scan.nextInt();
            if (n <= 0) {
                System.out.println("The number must be larger than 0. Enter again: ");
            }
        }
        return n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
