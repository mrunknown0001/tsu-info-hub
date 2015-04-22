<?php

	include "connect.php";
	
	$idnumber = $_POST['idnumber'];
	 
	 /*
	 * Checking if the user trying to register is valid.
	 */
	 
	$r = mysql_query("SELECT * FROM validation_table WHERE idNumber='$idnumber'",$con);

	while($row = mysql_fetch_array($r))
	{
		$flag['idNumber']=$row['idNumber'];
	 
	print(json_encode($flag));
	
	}
	mysql_close($con);
?>