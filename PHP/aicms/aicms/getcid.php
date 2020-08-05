<?php 
    require 'connection.php';
 
 $email=$_GET['email'];
 $stmt = $cn->prepare("SELECT `cid` FROM `customor_registration` WHERE `email`=$email");
 
 $stmt->execute();
 
  $stmt->bind_result($cid,$aicms_id,$name,$mobile,$email,$password);
 $aicms = array(); 
 while($stmt->fetch()){
 $temp = array(); 
 $temp['cid']=$cid;
 array_push($aicms, $temp);
 }
 echo json_encode($aicms);
 ?>