
import java.awt.Color;
import java.awt.Graphics;


public class Board extends BaseGrap
{
    public Board(){
        setX(0);
        setY(0);
        setHeight(780);
        setWidth(780);
        setColor(Color.BLACK);
    }


public void DrawBoard(Graphics g)
{
    g.setColor(getColor());
    g.fillRect(getX(), getY(), getWidth(), getHeight());


}


}
