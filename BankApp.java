import javax.swing.*; // Import Swing components for creating the GUI
import java.awt.event.ActionEvent; // Import for handling button actions
import java.awt.event.ActionListener; // Import for listening to actions

// Main class that creates the GUI for the Bank Balance Application
public class BankApp {
    private JFrame frame; // The main window
    private JPanel panel; // The panel that holds components
    private JTextField balanceField; // Displays the current balance
    private JTextField amountField; // Field for entering deposit/withdrawal amounts
    private JLabel balanceLabel; // Label for the balance
    private JButton depositButton; // Button to deposit money
    private JButton withdrawButton; // Button to withdraw money
    private JButton exitButton; // Button to exit the application
    private BankAccount account; // The bank account being managed

    // Constructor to set up the GUI
    public BankApp() {
        account = new BankAccount(0.0); // Start with an initial balance of 0.0

        // Create the main frame (window)
        frame = new JFrame("Bank Balance Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the app when the window is closed
        frame.setSize(300, 200); // Set the window size

        // Create the panel that holds all the components
        panel = new JPanel();

        // Create a label to display the balance
        balanceLabel = new JLabel("Current Balance: $");
        panel.add(balanceLabel); // Add the label to the panel

        // Create a text field to display the balance, and set it as not editable
        balanceField = new JTextField(10);
        balanceField.setText(String.valueOf(account.getBalance())); // Show the current balance
        balanceField.setEditable(false); // User can't change this field
        panel.add(balanceField); // Add the balance field to the panel

        // Create a text field for entering amounts to deposit/withdraw
        amountField = new JTextField(10);
        panel.add(amountField); // Add the amount field to the panel

        // Create a deposit button and add it to the panel
        depositButton = new JButton("Deposit");
        panel.add(depositButton);

        // Create a withdraw button and add it to the panel
        withdrawButton = new JButton("Withdraw");
        panel.add(withdrawButton);

        // Create an exit button and add it to the panel
        exitButton = new JButton("Exit");
        panel.add(exitButton);

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);

        // Add action listeners to handle button clicks

        // Handle deposit action
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText()); // Get the amount entered by the user
                    account.deposit(amount); // Deposit the amount
                    balanceField.setText(String.valueOf(account.getBalance())); // Update the balance display
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid amount."); // Show an error if the input is invalid
                }
            }
        });

        // Handle withdraw action
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText()); // Get the amount entered by the user
                    account.withdraw(amount); // Withdraw the amount
                    balanceField.setText(String.valueOf(account.getBalance())); // Update the balance display
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid amount."); // Show an error if the input is invalid
                }
            }
        });

        // Handle exit action
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Final Balance: $" + account.getBalance()); // Show the final balance
                System.exit(0); // Exit the application
            }
        });
    }

    // Main method to run the application
    public static void main(String[] args) {
        new BankApp(); // Create and show the GUI
    }
}