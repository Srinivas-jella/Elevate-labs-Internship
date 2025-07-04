import java.util.ArrayList;
import java.util.Scanner;
public class Account {
    String accountHolderName;
    int accountNumber;
    double balance;     
    ArrayList<String> transactionHistory=new ArrayList<>();
    
    public Account(String accountHolderName, int accountNumber){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        balance = 0.0;
        
    }
    public void deposit(double amount){
        if(amount>0){
            balance+= amount;
            transactionHistory.add("Deposited: " + amount);
        } else {            
            System.out.println("Deposit amount must be positive.");
        }
    }
    public void withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance-= amount;
            transactionHistory.add("Withdrew: " + amount);
        } else if(amount > balance) {
            System.out.println("Insufficient funds for withdrawal.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
    public void showTransactionHistory(){
        System.out.println("Transaction History for " + accountHolderName + ":");
        for(String transaction : transactionHistory){
            System.out.println(transaction);
        }
    }

    public static void displayMenu() {
        System.out.println("\n--- Bank Menu ---");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Show Transaction History");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        int number = scanner.nextInt();
        Account account = new Account(name,number);
        int choice;
        while(true){
            displayMenu();
            choice = scanner.nextInt();
            switch(choice){
                case 1: System.out.println("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        System.out.println("Deposit successful.");
                        break;
                case 2: System.out.println("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        System.out.println("Withdrawal successful.");
                        break;

                case 3: System.out.println("Current balance: " + account.balance);
                        break;        
                case 4: account.showTransactionHistory();
                        break;
                case 5: System.out.println("Exiting...Thank you for using our banking system.");
                        scanner.close();
                        return;
                default: System.out.println("Invalid choice. Please try again.");        
            }
        }
        
    }

}
