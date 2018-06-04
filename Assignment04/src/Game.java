
import javafx.scene.paint.Stop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.util.ArrayList;

public class Game extends JFrame implements ActionListener, KeyListener {
    private Board board = new Board();
    private Apple apple = new Apple();
    private ArrayList<Snake> snakebody  = new ArrayList<>();
    public boolean StartGame=true;
    public boolean Gameover=false;
    private int count=0;

    private Direction currentDir = Direction.Stop;
    enum Direction {
        Up, Down, Left, Right, Stop,
    }
    Timer T = new Timer(120, this);
    public Game() {


            //Creating the layout
            GridLayout S = new GridLayout();
            //adding the snake to the snake body
            this.snakebody.add(new Snake());
           //the title
            this.setTitle("Snake");
            //the program will exit it the user close the window
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //adding the layout
            this.setLayout(S);
            //setting the size
            setSize(780, 780);
            this.setLocationRelativeTo(null);
            //cant resize the window
            this.setResizable(false);
            //adding the timer to the board
            //adding listeners
            T.addActionListener(this);
            T.start();
            this.addKeyListener(this);
            this.setVisible(true);



    }


    //Paint function:
    private void Draw() {

            Graphics g = this.getGraphics();
            //Drawing the board from the Board class
            board.DrawBoard(g);
            //Drawing the Apple from the Apple class
            apple.DrawApple(g);
            // Drawing the snake, and every element in the Snake Body
            for(Snake snakeElement : snakebody ) {
                snakeElement. DrawSnake(g);
            }
            this.setVisible(true);


    }

    public void ReDraw()
    {
        Graphics g = this.getGraphics();
        for(Snake snakeElement : snakebody ) {
            snakeElement. ClearSnake(g);
        }
        this.setVisible(true);
        count=0;
        //Drawing the board from the Board class
        board.DrawBoard(g);
        //Drawing the Apple from the Apple class
        apple.DrawApple(g);
    }



private void Gameover(){
    {

        Graphics g = this.getGraphics();
        //board.DrawBoard(g);
        g.setColor(Color.PINK);

        g.setFont(new Font("Arial", Font.ITALIC, 70));
        g.drawString("Game over", 220, 300);

        g.setFont(new Font("Arial", Font.ITALIC, 50));
        g.drawString("Score  " + count, 300, 370);


        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Press Space to Restart", 280, 410);

    }

}


        //Move function
    private void move() {
        //new snake, position 0 (the head) in the snake body arraylist
        //extends from the Snake class
        Snake SnakeElement = this.snakebody.get(0);
        //Moving the snake
        if(currentDir==Direction.Stop){
            SnakeElement.Stop();
        }
        if (currentDir == Direction.Right) {

            //move right
            System.out.println("   ");
            SnakeElement.MoveRight();

        }  if (currentDir == Direction.Left) {
            //move left
            SnakeElement.MoveLeft();
            //move down
        }  if (currentDir == Direction.Down) {
            SnakeElement.MoveDown();
            //Move Up
        } if (currentDir == Direction.Up) {
            SnakeElement.MoveUp();

        }




        //check if the snakes x, and y pos intersect with the apples x and y pos
        if(apple.intersectsWith(SnakeElement )){
            count++;
            snakebody.add(new Snake());
            apple.MoveApple();

        }

        for (int i = snakebody.size()-1; i > 0; i--)
        {

            snakebody.get(i).setX(snakebody.get(i-1).getX());
            snakebody.get(i).setY(snakebody.get(i-1).getY());
        }


    }





    @Override


    public void actionPerformed(ActionEvent e)
    {
        Snake SnakeElement = this.snakebody.get(0);

        if (StartGame==true)
            {
               Draw();
               move();


            if (SnakeElement.getX() == 780 || SnakeElement.getX() == 0)
            {
                currentDir=Direction.Stop;
                StartGame=false;
               Gameover();

            }
        }



    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {


    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

            int key = keyEvent.getKeyCode();
            //if the snake hits the "wall" the StartGame= false
            //it will show the Gameover
        if(StartGame==false)
        {
            //if space pressed it will start a new game
            if (key== KeyEvent.VK_SPACE){


                ReDraw();



            }

        }



            if ((key == KeyEvent.VK_LEFT && currentDir != Direction.Right)) {
                System.out.println("LEFT");
                currentDir = Direction.Left;

            }


            if ((key == KeyEvent.VK_RIGHT && currentDir != Direction.Left)) {
                System.out.println("RIGHT");
                currentDir = Direction.Right;
            }

            if ((key == KeyEvent.VK_UP && currentDir != Direction.Down)) {
                System.out.println("UP ");
                currentDir = Direction.Up;

            }

            if ((key == KeyEvent.VK_DOWN && currentDir != Direction.Up)) {
                System.out.println("DOWN ");
                currentDir = Direction.Down;

            }


        }




    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}




