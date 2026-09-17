package javalab1;
import java.util.Scanner;

class BankAccount {
    String accountNumber;
    String customerName;
    String aadhaarNumber;
    String panNumber;
    double balance;
    String[] transactionHistory;
    int transactionCount;

    // Constructor to initialize a new account
    public BankAccount(String accountNumber, String name, String aadhaar, String pan) {
        this.accountNumber = accountNumber;
        this.customerName = name;
        this.aadhaarNumber = aadhaar;
        this.panNumber = pan;
        this.balance = 0.0; // Initial balance is 0
        this.transactionHistory = new String[10]; // Stores last 10 transactions
        this.transactionCount = 0;
        addTransaction("Account Created. Opening Balance: Rs. 0.0");
    }

    // Helper method to log transactions for Mini Statement
    public void addTransaction(String message) {
        if (transactionCount < 10) {
            transactionHistory[transactionCount++] = message;
        } else {
            // Shift history left to make space for the latest transaction
            for (int i = 1; i < 10; i++) {
                transactionHistory[i - 1] = transactionHistory[i];
            }
            transactionHistory[9] = message;
        }
    }
}

public class bankapp {
    // Array to hold up to 100 bank accounts
    private static BankAccount[] accounts = new BankAccount[100];
    private static int totalAccounts = 0;
    private static int nextAccountNumber = 1001; // Auto-incrementing account numbers

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=== Welcome to the Corporate Banking Portal ===");

        // Outer loop to run the menu continuously
        do {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Create New Account");
            System.out.println("2. Credit (Deposit) Amount");
            System.out.println("3. Debit (Withdraw) Amount");
            System.out.println("4. Balance Enquiry & Mini Statement");
            System.out.println("5. Fund Transfer");
            System.out.println("6. Exit Portal");
            System.out.print("Enter your choice (1-6): ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            // Switch case to delegate operations
            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    creditAmount(scanner);
                    break;
                case 3:
                    debitAmount(scanner);
                    break;
                case 4:
                    viewStatement(scanner);
                    break;
                case 5:
                    transferFunds(scanner);
                    break;
                case 6:
                    System.out.println("Exiting the application securely. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid Option! Please select a choice between 1 and 6.");
            }

            // Loop termination checks
            if (choice != 6) {
                System.out.print("\nDo you want to continue using the portal? (yes/no): ");
                String continueChoice = scanner.nextLine().trim().toLowerCase();
                if (continueChoice.equals("no") || continueChoice.equals("n")) {
                    choice = 6; // Set choice to exit value to break the loop
                    System.out.println("Exiting the application securely. Goodbye!");
                }
            }

        } while (choice != 6);

        scanner.close();
    }

    // 1. Account Creation
    private static void createAccount(Scanner scanner) {
        if (totalAccounts >= accounts.length) {
            System.out.println("System Error: Maximum storage capacity reached. Cannot create more accounts.");
            return;
        }

        System.out.print("Enter Customer Full Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter 12-digit Aadhaar Number: ");
        String aadhaar = scanner.nextLine();
        System.out.print("Enter 10-digit PAN Number: ");
        String pan = scanner.nextLine();

        String accNo = "BANK" + nextAccountNumber++;
        accounts[totalAccounts++] = new BankAccount(accNo, name, aadhaar, pan);

        System.out.println("\n[SUCCESS] Account created successfully!");
        System.out.println("Generated Account Number: " + accNo);
    }

    // 2. Credit Amount
    private static void creditAmount(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();
        BankAccount account = findAccount(accNo);

        if (account == null) {
            System.out.println("[ERROR] Account not found!");
            return;
        }

        System.out.print("Enter amount to credit: Rs. ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer

        if (amount <= 0) {
            System.out.println("[ERROR] Invalid amount! Deposit value must be greater than zero.");
        } else {
            account.balance += amount;
            account.addTransaction("Credited: +Rs. " + amount);
            System.out.println("[SUCCESS] Rs. " + amount + " credited to account " + accNo);
            System.out.println("Current Balance: Rs. " + account.balance);
        }
    }

    // 3. Debit Amount
    private static void debitAmount(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();
        BankAccount account = findAccount(accNo);

        if (account == null) {
            System.out.println("[ERROR] Account not found!");
            return;
        }

        System.out.print("Enter amount to debit: Rs. ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer

        if (amount <= 0) {
            System.out.println("[ERROR] Invalid amount!");
        } else if (account.balance < amount) {
            System.out.println("[ERROR] Insufficient funds! Available balance: Rs. " + account.balance);
        } else {
            account.balance -= amount;
            account.addTransaction("Debited: -Rs. " + amount);
            System.out.println("[SUCCESS] Rs. " + amount + " debited from account " + accNo);
            System.out.println("Current Balance: Rs. " + account.balance);
        }
    }

    // 4. Balance Enquiry & Mini Statement
    private static void viewStatement(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();
        BankAccount account = findAccount(accNo);

        if (account == null) {
            System.out.println("[ERROR] Account not found!");
            return;
        }

        System.out.println("\n======================================");
        System.out.println("           ACCOUNT DETAIL            ");
        System.out.println("======================================");
        System.out.println("Account Holder : " + account.customerName);
        System.out.println("Aadhaar Number : " + account.aadhaarNumber);
        System.out.println("PAN Number     : " + account.panNumber);
        System.out.println("Current Balance: Rs. " + account.balance);
        System.out.println("\n--- MINI STATEMENT (Last 10 Actions) ---");
        
        for (int i = 0; i < account.transactionCount; i++) {
            System.out.println((i + 1) + ". " + account.transactionHistory[i]);
        }
        System.out.println("======================================");
    }

    // 5. Fund Transfer
    private static void transferFunds(Scanner scanner) {
        System.out.print("Enter Source Account Number (From): ");
        String sourceAccNo = scanner.nextLine();
        BankAccount sourceAcc = findAccount(sourceAccNo);

        if (sourceAcc == null) {
            System.out.println("[ERROR] Source account not found!");
            return;
        }

        System.out.print("Enter Destination Account Number (To): ");
        String destAccNo = scanner.nextLine();
        BankAccount destAcc = findAccount(destAccNo);

        if (destAcc == null) {
            System.out.println("[ERROR] Destination account not found!");
            return;
        }

        if (sourceAccNo.equalsIgnoreCase(destAccNo)) {
            System.out.println("[ERROR] Source and destination accounts cannot be the same!");
            return;
        }

        System.out.print("Enter amount to transfer: Rs. ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer

        if (amount <= 0) {
            System.out.println("[ERROR] Invalid transfer amount!");
        } else if (sourceAcc.balance < amount) {
            System.out.println("[ERROR] Transfer failed! Insufficient funds in source account.");
        } else {
            // Deduct from source and add to destination
            sourceAcc.balance -= amount;
            destAcc.balance += amount;

            // Log details in both accounts
            sourceAcc.addTransaction("Transferred to " + destAccNo + ": -Rs. " + amount);
            destAcc.addTransaction("Received from " + sourceAccNo + ": +Rs. " + amount);

            System.out.println("[SUCCESS] Fund Transfer Complete!");
            System.out.println("Rs. " + amount + " transferred successfully from " + sourceAccNo + " to " + destAccNo);
        }
    }

    // Helper search method using a basic loop (linear search)
    private static BankAccount findAccount(String accountNumber) {
        for (int i = 0; i < totalAccounts; i++) {
            if (accounts[i].accountNumber.equalsIgnoreCase(accountNumber)) {
                return accounts[i];
            }
        }
