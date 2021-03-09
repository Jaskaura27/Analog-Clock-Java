//import required classes for the class CurrentTime.
import java.time.LocalDateTime;


public class CurrentTime {
    //Declear the private variables for the call CurrentTime.
    private int hour;
    private int minute;
    private int second;
    private int hourDiff;
    private int minuteDiff;
    private int secondDiff;
    

    //Constructor for class CurrentTime.
    public CurrentTime(){
        LocalDateTime now = LocalDateTime.now();
        hourDiff= 8-now.getHour()%12;
        minuteDiff= 27-now.getMinute();
        secondDiff = 56-now.getSecond();

        hour=5;
        minute=24;
        second=53;

    }

    //returns hour.
    public int getHour(){
        LocalDateTime now = LocalDateTime.now();
        hour=now.getHour()+hourDiff;
        return hour;
    }

    //returns minute.
    public int getMinute(){
        LocalDateTime now = LocalDateTime.now();
        minute=now.getMinute()+minuteDiff;
        return minute;
    }

    //returns second.
    public int getSecond(){
        LocalDateTime now = LocalDateTime.now();
        second=now.getSecond()+secondDiff;
        return second;
    }
}