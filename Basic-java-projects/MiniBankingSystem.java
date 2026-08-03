import java.util.Scanner;

public class MiniBankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int choice = 0;
        double balance = 0;
        double amountDeposit;
        double amountWithdraw;
        boolean turnedOn = true;
        
        // Creates an array with a limit of  100 transactions
        String[] history = new String[100];
        int historyCount = 0; 

        System.out.println("  ===Mini Banking System===");
        System.out.println("  1.) Deposit");
        System.out.println("  2.) Withdraw");
        System.out.println("  3.) Transfer");
        System.out.println("  4.) View Balance");
        System.out.println("  5.) Transaction History");
        System.out.println("  6.) Exit");

        do {
            System.out.print("\n  Input Choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1: 
                    System.out.print("  Amount you want to deposit: ");
                    amountDeposit = sc.nextDouble();
                    if (amountDeposit <= 0) {
                        System.out.println("  Invalid amount.");
                    } else {
                        balance += amountDeposit;
                        
                        // Add record to array if space allows
                        if (historyCount < history.length) {
                            history[historyCount] = "Deposited: $" + amountDeposit;
                            historyCount++;
                        }
                        
                        System.out.println("  Current balance: $" + balance);
                    }
                    break;

                case 2: 
                    System.out.print("  How much balance would you like to withdraw: ");
                    amountWithdraw = sc.nextDouble();
                    if (amountWithdraw > balance) {
                        System.out.println("  You do not have enough balance.");
                    } else if (amountWithdraw <= 0) {
                        System.out.println("  Invalid amount.");
                    } else {
                        balance -= amountWithdraw;
                        
                        // Add record to array if space allows
                        if (historyCount < history.length) {
                            history[historyCount] = "Withdrew: $" + amountWithdraw;
                            historyCount++;
                        }
                        
                        System.out.println("  Current balance: $" + balance);
                    }
                    break;

                case 3: 
                    System.out.print("  Enter recipient account number: ");
                    String accountNum = sc.next();
                    System.out.print("  Enter amount to transfer: ");
                    double transferAmount = sc.nextDouble();

                    if (transferAmount > balance) {
                        System.out.println("  Insufficient funds for transfer.");
                    } else if (transferAmount <= 0) {
                        System.out.println("  Invalid amount.");
                    } else {
                        balance -= transferAmount;
                        
                        // Add record to array if space allows
                        if (historyCount < history.length) {
                            history[historyCount] = "Transferred $" + transferAmount + " to Account " + accountNum;
                            historyCount++;
                        }
                        
                        System.out.println("  Transfer successful. Current balance: $" + balance);
                    }
                    break;

                case 4: 
                    System.out.println("  Current balance: $" + balance);
                    break;

                case 5: 
                    System.out.println("  === Transaction History ===");
                    if (historyCount == 0) {
                        System.out.println("  No transactions found.");
                    } else {
                        // Loop only up to the number of stored entries
                        for (int i = 0; i < historyCount; i++) {
                            System.out.println("  - " + history[i]);
                        }
                    }
                    break;

                case 6: 
                    System.out.println("  Exiting system. Goodbye!");      
                    turnedOn = false;
                    break;

                default:
                    System.out.println("  Input a valid choice.");
                    break;
            }
        } while(turnedOn);

        sc.close();
    }
}