package DrinkMachine;


/*
The SimpleDrinksMachine class gives as output from the button-pressing methods the drink and the change
(as a string). However, the class wasn't written to check the amount entered is enough, so the simulation
allows you to put less money than the price of a drink into the machine and get a negative amount in change.
To correct this, we introduce a new implementation of DrinksMachine which we call DrinksMachineA
in which the button pressing methods return the string "Nothing" when they are used in the situation
simulating less than the price of a drink entered into the machine. Here is the code for DrinksMachineA:
 */

public class DrinksMachineA {
    // A drinks machine that makes sure you pay enough

    protected int balance, price;

    public DrinksMachineA(int p) {
        price = p;
    }

    public void addMoney(int pence) {
        balance += pence;
    }

    public int showMoney() {
        return balance;
    }

    public int showPrice() {
        return price;
    }

    public String pressCoke() {
        if (balance < price)
            return "Nothing";
        else {
            int change = balance - price;
            balance = 0;
            return "Coke + " + change + "p";
        }
    }

    public String pressFanta() {
        if (balance < price)
            return "Nothing";
        else {
            int change = balance - price;
            balance = 0;
            return "Fanta + " + change + "p";
        }
    }

    public void changePrice(int newprice) {
        price = newprice;
    }

}

