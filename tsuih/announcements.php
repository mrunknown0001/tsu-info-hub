<?php


	include "connect.php";
	
	$type = $_POST['type'];
	
	
	$r=mysql_query("SELECT * FROM post_table WHERE postType = '$type' ORDER BY datetime DESC",$con);

	while($row=mysql_fetch_array($r))
	{
		
		$flag['message']=$row['message'];
		$flag['postTitle']=$row['postTitle'];
		$flag['datetime']=$row['datetime'];
		$flag['viewer']=$row['viewer'];
		print(json_encode($flag));
	}
	 
	
	mysql_close($con);
?>