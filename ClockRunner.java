import javax.swing.JFrame;

public class ClockRunner {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        final int FRAME_WIDTH = 450;
        final int FRAME_HEIGHT = 450;
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ClockComponent c= new ClockComponent();
        frame.add(c);
        frame.setVisible(true);
        


    }
}
