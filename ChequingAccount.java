import java.util.Scanner;

/**
 * Child class of BankAccount class. Holds info of bank account plus its monthly fees.
 */
public class ChequingAccount extends BankAccount {

    private double fee;

    @Override
    public boolean addBankAccount(Scanner scanner){
        //Calls the parents method
        if(super.addBankAccount(scanner)){
            //Prompts the user for a valid monthly fee.
            System.out.print("Enter Monthly Fee: ");
            if(scanner.hasNextDouble()){
                fee = scanner.nextDouble();
                if(fee < 0){
                    System.out.println("Fee cannot be negative\n");
                    return false;
                }
            } else {
                System.out.println("Invalid Entry\n");
                return false;
            }
        } else {
            return false;
        }

        System.out.println();
        return true;
    }

    /**
     * Subtracts the fee of the account from the balance.
     */
    public void monthlyAccountUpdate(){
        balance = balance - fee;
    }

    @Override
    public String toString(){
        return super.toString() + "Monthly Fee: $" + fee;
    }
}
