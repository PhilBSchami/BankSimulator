import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class holding all of the bank's functions.
 */
public class Bank {

    /**
     * ArrayList of bank accounts simulating a bank.
     */
    ArrayList<BankAccount> accounts = new ArrayList<>();

    /**
     * Adds bank account to the accounts ArrayList.
     * @param scanner allows for user input.
     */
    public void addBankAccount(Scanner scanner){
        String accountType;
        System.out.print("Enter Account Type: [C] Chequing, [S] Savings: ");
        accountType = scanner.next();

        //Creates a chequing account and adds it to the ArrayList.
        if(accountType.length() == 1 && accountType.equalsIgnoreCase("C")){
            BankAccount chequingAccount = new ChequingAccount();
            if(chequingAccount.addBankAccount(scanner))
                accounts.add(chequingAccount);
            else
                System.out.println("Account not added.");
        }
        //Creates a savings account and adds it to the ArrayList.
        else if(accountType.length() == 1 && accountType.equalsIgnoreCase("S")){
            BankAccount savingsAccount = new SavingsAccount();
            if(savingsAccount.addBankAccount(scanner))
                accounts.add(savingsAccount);
            else
                System.out.println("Account not added.");
        }

        else {
            System.out.println("Invalid Account Type.\n");
        }
    }

    /**
     * Withdraws money from the specified bank account.
     * @param scanner allows for user input.
     */
    public void withdraw(Scanner scanner){
        //If bank is empty, notify user. If not, ask user for account number and withdraw amount.
        if(accounts.size() > 0){
            int i = findAccount(scanner);
            if(i > -1){
                System.out.print("Amount to Withdraw: ");
                if(scanner.hasNextDouble() || scanner.hasNextInt()){
                    double withdrawAmount = scanner.nextDouble();
                    if(accounts.get(i).balance >= withdrawAmount){
                        accounts.get(i).balance = accounts.get(i).balance - withdrawAmount;
                    } else {
                        System.out.println("Insufficient Funds");
                    }

                } else {
                    System.out.println("Invalid Entry.");
                    scanner.next();
                }

            } else {
                System.out.println("Account doesn't exist in system.");
            }
        } else {
            System.out.println("Bank empty, no accounts to withdraw from.\n");
        }
    }

    /**
     * Deposits money in the specified bank account.
     * @param scanner allows for user input.
     */
    public void deposit(Scanner scanner){
        //If bank is empty, notify user. If not, ask user for account number and deposit amount.
        if(accounts.size() > 0){
            int i = findAccount(scanner);
            if(i > -1){
                System.out.print("Amount to Deposit: ");
                if(scanner.hasNextDouble() || scanner.hasNextInt()){
                    double depositAmount = scanner.nextDouble();
                    accounts.get(i).balance = accounts.get(i).balance + depositAmount;
                } else {
                    System.out.println("Invalid Entry.");
                    scanner.next();
                }

            } else {
                System.out.println("Account doesn't exist in system.");
                scanner.next();
            }
        } else {
            System.out.println("Bank empty, no accounts to deposit to.\n");
        }
    }

    /**
     * Asks the user for the account they are willing to access.
     * @param scanner allows for user input.
     * @return int the index of the account the user want's to access.
     */
    public int findAccount(Scanner scanner){
        //Asks user for accounts number, if it exists return account number, else return -1.
        int accountToFind;
        System.out.print("Enter Account Number: ");
        if(scanner.hasNextInt()) {
            accountToFind = scanner.nextInt();
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).accountNumber == accountToFind)
                    return i;
            }
        }

        return -1;
    }

    /**
     * Display a specific account.
     * @param scanner allows for user input.
     */
    public void displayAccount(Scanner scanner){
        //If the bank is empty, notify the user. If not asks for account number, if it exists display it.
        if(accounts.size() > 0){
            int i = findAccount(scanner);
            if(i > -1)
                System.out.println(accounts.get(i).toString());
            else
                System.out.println("Account doesn't exists in system.");
        } else {
            System.out.println("Bank empty, no accounts to display.\n");
        }

    }

    /**
     * Displays all of the bank accounts in the bank.
     */
    public void displayBank(){
        //if the bank is empty, notify the user. If not, print out all the accounts in the bank.
        if(accounts.size() == 0)
            System.out.println("Bank empty, no accounts to display.");
        else{
            for(int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i) != null) {
                    System.out.println(accounts.get(i).toString());
                }
            }
        }
        System.out.println();
    }

    /**
     * Updates every account according to their monthly fee (chequing account) or interest rate (savings account).
     */
    public void monthlyUpdate(){
        //If the bank is not empty, and if an account exists in the ArrayList spot, update.
        if(accounts.size() > 0){
            for(int i = 0; i < accounts.size(); i++){
                if(accounts.get(i) != null)
                    accounts.get(i).monthlyAccountUpdate();
            }
        } else {
            System.out.println("Bank Empty, no accounts to update.");
        }
        System.out.println();
    }
}
