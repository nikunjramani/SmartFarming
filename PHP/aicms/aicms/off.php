<?php
    $status=$_POST['status'];
    $myfile = fopen("data.txt", "w") or die("Unable to open file!");
    fwrite($myfile,$status);
    fclose($myfile);
     require 'connection.php';
      
    $query="UPDATE `motor_status` SET `status`='$status' WHERE 1";
    mysqli_query($cn,$query);
    if(mysqli_affected_rows($cn)>0){
	    echo "1";   
	}
	else{
	    echo "-1";
	}
?>