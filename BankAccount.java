import java.util.Scanner;

/**
 * Parent class of chequing and savings account, holds their states and behaviours.
 */
public abstract class BankAccount {

    /**
     * Account number of the bank account.
     */
    protected int accountNumber;
    /**
     * Balance of bank account.
     */
    protected double balance;
    private Client client;

    /**
     * Creates a bank account with client information, bank account # and balance.
     * @param scanner allows for user input.
     * @return true if succeeded and false if not.
     */
    public boolean addBankAccount(Scanner scanner){
        //Prompts User for Client Information
        System.out.print("Enter First Name: ");
        String firstName = scanner.next();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.next();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.next();
        //Regex allowing for the following phone number formats 123456789 or 123-456-7890 or (123)456-7890 or (123)4567890.
        if(!phoneNumber.matches("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}")){
            System.out.println("Incorrect Phone Number Format -> 123456789 or 123-456-7890 or (123)456-7890 or (123)4567890\n");
            return false;
        }

        System.out.print("Enter Email Address: ");
        String emailAddress = scanner.next();
        if(!emailAddress.contains("@")){
            System.out.println("Incorrect Email Address\n");
            return false;
        }

        //Creates a new client with the information above.
        client = new Client(firstName, lastName, phoneNumber, emailAddress);

        //Prompts bank teller to affiliate the Bank Account to an account number and to set starting balance
        System.out.print("Enter Account Number: ");
        if(scanner.hasNextInt()){
            accountNumber = scanner.nextInt();
            if(accountNumber > 99999999) {
                System.out.println("Account Numbers can Only Consists of 8 Digits.\n");
                return false;
            }
        }

        System.out.print("Enter Starting Balance: ");
        if(scanner.hasNextInt())
            balance = scanner.nextInt();
        else{
            System.out.println("Balance must only contain numbers.\n");
            return false;
        }

        return true;

    }

    /**
     * Method which differs from chequing and savings account.
     */
    public abstract void monthlyAccountUpdate();

    /**
     * Returns the information of non type specific bank accounts.
     * @return String account information.
     */
    public String toString(){
        return accountNumber + " | " + client.getName() + " | " + client.getPhoneNumber() + " | " + client.getEmailAddress() + " | $" +  balance + " | ";
    }
}
