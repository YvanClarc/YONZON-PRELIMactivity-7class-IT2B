package pkg7class;

import java.util.Scanner;

public class Account {
    Scanner sc = new Scanner(System.in);
    Accounts[] ac = new Accounts[100];
    int accountNum;
    int counter = 0;

    public void getAccount() {
        boolean status;

        System.out.println("------------------------");
        System.out.println("\nWELCOME TO ACCOUNT APP!");
        System.out.println("\n----------------------");

        do {
            System.out.print("\nMain menu:\n1. Add Account\n2. View Account\n3. Exit\nEnter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    inputAccount();
                    status = tryAgain();
                    break;
                case 2:
                    if (counter == 0) {
                        System.out.println("No Accounts yet!");
                        status = false;
                    } else {
                        System.out.println();
                        System.out.println(" -------------------------------------------------------------------------------------");
                        System.out.printf(" %-10s %-10s %-10s %-10s %-10s %-10s\n",
                                "ID", "First Name", "Last Name", "Email", "User", "Password");
                        System.out.println(" -------------------------------------------------------------------------------------");
                        view();
                        System.out.println();
                        status = tryAgain();
                    }
                    break;
                case 3:
                    System.out.println("Exiting the Account App. Thank you for using!");
                    return;  // Exit the method
                default:
                    System.out.println("Error! Try again.");
                    status = false;
            }
        } while (!status);

        System.out.println("Thank you for using!");
    }

    public void inputAccount() {
        System.out.println("-------------------------------------------------");
        System.out.print("\n(1) Enter no. of Accounts: ");
        accountNum = sc.nextInt();
        sc.nextLine();  // Consume newline

        for (int i = 0; i < accountNum; i++) {
            System.out.print("\n ID: ");
            String id = sc.nextLine();
            System.out.print(" First Name: ");
            String fname = sc.nextLine();
            System.out.print(" Last Name: ");
            String lname = sc.nextLine();
            System.out.print(" Email: ");
            String email = sc.nextLine();
            System.out.print(" User: ");
            String user = sc.nextLine();
            String pass;

            while (true) {
                System.out.print(" Password: ");
                pass = sc.nextLine();
                if (passCheck(pass)) {
                    break;
                }
            }

            System.out.println("\n-------------------------------------------------\n");

            ac[counter] = new Accounts();
            ac[counter].storage(id, fname, lname, email, user, pass);
            counter++;
        }
    }

    public void view() {
        for (int i = 0; i < counter; i++) {
            ac[i].display();
        }
    }

    public boolean tryAgain() {
        System.out.print("Enter again? (Y/N): ");
        String choice = sc.next();
        return !choice.equalsIgnoreCase("y");
    }

    public boolean passCheck(String pass) {
        boolean valid = true;

        if (pass == null || pass.isEmpty()) {
            System.out.println("Is Empty!");
            return false;
        }
        if (pass.length() < 8) {
            System.out.println("Password must be at least 8 characters long!");
            valid = false;
        }
        if (!pass.matches(".*[a-z].*")) {
            System.out.println("Must contain at least 1 lowercase letter!");
            valid = false;
        }
        if (!pass.matches(".*[A-Z].*")) {
            System.out.println("Must contain at least 1 uppercase letter!");
            valid = false;
        }
        if (!pass.matches(".*[0-9].*")) {
            System.out.println("Password must have at least 1 digit!");
            valid = false;
        }
        if (!pass.matches(".*[!@#$%&+=].*")) {
            System.out.println("Must contain at least 1 special character!");
            valid = false;
        }

        String[] commonPW = {"admin", "user", "password", "1234"};

        for (String commonPass : commonPW) {
            if (pass.toLowerCase().contains(commonPass)) {
                System.out.println("Must not have common names! e.g., admin, 1234, password");
                valid = false;
                break;
            }
        }

        return valid;
    }
}