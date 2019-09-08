/**
 * Holds the client's information.
 */
public class Client {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    /**
     * Parameterized constructor.
     * @param firstName client's first name.
     * @param lastName client's last name.
     * @param phoneNumber client's phone number.
     * @param emailAddress client's email address.
     */
    public Client(String firstName, String lastName, String phoneNumber, String emailAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;

    }

    /**
     * Returns the client's first name and last name concatenated together.
     * @return String client's name.
     */
    public String getName(){
        return firstName + " " + lastName;
    }

    /**
     * Returns the client's phone number.
     * @return String client's phone number.
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * Returns the client's email address.
     * @return String client's email address.
     */
    public String getEmailAddress(){
        return emailAddress;
    }
}
