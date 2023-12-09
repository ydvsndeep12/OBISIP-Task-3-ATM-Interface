import java.util.*;
public class ATMInterface{
    public static void main(String args[]) {
    
    int balance = 100000, withdraw, deposit;
    String userID, userPIN;
    int transactionCount = 0;
    String[] transactionHistory = new String[5];
    
    Scanner sc = new Scanner(System.in);
    
    // Authenticate user
    System.out.print("Enter user ID: ");
    userID = sc.nextLine();
    System.out.print("Enter user PIN: ");
    userPIN = sc.nextLine();
    
    if (!userID.equals("sandeep") || !userPIN.equals("2023")) {
        System.out.println("Invalid user ID or PIN. Exiting...");
        System.exit(0);
    }
    
    while (true) {
        
        System.out.println("Automated Teller Machine");
        System.out.println("Choose 1 for Withdraw");
        System.out.println("Choose 2 for Deposit");
        System.out.println("Choose 3 for Check Balance");
        System.out.println("Choose 4 for Transaction History");
        System.out.println("Choose 5 for Money Transfer");
        System.out.println("Choose 6 for EXIT");
        System.out.print("Choose the operation you want to perform: ");

        int choice = sc.nextInt();
        
        switch (choice) {
            
            case 1:
                System.out.print("Enter money to be withdrawn: ");
                withdraw = sc.nextInt();
                
                if (balance >= withdraw) {
                    balance = balance - withdraw;
                    System.out.println("Please collect your money");
                    transactionHistory[transactionCount++ % 5] = "Withdrawn: " + withdraw;
                } else {
                    System.out.println("Insufficient Balance");
                }
                System.out.println("");
                break;
            
            case 2:
                System.out.print("Enter money to be deposited: ");
                deposit = sc.nextInt();
                
                balance = balance + deposit;
                System.out.println("Your Money has been successfully deposited");
                transactionHistory[transactionCount++ % 5] = "Deposited: " + deposit;
                System.out.println("");
                break;
            
            case 3:
                System.out.println("Balance: " + balance);
                System.out.println("");
                break;
            
            case 4:
                System.out.println("Transaction History:");
                for (int i = 0; i < 5; i++) {
                    if (transactionHistory[i] != null) {
                        System.out.println(transactionHistory[i]);
                    }
                }
                System.out.println("");
                break;
            
            case 5:
                System.out.print("Enter amount to transfer: ");
                int transfer = sc.nextInt();
                if (balance >= transfer) {
                    System.out.print("Enter recipient's user ID: ");
                    String recipientID = sc.next();
                    if (recipientID.equals("ahalya")) {
                        System.out.println("Cannot transfer to the same account.");
                    } else {
                        // Simulate transfer
                        balance -= transfer;
                        System.out.println("Transfer of " + transfer + " to " + recipientID + " successful.");
                        transactionHistory[transactionCount++ % 5] = "Transferred " + transfer + " to " + recipientID;
                    }
                } else {
                    System.out.println("Insufficient Balance");
                }
                System.out.println("");
                break;
            
            case 6:
                System.exit(0);
            
            default:
                System.out.println("Invalid choice. Please choose again.");
                System.out.println("");
                break;
        }
    }
}
}

       
