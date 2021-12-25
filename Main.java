package arduinocontroller;

import javax.swing.JFrame;

/**
 *
 * @author Nick
 */
public class Main
{
    public static MainFrame mainFrame = new MainFrame();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Arduino Watering System Controller");
        mainFrame.setVisible(true);
        Variables variables = new Variables();
        //StartThreadChart.args2 = args;
        //Runnable runnable = new StartThreadChart();

        //Thread thread = new Thread(runnable);
        //thread.start();
    }
    
    public void updateGUI()
    {
        mainFrame.repaint();
    }
    
}
