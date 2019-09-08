import java.util.Scanner;

/**
 * Bank menu processing.
 */
public class Simulator {

    /**
     * Asks for the user's menu choice.
     * @param args nothing.
     */
    public static void main(String[] args){

        int choice = 0;
        int exit = 7;
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while(choice != exit){
            displayMenu();
            if(scanner.hasNextInt()){
                choice = scanner.nextInt();
                if(choice >= 1 && choice <= 7){
                    switch (choice){
                        case 1:
                            bank.addBankAccount(scanner);
                            break;
                        case 2:
                            bank.displayBank();
                            break;
                        case 3:
                            bank.displayAccount(scanner);
                            break;
                        case 4:
                            bank.withdraw(scanner);
                            break;
                        case 5:
                            bank.deposit(scanner);
                            break;
                        case 6:
                            bank.monthlyUpdate();
                            break;
                        case 7:
                            System.out.println("Have a Great Day...");
                            break;
                    }
                } else {
                    System.out.println("Invalid Entry.");
                }
            } else {
                System.out.println("Invalid Entry");
                scanner.next();
            }
        }
    }

    /**
     * Displays the menu options.
     */
    public static void displayMenu(){
        System.out.println("*****************************************");
        System.out.println("[1] Add Account");
        System.out.println("[2] Display Bank");
        System.out.println("[3] Display Specific Account");
        System.out.println("[4] Withdraw");
        System.out.println("[5] Deposit");
        System.out.println("[6] Monthly Updates");
        System.out.print("[7] Exit: ");
    }
}
