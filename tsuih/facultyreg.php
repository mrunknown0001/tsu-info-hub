<?php


	include "connect.php";
	
	$idnumber = $_POST['idnumber'];
	$password = $_POST['password'];
	$facultyfn = $_POST['facultyfn'];
	$facultyln = $_POST['facultyln'];
	$facultymn = $_POST['facultymn'];
	$college = $_POST['college'];
	$position = $_POST['position'];
	$category = $_POST['category'];
	

	
	$flag['code']=0;

	if($r=mysql_query("insert into user_table (idNumber , password , firstName , lastName , middleName , college , category, position) values('$idnumber','$password','$facultyfn','$facultyln','$facultymn','$college','$category', '$position') ",$con))
	{
		$flag['code']=1;
	}

	print(json_encode($flag));
	mysql_close($con);
	
?>