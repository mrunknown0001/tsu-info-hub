<?php

	$host = 'localhost'; //name of mysql server
	$uname = 'root';	//username of mysql user
	$pwd = 'openroot';	//password of mysql user
	$db = "tsuih";		//name of mysql database

	$con = mysql_connect($host,$uname,$pwd) or die("connection failed");
	mysql_select_db($db,$con) or die("db selection failed");
	
?>