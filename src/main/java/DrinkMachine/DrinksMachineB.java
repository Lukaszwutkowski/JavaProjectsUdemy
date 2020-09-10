package DrinkMachine;

/*
Code showing the same scenario as given above, but using drinks machines simulated by DrinksMachineA
objects is given in the file UseDrinksMachine3.java
An alternative design for a drinks machine might not automatically give change with a drink.
Rather there is a separate change button which you press if you want your change, otherwise
the change can be kept in the machine for buying further drinks. This sort of machine is simulated by
the class DrinksMachineB given below:
 */

public class DrinksMachineB {
    // A drinks machine with a Change button

    private int balance,price;

    public DrinksMachineB(int p)
    {
        price=p;
    }

    public void addMoney(int pence)
    {
        balance+=pence;
    }

    public int showMoney()
    {
        return balance;
    }

    public int showPrice()
    {
        return price;
    }

    public String pressCoke()
    {
        if(balance<price)
            return "Nothing";
        else
        {
            balance-=price;
            return "Coke";
        }
    }

    public String pressFanta()
    {
        if(balance<price)
            return "Nothing";
        else
        {
            balance-=price;
            return "Fanta";
        }
    }

    public String pressChange()
    {
        int change=balance;
        balance=0;
        return change+"p";
    }

    public void changePrice(int newprice)
    {
        price=newprice;
    }
}
