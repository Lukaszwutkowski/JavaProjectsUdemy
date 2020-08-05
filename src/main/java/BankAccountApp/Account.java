package BankAccountApp;

public abstract class Account implements IBaseRate {
    // List common properties for savings and checking account
    private String name;
    private String sSN;
    private double balance;

    private static int index = 1000;
    protected String accountNumber;
    protected double rate;


    // Constructor to set base properties ans initialize the account
    public Account(String name, String sSN, double initDeposit){
        this.name = name;
        this.sSN = sSN;
        balance = initDeposit;


        // Set account number
        index++;
        this.accountNumber = setAccountNumber();

        setRate();
    }


    public abstract void setRate();


    private String setAccountNumber(){
        String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }


    // List common methods - transactions

    public void deposit(double amount){
        balance = balance + amount;
        System.out.println("Depositing $" + amount);
    }

    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
    }

    public void transfer(String toWhere, double amount){
        balance = balance - amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
    }

    public void printBalance(){
        System.out.println("Your balance is now: $" + balance);
    }
    public void showInfo(){
        System.out.println(
                "Name: " + name +
                        "\nACCOUNT NUMBER: " + accountNumber +
                        "\nBALANCE: " + balance +
                        "\nRate: " + rate + "%"
        );
    }
}
