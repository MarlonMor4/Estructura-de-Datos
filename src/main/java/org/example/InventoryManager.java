package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class InventoryManager {
    private List<Product> productList;

    public InventoryManager() {
        this.productList = new ArrayList<>();
    }

    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n== Add Product ==");
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product stock: ");
        int stock = scanner.nextInt();
        Product newProduct = new Product(id, name, price, stock);
        productList.add(newProduct);
        System.out.println("Product added successfully.");
    }

    public void removeProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n== Remove Product ==");
        System.out.print("Enter product ID to remove: ");
        int idToRemove = scanner.nextInt();
        Product productToRemove = null;
        for (Product product : productList) {
            if (product.getId() == idToRemove) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            productList.remove(productToRemove);
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Error: Product with ID " + idToRemove + " not found.");
        }
    }

    public void displayInventory() {
        if (productList.isEmpty()) {
            System.out.println("The inventory is empty.");
        } else {
            System.out.println("=== Product Inventory ===");
            for (Product product : productList) {
                System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Price: " +
                        product.getPrice() + ", Stock: " + product.getStock());
            }
        }
    }

    public void calculateInventoryValue() {
        double totalValue = 0;
        for (Product product : productList) {
            totalValue += product.calculateInventoryValue();
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    public void adjustStock(boolean increase) {
        Scanner scanner = new Scanner(System.in);
        String operation = increase ? "Increase" : "Reduce";
        System.out.println("\n== " + operation + " Stock ==");
        System.out.print("Enter product ID: ");
        int idToAdjust = scanner.nextInt();
        Product productToAdjust = null;
        for (Product product : productList) {
            if (product.getId() == idToAdjust) {
                productToAdjust = product;
                break;
            }
        }
        if (productToAdjust != null) {
            System.out.print("Enter quantity to " + operation.toLowerCase() + ": ");
            int quantity = scanner.nextInt();
            if (increase) {
                productToAdjust.increaseStock(quantity);
            } else {
                productToAdjust.reduceStock(quantity);
            }
            System.out.println("Stock updated successfully.");
        } else {
            System.out.println("Error: Product with ID " + idToAdjust + " not found.");
        }
    }
}