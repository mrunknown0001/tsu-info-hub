<?php

		session_start();
	

	include "connect.php";
			
			
			$title = @$_GET['title'];
			$type = @$_GET['type'];
			$message = @$_GET['message'];
			$viewer = @$_GET['viewer'];
			$user = $_SESSION['user'];
			
			mysql_query("INSERT INTO post_table (postTitle, postType, message, viewer, idNumber) 
						VALUES ('$title','$type','$message','$viewer','$user')", $con);
			
			
		mysql_close($con);

		
		echo "<h1>Successfully Posted! :)</h1>";
?>