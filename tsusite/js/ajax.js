//TEMPLATE AND FOR TESTING FUNCTIONS

function functionname()
{

var ajaxRequest;
	
	try{ajaxRequest = new XMLHttpRequest();}
	catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
	catch(e){alert("Browser problem.");return false;}}}
		
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			document.getElementById('id of div element where to display php file').innerHTML = ajaxRequest.responseText;
		}
	}

	ajaxRequest.open("GET", "php file to be called", true);
	ajaxRequest.send(null); 	
	
}

function Login() {

	idnum = document.getElementById("idnumber").value;
	pass = document.getElementById("password").value;
	
	if (idnum == "" || pass == "") {
	
		alert("Fill Out all fields!");
		
	}
	else {

	var ajaxRequest;
	
	try{ajaxRequest = new XMLHttpRequest();}
	catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
	catch(e){alert("Browser problem.");return false;}}}
		
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			document.getElementById('content').innerHTML = ajaxRequest.responseText;
		}
	}
	
	
	var idnumber = document.getElementById("idnumber").value;
	var password = document.getElementById("password").value;
	
	querySTR = "?idnumber=" + idnumber +  "&password=" + password;

	ajaxRequest.open("GET", "loginacc.php" + querySTR, true);
	ajaxRequest.send(null); 
	
	}

	
}


function TsuLogoMouseOver() {
	document.getElementById("logo").src="../tsusite/img/logotsu_mouseover.png";
	}
function TsuLogoMouseOut() {
	document.getElementById("logo").src="../tsusite/img/logotsu.png";
	}


function userlogin() {

	
	var ajaxRequest;
	
	try{ajaxRequest = new XMLHttpRequest();}
	catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
	catch(e){alert("Browser problem.");return false;}}}
		
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			document.getElementById('content').innerHTML = ajaxRequest.responseText;
		}
	}

	ajaxRequest.open("GET", "welcome.php", true);
	ajaxRequest.send(null); 

}
function userlogin2() {

	var ajaxRequest;
	
	try{ajaxRequest = new XMLHttpRequest();}
	catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
	catch(e){alert("Browser problem.");return false;}}}
		
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			document.getElementById('navigation').innerHTML = ajaxRequest.responseText;
		}
	}

	ajaxRequest.open("GET", "nav.php", true);
	ajaxRequest.send(null); 
	
}


function postmsg() {

	var ajaxRequest;
	
	try{ajaxRequest = new XMLHttpRequest();}
	catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
	catch(e){alert("Browser problem.");return false;}}}
		
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			document.getElementById('content').innerHTML = ajaxRequest.responseText;
		}
	}

	ajaxRequest.open("GET", "postmsg.php", true);
	ajaxRequest.send(null); 

}


function viewmsg() {

	var ajaxRequest;
	
	try{ajaxRequest = new XMLHttpRequest();}
	catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
	catch(e){alert("Browser problem.");return false;}}}
		
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			document.getElementById('navigation').innerHTML = ajaxRequest.responseText;
		}
	}

	ajaxRequest.open("GET", "viewmenu.php", true);
	ajaxRequest.send(null); 

}
function viewmsg2() {

	var ajaxRequest;
	
	try{ajaxRequest = new XMLHttpRequest();}
	catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
	catch(e){alert("Browser problem.");return false;}}}
		
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			document.getElementById('content').innerHTML = ajaxRequest.responseText;
		}
	}

	ajaxRequest.open("GET", "welcome.php", true);
	ajaxRequest.send(null); 

}


function back() {

	var ajaxRequest;
	
	try{ajaxRequest = new XMLHttpRequest();}
	catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
	catch(e){alert("Browser problem.");return false;}}}
		
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			document.getElementById('navigation').innerHTML = ajaxRequest.responseText;
		}
	}

	ajaxRequest.open("GET", "nav.php", true);
	ajaxRequest.send(null); 

	viewmsg2();
	
}

function logout() {
	
	var logout = confirm("Are you sure you want to Logout?");
	
	if (logout == true) {

	var ajaxRequest;
	
	try{ajaxRequest = new XMLHttpRequest();}
	catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
	catch(e){alert("Browser problem.");return false;}}}
		
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			document.getElementById('navigation').innerHTML = ajaxRequest.responseText;
		}
	}

	ajaxRequest.open("GET", "logout.php", true);
	ajaxRequest.send(null); 


	logout2();
	
	}
	
}
function logout2() {

var ajaxRequest;
	
	try{ajaxRequest = new XMLHttpRequest();}
	catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
	catch(e){alert("Browser problem.");return false;}}}
		
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			document.getElementById('content').innerHTML = ajaxRequest.responseText;
		}
	}

	ajaxRequest.open("GET", "login.php", true);
	ajaxRequest.send(null);
}



function messagepost() {

	var title = document.getElementById("posttitle").value;
	var type = document.getElementById("posttype").value;
	var message = document.getElementById("msg").value;
	var viewer = document.getElementById("viewer").value;
	
	
	if (title == "" || message == "") {
	
		alert("All Fields are required to be filled up!.");
	
	}
	else {
	
		var ans = confirm ("Are you sure you want to post this message?");
		
		if (ans == true) {
	
			var ajaxRequest;
	
			try{ajaxRequest = new XMLHttpRequest();}
			catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
			catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
			catch(e){alert("Browser problem.");return false;}}}
				
			ajaxRequest.onreadystatechange = function(){
				if(ajaxRequest.readyState == 4){
					document.getElementById('content').innerHTML = ajaxRequest.responseText;
				}
			}

			
			querySTR = "?title=" + title + "&type=" + type + "&message=" + message + "&viewer=" + viewer;
			
			ajaxRequest.open("GET", "postsuccess.php" + querySTR, true);
			ajaxRequest.send(null); 
	
		
		}
	
	
	}


}

function announcement() {

	var ajaxRequest;
	
	try{ajaxRequest = new XMLHttpRequest();}
	catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
	catch(e){alert("Browser problem.");return false;}}}
		
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			document.getElementById('content').innerHTML = ajaxRequest.responseText;
		}
	}

	ajaxRequest.open("GET", "announcement.php", true);
	ajaxRequest.send(null); 	

}

function whatsnew() {

	var ajaxRequest;
	
	try{ajaxRequest = new XMLHttpRequest();}
	catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
	catch(e){alert("Browser problem.");return false;}}}
		
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			document.getElementById('content').innerHTML = ajaxRequest.responseText;
		}
	}

	ajaxRequest.open("GET", "whatsnew.php", true);
	ajaxRequest.send(null);

}

function memos() {

	var ajaxRequest;
	
	try{ajaxRequest = new XMLHttpRequest();}
	catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
	catch(e){alert("Browser problem.");return false;}}}
		
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			document.getElementById('content').innerHTML = ajaxRequest.responseText;
		}
	}

	ajaxRequest.open("GET", "memo.php", true);
	ajaxRequest.send(null);

}


function maypasokba() {

	var ajaxRequest;
	
	try{ajaxRequest = new XMLHttpRequest();}
	catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
	catch(e){alert("Browser problem.");return false;}}}
		
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			document.getElementById('content').innerHTML = ajaxRequest.responseText;
		}
	}

	ajaxRequest.open("GET", "maypasokba.php", true);
	ajaxRequest.send(null);

}


function upcomingevents() {

	var ajaxRequest;
	
	try{ajaxRequest = new XMLHttpRequest();}
	catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
	catch(e){alert("Browser problem.");return false;}}}
		
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			document.getElementById('content').innerHTML = ajaxRequest.responseText;
		}
	}

	ajaxRequest.open("GET", "upcomingevents.php", true);
	ajaxRequest.send(null);

}

function dateofgrad() {

	var ajaxRequest;
	
	try{ajaxRequest = new XMLHttpRequest();}
	catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
	catch(e){alert("Browser problem.");return false;}}}
		
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			document.getElementById('content').innerHTML = ajaxRequest.responseText;
		}
	}

	ajaxRequest.open("GET", "dateofgraduation.php", true);
	ajaxRequest.send(null);

}

function history() {

	var ajaxRequest;
	
	try{ajaxRequest = new XMLHttpRequest();}
	catch(e){try{ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(e){try{ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");}
	catch(e){alert("Browser problem.");return false;}}}
		
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			document.getElementById('content').innerHTML = ajaxRequest.responseText;
		}
	}

	ajaxRequest.open("GET", "posts.php", true);
	ajaxRequest.send(null);

}