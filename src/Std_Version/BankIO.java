package Std_Version;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BankIO {
    //************
    //*  TASK 4  *
    //************
    /**
     The BankIO class has the following two  static methods:
     This method should create a Scanner(you are free to use other methods)object
     that reads from the given file specified by path.
     While there's data in the file, the method repeatedly calls the getAccounts method  that returns a Account object,
     and add that  account to the given bank.
        * public static void getAccountData(String path, Bank bank)
        * public static Account getAccounts (Scanner in)
     */
    //TODO TASK 4: add code to raead account info from file and add it to the bank
   public static void getAccountData(File file,Bank bank){
        Scanner input;
        try {
            input = new Scanner(file);
            while(input.hasNextLine()){
                Account account = new Account();
                if (input.hasNextInt()){
                    // Account Number
                    account.setAccountNumber(input.nextInt());

                }
                if (input.hasNextDouble()){
                    //Amount
                    account.setBalance(input.nextDouble());
                }
                bank.add(account);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

        }
    }


}
