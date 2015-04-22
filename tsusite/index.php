<html>

	<head>
		<title>TSU Information Hub</title>
		
		<!-- css file -->
		<link rel="stylesheet" type="text/css" href="../tsusite/css/style.css" />
		<!-- javascript file -->
		<script type="text/javascript" src="../tsusite/js/ajax.js"> 
			window.onbeforeunload = function () {
				return " ";
			}
		
		</script>
	</head>

	<body text="white"id="bodybg">
	
		<div id="header" name="header">
		
			<?php include("header.php");?>
		
		</div>
		
		<div id="wrapper" name="wrapper">
		
			<div id="navigation" name="navigation">
			
			
			</div>
		
			<div id="content" name="content">
			
				<?php include("login.php"); ?>
			
			</div>
		
		
		</div>
		
		<div id="footer" name="footer">
		
			
		
		</div>
	
	
	</body>


</html>