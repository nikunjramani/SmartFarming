#include <ESP8266WiFi.h>
#include <WiFiClient.h> 
#include <ESP8266HTTPClient.h>
#include <ESP8266WebServer.h>
#include <PubSubClient.h>
#include "DHT.h"        

#define DHTTYPE DHT11   
#define dht_dpin D3
DHT dht(dht_dpin, DHTTYPE); 


const char* mqttServer = ""; //go to cloudmqtt.com login account and add servername here
const int mqttPort = ""; // add mqttpornumber here
const char* mqttUser = ""; //mqttuser name
const char* mqttPassword = ""; //mqttuser password
const char* topicOut = "start";
const char* topicIn = "motor";

WiFiClient client;
PubSubClient mqtt(client);


String host=""; //your hosting server address
const char* ssid = ""; //wifi name
const char* password = ""; //wifi password
char message_buff[100];

int soil_moisture=A0;
int echo=D2,trig=D1;
int motor=D4;

int value=0,level=0;
float Temperature=0,Humidity=0,distance=0,duration=0;
void setup() {
  Serial.begin(115200);
  dht.begin();
  Serial.println("Connecting ");
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("WiFi connected");
  Serial.println(WiFi.localIP());
  while (!Serial) continue;
  pinMode(motor,OUTPUT);

  mqtt.setServer(mqttServer, mqttPort);
  mqtt.setCallback(mqttCallback);
 
  Serial.println("Connecting to MQTT Broker: " + String(mqttServer));
  mqttConnect();
  while(mqttConnect()==false) continue;
  Serial.println();
  mqtt.publish("esp/test", "Hello from ESP8266");

}

void loop() {
    if(mqtt.connected()){
     mqtt.loop();
  }
   get_soilmoisture_data();
  getWaterLevel();
  getTemperaturedata();
  sendMqttData();
 

}
boolean mqttConnect()
{
  if(!mqtt.connect("nikunj",mqttUser,mqttPassword)){
    Serial.print(".");
    return false;
  }
  Serial.println("Connected to broker.");
  mqtt.subscribe(topicIn);
  return mqtt.connected();
}
void mqttCallback(char* topic, byte* payload, unsigned int len)
{
  Serial.print("Message receive: ");
  Serial.write(payload, len);
   int i;
  for (i = 0; i<len; i++)
  {
    message_buff[i] = payload[i];
  }
  message_buff[i] = '\0';

  String msgString = String(message_buff);
  Serial.println(msgString);
  if (strcmp(topic, "motor") == 0){ 
    if (msgString == "1"){
      digitalWrite(motor, HIGH);
    }else if (msgString == "0"){
      digitalWrite(motor, LOW);
    }
  }
  Serial.println();
}

void sendMqttData(){
  char result[8]; // Buffer big enough for 7-character float
  dtostrf(value, 6, 2, result);
  mqtt.publish("moisture",result);
  mqtt.publish("humidity",  (char*) String(Humidity).c_str());
  mqtt.publish("temprature",(char*) String(Temperature).c_str());
  mqtt.publish("level",(char*) String(level).c_str());
}
void get_soilmoisture_data(){
   Serial.print("MOISTURE LEVEL : ");
   value= 100.00 - ( (analogRead(soil_moisture)/1023.00) * 100.00 );
   Serial.println(value);
   delay(1000);
}
void getTemperaturedata(){
    Humidity = dht.readHumidity();
    Temperature= dht.readTemperature();         
    Serial.print("Current humidity = ");
    Serial.print(Humidity);
    Serial.print("%  ");
    Serial.print("temperature = ");
    Serial.print(Temperature); 
    Serial.println("C  ");
    delay(1000);
}

void getWaterLevel(){
  digitalWrite(trig, LOW);
  delayMicroseconds(2);
  digitalWrite(trig, HIGH);
  delayMicroseconds(10);
  digitalWrite(trig, LOW);
  duration = pulseIn(echo, HIGH);
  distance= duration*0.034/2;
  if(distance<30){
    level=(distance*100)/30;
    level=100-level;
    Serial.print("Water Level ");
    Serial.print(level);
    Serial.println("%");
  }
  delay(1000);
}
