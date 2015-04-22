<?php

	include "connect.php";
	
	$idnumber  = $_POST['idnumber'];
	$password  = $_POST['password'];
	$firstname  = $_POST['firstname'];
	$lastname  = $_POST['lastname'];
	$middle  = $_POST['middle'];
	$position = $_POST['position'];
	$salutation = $_POST['salutation'];
	$category  = $_POST['category'];
	
	
	$flag['code']=0;

	if($r=mysql_query("INSERT INTO user_table (idNumber , password , firstName , lastname , middleName , category, position, salutation) VALUES ('$idnumber','$password','$firstname','$lastname','$middle','$category','$position','$salutation') ",$con))
	{
		$flag['code']=1;
	}

	print(json_encode($flag));
	mysql_close($con);
	
?>