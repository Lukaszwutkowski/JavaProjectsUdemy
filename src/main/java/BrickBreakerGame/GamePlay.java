package BrickBreakerGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener { // Extend class with JPanel (need JPanel methods)
    // We also need to implement the actions from the keyboard and also the movement of the ball for that reason.

    private boolean play = false; // We're going to add the boolean play so we can control the game, whether it is play
    private int score = 0; // We need a score

    private int totalBricks = 21; // Here we will set a number of total bricks

    private Timer timer; // We need to add timer and delay
    private int delay = 8;

    private int playerX = 310; // Location of the pedal (position)

    // The X and Y directions up, I missed the miles, here are the X in the way directions of the ball are
    //going to be the increments with which the program will know how to move the ball and which is the next

    private int ballposX = 120; // Position of ball
    private int ballposY = 350; // Position of ball
    private int ballXdir = -1; // Position of ball
    private int ballYdir = -2; // Position of ball

    // values for the game play initialization

    private MapGenerator map;

    public GamePlay() {
        map = new MapGenerator(3, 7);
        addKeyListener(this); // We want to use input from the keys on the keyboard that's why we need addKeyListener
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    // Create the graphics method. Display the ball and display the pedal
    // + control method (for control the things that are displayed on game)

    public void paint(Graphics g) {
        g.setColor(Color.white); // Bcg color as white
        // What will be filled from our screen (frame that needs to be filled with different attributes,
        // with the background, with the color of the bow, with the color of the bricks.
        //Here we don't actually initiate what is going to be the functionality, but the colors and
        //the positions of the different items displayed on the screen of the rectangular and here will need to
        //specify locations with a hate.
        g.fillRect(1, 1, 692, 592);

        map.draw((Graphics2D) g);
        g.setColor(Color.yellow);

        // Positions of the borders

        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

        // Set the attributes of the pillow

        g.setColor(Color.blue); // Color of pedal

        // Instead of specifying exact location of the pedal will set the X location to be dependent
        // on the on the variable. Player X, going to allow us. To connect.
        // The value of the pedal to the hour, also the keyboard, and then change it, and in that way we will
        // be able to move the pedal on the screen.
        g.fillRect(playerX, 550, 100, 8);

        // Add the Ball
        g.setColor(Color.green);
        // To be similarly to the pedal with the ball, we would like it to move not only in every direction,
        // but also in Y direction.
        // Also, we actually here need to do not feel rectangular, but we need to make the ball to be a circle.
        g.fillOval(ballposX, ballposY, 20, 20);

        g.setColor(Color.black);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("" + score, 590, 30);

        if (totalBricks <= 0) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;

            g.setColor(Color.green);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("You Won, Score: " + score, 190, 300);

            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Restart", 230, 350);
        }

        if (ballposY > 570) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;

            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Game Over, Score: " + score, 190, 300);

            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Restart", 230, 350);

        }

        g.dispose();
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        //TODO Auto-generated method stub

        timer.start();

        if (play) {

            // Ball - Pedal interaction
            if (new Rectangle(ballposX, ballposY, 20, 30).intersects(new Rectangle(playerX, 550, 100, 8))) {
                ballYdir = -ballYdir;
            }
            for (int i = 0; i < map.map.length; i++) {
                for (int j = 0; j < map.map[0].length; j++) {
                    if (map.map[i][j] > 0) {
                        int brickX = j * map.brickWidth + 80;
                        int brickY = j * map.brickHeight + 50;
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHeight;

                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
                        Rectangle brickRect = rect;

                        if (ballRect.intersects(brickRect)) {
                            map.setBrickValue(0, i, j);
                            totalBricks--;
                            score += 5;

                            if (ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + ballRect.width) {
                                ballXdir = -ballXdir;
                            } else {
                                ballYdir = -ballYdir;
                            }
                        }
                    }
                }
            }

            ballposX += ballXdir;
            ballposY += ballYdir;
            if (ballposX < 0) {
                ballXdir = -ballXdir;
            }
            if (ballposY < 0) {
                ballYdir = -ballYdir;
            }
            if (ballposX > 670) {
                ballXdir = -ballXdir;
            }
        }
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }


    /*
    What we want first is when press the left arrow our panel to move left, and when we press
    the right arrow, our pedal to move right, let's do this here.

     */

    @Override
    public void keyPressed(KeyEvent arg0) {

        if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX >= 600) {
                playerX = 600;
            } else {
                moveRight();
            }
        }

        if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX <= 10) {
                playerX = 10;
            } else {
                moveLeft();
            }
        }

        if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!play){
                play = true;
                ballposX = 120;
                ballposY = 350;
                ballXdir = -1;
                ballYdir = -2;
                score = 0;
                totalBricks = 21;
                map = new MapGenerator(3,7);

                repaint();
            }
        }
    }

    public void moveRight() {

        play = true;
        playerX += 20;
    }

    public void moveLeft() {

        play = true;
        playerX -= 20;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
