<?php 
   require 'connection.php';
 
 $stmt = $cn->prepare("SELECT * FROM `motor_status` WHERE 1");
 
 $stmt->execute();
 
  $stmt->bind_result($mid,$cid,$status);
 $aicms = array(); 
 while($stmt->fetch()){
 $temp = array();
 $temp['mid'] = $mid; 
 $temp['cid']=$cid;
 $temp['status']=$status;
 array_push($aicms, $temp);
 }
 echo json_encode($aicms);
 ?>