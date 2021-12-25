#include <Wire.h>
#include "U8glib.h"
U8GLIB_SSD1306_128X64 u8g(U8G_I2C_OPT_NONE);    // I2C
#include "Wire.h"

// set all moisture sensors PIN ID
int moisture1 = A0;
int moisture2 = A1;
int moisture3 = A2;
int moisture4 = A3;

// declare moisture values
int moisture1_value = 0;
int moisture2_value = 0;
int moisture3_value = 0;
int moisture4_value = 0;

// set water relays
int relay1 = 6;
int relay2 = 8;
int relay3 = 9;
int relay4 = 10;

int pumpCounter = 0;

//Set the globle value per plant.
//Basically Changes the moisture level 
//as the plant needs it. 
//Now default value
int SetPlant1Value = 30;
int SetPlant2Value = 30;
int SetPlant3Value = 30;
int SetPlant4Value = 30;

//Sets plants endpoints
int SetPlant1Endpoint = 70;
int SetPlant2Endpoint = 70;
int SetPlant3Endpoint = 70;
int SetPlant4Endpoint = 70;

//0 = Disabled; 1 = Enabled;
int isPlant1Enabled = 0;
int isPlant2Enabled = 0;
int isPlant3Enabled = 0;
int isPlant4Enabled = 0;

int connectionStarted = 0;
int rsf1Ena = 0;
int rsf1Dsa = 0;

int rsf2Ena = 0;
int rsf2Dsa = 0;

int rsf3Ena = 0;
int rsf3Dsa = 0;

int rsf4Ena = 0;
int rsf4Dsa = 0;

int dataCounter = 0;
int loopCounter = 0;

// set water pump
int pump = 4;
int pump_state_flag = 0;
int relay1_state_flag = 0;
int relay2_state_flag = 0;
int relay3_state_flag = 0;
int relay4_state_flag = 0;

//ESTOP
int eStop = 0;
int manualControlEnabled = 0;

void setup()
{
 delay(2000);
  Wire.begin();
  Serial.begin(9600);
  // declare relay as output
  pinMode(relay1, OUTPUT);
  pinMode(relay2, OUTPUT);
  pinMode(relay3, OUTPUT);
  pinMode(relay4, OUTPUT);
  // declare pump as output
  pinMode(pump, OUTPUT);
}

void sendPlantMoisture()
{
    loopCounter = loopCounter + 1;
    if(loopCounter == 5)
    {
        Serial.println("[CMDSET]moisture1_value=" + String(moisture1_value));
        Serial.println("[CMDSET]moisture2_value=" + String(moisture2_value));
        Serial.println("[CMDSET]moisture3_value=" + String(moisture3_value));
        Serial.println("[CMDSET]moisture4_value=" + String(moisture4_value));
        loopCounter = 0;
    }
  
}

void sendDataToGUI()
{
  for (dataCounter; dataCounter <= 5500; dataCounter++)
  {
    //Sends Plant Values
    switch(dataCounter)
    {
      case 10:
        Serial.println("[CMDSET]SetPlant1Value=" + String(SetPlant1Value));
        break;
      case 500:
        Serial.println("[CMDSET]SetPlant2Value=" + String(SetPlant2Value));
        break;
      case 1000:
        Serial.println("[CMDSET]SetPlant3Value=" + String(SetPlant3Value));
        break;
      case 1500:
        Serial.println("[CMDSET]SetPlant4Value=" + String(SetPlant4Value));
        break;
      case 2000:
        Serial.println("[CMDSET]SetPlant1Endpoint=" + String(SetPlant1Endpoint));
        break;
      case 2500:
        Serial.println("[CMDSET]SetPlant2Endpoint=" + String(SetPlant2Endpoint));
        break;
      case 3000:
        Serial.println("[CMDSET]SetPlant3Endpoint=" + String(SetPlant3Endpoint));
        break;
      case 3500:
        Serial.println("[CMDSET]SetPlant4Endpoint=" + String(SetPlant4Endpoint));
        break;
      case 4000:
        Serial.println("[CMDSET]isPlant1Enabled=" + String(isPlant1Enabled));
        break;
      case 4500:
        Serial.println("[CMDSET]isPlant2Enabled=" + String(isPlant2Enabled));
        break;
      case 5000:
        Serial.println("[CMDSET]isPlant3Enabled=" + String(isPlant3Enabled));
        break;
      case 5500:
        Serial.println("[CMDSET]isPlant4Enabled=" + String(isPlant4Enabled));
        break;
    }
  }
}

void loop()
{
  // read the value from the moisture sensors:
  
  
  if(eStop == 0 && manualControlEnabled == 0)
  { 
      water_flower();
  }
  if(eStop == 1)
  {
        digitalWrite(pump, LOW);
        digitalWrite(relay1, LOW);
        digitalWrite(relay2, LOW);
        digitalWrite(relay3, LOW);
        digitalWrite(relay4, LOW);
  }
  read_value();
  sendPlantMoisture();
  mainMenu();
 
  
  if(Serial.available() > 0)
  {
      String s = Serial.readString();
      if(s == "connected")
      {
          sendDataToGUI();
          dataCounter = 0;
      }
      //Plant 1 enable/Disable----------------------|
      if(s == "[SEND]isPlant1Enabled=1")
      {
          isPlant1Enabled = 1;
      }
      if(s == "[SEND]isPlant1Enabled=0")
      {
          isPlant1Enabled = 0;
      }
      //Plant 2 enable/Disable----------------------|
      if(s == "[SEND]isPlant2Enabled=1")
      {
          isPlant2Enabled = 1;
      }
      if(s == "[SEND]isPlant2Enabled=0")
      {
          isPlant2Enabled = 0;
      }
      //Plant 3 enable/Disable----------------------|
      if(s == "[SEND]isPlant3Enabled=1")
      {
          isPlant3Enabled = 1;
      }
      if(s == "[SEND]isPlant3Enabled=0")
      {
          isPlant3Enabled = 0;
      }
      //Plant 4 enable/Disable----------------------|
      if(s == "[SEND]isPlant4Enabled=1")
      {
          isPlant4Enabled = 1;
      }
      if(s == "[SEND]isPlant4Enabled=0")
      {
          isPlant4Enabled = 0;
      }
      //Plant 1 Setpoint----------------------------|
      if(s.indexOf("[SEND]plant1SetpointInt") >= 0)
      {
          String s1 = getValue(s, '=', 0);
          String s2 = getValue(s, '=', 1);
          SetPlant1Value = s2.toInt();//tring(SetPlant1Value)
          Serial.println("[INFO]SetPlant1Value=" + String(SetPlant1Value));
      }
      //Plant 2 Setpoint----------------------------|
      if(s.indexOf("[SEND]plant2SetpointInt") >= 0)
      {
          String s1 = getValue(s, '=', 0);
          String s2 = getValue(s, '=', 1);
          SetPlant2Value = s2.toInt();
          Serial.println("[INFO]SetPlant2Value=" + String(SetPlant2Value));
      }
      //Plant 3 Setpoint----------------------------|
      if(s.indexOf("[SEND]plant3SetpointInt") >= 0)
      {
          String s1 = getValue(s, '=', 0);
          String s2 = getValue(s, '=', 1);
          SetPlant3Value = s2.toInt();
          Serial.println("[INFO]SetPlant3Value=" + String(SetPlant3Value));
      }
      //Plant 4 Setpoint----------------------------|
      if(s.indexOf("[SEND]plant4SetpointInt") >= 0)
      {
          String s1 = getValue(s, '=', 0);
          String s2 = getValue(s, '=', 1);
          SetPlant4Value = s2.toInt();
          Serial.println("[INFO]SetPlant4Value=" + String(SetPlant4Value));
      }

      //Plant 1 Endpoint----------------------------|
      if(s.indexOf("[SEND]plant1EndpointInt") >= 0)
      {
          String s1 = getValue(s, '=', 0);
          String s2 = getValue(s, '=', 1);
          SetPlant1Endpoint = s2.toInt();
          Serial.println("[INFO]SetPlant1Endpoint=" + String(SetPlant1Endpoint));
      }
      //Plant 2 Endpoint----------------------------|
      if(s.indexOf("[SEND]plant2EndpointInt") >= 0)
      {
          String s1 = getValue(s, '=', 0);
          String s2 = getValue(s, '=', 1);
          SetPlant2Endpoint = s2.toInt();
          Serial.println("[INFO]SetPlant2Endpoint=" + String(SetPlant2Endpoint));
      }
      //Plant 3 Endpoint----------------------------|
      if(s.indexOf("[SEND]plant3EndpointInt") >= 0)
      {
          String s1 = getValue(s, '=', 0);
          String s2 = getValue(s, '=', 1);
          SetPlant3Endpoint = s2.toInt();
          Serial.println("[INFO]SetPlant3Endpoint=" + String(SetPlant3Endpoint));
      }
      //Plant 4 Endpoint----------------------------|
      if(s.indexOf("[SEND]plant4EndpointInt") >= 0)
      {
          String s1 = getValue(s, '=', 0);
          String s2 = getValue(s, '=', 1);
          SetPlant4Endpoint = s2.toInt();
          Serial.println("[INFO]SetPlant4Endpoint=" + String(SetPlant4Endpoint));
      }
      //ESTOP---------------------------------------|
      if(s.indexOf("[SEND]STOP=1") >= 0)
      {
          String s1 = getValue(s, '=', 0);
          String s2 = getValue(s, '=', 1);
          eStop = s2.toInt();
          Serial.println("[INFO] WARNING EMERGENCY STOP");
      }
      if(s.indexOf("[SEND]STOP=0") >= 0)
      {
          String s1 = getValue(s, '=', 0);
          String s2 = getValue(s, '=', 1);
          eStop = s2.toInt();
          Serial.println("[INFO] ESTOP Cleared");
      }

      //relay 1 manual control----------------------|
      if(s.indexOf("[SEND]relay1Enable=1") >= 0 && manualControlEnabled == 1)
      {
          digitalWrite(relay1, HIGH);
      }
      if(s.indexOf("[SEND]relay1Enable=0") >= 0 && manualControlEnabled == 1)
      {
          digitalWrite(relay1, LOW);
      }
      
      //relay 2 manual control----------------------|
      if(s.indexOf("[SEND]relay2Enable=1") >= 0 && manualControlEnabled == 1)
      {
          digitalWrite(relay2, HIGH);
      }
      if(s.indexOf("[SEND]relay2Enable=0") >= 0 && manualControlEnabled == 1)
      {
          digitalWrite(relay2, LOW);
      }
      
      //relay 3 manual control----------------------|
      if(s.indexOf("[SEND]relay3Enable=1") >= 0 && manualControlEnabled == 1)
      {
          digitalWrite(relay3, HIGH);
      }
      if(s.indexOf("[SEND]relay3Enable=0") >= 0 && manualControlEnabled == 1)
      {
          digitalWrite(relay3, LOW);
      }

      //relay 4 manual control----------------------|
      if(s.indexOf("[SEND]relay4Enable=1") >= 0 && manualControlEnabled == 1)
      {
          digitalWrite(relay4, HIGH);
      }
      if(s.indexOf("[SEND]relay4Enable=0") >= 0 && manualControlEnabled == 1)
      {
          digitalWrite(relay4, LOW);
      }

      //pump manual control-------------------------|
      if(s.indexOf("[SEND]pumpEnable=1") >= 0 && manualControlEnabled == 1)
      {
          digitalWrite(pump, HIGH);
      }
      if(s.indexOf("[SEND]pumpEnable=0") >= 0 && manualControlEnabled == 1)
      {
          digitalWrite(pump, LOW);
      }

      //Enable/Disable Manual Control---------------|
      if(s.indexOf("[SEND]manualControl=1") >= 0)
      {
          manualControlEnabled = 1;
          digitalWrite(pump, LOW);
          digitalWrite(relay1, LOW);
          digitalWrite(relay2, LOW);
          digitalWrite(relay3, LOW);
          digitalWrite(relay4, LOW);
      }
      if(s.indexOf("[SEND]manualControl=0") >= 0)
      {
          manualControlEnabled = 0;
      }
  }
}

String getValue(String data, char separator, int index)
{
    int found = 0;
    int strIndex[] = { 0, -1 };
    int maxIndex = data.length() - 1;

    for (int i = 0; i <= maxIndex && found <= index; i++) {
        if (data.charAt(i) == separator || i == maxIndex) {
            found++;
            strIndex[0] = strIndex[1] + 1;
            strIndex[1] = (i == maxIndex) ? i+1 : i;
        }
    }
    return found > index ? data.substring(strIndex[0], strIndex[1]) : "";
}

String concatenate(String s, int i)
{
    String conv = String(i);
    return s + conv;

    //s + i;
}

int Toggle(int i)
{
    if(i == 0)
    {
       return 1;
    }
    else if(i == 1)
    {
       return 0;
    }
    return 0;
}

void mainMenu(void)
{
      u8g.firstPage();
      do
      {
          u8g.setFont(u8g_font_7x13);
          u8g.setPrintPos(15, 11);
          u8g.print("Remote Mode");
          u8g.setFont(u8g_font_8x13);
          u8g.setPrintPos(35, 33);
          u8g.print("Enabled");
      }
      while 
      ( 
          u8g.nextPage()
      );
}

//Set moisture value
void read_value()
{

/************These is for capacity moisture sensor*********/
  if(isPlant1Enabled == 1)
  {
      float value1 = analogRead(A0);
      moisture1_value = map(value1, 590, 360, 0, 100); 
      delay(20);
      if(moisture1_value < 0)
      {
          moisture1_value = 0;
      }
  }
  else if(isPlant1Enabled == 0)
  {
      moisture1_value = 0;
  }

  if(isPlant2Enabled == 1)
  {
      float value2 = analogRead(A1);
      moisture2_value = map(value2, 600, 360, 0, 100); 
      delay(20);
      if(moisture2_value < 0) 
      {
          moisture2_value = 0;
      }
  }  
  else if(isPlant2Enabled == 0)
  {
      moisture2_value = 0;
  }

  if(isPlant3Enabled == 1)
  {
      float value3 = analogRead(A2);
      moisture3_value = map(value3, 600, 360, 0, 100); 
      delay(20);
      if(moisture3_value < 0)
      {
          moisture3_value = 0;
      }
  }
  else if(isPlant3Enabled == 0)
  {
      moisture3_value = 0;
  }

  if(isPlant4Enabled == 1)
  {
      float value4 = analogRead(A3);
      moisture4_value = map(value4, 600, 360, 0, 100);
      delay(20);
      if(moisture4_value < 0) 
      {
          moisture4_value = 0;
      }
  }
  else if(isPlant4Enabled == 0)
  {
      moisture4_value = 0;
  }
  
}

void water_flower()
{
  if (moisture1_value < SetPlant1Value && isPlant1Enabled == 1)
  {
    digitalWrite(relay1, HIGH);
    relay1_state_flag = 1;
        if(rsf1Ena == 0)
        {
            Serial.println("[CMDSET]relay1_state_flag=1");
            rsf1Ena = 1;
            rsf1Dsa = 0;
        }
    delay(50);
    if (pump_state_flag == 0)
    {
      digitalWrite(pump, HIGH);
      pump_state_flag = 1;
      delay(50);
    }
  }
  else if (moisture1_value > SetPlant1Endpoint)
  {
    digitalWrite(relay1, LOW);
    relay1_state_flag = 0;
        if(rsf1Dsa == 0)
        {
            Serial.println("[CMDSET]relay1_state_flag=0");
            rsf1Dsa = 1;
            rsf1Ena = 0;
        }
    delay(50);
    if ((relay1_state_flag == 0) && (relay2_state_flag == 0) && (relay3_state_flag == 0) && (relay4_state_flag == 0))
    {
      digitalWrite(pump, LOW);
      pump_state_flag = 0;
      delay(50);
    }
  }

  if (moisture2_value < SetPlant2Value && isPlant2Enabled == 1)
  {
    digitalWrite(relay2, HIGH);
    relay2_state_flag = 1;
        if(rsf2Ena == 0)
        {
            Serial.println("[CMDSET]relay2_state_flag=1");
            rsf2Ena = 1;
            rsf2Dsa = 0;
        }
    delay(50);
    if (pump_state_flag == 0)
    {
      digitalWrite(pump, HIGH);
      pump_state_flag = 1;
      delay(50);
    }
  }
  else if (moisture2_value > SetPlant2Endpoint)
  {
    digitalWrite(relay2, LOW);
    relay2_state_flag = 0;
        if(rsf2Dsa == 0)
        {
            Serial.println("[CMDSET]relay2_state_flag=0");
            rsf2Dsa = 1;
            rsf2Ena = 0;
        }
    delay(50);
    if ((relay1_state_flag == 0) && (relay2_state_flag == 0) && (relay3_state_flag == 0) && (relay4_state_flag == 0))
    {
      digitalWrite(pump, LOW);
      pump_state_flag = 0;
      delay(50);
    }
  }

  if (moisture3_value < SetPlant3Value && isPlant3Enabled == 1)
  {
    digitalWrite(relay3, HIGH);
    relay3_state_flag = 1;
        if(rsf3Ena == 0)
        {
            Serial.println("[CMDSET]relay3_state_flag=1");
            rsf3Ena = 1;
            rsf3Dsa = 0;
        }
    delay(50);
    if (pump_state_flag == 0)
    {
      digitalWrite(pump, HIGH);
      pump_state_flag = 1;
      delay(50);
    }
  }
  else if (moisture3_value > SetPlant3Endpoint)
  {
    digitalWrite(relay3, LOW);
    relay3_state_flag = 0;
        if(rsf3Dsa == 0)
        {
            Serial.println("[CMDSET]relay3_state_flag=0");
            rsf3Dsa = 1;
            rsf3Ena = 0;
        }
    delay(50);
    if ((relay1_state_flag == 0) && (relay2_state_flag == 0) && (relay3_state_flag == 0) && (relay4_state_flag == 0))
    {
      digitalWrite(pump, LOW);
      pump_state_flag = 0;
      delay(50);
    }
  }

  if (moisture4_value < SetPlant4Value && isPlant4Enabled == 1)
  {
    digitalWrite(relay4, HIGH);
    relay4_state_flag = 1;
        if(rsf4Ena == 0)
        {
            Serial.println("[CMDSET]relay4_state_flag=1");
            rsf4Ena = 1;
            rsf4Dsa = 0;
        }
    delay(50);
    if (pump_state_flag == 0)
    {
      digitalWrite(pump, HIGH);
      pump_state_flag = 1;
      delay(50);
    }
  }
  else if (moisture4_value > SetPlant4Endpoint)
  {
    digitalWrite(relay4, LOW);
    relay4_state_flag = 0;
    if(rsf4Dsa == 0)
        {
            Serial.println("[CMDSET]relay4_state_flag=0");
            rsf4Dsa = 1;
            rsf4Ena = 0;
        }
    delay(50);
    if ((relay1_state_flag == 0) && (relay2_state_flag == 0) && (relay3_state_flag == 0) && (relay4_state_flag == 0))
    {
      digitalWrite(pump, LOW);
      pump_state_flag = 0;
      delay(50);
    }
  }
 
  if(isPlant1Enabled == 0)
  {
    digitalWrite(relay1, LOW);
      relay1_state_flag = 0;
  }
  if(isPlant2Enabled == 0)
  {
    digitalWrite(relay2, LOW);
      relay2_state_flag = 0;
  }
  if(isPlant3Enabled == 0)
  {
      digitalWrite(relay3, LOW);
      relay3_state_flag = 0;
  }
  if(isPlant4Enabled == 0)
  {
      digitalWrite(relay4, LOW);
      relay4_state_flag = 0;
  }
}
