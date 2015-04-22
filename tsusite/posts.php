<html>
	<head>
		<title>TSU Information Hub - History of Posts</title>
	</head>
	
	<body>
		<h3 align="">TSU Information Hub - History of Posts</h3>
		<br/>
		
		
			<table border="1" align="">
			<col width="150px;" />
			<col width="200px;" />
			<col width="250px;" />
			<col width="350px;" />
			<col width="300px;" />
			<tr>
			<th>
				ID Number
			</th>
			<th>
				Type
			</th>
			<th>
				Title
			</th>
			<th>
				Messages
			</th>
			<th>
				Date & Time
			</th>
			</tr>
				<?php
				
						
	include "connect.php";
						
						$total = 0;
	
							$r = mysql_query("SELECT * FROM post_table ORDER BY datetime DESC",$con);
							
							while($row = mysql_fetch_array($r))
							{
								$total = $total + 1;
									echo "<tr>";
									echo "<td>" . $row['idNumber'] . "</td>";
									echo "<td>" . $row['postType'] . "</td>";
									echo "<td>" . $row['postTitle'] . "</td>";
									echo "<td>" . $row['message'] . "</td>";
									echo "<td>" . $row['datetime'] . "</td>";
									echo "</tr>";
							}
						echo "Total Number of Post(s): " .  $total;
						
						mysql_close($con);
				
				?>
			</table>
			<br/>
			*** End of Posts ***
			
			
			<br />
			<br />
			<br />
	
	
	</body>
	
	
</html>