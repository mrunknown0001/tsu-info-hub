<?php
	

	
	include "connect.php";
	

	$message = $_POST['message'];
	$type = $_POST['type'];
	$title = $_POST['title'];
	$viewer = $_POST['viewer'];
	$idnumber = $_POST['idnumber'];
	
	$flag['code']=0;

	if($r=mysql_query("insert into post_table (idNumber, postType, postTitle, message, viewer) values('$idnumber','$type','$title','$message','$viewer') ",$con));
	{
		$flag['code']=1;
	}

	print(json_encode($flag));
	mysql_close($con);
?>