<?php

 $cid=$_GET['cid'];
require 'connection.php';
 $query=mysqli_query($cn,"SELECT * FROM `motor_status` WHERE `cid`='$cid'");
 while ($row = mysql_fetch_array($query)) {
     echo $row['status'];
 }
?>