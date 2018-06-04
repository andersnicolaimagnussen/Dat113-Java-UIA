import java.awt.*;
import java.util.Random;

public class Apple extends BaseGrap {

    public Apple() {
        setWidth(24);
        setHeight(30);
        setColor(Color.GREEN);

        MoveApple();
    }

    public void MoveApple() {

        Random rg = new Random();
        //random number for the 780*780
        int n = rg.nextInt(500) + 30;
        int b = rg.nextInt(500) + 30;

        setX(n);
        setY(b);

    }

    public void DrawApple(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getWidth(), getHeight());

        //System.out.println(getX());

    }

}
