<?php
require 'connection.php';
       $cid=$_GET['cid'];
                   $cid=$_POST['cid'];
                     $result=mysqli_query($cn,"SELECT token FROM `customor_registration` WHERE cid='$cid'");
                        $row=mysqli_fetch_row($result);
                            $firebase_token=$row[0];
                        echo $firebase_token;
                        require_once __DIR__ . '/notification.php';
						$notification = new Notification();
	
						$title = "Smoke Detected";
						$message = "";
						$imageUrl = isset($_POST['image_url'])?$_POST['image_url']:'';
						$action = isset($_POST['action'])?$_POST['action']:'';
						
						$actionDestination = isset($_POST['action_destination'])?$_POST['action_destination']:'';
	
						if($actionDestination ==''){
							$action = '';
						}
						$notification->setTitle($title);
						$notification->setMessage($message);
						$notification->setImage($imageUrl);
						$notification->setAction($action);
						$notification->setActionDestination($actionDestination);
						
				
						$topic = $_POST['topic'];
						
						$requestData = $notification->getNotificatin();
						
						if($_POST['send_to']=='topic'){
							$fields = array(
								'to' => '/topics/' . $topic,
								'data' => $requestData,
							);
							
						}else{
							
							$fields = array(
								'to' => $firebase_token,
								'data' => $requestData,
							);
						}
		
		
						// Set POST variables
						$url = 'https://fcm.googleapis.com/fcm/send';
 
						$headers = array(
							'Authorization: key=' . $firebase_api,
							'Content-Type: application/json'
						);
						
						// Open connection
						$ch = curl_init();
 
						// Set the url, number of POST vars, POST data
						curl_setopt($ch, CURLOPT_URL, $url);
 
						curl_setopt($ch, CURLOPT_POST, true);
						curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
						curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
 
						// Disabling SSL Certificate support temporarily
						curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
 
						curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($fields));
 
						// Execute post
						$result = curl_exec($ch);
						if($result === FALSE){
							die('Curl failed: ' . curl_error($ch));
						}
 
						// Close connection
						curl_close($ch);
						
						echo '<h2>Result</h2><hr/><h3>Request </h3><p><pre>';
						echo json_encode($fields,JSON_PRETTY_PRINT);
						echo '</pre></p><h3>Response </h3><p><pre>';
						echo $result;
						echo '</pre></p>';
					?>