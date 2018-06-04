
import java.awt.*;
import java.awt.Graphics;

public class Snake extends BaseGrap {
    public Snake() {
        setX(400);
        setY(400);
        setHeight(15);
        setWidth(15);
        setColor(Color.MAGENTA);
    }

    public void DrawSnake(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getHeight(), getWidth());

    }
    public void ClearSnake(Graphics g){
        g.clearRect(getX(), getY(), getHeight(), getWidth());
    }




    public void Stop(){
        setY(getY());
    }

    public void MoveUp() {
        System.out.println("UP");
        setY(getY() -20 );

    }

    public void MoveDown() {
        System.out.println("Down");
        setY(getY() + 20);
    }

    public void MoveRight() {
        System.out.println("Right");
        setX(getX() + 20);

    }

    public void MoveLeft() {
        System.out.println("Left");
        setX(getX() -20);
    }



}
