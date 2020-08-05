<?php
    $aa=$_GET['motor'];
    $cid=$_GET['cid'];
    $time=$_GET['time'];
    $myfile = fopen("data.txt", "w") or die("Unable to open file!");

    fwrite($myfile,$aa);
    fclose($myfile);
    
require 'connection.php';
      $str="";
      if($aa==0){
          $str="Off";
          $query1="UPDATE `motor_status` SET `status`=0 WHERE 1";
      }else if($aa==1){
          $str="On";
          $query1="UPDATE `motor_status` SET `status`=1 WHERE 1";
      }
          mysqli_query($cn,$query1);
          $bb="";
    $mylife1=fopen("motor_time.txt","w") or die("Unable to open file!");
      if($time == 0){
          $bb="70";
      }else if($time==2){
          $bb="40";
      }else if($time == 3){
          $bb="30";
      }
      fwrite($mylife1,$bb);
        fclose($mylife1);
    $query="INSERT INTO `motor_log` (`mid`, `cid`, `on/off`, `time`) VALUES (NULL, '$cid', '$str', now())";
    mysqli_query($cn,$query);
    if(mysqli_affected_rows($cn)>0){
	    echo "1";   
	}
	else{
	    echo "-1";
	}
?>