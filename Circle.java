import java.awt.Graphics2D;
import java.awt.Color;


public class Circle {
    //Declearing the private variables for class Circle
    private int radius;
    private Point centre;

    //Constructs the Object Circle
    public Circle(int radius){
        //Constructs the Object Circle
        this.radius=radius;
        centre=null;
    }

    //Constructs the object Circle
    public Circle(Point p){
        //Constructs the object Circle
        radius=2;
        centre=p;
    }

    //takes g2 and color as parameters and draws Oval shape and fills it with color
   public void draw(Graphics2D g2,Color color)
   {
       //takes g2 and color as parameters and draws Oval shape and fills it with color
       g2.setColor(color);
	   g2.fillOval(200-radius, 200-radius, 2*radius, 2*radius);
   }

   //takes g2 and color as parameters and draws Oval shape and fills it with black color
   public void draw(Graphics2D g2){
        //takes g2 and color as parameters and draws Oval shape and fills it with black color
       g2.setColor(Color.BLACK);
       g2.fillOval((int)(centre.getX()-radius), (int)(centre.getY()-radius), 2*radius, 2*radius);
   }
}