package BrickBreakerGame;

import javax.swing.*;

public class BrickBrakerApp {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BrickBrakerApp();
            }
        });

    }

    public BrickBrakerApp() {

                JFrame obj = new JFrame();  // Here we create a new object from class JFrame
                GamePlay gamePlay = new GamePlay(); // Here we create a new object from GamePlay class

                // Create the frame of the game

                obj.setBounds(10, 10, 700, 600);
                obj.setTitle("Brick Breaker");
                obj.setResizable(false);
                obj.setVisible(true);
                obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                obj.add(gamePlay);

            }
}

