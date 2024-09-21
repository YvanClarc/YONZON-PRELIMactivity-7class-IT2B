package pkg7class;

import java.util.Scanner;

public class Salaries {

    public void getSalary() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------");
        System.out.println("\nWECOME TO SALARY APP!");
        System.out.println("\n---------------------");
        System.out.print("\nEnter no. of Employees: ");
        int numEmployees = sc.nextInt();
        sc.nextLine();

        Salary[] employees = new Salary[numEmployees]; 
        double totalSalaryRequest = 0;
        double totalDeduction = 0;
        double totalNetPay = 0;

       
        for (int i = 0; i < numEmployees; i++) {
            System.out.println("Enter details of employee: " + (i + 1));

            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Rate: ");
            double rate = sc.nextDouble();

            System.out.print("Hours Worked: ");
            int hoursWorked = sc.nextInt();

            System.out.print("Deduction: ");
            double deduction = sc.nextDouble();
            sc.nextLine();

            //Salary object
            employees[i] = new Salary(id, name, rate, hoursWorked, deduction);
            totalSalaryRequest += employees[i].calculateGross();
            totalDeduction += employees[i].deduction;
            totalNetPay += employees[i].calculateNetPay();
        }

        //salary details
        System.out.println("--------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                "ID", "Name", "Rate", "Hours", "Gross", "Deduction", "Netpay");

        for (Salary employee : employees) {
            System.out.printf("%-10s %-10s %-10.2f %-10d %-10.2f %-10.2f %-10.2f\n",
                    employee.id,
                    employee.name,
                    employee.rate,
                    employee.hoursWorked,
                    employee.calculateGross(),
                    employee.deduction,
                    employee.calculateNetPay()
            );
        }

        //total calculations
        System.out.println("--------------------------------------------------");
        System.out.printf("Total Salary Request: %.2f\n", totalSalaryRequest);
        System.out.printf("Total Employee Deduction: %.2f\n", totalDeduction);
        System.out.printf("Total Netpay: %.2f\n", totalNetPay);
        System.out.printf("No. of Employees: %d\n", numEmployees);

        sc.close();
    }
}