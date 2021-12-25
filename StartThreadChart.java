/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinocontroller;

/**
 *
 * @author Nick
 */
public class StartThreadChart implements Runnable
{
    public static String[] args2;

    @Override
    public void run() 
    {
        System.out.println("Thread Started");
        LineChartDisplay.main(args2);
        
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
