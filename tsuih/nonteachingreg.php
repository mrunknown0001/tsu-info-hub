<?php

	include "connect.php";
	
	
	$idnumber = $_POST['idnumber'];
	$password = $_POST['password'];
	$ntfirstname = $_POST['ntfirstname'];
	$ntlastname = $_POST['ntlastname'];
	$ntmiddle = $_POST['ntmiddle'];
	$category = $_POST['category'];
	$position = $_POST['position'];
	
	
	
	$flag['code']=0;

	if($r=mysql_query("INSERT INTO user_table (idNumber , password , firstName , lastName , middleName , category, position) VALUES('$idnumber','$password','$ntfirstname','$ntlastname','$ntmiddle','$category','$position') ",$con))
	{
		$flag['code']=1;
	}

	print(json_encode($flag));
	mysql_close($con);
	
	
	
?>