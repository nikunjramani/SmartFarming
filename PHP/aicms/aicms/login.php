<?php
   require 'connection.php';
	if($_POST['email']!="" && $_POST['password']!=""){
	    $token=$_POST["token"];
	$email=$_POST["email"];
	$pass=$_POST["password"];
	mysqli_query($cn,"update customor_registration set token='$token' where email='$email'");
	$sql = "SELECT * FROM `customor_registration` WHERE `email`='$email'AND `password`='$pass'";
	mysqli_query($cn,$sql);
	
	if(mysqli_affected_rows($cn)>0){
	    echo "1";   
	}
	else{
	    echo "-1";
	}
	}else{
	    echo "please insert email and password";
	}
	mysqli_close($cn);
	?>