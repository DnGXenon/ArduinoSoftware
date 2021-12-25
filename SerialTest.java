package arduinocontroller;

import static arduinocontroller.MainFrame.variables;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier; 
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 
import gnu.io.UnsupportedCommOperationException;
import java.util.Enumeration;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TooManyListenersException;

/*
--------Coming From Arduino To Java--------
[INFO], Displays a string to console
string layout = "[INFO]message to display";

[CMDSET], Sets variable information ex: isPlant1Enabled = 0;
string layout = "[CMDSET]isPlant1Enabled|0";

--------Commands From Java To Arduino--------
[SET]
*/


public class SerialTest implements SerialPortEventListener {
	static SerialPort serialPort;
        static boolean canWrite = false;
        /** The port we're normally going to use. */
	private static final String PORT_NAMES[] = 
        {
            "COM1", 
            "COM2", 
            "COM3", 
            "COM4", 
            "COM5", 
            "COM6", 
            "COM7", 
            "COM8", 
            "COM9",
            "COM10", 
            "COM11", 
            "COM12", 
            "COM13", 
            "COM14", 
            "COM15", 
            "COM16"
        };
	/**
	* A BufferedReader which will be fed by a InputStreamReader 
	* converting the bytes into characters 
	* making the displayed results code page independent
	*/
	private static BufferedReader input;
        
        @SuppressWarnings("FieldMayBeFinal")
        private static ArrayList<String> list = new ArrayList<String>();
        
        private static BufferedWriter writer;
	/** The output stream to the port */
	private static OutputStream output;
	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 2000;
	/** Default bits per second for COM port. */
	private static final int DATA_RATE = 9600;

	public void initialize()
        {
            canWrite = true;
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		//First, Find an instance of serial port as set in PORT_NAMES.
		while (portEnum.hasMoreElements())
                {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			for (String portName : PORT_NAMES)
                        {
				if (currPortId.getName().equals(portName))
                                {
					portId = currPortId;
					break;
				}
			}
		}
		try
                {
			// open serial port, and use class name for the appName.
			serialPort = (SerialPort) portId.open(this.getClass().getName(),
					TIME_OUT);

			// set port parameters
			serialPort.setSerialPortParams(DATA_RATE,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			// open the streams
			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
                        output = serialPort.getOutputStream();

			// add event listeners
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
                        if(canWrite)
                        {
                            
                            output.write("connected".getBytes());
                            
                        }
                        
                        MainFrame.disconnectMenuItem.setEnabled(true);
                        MainFrame.resyncMenuItem.setEnabled(true);
                        MainFrame.connectMenuItem.setEnabled(false);
                        System.out.println("COM Port Selected Is: " + portId.getName());
                        MainFrame.comPortLabel.setText(portId.getName());
                        MainFrame.printStringToConsole("Connected to arduino board on port: " + portId.getName());
                        MainFrame.connectionStatusLabel.setText("Connected");
                        MainFrame.connectionStatusLabel.setForeground(Color.green);
                        
                        MainFrame.clearButton.setEnabled(true);
                        MainFrame.sendButton.setEnabled(true);
                        MainFrame.consoleField.setEnabled(true);
                        
                        MainFrame.plant1EndpointBox.setEnabled(true);
                        MainFrame.plant1SetpointBox.setEnabled(true);
                        MainFrame.plant1StatusButton.setEnabled(true);
                        
                        MainFrame.plant2EndpointBox.setEnabled(true);
                        MainFrame.plant2SetpointBox.setEnabled(true);
                        MainFrame.plant2StatusButton.setEnabled(true);
                        
                        MainFrame.plant3EndpointBox.setEnabled(true);
                        MainFrame.plant3SetpointBox.setEnabled(true);
                        MainFrame.plant3StatusButton.setEnabled(true);
                        
                        MainFrame.plant4EndpointBox.setEnabled(true);
                        MainFrame.plant4SetpointBox.setEnabled(true);
                        MainFrame.plant4StatusButton.setEnabled(true);
                        
                        MainFrame.manualControlButton.setEnabled(true);
                        
		}
                catch (PortInUseException | UnsupportedCommOperationException | IOException | TooManyListenersException e)
                {
			System.err.println(e.toString());
                        if(Variables.advancedDiagnostics)
                        {
                            MainFrame.printStringToConsole(e.toString());
                        }
                        System.out.println("Could not find COM port.");
                        MainFrame.printStringToConsole("Could not connect to board.");
                        MainFrame.printStringToConsole("Please ensure the board is connected to a USB port.");
                        MainFrame.printStringToConsole("COM port may already be in use.");
                        MainFrame.connectionStatusLabel.setText("Disconnected");
                        MainFrame.connectionStatusLabel.setForeground(Color.red);
		}
	}
        
        public static void serialWrite(String s)
        {
            try
            {
                output.write(s.getBytes());
            }
            catch (IOException e)
            {
                System.err.println(e);
            }
        }
        
        public static void disconnectFromDevice()
        {
            try
            {
                serialPort.notifyOnDataAvailable(false);
                canWrite = false;
                output.flush();
                input.close();
                output.close();
                serialPort.close();
                
                MainFrame.disconnectMenuItem.setEnabled(false);
                MainFrame.resyncMenuItem.setEnabled(false);
                MainFrame.connectMenuItem.setEnabled(true);
                MainFrame.comPortLabel.setText("N/A");
                MainFrame.printStringToConsole("[INFO] Disconnected From Arduino Board");
                MainFrame.connectionStatusLabel.setText("Disconnected");
                MainFrame.connectionStatusLabel.setForeground(Color.red);
                        
                MainFrame.clearButton.setEnabled(false);
                MainFrame.sendButton.setEnabled(false);
                MainFrame.consoleField.setEnabled(false);
                        
                MainFrame.plant1EndpointBox.setEnabled(false);
                MainFrame.plant1SetpointBox.setEnabled(false);
                MainFrame.plant1StatusButton.setEnabled(false);
                        
                MainFrame.plant2EndpointBox.setEnabled(false);
                MainFrame.plant2SetpointBox.setEnabled(false);
                MainFrame.plant2StatusButton.setEnabled(false);
                        
                MainFrame.plant3EndpointBox.setEnabled(false);
                MainFrame.plant3SetpointBox.setEnabled(false);
                MainFrame.plant3StatusButton.setEnabled(false);
                        
                MainFrame.plant4EndpointBox.setEnabled(false);
                MainFrame.plant4SetpointBox.setEnabled(false);
                MainFrame.plant4StatusButton.setEnabled(false);
                
                MainFrame.manualControlButton.setEnabled(false);
            }
            catch(IOException e)
            {
                System.err.println(e);
            }
            
        }
        

	/**
	 * Handle an event on the serial port. Read the data and print it.
     * @param oEvent
	 */
        @Override
	public synchronized void serialEvent(SerialPortEvent oEvent)
        {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE)
                {
			try
                        {
				String inputLine = input.readLine();
                                handleStrings(inputLine);
                                //testArray(inputLine);
                                list.add(inputLine);
				System.out.println(inputLine);
			} 
                        catch (IOException e)
                        {
				e.printStackTrace();
			}
		}
	}
        
        private static void testArray(String s)
        {
            
            for (int counter = 0; counter < list.size(); counter++)
            {
                System.out.print(counter + "" + list.get(counter));
                list.remove(list.get(counter));
            }
        }
        
        
        public static void handleStrings(String s)
        {
            
            if(s.contains("[INFO]"))
            {
                MainFrame.printStringToConsole(s);
            }
            if(s.contains("[CMDSET]"))
            {
                Variables variables = new Variables();
                String str = s;
                str = s.substring(8);
                

                String[] parts = str.split("=", 2);
                String s1 = parts[0];
                String s2 = parts[1];
                
                
                if(s1.contains("SetPlant1Value"))
                {
                    
                    MainFrame.plant1SetpointBox.setSelectedItem(s2);
                    MainFrame.plant1SetpointLabel.setText(s2 + "%");
                    Variables.plant1SetpointInt = Integer.parseInt(s2);
                    MainFrame.printStringToConsole("[INFO]Plant 1 Setpoint set to: " + s2 + "%");
                }
                else if(s1.contains("SetPlant2Value"))
                {
                    Variables.plant2SetpointInt = Integer.parseInt(s2);
                    MainFrame.plant2SetpointBox.setSelectedItem(s2);
                    MainFrame.plant2SetpointLabel.setText(s2 + "%");
                    MainFrame.printStringToConsole("[INFO]Plant 2 Setpoint set to: " + s2 + "%");
                }
                else if(s1.contains("SetPlant3Value"))
                {
                    Variables.plant3SetpointInt = Integer.parseInt(s2);
                    MainFrame.plant3SetpointBox.setSelectedItem(s2);
                    MainFrame.plant3SetpointLabel.setText(s2 + "%");
                    MainFrame.printStringToConsole("[INFO]Plant 3 Setpoint set to: " + s2 + "%");
                }
                else if(s1.contains("SetPlant4Value"))
                {
                    Variables.plant4SetpointInt = Integer.parseInt(s2);
                    MainFrame.plant4SetpointBox.setSelectedItem(s2);
                    MainFrame.plant4SetpointLabel.setText(s2 + "%");
                    MainFrame.printStringToConsole("[INFO]Plant 4 Setpoint set to: " + s2 + "%");
                }
                
                else if(s1.contains("SetPlant1Endpoint"))
                {
                    
                    MainFrame.plant1EndpointBox.setSelectedItem(s2);
                    MainFrame.plant1EndpointLabel.setText(s2 + "%");
                    Variables.plant1EndpointInt = Integer.parseInt(s2);
                    MainFrame.printStringToConsole("[INFO]Plant 1 Endpoint set to: " + s2 + "%");
                }
                else if(s1.contains("SetPlant2Endpoint"))
                {
                    Variables.plant2EndpointInt = Integer.parseInt(s2);
                    MainFrame.plant2EndpointBox.setSelectedItem(s2);
                    MainFrame.plant2EndpointLabel.setText(s2 + "%");
                    MainFrame.printStringToConsole("[INFO]Plant 2 Endpoint set to: " + s2 + "%");
                }
                else if(s1.contains("SetPlant3Endpoint"))
                {
                    Variables.plant3EndpointInt = Integer.parseInt(s2);
                    MainFrame.plant3EndpointBox.setSelectedItem(s2);
                    MainFrame.plant3EndpointLabel.setText(s2 + "%");
                    MainFrame.printStringToConsole("[INFO]Plant 3 Endpoint set to: " + s2 + "%");
                }
                else if(s1.contains("SetPlant4Endpoint"))
                {
                    Variables.plant4EndpointInt = Integer.parseInt(s2);
                    MainFrame.plant4EndpointBox.setSelectedItem(s2);
                    MainFrame.plant4EndpointLabel.setText(s2 + "%");
                    MainFrame.printStringToConsole("[INFO]Plant 4 Endpoint set to: " + s2 + "%");
                }
                
                else if(s1.contains("isPlant1Enabled"))
                {
                    int s3 = Integer.parseInt(s2);
                    if(s3 == 1)
                    {
                        Variables.plant1StatusBoolean = true;
                        MainFrame.plant1StatusButton.setText("Enabled");
                        MainFrame.plant1StatusLabel.setText("Active");
                        MainFrame.plant1StatusLabel.setForeground(Color.green);
                        MainFrame.printStringToConsole("[INFO]Plant 1 Enabled");
                    }
                    if(s3 == 0)
                    {
                        Variables.plant1StatusBoolean = false;
                        MainFrame.plant1StatusButton.setText("Disabled");
                        MainFrame.plant1StatusLabel.setText("Inactive");
                        MainFrame.plant1StatusLabel.setForeground(Color.red);
                        MainFrame.printStringToConsole("[INFO]Plant 1 Disabled");
                    }
                }
                else if(s1.contains("isPlant2Enabled"))
                {
                    int s3 = Integer.parseInt(s2);
                    if(s3 == 1)
                    {
                        Variables.plant2StatusBoolean = true;
                        MainFrame.plant2StatusButton.setText("Enabled");
                        MainFrame.plant2StatusLabel.setText("Active");
                        MainFrame.plant2StatusLabel.setForeground(Color.green);
                        MainFrame.printStringToConsole("[INFO]Plant 2 Enabled");
                    }
                    if(s3 == 0)
                    {
                        Variables.plant2StatusBoolean = false;
                        MainFrame.plant2StatusButton.setText("Disabled");
                        MainFrame.plant2StatusLabel.setText("Inactive");
                        MainFrame.plant2StatusLabel.setForeground(Color.red);
                        MainFrame.printStringToConsole("[INFO]Plant 2 Disabled");
                    }
                }
                else if(s1.contains("isPlant3Enabled"))
                {
                    int s3 = Integer.parseInt(s2);
                    if(s3 == 1)
                    {
                        Variables.plant3StatusBoolean = true;
                        MainFrame.plant3StatusButton.setText("Enabled");
                        MainFrame.plant3StatusLabel.setText("Active");
                        MainFrame.plant3StatusLabel.setForeground(Color.green);
                        MainFrame.printStringToConsole("[INFO]Plant 3 Enabled");
                    }
                    if(s3 == 0)
                    {
                        Variables.plant3StatusBoolean = false;
                        MainFrame.plant3StatusButton.setText("Disabled");
                        MainFrame.plant3StatusLabel.setText("Inactive");
                        MainFrame.plant3StatusLabel.setForeground(Color.red);
                        MainFrame.printStringToConsole("[INFO]Plant 3 Disabled");
                    }
                }
                else if(s1.contains("isPlant4Enabled"))
                {
                    int s3 = Integer.parseInt(s2);
                    if(s3 == 1)
                    {
                        Variables.plant4StatusBoolean = true;
                        MainFrame.plant4StatusButton.setText("Enabled");
                        MainFrame.plant4StatusLabel.setText("Active");
                        MainFrame.plant4StatusLabel.setForeground(Color.green);
                        MainFrame.printStringToConsole("[INFO]Plant 4 Enabled");
                    }
                    if(s3 == 0)
                    {
                        Variables.plant4StatusBoolean = false;
                        MainFrame.plant4StatusButton.setText("Disabled");
                        MainFrame.plant4StatusLabel.setText("Inactive");
                        MainFrame.plant4StatusLabel.setForeground(Color.red);
                        MainFrame.printStringToConsole("[INFO]Plant 4 Disabled");
                    }
                }
                else if(s1.contains("relay1_state_flag"))
                {
                    int s3 = Integer.parseInt(s2);
                    if(s3 == 1)
                    {
                        MainFrame.plant1WaterStatus.setText("Watering");
                        MainFrame.printStringToConsole("[INFO]Plant 1 Watering");
                        MainFrame.plant1WaterStatus.setForeground(Color.green);
                    }
                    if(s3 == 0)
                    {
                        MainFrame.plant1WaterStatus.setText("Waiting");
                        MainFrame.printStringToConsole("[INFO]Plant 1 Waiting...");
                        MainFrame.plant1WaterStatus.setForeground(Color.white);
                    }
                }
                else if(s1.contains("relay2_state_flag"))
                {
                    int s3 = Integer.parseInt(s2);
                    if(s3 == 1)
                    {
                        MainFrame.plant2WaterStatus.setText("Watering");
                        MainFrame.printStringToConsole("[INFO]Plant 2 Watering");
                        MainFrame.plant2WaterStatus.setForeground(Color.green);
                    }
                    if(s3 == 0)
                    {
                        MainFrame.plant2WaterStatus.setText("Waiting");
                        MainFrame.printStringToConsole("[INFO]Plant 2 Waiting...");
                        MainFrame.plant2WaterStatus.setForeground(Color.white);
                    }
                }
                else if(s1.contains("relay3_state_flag"))
                {
                    int s3 = Integer.parseInt(s2);
                    if(s3 == 1)
                    {
                        MainFrame.plant3WaterStatus.setText("Watering");
                        MainFrame.printStringToConsole("[INFO]Plant 3 Watering");
                        MainFrame.plant3WaterStatus.setForeground(Color.green);
                    }
                    if(s3 == 0)
                    {
                        MainFrame.plant3WaterStatus.setText("Waiting");
                        MainFrame.printStringToConsole("[INFO]Plant 3 Waiting...");
                        MainFrame.plant3WaterStatus.setForeground(Color.white);
                    }
                }
                else if(s1.contains("relay4_state_flag"))
                {
                    int s3 = Integer.parseInt(s2);
                    if(s3 == 1)
                    {
                        MainFrame.plant4WaterStatus.setText("Watering");
                        MainFrame.printStringToConsole("[INFO]Plant 4 Watering");
                        MainFrame.plant4WaterStatus.setForeground(Color.green);
                    }
                    if(s3 == 0)
                    {
                        MainFrame.plant4WaterStatus.setText("Waiting");
                        MainFrame.printStringToConsole("[INFO]Plant 4 Waiting...");
                        MainFrame.plant4WaterStatus.setForeground(Color.white);
                    }
                }
                else if(s1.contains("moisture1_value"))
                {
                    int s3 = Integer.parseInt(s2);
                    MainFrame.plant1PercentLabel.setText(s3 + "%");
                }
                else if(s1.contains("moisture2_value"))
                {
                    int s3 = Integer.parseInt(s2);
                    MainFrame.plant2PercentLabel.setText(s3 + "%");
                }
                else if(s1.contains("moisture3_value"))
                {
                    int s3 = Integer.parseInt(s2);
                    MainFrame.plant3PercentLabel.setText(s3 + "%");
                }
                else if(s1.contains("moisture4_value"))
                {
                    int s3 = Integer.parseInt(s2);
                    MainFrame.plant4PercentLabel.setText(s3 + "%");
                }
                
                
                Main.mainFrame.repaint();
            }
        }
        
        /**
	 * This should be called when you stop using the port.
	 */
	public synchronized void close()
        {
            System.out.println("Serial Port = " + serialPort);
		//if (serialPort != null)
                //{
                        try
                        {
                            System.out.println("Disconnecting From Board...");
                            MainFrame.printStringToConsole("Disconnecting From Board...");
                            serialPort.removeEventListener();
                            serialPort.close();
                            System.out.println("Board Disconnected.");
                            MainFrame.printStringToConsole("Board Disconnected.");
                            MainFrame.connectionStatusLabel.setText("Disconnected");
                            MainFrame.connectionStatusLabel.setForeground(Color.red);
                        }
                        catch(Exception e)
                        {
                            System.err.println(e.toString());
                        }
			
		/*}
                else
                {
                    System.out.println("No Board Connected.");
                    printStringToConsole("No Board Connected.");
                    System.out.println("Serial Port = " + serialPort);
                }*/
	}
        
	public static void start() throws Exception {
		SerialTest main = new SerialTest();
		main.initialize();
		System.out.println("Started");
	}
}