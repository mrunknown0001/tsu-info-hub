<?php


	include "connect.php";
	
	$idnumber = $_POST['idnumber'];
	$password = $_POST['password'];
	$studfn = $_POST['studfn'];
	$studln = $_POST['studln'];
	$studmn = $_POST['studmn'];
	$college = $_POST['college'];
	$yearlvl = $_POST['yearlvl'];
	$category = $_POST['category'];
	$position = $_POST['position'];
	
		
	
	$flag['code'] = 0;

	if($r=mysql_query("insert into user_table ( idNumber , password , firstName , lastName , middleName , college , yearLevel , category, position) values('$idnumber','$password','$studfn','$studln','$studmn','$college','$yearlvl','$category','$position') ",$con))
	{
		$flag['code'] = 1;
	}

	print(json_encode($flag));
	mysql_close($con);
?>