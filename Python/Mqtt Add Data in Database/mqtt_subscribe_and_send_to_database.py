import paho.mqtt.client as mqtt
import mysql.connector
from datetime import datetime
now = datetime.now()
formatted_date = now.strftime('%Y-%m-%d %H:%M:%S')


mydb = mysql.connector.connect(host="localhost",user="root",passwd="",database="id4111561_nikkat")
i=0
moisture=''
humidity=''
temprature=''
smoke=''
level=''
def on_connect( client, userdata, flags, rc):
	print ("Connected with Code :" +str(rc))
	client.subscribe([("moisture",0),("humidity",0),("temprature",0),("level",0),("smoke",0)])
	client.subscribe("motor",0)

def on_message( client, userdata, msg):
	#print(msg.topic+"="+data)
	data_send(msg.topic,msg.payload.decode("utf-8"))

def on_motor_on_off_status(client,userdata,msg):
		m=msg.payload.decode("utf-8")
		if(m=="0"):
			send_motor_log("off")
		
		if(m=="1"):
			send_motor_log("on")
		
def data_send(topic,msg):
	if(topic=="moisture"):
		i=1
		global moisture
		moisture=msg
	if(topic=="humidity"):
		i=2
		global humidity
		humidity=msg
	if(topic=="temprature"):
		i=3
		global temprature
		temprature=msg
	if(topic=="level"):
		i=4
		global level
		level=msg
	if(i==4):
		i=0
		print("moisture="+moisture+"\nhumidity="+humidity+"\ntemprature="+temprature+"\nlevel="+level)
		send_data_to_database(moisture,humidity,temprature,level,0)

def send_data_to_database(moisture,humidity,temprature,level,smoke):
	mycursor = mydb.cursor()
	sql = "INSERT INTO `sensor_data` (`sid`, `cid`, `soil_moisture`, `temprature`, `humidity`, `level`, `datetime`) VALUES (%s, %s, %s, %s, %s, %s, %s)"
	val = ("","1",moisture,temprature,humidity,level,formatted_date)
	mycursor.execute(sql, val)
	mydb.commit()
	print(mycursor.rowcount, "record inserted.")

def send_motor_log(status):
	mycursor = mydb.cursor()
	sql = "INSERT INTO `motor_log` (`mid`, `cid`, `on/off`, `time`) VALUES (%s, %s, %s, %s)"
	val = ("","1",status,formatted_date)
	mycursor.execute(sql, val)
	mydb.commit()
	print(mycursor.rowcount, "record inserted.")

client = mqtt.Client()
client.on_connect = on_connect
client.on_message = on_message
client.message_callback_add("motor",on_motor_on_off_status)
client.username_pw_set("vtxapwpp", "8-TU2fl-dTUr")
client.connect("soldier.cloudmqtt.com", 15651, 60)

client.loop_forever()