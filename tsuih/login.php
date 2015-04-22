<?php


	
	/* login.php
	*  use to login, verify users...
	*/
	

	include "connect.php";
	
	$idnumber = $_POST['idnumber'];
	

	 
	$r = mysql_query("SELECT * FROM user_table WHERE idNumber='$idnumber'",$con);

	while($row = mysql_fetch_array($r))
	{
		
		$flag['idNumber']=$row['idNumber'];
		$flag['password']=$row['password'];
		$flag['category']=$row['category'];
		$flag['college']=$row['college'];
		$flag['yearLevel']=$row['yearLevel'];
		$flag['position']=$row['position'];
		$flag['firstName']=$row['firstName'];
	}
	 
	 
	print(json_encode($flag));
	mysql_close($con);
	
?>