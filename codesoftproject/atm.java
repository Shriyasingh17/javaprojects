import java.util.Scanner;

public class atm {

    // Simulating an initial balance
    private static double balance = 1000.00;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to MyBank ATM");
        boolean quit = false;
        int choice;

        while (!quit) {
            printMenu();
            System.out.print("Please enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        System.out.println("Thank you for using MyBank ATM. Goodbye!");
        scanner.close();
    }

    // Method to print the menu options
    private static void printMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");
    }

    // Method to check account balance
    private static void checkBalance() {
        System.out.println("Your current balance: $" + balance);
    }

    // Method to withdraw money
    private static void withdraw() {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal not processed.");
        } else {
            balance -= amount;
            System.out.println("$" + amount + " has been withdrawn. Remaining balance: $" + balance);
        }
    }

    // Method to deposit money
    private static void deposit() {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Deposit not processed.");
        } else {
            balance += amount;
            System.out.println("$" + amount + " has been deposited. New balance: $" + balance);
        }
    }
}

