<?php 
    require 'connection.php';
 
 $cid=$_GET['cid'];
 $stmt = $cn->prepare("SELECT * FROM `customor_registration` WHERE `cid`=$cid");
 
 $stmt->execute();
 
  $stmt->bind_result($cid,$aicms_id,$name,$mobile,$email);
 $aicms = array(); 
 while($stmt->fetch()){
 $temp = array(); 
 $temp['cid']=$lcid;
 $temp['aicms_id']=$aicms_id;
 $temp['name']=$name;
 $temp['mobile']=$mobile;
 $temp['email']=$email;
 array_push($aicms, $temp);
 }
 echo json_encode($aicms);
 ?>