//11) Create an interface named Bank with the services 
//(use proper input parameters and return types) - create account, 
//credit amount, debit amount, transfer amount, mini statement and with fixed rate of interest.
// Provide two implementation classes SBI, Axis with necessary implementations.
// Use Late binding to create respective objects and call the methods.

package javalab1;

import java.util.Scanner;

//1. BANK INTERFACE
interface Bank {
 // Fixed rate of interest (Constant)
 double RATE_OF_INTEREST = 4.5; 

 // Abstract methods defining core services
 String createAccount(String name, String aadhaar, String pan, double initialDeposit);
 void creditAmount(String accountNumber, double amount);
 void debitAmount(String accountNumber, double amount);
 void transferAmount(String srcAccount, String destAccount, double amount);
 void printMiniStatement(String accountNumber);
 void displayInterestRate();
}

//Helper Class to represent an Account structure
class Account {
 String accountNumber;
 String customerName;
 String aadhaarNumber;
 String panNumber;
 double balance;
 String[] history = new String[5];
 int historyCount = 0;

 public Account(String accNo, String name, String aadhaar, String pan, double balance) {
     this.accountNumber = accNo;
     this.customerName = name;
     this.aadhaarNumber = aadhaar;
     this.panNumber = pan;
     this.balance = balance;
     logTransaction("Account Opened. Bal: Rs. " + balance);
 }

 public void logTransaction(String text) {
     if (historyCount < 5) {
         history[historyCount++] = text;
     } else {
         for (int i = 1; i < 5; i++) {
             history[i - 1] = history[i];
         }
         history[4] = text;
     }
 }
}

//2. SBI IMPLEMENTATION CLASS
class SBI implements Bank {
 private Account[] sbiAccounts = new Account[50];
 private int accountCounter = 0;
 private static int nextId = 5001;

 @Override
 public String createAccount(String name, String aadhaar, String pan, double initialDeposit) {
     String accNo = "SBI" + nextId++;
     sbiAccounts[accountCounter++] = new Account(accNo, name, aadhaar, pan, initialDeposit);
     System.out.println("[SBI] Account generated successfully!");
     return accNo;
 }

 private Account find(String accNo) {
     for (int i = 0; i < accountCounter; i++) {
         if (sbiAccounts[i].accountNumber.equalsIgnoreCase(accNo)) return sbiAccounts[i];
     }
     return null;
 }

 @Override
 public void creditAmount(String accountNumber, double amount) {
     Account acc = find(accountNumber);
     if (acc != null && amount > 0) {
         acc.balance += amount;
         acc.logTransaction("Credited: +" + amount);
         System.out.println("[SBI] Credited Rs. " + amount + ". New Balance: Rs. " + acc.balance);
     } else {
         System.out.println("[SBI Error] Account not found or invalid amount.");
     }
 }

 @Override
 public void debitAmount(String accountNumber, double amount) {
     Account acc = find(accountNumber);
     if (acc != null && amount > 0 && acc.balance >= amount) {
         acc.balance -= amount;
         acc.logTransaction("Debited: -" + amount);
         System.out.println("[SBI] Debited Rs. " + amount + ". New Balance: Rs. " + acc.balance);
     } else {
         System.out.println("[SBI Error] Transaction failed! Insufficient funds or invalid details.");
     }
 }

 @Override
 public void transferAmount(String srcAccount, String destAccount, double amount) {
     Account src = find(srcAccount);
     Account dest = find(destAccount);
     if (src != null && dest != null && amount > 0 && src.balance >= amount) {
         src.balance -= amount;
         dest.balance += amount;
         src.logTransaction("Trf to " + destAccount + ": -" + amount);
         dest.logTransaction("Recv from " + srcAccount + ": +" + amount);
         System.out.println("[SBI] Fund Transfer Successful! Rs. " + amount + " moved out.");
     } else {
         System.out.println("[SBI Error] Transfer Failed! Verify internal account IDs and balances.");
     }
 }

 @Override
 public void printMiniStatement(String accountNumber) {
     Account acc = find(accountNumber);
     if (acc != null) {
         System.out.println("\n--- SBI Mini Statement for: " + acc.customerName + " ---");
         System.out.println("Current Balance: Rs. " + acc.balance);
         for (int i = 0; i < acc.historyCount; i++) {
             System.out.println(" -> " + acc.history[i]);
         }
     } else {
         System.out.println("[SBI Error] Account matching this reference not found.");
     }
 }

 @Override
 public void displayInterestRate() {
     System.out.println("SBI base interest payout rate rules apply: " + RATE_OF_INTEREST + "% per annum.");
 }
}

//3. AXIS IMPLEMENTATION CLASS
class Axis implements Bank {
 private Account[] axisAccounts = new Account[50];
 private int accountCounter = 0;
 private static int nextId = 9001;

 @Override
 public String createAccount(String name, String aadhaar, String pan, double initialDeposit) {
     String accNo = "AXIS" + nextId++;
     axisAccounts[accountCounter++] = new Account(accNo, name, aadhaar, pan, initialDeposit);
     System.out.println("[Axis Bank] Account generated successfully!");
     return accNo;
 }

 private Account find(String accNo) {
     for (int i = 0; i < accountCounter; i++) {
         if (axisAccounts[i].accountNumber.equalsIgnoreCase(accNo)) return axisAccounts[i];
     }
     return null;
 }

 @Override
 public void creditAmount(String accountNumber, double amount) {
     Account acc = find(accountNumber);
     if (acc != null && amount > 0) {
         acc.balance += amount;
         acc.logTransaction("Credited: +" + amount);
         System.out.println("[Axis] Credited Rs. " + amount + ". New Balance: Rs. " + acc.balance);
     } else {
         System.out.println("[Axis Error] Account not found or invalid amount.");
     }
 }

 @Override
 public void debitAmount(String accountNumber, double amount) {
     Account acc = find(accountNumber);
     if (acc != null && amount > 0 && acc.balance >= amount) {
         acc.balance -= amount;
         acc.logTransaction("Debited: -" + amount);
         System.out.println("[Axis] Debited Rs. " + amount + ". New Balance: Rs. " + acc.balance);
     } else {
         System.out.println("[Axis Error] Transaction failed! Insufficient balance.");
     }
 }

 @Override
 public void transferAmount(String srcAccount, String destAccount, double amount) {
     Account src = find(srcAccount);
     Account dest = find(destAccount);
     if (src != null && dest != null && amount > 0 && src.balance >= amount) {
         src.balance -= amount;
         dest.balance += amount;
         src.logTransaction("Trf to " + destAccount + ": -" + amount);
         dest.logTransaction("Recv from " + srcAccount + ": +" + amount);
         System.out.println("[Axis] Fund Transfer Successful! Rs. " + amount + " moved out.");
     } else {
         System.out.println("[Axis Error] Transfer Failed! Verify internal account IDs and balances.");
     }
 }

 @Override
 public void printMiniStatement(String accountNumber) {
     Account acc = find(accountNumber);
     if (acc != null) {
         System.out.println("\n--- Axis Mini Statement for: " + acc.customerName + " ---");
         System.out.println("Current Balance: Rs. " + acc.balance);
         for (int i = 0; i < acc.historyCount; i++) {
             System.out.println(" -> " + acc.history[i]);
         }
     } else {
         System.out.println("[Axis Error] Account matching this reference not found.");
     }
 }

 @Override
 public void displayInterestRate() {
     // Modifying the output slightly to display Axis specific text using interface constant
     System.out.println("Axis Bank retail customer premium tier interest rate: " + RATE_OF_INTEREST + "% per annum.");
 }
}

//4. MAIN TESTING EXECUTIVE CLASS
public class bank {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     
     // Declare an Interface reference (Crucial for Late Binding)
     Bank corporateBankReference = null;

     System.out.println("Select the Bank to work with:");
     System.out.println("1. State Bank of India (SBI)");
     System.out.println("2. Axis Bank");
     System.out.print("Enter choice (1 or 2): ");
     int choice = scanner.nextInt();

     // Late Binding (Dynamic Binding): Object instantiation happens at runtime based on input
     if (choice == 1) {
         corporateBankReference = new SBI(); 
     } else if (choice == 2) {
         corporateBankReference = new Axis();
     } else {
         System.out.println("Invalid selection. Terminating program.");
         scanner.close();
         return;
     }

     System.out.println("\n--- Executing Bank Operations using Late Binding Reference ---");
     corporateBankReference.displayInterestRate();

     // Perform transactional workflows using the interface reference
     System.out.println("\n1. Creating Account A...");
     String accA = corporateBankReference.createAccount("Amit Sharma", "123456789012", "ABCDE1234F", 5000);
     
     System.out.println("\n2. Creating Account B...");
     String accB = corporateBankReference.createAccount("Priya Patel", "987654321098", "XYZWR9876G", 2000);

     System.out.println("\n3. Crediting Rs. 1500 to Account A...");
     corporateBankReference.creditAmount(accA, 1500);

     System.out.println("\n4. Debiting Rs. 500 from Account B...");
     corporateBankReference.debitAmount(accB, 500);

     System.out.println("\n5. Transferring Rs. 2000 from Account A to Account B...");
     corporateBankReference.transferAmount(accA, accB, 2000);
 }
}