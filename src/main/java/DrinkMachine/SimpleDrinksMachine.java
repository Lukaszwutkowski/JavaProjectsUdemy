package DrinkMachine;

public class SimpleDrinksMachine implements DrinksMachine{
    private int balance, price;

    public SimpleDrinksMachine(int p) {
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
        int change = balance - price;
        balance = 0;
        return "Coke + " + change + "p";
    }

    public String pressFanta() {
        int change = balance - price;
        balance = 0;
        return "Fanta + " + change + "p";
    }

    public void changePrice(int newprice) {
        price = newprice;
    }
}
