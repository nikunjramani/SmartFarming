<?php

require("phpMQTT.php");

$server = "soldier.cloudmqtt.com";     // change if necessary
$port = 15651;                     // change if necessary
$username = "vtxapwpp";                   // set your username
$password = "8-TU2fl-dTUr";                    // set your password
$client_id = "phpMQTT-publisher"; // make sure this is unique for connecting to sever - you could use uniqid()
$client_id = "phpMQTT-publisher"; // make sure this is unique for connecting to sever - you could use uniqid()

$mqtt = new bluerhinos\phpMQTT($server, $port, $client_id);

if ($mqtt->connect(true, NULL, $username, $password)) {
	while(true){
	$mqtt->publish("moisture", rand(11,100), 0);
	$mqtt->publish("humidity", rand(11,100), 0);
	$mqtt->publish("temprature", rand(11,100), 0);
	$mqtt->publish("level", rand(11,100), 0);
	$mqtt->publish("smoke", rand(11,100), 0);
	sleep(2);
	}
	$mqtt->close();
} else {
    echo "Time out!\n";
}
