package pkg7class;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Salaries slr = new Salaries();
        Receipt rc = new Receipt();
        Account acc = new Account();

        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("-------------------------------------------");
            System.out.println("\nPlease select an App you would like to use.");
            System.out.println("\n1. Salary");
            System.out.println("\n2. Receipt");
            System.out.println("\n3. Account");
            System.out.println("\n4. Exit");
            System.out.println("-------------------------------------------");
            System.out.print("\nEnter Option: ");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    slr.getSalary();
                    break;
                case 2:
                    rc.getReceipt();
                    break;
                case 3:
                    acc.getAccount();
                    break;
                case 4:
                    System.out.println("Exiting the program. Thank you for using!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);

        sc.close();
    }
}
