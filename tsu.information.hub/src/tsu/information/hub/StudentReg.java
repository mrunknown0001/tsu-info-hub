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
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class StudentReg extends Activity {
	
	
	/*
	 * Declarations 
	 */
	
	private Button btnContinueReg;
	
	private EditText studentPassword;
	private EditText studentFirstName;
	private EditText studentLastName;
	private EditText studentMiddle;
	private EditText studentNumber;
	
	private Spinner spinColleges;
	private Spinner yearLevel;
	
	private String studentPasswordStr;
	private String studentFirstNameStr;
	private String studentLastNameStr;
	private String studentMiddleStr;
	private String studentNumberStr;
	private String spinCollegesStr;
	private String yearLevelStr;
	private String cat;
	

	InputStream is = null;
	String result = null;
	String line = null;
	int code;

	/* This will check if the user will be a valid 
	 *  user of the system, and validate the input.
	 * 
	 */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.studentreg);
		
		/*
		 * Initializations variables.
		 * 
		 */
		
		studentPassword = (EditText) findViewById(R.id.studentPassword);
		studentFirstName = (EditText) findViewById(R.id.studentFirstName);
		studentLastName = (EditText) findViewById(R.id.studentLastName);
		studentMiddle = (EditText) findViewById(R.id.studentMiddleName);
		studentNumber = (EditText) findViewById(R.id.studentNumber);
		
		spinColleges = (Spinner) findViewById(R.id.spinColleges);
		yearLevel = (Spinner) findViewById(R.id.yearLevel);
		
		// Assignments of Strings
		cat = "Student";


		
		
		btnContinueReg = (Button) findViewById(R.id.btnStudentContinue);
		
		btnContinueReg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				
				/*
				 * Assigning of Variables
				 */
				studentNumberStr = studentNumber.getText().toString();
				studentPasswordStr = studentPassword.getText().toString();
				studentFirstNameStr = studentFirstName.getText().toString();
				studentLastNameStr = studentLastName.getText().toString();
				studentMiddleStr = studentMiddle.getText().toString();
				
				spinCollegesStr = spinColleges.getSelectedItem().toString();
				yearLevelStr = yearLevel.getSelectedItem().toString();
				
				if (studentNumberStr.equals("") || studentPasswordStr.equals("") || studentFirstNameStr.equals("") || studentLastNameStr.equals("") || studentMiddleStr.equals("") || studentNumberStr.equals("")) {
					
					Toast.makeText(getApplicationContext(), "All fields are required to fill up with valid information!", Toast.LENGTH_SHORT).show();
					
				}
				else {
					
					/*
					 * This condition check weather the device is
					 * connected to the network or not. (WiFi)
					 */
					
					//ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
					//NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

					//if (mWifi.isConnected()) {
					    
						
						Register();
						/*
						 *This were the methods in creating a new Student user 
						 */

					//}
					//else {
					
					//Toast.makeText(getApplicationContext(), "Not Connected to the Network!", Toast.LENGTH_SHORT).show();
				    
					
				//}
				
				} // End of checking of null fields
			}

			private void Register() {

					
				
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				
				nameValuePairs.add(new BasicNameValuePair("idnumber", studentNumberStr ));	
				
				try
		    	{
					HttpClient httpclient = new DefaultHttpClient();
			        HttpPost httppost = new HttpPost("http://192.168.1.100/tsuih/register.php");
			        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			        HttpResponse response = httpclient.execute(httppost); 
			        HttpEntity entity = response.getEntity();
			        is = entity.getContent();
			        Log.e("pass 1", "connection success ");
		    	}
		        catch(Exception e)
		        {
		        	Log.e("Fail 1", e.toString());
			    	Toast.makeText(getApplicationContext(), "Invalid IP Address",
					Toast.LENGTH_LONG).show();

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
		            	
		            	Log.e("pass 2", "connection success ");
		        }
		        catch(Exception e)
		    	{
				Log.e("Fail 2", e.toString());
	        	Toast.makeText(getApplicationContext(), "Error in Buffered Reader.", Toast.LENGTH_SHORT).show();

		    	}
				
				try
		    	{
		        	JSONObject json_data = new JSONObject(result);
		        	
		        	String IdNumber = (json_data.getString("idNumber"));
		        	
		        	if (IdNumber.equals(studentNumberStr)) {
		        		
		        		//Toast.makeText(getApplicationContext(), "valid to register.", Toast.LENGTH_SHORT).show();
		        		
		        		InsertReg();
		        		
		        	}
		    	}
		        catch(Exception e)
		    	{
		        	Log.e("Fail 3", e.toString());
		        	
		        	Toast.makeText(getApplicationContext(), "Not Valid to Register.", Toast.LENGTH_SHORT).show();
		    	}
				
			}

			private void InsertReg() {


				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				 
			   	nameValuePairs.add(new BasicNameValuePair("idnumber",studentNumberStr));
			   	nameValuePairs.add(new BasicNameValuePair("password",studentPasswordStr ));
			   	nameValuePairs.add(new BasicNameValuePair("studfn",studentFirstNameStr ));
			   	nameValuePairs.add(new BasicNameValuePair("studln",studentLastNameStr ));
			   	nameValuePairs.add(new BasicNameValuePair("studmn",studentMiddleStr ));
			   	nameValuePairs.add(new BasicNameValuePair("college",spinCollegesStr ));
			   	nameValuePairs.add(new BasicNameValuePair("yearlvl",yearLevelStr ));
			   	nameValuePairs.add(new BasicNameValuePair("position", cat));
			   	nameValuePairs.add(new BasicNameValuePair("category", cat));
			   	
			   	try
		    	{
				HttpClient httpclient = new DefaultHttpClient();
			        HttpPost httppost = new HttpPost("http://192.168.1.100/tsuih/insertreg.php");
			        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			        HttpResponse response = httpclient.execute(httppost); 
			        HttpEntity entity = response.getEntity();
			        is = entity.getContent();
			        Log.e("pass 1", "connection success ");
		    	}
		        catch(Exception e)
		        {
		        	Log.e("Fail 1", e.toString());
			    	Toast.makeText(getApplicationContext(), "Invalid IP Address",
					Toast.LENGTH_LONG).show();
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
		            
		           /*
		            * text to show the result string from php file
		            */
		            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
			    Log.e("pass 2", "connection success ");
		        }
		        catch(Exception e)
		        {
		        Log.e("Fail 2", e.toString());
		        }
			    try
				{
			            JSONObject json_data = new JSONObject(result);
			            code = (json_data.getInt("code"));
						
			            if(code == 1)
			            {
					Toast.makeText(getBaseContext(), "Registration Successful! You can now Login.", Toast.LENGTH_SHORT).show();

						Intent i = new Intent(getApplicationContext(), MainActivity.class);
						startActivity(i);
					
			            }
			            else
			            {
					 Toast.makeText(getBaseContext(), "This ID Number was already registered.", Toast.LENGTH_LONG).show();
			            }
				}
				catch(Exception e)
				{
			            Log.e("Fail 3", e.toString());
				}
				
			}
			
		});
		
	}

}
