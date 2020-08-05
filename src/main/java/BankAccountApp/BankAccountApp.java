package BankAccountApp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {


       /* Checking chkacc1 = new Checking("Tom Wilson", "321457345", 1500);

        Savings savacc1 = new Savings("Rich Lowe", "357463234", 2500);

        savacc1.showInfo();
        chkacc1.showInfo();

        savacc1.deposit(100);
        savacc1.withdraw(200);
        savacc1.transfer("Brokerage", 1000);

        savacc1.compound();

        */

        List<Account> accounts = new LinkedList<Account>();

        // Read a CSV file then create new accounts based on that data
        String file = "src/main/java/utilities/NewBankAccounts.csv";
        List<String[]> newAccountHolder = utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolder) {
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            //System.out.println(name + " " + sSN + " " + accountType + " $" + initDeposit);
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSN, initDeposit));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, sSN, initDeposit));

            } else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }

        }
        // accounts.get(5).showInfo();


        for (Account acc : accounts) {
            System.out.println("\n*********************");
            acc.showInfo();
        }

        System.out.println("\n**************\nRANDOM ACCOUNT FROM A FILE: \n");

        accounts.get((int) Math.random() * accounts.size()).showInfo();

        accounts.get((int) Math.random() * accounts.size()).withdraw(1350);

    }
}
