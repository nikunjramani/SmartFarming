<?php
     define('HOST','localhost');
	define('UNAME','id4111561_nikkat');
	define('PASS','nikkat');
	define('DB','id4111561_nikkat');
	
	$cn=mysqli_connect(HOST,UNAME,PASS,DB);
	$emai=$_GET['email'];
	$stmt=$cn->prepare("SELECT * FROM `notification` WHERE `email`='$emai';");
	$stmt->execute();
	$stmt->bind_result($nid,$email,$title,$message,$image,$datetime);
	$noti=array();
	while($stmt->fetch()){
	    $temp=array();
	    $temp['nid']=$nid;
	    $temp['email']=$email;
	    $temp['title']=$title;
	    $temp['message']=$message;
	    $temp['image']=$image;
	    array_push($noti,$temp);
	}
	echo json_encode($noti);
	?>