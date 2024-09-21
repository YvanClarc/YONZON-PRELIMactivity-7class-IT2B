package pkg7class;

import java.util.Scanner;

public class Receipt {
    Scanner sc = new Scanner(System.in);
    Receipts[] rc = new Receipts[100];
    int productNum;
    int counter = 0;

    public void getReceipt() {
        boolean status;

        System.out.println("-----------------------");
        System.out.println("\nWELCOME TO RECEIPT APP!");
        System.out.println("\n---------------------");
        
        do {
            System.out.print("\nMain menu:\n1. Add Product\n2. View Product\n3. Exit\nEnter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    inputProduct();
                    status = tryAgain();
                    break;
                case 2:
                    if (counter == 0) {
                        System.out.println("No Products yet!");
                        status = false;
                    } else {
                        System.out.println();
                        view();
                        System.out.println();
                        status = tryAgain();
                    }
                    break;
                case 3:
                    System.out.println("Exiting the Receipt App. Thank you for using!");
                    return;
                default:
                    System.out.println("Error! Try again.");
                    status = false;
            }
        } while (!status);
        
        System.out.println("Thank you for using!");
    }

    public void inputProduct() {
        System.out.println("-------------------------------------------------");
        System.out.print("\nEnter no. of Products: ");
        productNum = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < productNum; i++) {
            System.out.print("\n ID: ");
            String id = sc.nextLine();
            System.out.print(" Product Name: ");
            String name = sc.nextLine();
            System.out.print(" Stock: ");
            double stock = sc.nextDouble();
            System.out.print(" Price: ");
            double price = sc.nextDouble();
            System.out.print(" Sold: ");
            double sold = sc.nextDouble();
            sc.nextLine();
            System.out.println("\n-------------------------------------------------\n");

            rc[counter] = new Receipts();
            rc[counter].storage(id, name, stock, price, sold);
            counter++;
        }
    }

    public void view() {
        for (int i = 0; i < counter; i++) {
            rc[i].display();
        }
    }

    public boolean tryAgain() {
        System.out.print("Enter again? (Y/N): ");
        String choice = sc.next();
        return !choice.equalsIgnoreCase("y");
    }
}