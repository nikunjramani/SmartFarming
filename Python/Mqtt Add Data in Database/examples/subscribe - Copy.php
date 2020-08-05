<?php

require("phpMQTT.php");

$server = "soldier.cloudmqtt.com";     // change if necessary
$port = 15651;                     // change if necessary
$username = "vtxapwpp";                   // set your username
$password = "8-TU2fl-dTUr";                    // set your password
$client_id = "phpMQTT-publisher"; // make sure this is unique for connecting to sever - you could use uniqid()

$mqtt = new bluerhinos\phpMQTT($server, $port, "ClientID".rand());

if(!$mqtt->connect(true,NULL,$username,$password)){
  exit(1);
}

//currently subscribed topics
$topics['topic'] = array("qos"=>0, "function"=>"procmsg");
$mqtt->subscribe($topics,0);

while($mqtt->proc()){
}

$mqtt->close();
function procmsg($topic,$msg){
  echo "Msg Recieved: $msg";
}