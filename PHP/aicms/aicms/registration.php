<?php 
require 'connection.php';
    $name=$_POST['name'];
    $mobile=$_POST['mobile'];
    $aicms_id=$_POST['aicms_id'];
    $email=$_POST['email'];
    
    $query="INSERT INTO `customor_registration` (`cid`, `aicms_id`, `name`, `mobileno`, `email`) VALUES (NULL, '$aicms_id', '$name', '$mobile', '$email');";
    mysqli_query($cn,$query);
    	if(mysqli_affected_rows($cn)>0)
	{
	    echo "1";   
	}
	else
	{
	    echo "-1";
	}
?>