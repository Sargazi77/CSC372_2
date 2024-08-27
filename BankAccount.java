// This class manages the bank account, allowing deposits, withdrawals, and balance checking.
public class BankAccount {
    // The balance of the bank account
    private double balance;

    // Constructor that initializes the balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance; // Set the starting balance
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) { // Check that the deposit amount is positive
            balance += amount; // Add the amount to the balance
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) { // Ensure there's enough balance to withdraw
            balance -= amount; // Subtract the amount from the balance
        }
    }
}