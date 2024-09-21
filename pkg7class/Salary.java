package pkg7class;

public class Salary {
    String id;
    String name;
    double rate;
    int hoursWorked;
    double deduction;
    
    Salary (String id, String name, double rate, int hoursWorked, double deduction) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.hoursWorked = hoursWorked;
        this.deduction = deduction;
    }
    // Method to calculate the gross salary
    double calculateGross() {
        return rate * hoursWorked;
    }
    // Method to calculate the net pay
    double calculateNetPay() {
        return calculateGross() - deduction;
    }
   
}
