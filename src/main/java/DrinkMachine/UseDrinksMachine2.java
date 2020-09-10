package DrinkMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UseDrinksMachine2 {
    public static void main(String[] args) throws NumberFormatException, IOException
    {
        DrinksMachine cheap = new SimpleDrinksMachine(25);
        DrinksMachine expensive = new SimpleDrinksMachine(80);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int amount;

        System.out.print("\nHow much do you want to put in the cheap machine? ");
        amount = Integer.parseInt(in.readLine());
        cheap.addMoney(amount);
        System.out.print("When you press the Coke button you get ");
        System.out.println(cheap.pressCoke());
        System.out.print("How much more do you want to put in? ");
        amount = Integer.parseInt(in.readLine());
        cheap.addMoney(amount);
        System.out.println("The amount showing is: "+cheap.showMoney()+"p");
        System.out.print("When you press the Fanta button you get ");
        System.out.println(cheap.pressFanta());

        System.out.print("\nHow much do you want to put in the expensive machine?");
        amount = Integer.parseInt(in.readLine());
        expensive.addMoney(amount);
        System.out.print("How much more do you want to put in? ");
        amount = Integer.parseInt(in.readLine());
        expensive.addMoney(amount);
        System.out.println("The amount showing is: "+expensive.showMoney()+"p");
        System.out.print("When you press the Coke button you get ");
        System.out.println(expensive.pressCoke());
        System.out.println();
    }
}
