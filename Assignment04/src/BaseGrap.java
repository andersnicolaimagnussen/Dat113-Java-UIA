import java.awt.*;

public class BaseGrap {

    public BaseGrap(){
        this.x=100;
        this.y=100;
        this.width=50;
        this.height=50;
        this.color=(Color.BLACK);
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public boolean intersectsWith(BaseGrap other) {
        Rectangle r1 = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle r2 = new Rectangle(other.getX(), other.getY(), other.getWidth(), other.getHeight());
        return r1.intersects(r2);

    }

}
