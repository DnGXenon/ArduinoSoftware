/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinocontroller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 *
 * @author Nick
 */
public class LineChartDisplay extends Application
{
    MainFrame mainFrame = new MainFrame();
    Variables variables = new Variables();
    static Thread thread = new Thread(); 
    static String[] args1;
    
    
    int graphCounter = 0;
        //@Override
        public void start(Stage stage)
        {
            
        stage.setTitle("Water Useage Plot");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<>(xAxis,yAxis);
                
        lineChart.setTitle("Water Useage Per Plant");
        //defining a series
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Plant 1");
        if(Integer.parseInt(mainFrame.plant1PercentLabel.getText().substring(0, 1).toString()) != Integer.parseInt(mainFrame.plant1PercentLabel.getText().substring(0, 1).toString()) && variables.plant1StatusBoolean == true)
        {
            
            series1.getData().add(new XYChart.Data(graphCounter, Integer.parseInt(mainFrame.plant1PercentLabel.toString())));
            graphCounter++;
        }
        //populating the series with data
        //series1.getData().add(new XYChart.Data(1, 23));
        //series1.getData().add(new XYChart.Data(2, 14));
        //series1.getData().add(new XYChart.Data(3, 15));
        //series1.getData().add(new XYChart.Data(4, 24));
        //series1.getData().add(new XYChart.Data(5, 34));
        //series1.getData().add(new XYChart.Data(6, 36));
        //series1.getData().add(new XYChart.Data(7, 22));
        //series1.getData().add(new XYChart.Data(8, 45));
        //series1.getData().add(new XYChart.Data(9, 43));
        //series1.getData().add(new XYChart.Data(10, 17));
        //series1.getData().add(new XYChart.Data(11, 29));
        //series1.getData().add(new XYChart.Data(12, 25));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Plant 2");
        
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Plant 3");
        
        
        XYChart.Series series4 = new XYChart.Series();
        series4.setName("Plant 4");
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().addAll(series1, series2, series3, series4);
        
       
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        args1 = args;
        launch(args1);
    }
    
    
    public static void setVisible(boolean b)
    {
        if(b = true)
        {
            
        }
        else
        {
            
        }
        
    }
    
    
}
