package tsu.information.hub;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity{
	


	private EditText idnumber;
	private EditText password;
	
	private Button login;
	
	private String idnumberstr;
	private String passwordstr;
	
	InputStream is = null;
	String result = null;
	String line = null;
	
	   public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.login);
	        
	        
	        idnumber = (EditText) findViewById(R.id.idnumber);
	        password = (EditText) findViewById(R.id.password);
	        
	        
	        login = (Button) findViewById(R.id.btnLogin);
	        
	        login.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					
					idnumberstr = idnumber.getText().toString();
					passwordstr = password.getText().toString();
					
					
					if (idnumberstr.equals("") || passwordstr.equals("")) {
						
						Toast.makeText(getApplicationContext(), "Check Login Details!", Toast.LENGTH_SHORT).show();
						
					}
					else {
						
						Login();
						
						
						
					}
					
					
				}

				private void Login() {

					ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
					
					nameValuePairs.add(new BasicNameValuePair("idnumber", idnumberstr ));	
					
					try
			    	{
						HttpClient httpclient = new DefaultHttpClient();
				        HttpPost httppost = new HttpPost("http://192.168.1.100/tsuih/login.php");
				        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				        HttpResponse response = httpclient.execute(httppost); 
				        HttpEntity entity = response.getEntity();
				        is = entity.getContent();
				        Log.e("pass 1", "connection success ");
			    	}
			        catch(Exception e)
			        {
			        	Log.e("Fail 1", e.toString());
				    	//Toast.makeText(getApplicationContext(), "Invalid IP Address", Toast.LENGTH_LONG).show();

			        }
					
					try
			        {
			         	BufferedReader reader = new BufferedReader
							(new InputStreamReader(is,"iso-8859-1"),8);
			            	StringBuilder sb = new StringBuilder();
			            	while ((line = reader.readLine()) != null)
					{
			       		    sb.append(line + "\n");
			           	}
			            	is.close();
			            	result = sb.toString();
			            	
			            	/* Checking the content value of the string from php file
			            	 * 
			            	 */
			            	//Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
			            	
			            	Log.e("pass 2", "connection success ");
			        }
			        catch(Exception e)
			    	{
					Log.e("Fail 2", e.toString());
		        	//Toast.makeText(getApplicationContext(), "Error in Buffered Reader.", Toast.LENGTH_SHORT).show();

			    	}
					
					
					try
			    	{
			        	JSONObject json_data = new JSONObject(result);
			        	
			        	String idnum = (json_data.getString("idNumber"));
			        	String pass = (json_data.getString("password"));
			        	String category = (json_data.getString("category"));
			        	String fn = (json_data.getString("firstName"));
			        	String col = (json_data.getString("college"));
			        	String yl = (json_data).getString("yearLevel");
			        	String position = (json_data).getString("position");



			        	/*
			        	 * Calling GlobalClass
			        	 * and setting the value of the globalvariable
			        	 */
			        	final GlobalClass globalvariable = (GlobalClass) getApplicationContext();
			        	
			        	globalvariable.setUserId(idnum);
			        	globalvariable.setCat(category);
			        	globalvariable.setCol(col);
			        	globalvariable.setYL(yl);
			        	globalvariable.setPosition(position);
			        	
			        	
			        	
			        	if (idnum.equals(idnumberstr) && pass.equals(passwordstr)) {
			        		// for student user only
			        		if (category.equals("Student") || (category.equals("Faculty")) || (category.equals("Non Teaching"))) {
			        		
			        			
			        			AlertDialog.Builder alert = new AlertDialog.Builder(Login.this);
			    				
			    				alert.setTitle("TSU Information Hub");
			    				alert.setMessage("Welcome " + fn + "!");
			    				
			    				alert.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
			    					public void onClick(DialogInterface dialog, int whichButton) {
			        			
			        			
					        		Intent i = new Intent(getApplicationContext(), HomePage.class);
					        		startActivity(i);
					        		
				        		
			    					}
								});
			    				
			    				alert.show();
							
			        		}
			        		else if (category.equals("User")) {
			        			
			        			AlertDialog.Builder alert = new AlertDialog.Builder(Login.this);
			    				
			    				alert.setTitle("TSU Information Hub");
			    				alert.setMessage("Welcome " + fn + "!");
			    				
			    				alert.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
			    					public void onClick(DialogInterface dialog, int whichButton) {
			        			
			    						
			    			        	
			    			        	Intent intent = new Intent(getApplicationContext(), UserHomePage.class);
			    			        	startActivity(intent);
					        		
					        		
			    					}
								});
			    				
			    				alert.show();
			        		}
			        	}
			        	else {
			        		
			        		Toast.makeText(getApplicationContext(), "Check Login Details.", Toast.LENGTH_SHORT).show();
			        	}
			        	
			        	
			    	}
			        catch(Exception e)
			    	{
			        	Log.e("Fail 3", e.toString());
			        	Toast.makeText(getApplicationContext(), "Error in Login.", Toast.LENGTH_SHORT).show();
			    	}
					
				}});
	        
	   }

}
