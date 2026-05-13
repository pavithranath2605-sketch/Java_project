import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a transaction
class Transaction {
    String type; // "Income" or "Expense"
    String category;
    double amount;

    public Transaction(String type, String category, double amount) {
        this.type = type;
        this.category = category;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + " | " + category + " | $" + amount;
    }
}

// Main Personal Finance Tracker class
public class PersonalFinanceTracker {

    private final ArrayList<Transaction> transactions;
    private double totalIncome;
    private double totalExpenses;

    public PersonalFinanceTracker() {
        transactions = new ArrayList<>();
        totalIncome = 0.0;
        totalExpenses = 0.0;
    }

    // Method to add a transaction
    public void addTransaction(String type, String category, double amount) {
        transactions.add(new Transaction(type, category, amount));
        if (type.equalsIgnoreCase("Income")) {
            totalIncome += amount;
        } else if (type.equalsIgnoreCase("Expense")) {
            totalExpenses += amount;
        }
    }

    // Method to display the summary
    public void displaySummary() {
        System.out.println("\n--- Financial Summary ---");
        System.out.println("Total Income: $" + totalIncome);
        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Net Savings: $" + (totalIncome - totalExpenses));
        System.out.println("\nTransactions:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    // Main method to run the tracker
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonalFinanceTracker tracker = new PersonalFinanceTracker();

        System.out.println("Welcome to the Personal Finance Tracker!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Summary");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter type (Income/Expense): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter category (e.g., Food, Rent, Salary): ");
                    String category = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    tracker.addTransaction(type, category, amount);
                    System.out.println("Transaction added successfully!");
                    break;

                case 2:
                    tracker.displaySummary();
                    break;

                case 3:
                    System.out.println("Exiting Personal Finance Tracker. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
