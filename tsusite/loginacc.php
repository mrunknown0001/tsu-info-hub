<?php

		session_start();
	

		
	include "connect.php";
	
		$userid = @$_GET['idnumber'];
		$userpass = @$_GET['password'];
						
						
								


			
		$r = mysql_query("SELECT * FROM user_table WHERE idNumber = $userid ", $con);
		
		while(@$row = mysql_fetch_array($r)) {
			
			$ui = $row['idNumber'];
			$cat = $row['category'];
			$pa = $row['password'];

			$_SESSION['user'] = $ui;
			
			if ($cat == "User") {
			
				if( $pa == $userpass) {
				
					include("loginsuccess.php");
				
				}
				else {
					
					echo "<h2>Wrong Password.</font></h2>";
					
					include("login.php");
					
				}
			}
			else {
			
				include("loginerror.php");
			}
			
				
		}
		
		mysql_close($con);
?>