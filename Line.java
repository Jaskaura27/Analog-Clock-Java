//imports the required classes.
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;
import java.awt.Color;


public class Line {
    //Declare private variables for the class.
    private int length;
    private int width;
    private double angle;
    private Color color;
    private Point startPoint;
    private Point endPoint;

    //Constructor
    public Line(int length,int width,Color color) {
        this.length = length;
        this.width = width;
        this.color = color;
        startPoint = new Point(200.0, 200.0);
        endPoint = new Point(0.0, 0.0);
    }

    //Constructor
    public Line(int length,int width,double angle,Point start) {
        this.angle = angle;
        this.length = length;
        this.width = width;
        this.color = Color.BLACK;
        this.startPoint = start;
        this.endPoint = new Point(0.0, 0.0);
    }
    public Line(int length,int width,double angle,Point start,Color color) {
        this.angle = angle;
        this.length = length;
        this.width = width;
        this.color = color;
        this.startPoint = start;
        this.endPoint = new Point(0.0, 0.0);
    }

    //Draws the onbject Line
    public void draw(Graphics2D g){
        this.endPoint=findEnd(angle);
        g.setStroke(new BasicStroke(width));
        g.setColor(color);
        g.draw((Shape) new Line2D.Double( startPoint.getX(),startPoint.getY(),endPoint.getX(),endPoint.getY() ));
    }

    //Draws the object Line
    public void draw(Graphics2D g,double angle){
        this.endPoint=findEnd(angle);
        g.setStroke(new BasicStroke(width));
        g.setColor(color);
        g.draw((Shape) new Line2D.Double( startPoint.getX(),startPoint.getY(),endPoint.getX(),endPoint.getY() ));
    }

    //return the end point for the line object.
    public Point findEnd(double angle){
        Point p;
        Double x,y;
        x=startPoint.getX()+((double)length*Math.cos(angle));
        y=startPoint.getY()+((double)length*Math.sin(angle));
        p = new Point(x,y);
        return p;
    }
}