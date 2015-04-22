<html>
	<head>
		<title>Insert in Validation</title>
		
				
	</head>

	<body>
		<div id="wrap" style="height:700px;width:700px;background-color:;margin:auto;">
		<h3 align="center">Insert to Validation Table</h3>
		
		<br />
		
		<form method="post" action="validation.php">
			<table>
			<tr>
			
			<td>Student Number:</td> <td><input type="text" id="sn" name="sn" /></td>
			
			</tr>
			
			<tr>
			
			<td>First Name:</td> <td><input type="text" id="fn" name="fn" /></td>
			
			</tr>
			
			
			<tr>
			
			<td>Last Name:</td> <td><input type="text" id="ln" name="ln" /></td>
			
			</tr>
			
			<tr>
			<td>College:</td> <td><input type="text" id="college" name="college" /></td>
			</tr>
			</table>
		
			<input type="submit"  value="GO" id="submit" name="submit" />
		
		</form>
		
		</div>
	
	<?php
		
		
	include "connect.php";
			
			
			$sn = $_POST['sn'];
			$fn = $_POST['fn'];
			$ln = $_POST['ln'];
			$college = $_POST['college'];
			
			if ($sn != "") {
			
			mysql_query("INSERT INTO validation_table (idNumber, firstName, lastName, college)   VALUES ('$sn','$fn','$ln','$college')", $con);
			
			}
			
		mysql_close($con);
	
	?>
	
	
	
	</body>

</html>