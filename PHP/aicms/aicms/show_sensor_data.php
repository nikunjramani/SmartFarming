<?php 
require 'connection.php';
 
 $cid=$_GET['cid'];
 $stmt = $cn->prepare("SELECT * FROM `sensor_data`WHERE `cid`='$cid'");
 
 $stmt->execute();
 
  $stmt->bind_result($sid,$cid,$soil_moisture,$temprature,$humidity,$co);
 $aicms = array(); 
 while($stmt->fetch()){
 $temp = array();
 $temp['sid'] = $sid; 
 $temp['soil_moisture']=$soil_moisture;
 $temp['temprature']=$temprature;
 $temp['humidity']=$humidity;
 $temp['co']=$co;
 array_push($aicms, $temp);
 }
 echo json_encode($aicms);
 ?>