package arduinocontroller;

/**
 *
 * @author Nick
 */
public class Variables
{

    //Plant Status Variables
    public static boolean plant1StatusBoolean = false;
    public static boolean plant2StatusBoolean = false;
    public static boolean plant3StatusBoolean = false;
    public static boolean plant4StatusBoolean = false;
    
    //Plant Setpoint Variables
    public static int plant1SetpointInt = 0;
    public static int plant2SetpointInt = 0;
    public static int plant3SetpointInt = 0;
    public static int plant4SetpointInt = 0;
    
    //Plant Endpoint Variables
    public static int plant1EndpointInt = 0;
    public static int plant2EndpointInt = 0;
    public static int plant3EndpointInt = 0;
    public static int plant4EndpointInt = 0;
    public static boolean advancedDiagnostics = false;
    
    //Status Monitor Variables
    public static String connectionStatusString = "Disconnected";
    public static String commPortAssignedString = "COMM4";
    
    //ManualControl
    public static boolean isManualControlEnabled = false;
    public static boolean mcPumpEnabled = false;
    public static boolean mcRelay1Enabled = false;
    public static boolean mcRelay2Enabled = false;
    public static boolean mcRelay3Enabled = false;
    public static boolean mcRelay4Enabled = false;
    
    
    //Method For Printing To Console
    public static void Print(String s)
    {
        System.out.println(s);
    }
    
    public static boolean toggleBoolean(boolean b)
    {
        return b != b;
    }
    /*
    returns plant 1 status boolean
    */
    public static boolean isPlant1StatusBoolean()
    {
        return plant1StatusBoolean;
    }

    public static void setPlant1StatusBoolean(boolean plant1StatusBoolean)
    {
        Variables.plant1StatusBoolean = plant1StatusBoolean;
    }

    public static boolean isPlant2StatusBoolean()
    {
        return plant2StatusBoolean;
    }

    public static void setPlant2StatusBoolean(boolean plant2StatusBoolean)
    {
        Variables.plant2StatusBoolean = plant2StatusBoolean;
    }

    public static boolean isPlant3StatusBoolean()
    {
        return plant3StatusBoolean;
    }

    public static void setPlant3StatusBoolean(boolean plant3StatusBoolean)
    {
        Variables.plant3StatusBoolean = plant3StatusBoolean;
    }

    public static boolean isPlant4StatusBoolean()
    {
        return plant4StatusBoolean;
    }

    public static void setPlant4StatusBoolean(boolean plant4StatusBoolean)
    {
        Variables.plant4StatusBoolean = plant4StatusBoolean;
    }

    public static int getPlant1SetpointInt()
    {
        return plant1SetpointInt;
    }

    public static void setPlant1SetpointInt(int plant1SetpointInt)
    {
        Variables.plant1SetpointInt = plant1SetpointInt;
    }

    public static int getPlant2SetpointInt()
    {
        return plant2SetpointInt;
    }

    public static void setPlant2SetpointInt(int plant2SetpointInt)
    {
        Variables.plant2SetpointInt = plant2SetpointInt;
    }

    public static int getPlant3SetpointInt() {
        return plant3SetpointInt;
    }

    public static void setPlant3SetpointInt(int plant3SetpointInt)
    {
        Variables.plant3SetpointInt = plant3SetpointInt;
    }

    public static int getPlant4SetpointInt()
    {
        return plant4SetpointInt;
    }

    public static void setPlant4SetpointInt(int plant4SetpointInt)
    {
        Variables.plant4SetpointInt = plant4SetpointInt;
    }

    public static int getPlant1EndpointInt()
    {
        return plant1EndpointInt;
    }

    public static void setPlant1EndpointInt(int plant1EndpointInt)
    {
        Variables.plant1EndpointInt = plant1EndpointInt;
    }

    public static int getPlant2EndpointInt()
    {
        return plant2EndpointInt;
    }

    public static void setPlant2EndpointInt(int plant2EndpointInt)
    {
        Variables.plant2EndpointInt = plant2EndpointInt;
    }

    public static int getPlant3EndpointInt()
    {
        return plant3EndpointInt;
    }

    public static void setPlant3EndpointInt(int plant3EndpointInt)
    {
        Variables.plant3EndpointInt = plant3EndpointInt;
    }

    public static int getPlant4EndpointInt()
    {
        return plant4EndpointInt;
    }

    public static void setPlant4EndpointInt(int plant4EndpointInt)
    {
        Variables.plant4EndpointInt = plant4EndpointInt;
    }

    public static String getConnectionStatusString()
    {
        return connectionStatusString;
    }

    public static void setConnectionStatusString(String connectionStatusString)
    {
        Variables.connectionStatusString = connectionStatusString;
    }

    public static String getCommPortAssignedString()
    {
        return commPortAssignedString;
    }

    public static void setCommPortAssignedString(String commPortAssignedString)
    {
        Variables.commPortAssignedString = commPortAssignedString;
    }
}
