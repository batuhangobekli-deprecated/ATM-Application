package Std_Version;

public class Account {
    private double balance;
    private int accountNumber;

    //************
    //*  TASK 2  *
    //************
    /**
     * Constructor
     * @param initialBalance the initial balance of the Account
     * @param accountNumber The account number to associate with this
     *                      Account.  Must be a 5 digit integer.
     */


    /**
     * Deposits money into the Account
     *
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Don't deposit negative amounts!");
        }
        balance = balance + amount;
    }

    //************
    //*  TASK 3  *
    //************
    /**
     * Withdraws money from the Account
     *
     * @param amount the amount to withdraw
     */
    //TODO TASK 3: add code to throw our new exception if an overdraw is attempted
    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Don't withdraw a negative amount!");
        }
            balance = balance - amount;


    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the current balance of the Account
     *
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets the account number of the Account
     * @return the account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Returns a string representation this Account in
     * the following format, e.g. 12345 100.52₺ where 12345
     * is the account number, and 100.52 is the balance.
     */
    public String toString () {
        return "" + accountNumber + " ₺" + balance;
    }
}
