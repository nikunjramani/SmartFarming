<?php 
    require 'connection.php';
    $soil_moisture=$_POST['soil_moisture'];
    $temprature=$_POST['temprature'];
    $cid=$_POST['cid'];
    $humidity=$_POST['humidity'];
    $co=$_POST['co'];
    $query="INSERT INTO `sensor_data` (`sid`, `cid`, `soil_moisture`, `temprature`, `humidity`, `co`) VALUES (NULL, '$cid', '$soil_moisture', '$temprature', '$humidity', '$co')";
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