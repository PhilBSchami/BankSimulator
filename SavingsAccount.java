import java.util.Scanner;

/**
 * Child class of BankAccount class. Holds info of bank account plus its interest rate.
 */
public class SavingsAccount extends BankAccount {

    private double interestRate;

    @Override
    public boolean addBankAccount(Scanner scanner){
        //Calls the parents method
        if(super.addBankAccount(scanner)){
            //Prompts user for a valid interest rate
            System.out.print("Enter Interest Rate: ");
            if(scanner.hasNextDouble()){
                interestRate = scanner.nextDouble();
                if(interestRate < 0){
                    System.out.println("Interest rates cannot be negative.\n");
                    return false;
                }
            } else {
                System.out.println("Invalid Entry\n");
            }
        } else {
            return false;
        }

        System.out.println();
        return true;
    }

    /**
     * Adds the interest rate to the account balance.
     */
    public void monthlyAccountUpdate(){
        //if the balance is higher than 0, add the interest rate to the balance.
        if(balance > 0)
            balance = balance + (balance * (interestRate / 100));
    }

    @Override
    public String toString(){
        return super.toString() + "Interest Rate " + interestRate + "%";
    }
}
