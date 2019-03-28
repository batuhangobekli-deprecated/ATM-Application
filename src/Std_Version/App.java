package Std_Version;

import java.io.File;
import java.util.Scanner;

public class App {
    private static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {

        Bank bank = new Bank(100);
        BankIO.getAccountData(new File("accounts.txt"), bank);

         Account account = null;
        int choice;
        double amount;
        int accountNumber;

        do {
            choice = getUserChoice();
            switch (choice) {
                case 1:
                    amount = getAmount();
                    accountNumber = getAccountNumber();
                    try {
                        account = new Account();
                        account.setAccountNumber(accountNumber);
                        account.setBalance(amount);
                        bank.add(account);
                        System.out.println("Account info: " + account + "\n");
                    } catch (IllegalArgumentException exception) {
                        System.out.println("\n*****ERROR*****: " + exception.getMessage() + "\n");
                    }
                    break;

                //*****************
                //*  TASKS 1 &2  *
                //*****************
                //TODO TASK 1: Notice the first catch clause
                //TODO TASK 2: Notice the second catch clause
                case 2:
                    amount = getAmount();
                    try {
                        account.deposit(amount);
                        System.out.println("Account info: " + account + "\n");
                    } catch (NullPointerException exception) {
                        System.out.println("\n*****ERROR*****: " + "No account! First find account"
                                + " or create a new account\n");
                    } catch (IllegalArgumentException exception) {
                        System.out.println("\n*****ERROR*****: " + exception.getMessage() + "\n");
                    }
                    break;

                //*****************
                //*  TASKS 1   *
                //*****************
                //TODO TASK 1: add a similar NullPointerException catch clause below

                case 3:
                    amount = getAmount();
                    try {
                        account.withdraw(amount);
                        System.out.println("Account info: " + account + "\n");
                    } catch (NullPointerException exception) {
                        System.out.println("\n*****ERROR*****: " + "No account! First find account"
                                + " or create a new account\n");
                    } catch (IllegalArgumentException exception) {
                        System.out.println("\n*****ERROR*****: " + exception.getMessage() + "\n");
                    }
                    break;

                case 4:
                    accountNumber = getAccountNumber();
                    Account found = bank.find(accountNumber);
                    if (found != null) {
                        account = found;
                        System.out.println("Account info: " + account + "\n");
                    } else {
                        System.out.println("\n*****ERROR*****: Bank account " + accountNumber
                                + " not found!\n");
                    }
                    break;

                case 5:
                    System.out.print("\n\nThe accounts: \n" + bank + "\n\n");
                    break;
            }
        } while (choice != 0);
        System.out.println("\n\nGoodbye!");
    }
    //*****************
    //*  TASKS 1   *
    //*****************
    //TODO TASK 1: add a similar try -catch clause(s) functions below
    private static int getUserChoice() {
        int choice;
        do {
            choice = -1;
            System.out.println("Menu Options:");
            System.out.println("0) Quit");
            System.out.println("1) Create new account");
            System.out.println("2) Deposit to current account");
            System.out.println("3) Withdraw from current account");
            System.out.println("4) Find account");
            System.out.println("5) Print all accounts");


            System.out.print("Enter your choice (0 - 6): ");


            try {
                choice = Integer.parseInt(stdin.nextLine());

            } catch (NullPointerException exception) {
                System.out.println("\n*****ERROR*****: " + "Please enter valid number");
            } catch (IllegalArgumentException exception) {
                System.out.println("\n*****ERROR*****: " + exception.getMessage() + "\n");
            }


            if (choice < 0 || choice > 6)
            System.out.println("Invalid choice");
    } while (choice < 0 || choice > 6);
        return choice;
    }

    private static double getAmount() {
        System.out.print("Enter the amount: $ ");
        double amount = -1;
        boolean valid = false;
        do {

                amount = Double.parseDouble(stdin.nextLine());
                valid = true;

        } while (!valid);
        return amount;
    }

    private static int getAccountNumber() {
        System.out.print("Enter the account number: ");
        int amount = -1;
        boolean valid = false;
        do {

                amount = Integer.parseInt(stdin.nextLine());
                valid = true;

        } while (!valid);
        return amount;
    }
}
