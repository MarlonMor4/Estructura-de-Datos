package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Show Inventory");
            System.out.println("4. Calculate Inventory Value");
            System.out.println("5. Increase Stock");
            System.out.println("6. Reduce Stock");
            System.out.println("0. Exit");
            System.out.print("Enter your option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    inventoryManager.addProduct();
                    break;
                case 2:
                    inventoryManager.removeProduct();
                    break;
                case 3:
                    inventoryManager.displayInventory();
                    break;
                case 4:
                    inventoryManager.calculateInventoryValue();
                    break;
                case 5:
                    inventoryManager.adjustStock(true);
                    break;
                case 6:
                    inventoryManager.adjustStock(false);
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);

        scanner.close();
    }
}
