package BankAccountApp;

public class Savings extends Account {
    // List properties specific to the Savings Account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;


    // Constructor to initialize settings for the Savings account properties
    public Savings(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }


    // List any methods specific to Savings account
    public void showInfo(){
        super.showInfo();
        System.out.println("Your Saving Account Features" +
                "\n Safety Deposit Box ID: " + safetyDepositBoxID +
                "\n Safety Deposit Box Key: " + safetyDepositBoxKey);

    }
    @Override
    public void setRate(){
        rate = getBaseRate() - .25;

    }
}
