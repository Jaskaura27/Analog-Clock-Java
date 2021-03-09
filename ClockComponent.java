//imports required classes
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.Timer;
import java.awt.event.ActionEvent;



public class ClockComponent extends JComponent{
    //Declearing private variables for ClockComponent class
    private Circle cInner;
    private Circle cOutter1;
    private Circle cOutter2;

    private Line hourLine;
    private Line minuteLine;
    private Line secondLine;

    private int hour,minute,second;

    private CurrentTime cTime;

    private ArrayList<Line> min15Line;
    private ArrayList<Line> min5Line;
    private ArrayList<Circle> min1Circle;

    //constructs the objet ClockComponent
    public ClockComponent(){
        //initialize cTime,hour,minute and second.
        cTime = new CurrentTime();
        hour = cTime.getHour();
        minute = cTime.getMinute();
        second = cTime.getSecond();

        //initilize Circle objects cInner, cOutter1 and cOutter2.
        cInner=new Circle(4);
        cOutter1=new Circle(188);
        cOutter2=new Circle(180);
        
        //intilize Line objects hourLine, minuteLine and secondLine
        hourLine = new Line(100,8,Color.BLACK);
        minuteLine = new Line(140,4,Color.BLACK);
        secondLine = new Line(160,2,Color.RED);

        /*calls methods get15MinLines(), get5MinLines() and get1MinCircle() and
         intilize min15Line, min5Line and min1Circle respectively
         */
        min15Line=get15MinLines();
        min5Line=get5MinLines();
        min1Circle=get1MinCircle();
        
        //calls paintComponent(...) after every second
        new Timer(1000, (ActionEvent e) -> {
            repaint();
        }).start();
    }

    //paint the clock on the frame.
    public void paintComponent(Graphics g)
	{  
        // Recover Graphics2D
        Graphics2D g2 = (Graphics2D) g;

        //reintilize hour,minute and second.
        hour = cTime.getHour();
        minute = cTime.getMinute();
        second = cTime.getSecond();
    
        //call method .draw(...) from class Circle for Circle object cOutter1 and cOutter2.
        cOutter1.draw(g2,Color.GRAY);
        cOutter2.draw(g2,Color.LIGHT_GRAY);

        //go through each element in the arrayLists and call the draw method for each objects from their respective classes.
        min15Line.forEach((line) -> line.draw(g2));
        min5Line.forEach((line)-> line.draw(g2));
        min1Circle.forEach((circle)->circle.draw(g2));

        //Draw string "CPSC 1181" in black colour
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial",Font.PLAIN,18));
        g2.drawString("CPSC 1181", 155, 60);


        //Draw hour, second and minute arm for the clock.
        hourLine.draw(g2,getHourAngle(hour, minute));
        minuteLine.draw(g2,getMinuteAngle(minute,second));
        secondLine.draw(g2,getSecondAngle(second));

        //draw the inner small circle.
        cInner.draw(g2,Color.RED);

	}


    //return angle for the hour line of the clock.
    public double getHourAngle(int hour,int minute){
        double angle= (0.523599*(double)(hour-3))+(0.00872665*(double)(minute-15));
        return angle;
    }

    //return angle for the minute line of the clock
    public double getMinuteAngle(int minute,int second){
        double angle =(0.10472*(double)(minute-15))+(0.00872665*(double)(second-15)/60);
        return angle;
    }

    //return angle for the second line of the clock.
    public double getSecondAngle(int second){
        double angle = (0.10472*(double)(second-15));
        return angle;
    }

    //return arraylist of line objects 
    private ArrayList<Line> get15MinLines() {
        ArrayList<Line> arr=new ArrayList<Line>();
        Point p;
        Line l;
        
        p =new Point(200.0,24.0);
        l=new Line(10, 4, 1.5708, p);
        arr.add(l);

        p = new Point(376.0, 200.0);
        l=new Line(10, 4, 3.14159, p);
        arr.add(l);

        p=new Point(200.0, 376.0);
        l=new Line(10, 4, 4.71239, p);
        arr.add(l);

        p=new Point(24.0, 200.0);
        l=new Line(10, 4, 0, p);
        arr.add(l);

        return arr;
    }


    //return arraylist of line objects.
    private ArrayList<Line> get5MinLines() {
        ArrayList<Line> arr=new ArrayList<Line>();
        Point p;
        Line l;

        p=new Point(288.0,47.58);
        l=new Line(5,2,2.0944,p);
        arr.add(l);

        p=new Point(352.42 , 112.00);
        l=new Line(5,2,2.61799,p);
        arr.add(l);

        p=new Point(352.42 , 288.0);
        l=new Line(5,2,3.66519,p);
        arr.add(l);

        p=new Point(288.0 , 352.42);
        l=new Line(5,2,4.18829,p);
        arr.add(l);

        p=new Point(112.0 , 352.42);
        l=new Line(5,2,5.23599,p);
        arr.add(l);

        p=new Point(352.42 , 112.00);
        l=new Line(5,2,2.61799,p);
        arr.add(l);

        p=new Point(47.58 , 288.0);
        l=new Line(5,2,5.75959,p);
        arr.add(l);

        p=new Point(47.58 , 111.20);
        l=new Line(5,2,0.523599,p);
        arr.add(l);

        p=new Point(111.20 , 47.58);
        l=new Line(5,2,1.0472,p);
        arr.add(l);

        return arr;
    }

    //return arraylist of circle objects.
    private ArrayList<Circle> get1MinCircle(){
        ArrayList<Circle> arr= new ArrayList<Circle>();
        int a=1;
        while(a<=60){
            if(a%5!=0){
                arr.add(new Circle(getPoint(a*6)));
            }
            a++;
        }
        return arr;

    }

    //return object point.
    private Point getPoint(int angle){
        double angleRad=Math.toRadians(angle);
        Point p;
        p=new Point( (200+ (176*(Math.cos(angleRad)))), (200+ (176*(Math.sin(angleRad)))));
        return p;
    }

}