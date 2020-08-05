<?php
     define('HOST','localhost');
	define('UNAME','id4111561_nikkat');
	define('PASS','nikkat');
	define('DB','id4111561_nikkat');
	
	$cn=mysqli_connect(HOST,UNAME,PASS,DB);
    $email=$_POST['email'];
    $title=$_POST['title'];
    $message=$_POST['message'];
    $imgurl=$_POST['image'];
    $sql="INSERT INTO `notification` (`nid`, `email`, `title`, `notification`, `image`, `datetime`) VALUES (NULL, '$email', '$title', '$message', '$image',now())";
    mysqli_query($cn,$sql);
    ?>