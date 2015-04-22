<?php


	include "connect.php";
	
	$type = "Announcement";
	
	
	$r=mysql_query("SELECT * FROM post_table WHERE postType = '$type' ORDER BY datetime DESC",$con);

	echo "<h1>Announcements</h1>";
	
	echo "<table border='1'>";
	
	echo "<col width='250px;'>";
	echo "<col width='350px;'>";
	echo "<col width='300px;'>";
	
	
	echo "<tr>";
	echo "<th>Post Title</th>";
	echo "<th>Message</th>";
	echo "<th>Date Posted</th>";
	
	echo "</tr>";
	
	while($row=mysql_fetch_array($r))
	{
		echo "<tr>";
		echo "<td><b>" . $row['postTitle'] ."</b></td>" ;
		echo "<td>" . $row['message'] . "</td>";
		echo "<td>" . $row['datetime'] ."</td>";
		echo "</tr>";
	}
	 
	echo "</table>";
	
	mysql_close($con);
?>