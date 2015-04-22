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

public class FacultyReg extends Activity {
	
	/*
	 * Declaration of Variables
	 */

	private EditText facultyIdNumber;
	private EditText facultyPassword;
	private EditText facultyFirstName;
	private EditText facultyLastName;
	private EditText facultyMiddle;
	
	private Spinner spinCollegesFaculty;

	private String facultyIdNumberStr;
	private String facultyPasswordStr;
	private String facultyFirstNameStr;
	private String facultyLastNameStr;
	private String facultyMiddleStr;
	private String spinCollegesFacultyStr;
	public Button btnFacultyContinueReg;
	private String cat = "Faculty";
	
	InputStream is=null;
	String result=null;
	String line=null;
	int code;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.facultyreg);
		
		/*
		 * Initializations of Variables.
		 * 
		 */

		facultyIdNumber = (EditText) findViewById(R.id.facultyIdNumber);
		facultyPassword = (EditText) findViewById(R.id.FacultyPassword);
		facultyFirstName = (EditText) findViewById(R.id.facultyFirstName);
		facultyLastName = (EditText) findViewById(R.id.facultyLastName);
		facultyMiddle = (EditText) findViewById(R.id.facultyMiddleName);
		
		spinCollegesFaculty = (Spinner) findViewById(R.id.spinCollegesFaculty);


		
		
		
		btnFacultyContinueReg = (Button) findViewById(R.id.btnContinueFaculty);

		btnFacultyContinueReg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				/*
				 * Assignment of Variables
				 */

				facultyIdNumberStr = facultyIdNumber.getText().toString();		
				facultyPasswordStr = facultyPassword.getText().toString();
				facultyFirstNameStr = facultyFirstName.getText().toString();
				facultyLastNameStr = facultyLastName.getText().toString();
				facultyMiddleStr = facultyMiddle.getText().toString();		
				spinCollegesFacultyStr = spinCollegesFaculty.getSelectedItem().toString();
				
				// Check if there are blank field
				if (facultyIdNumberStr.equals("") || facultyPasswordStr.equals("") || facultyFirstNameStr.equals("") || facultyLastNameStr.equals("") || facultyMiddleStr.equals("") || facultyIdNumberStr.equals("")) {
					
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
						 * this is were to create a new faculty user
						 * 
						 */
					//}
					//else {
					
					//Toast.makeText(getApplicationContext(), "Not Connected to the Network!", Toast.LENGTH_SHORT).show();
				    //}
				} // End of the null field checking
							
				
				
			}

			private void Register() {


				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				 
			   	nameValuePairs.add(new BasicNameValuePair("idnumber", facultyIdNumberStr ));
			   	nameValuePairs.add(new BasicNameValuePair("password", facultyPasswordStr ));
			   	nameValuePairs.add(new BasicNameValuePair("facultyfn", facultyFirstNameStr ));
			   	nameValuePairs.add(new BasicNameValuePair("facultyln", facultyLastNameStr ));
			   	nameValuePairs.add(new BasicNameValuePair("facultymn", facultyMiddleStr ));
			   	nameValuePairs.add(new BasicNameValuePair("college", spinCollegesFacultyStr ));
			   	nameValuePairs.add(new BasicNameValuePair("position", cat));
			   	nameValuePairs.add(new BasicNameValuePair("category", cat));
			   	
				
			   	
			   	try
		    	{
				HttpClient httpclient = new DefaultHttpClient();
			        HttpPost httppost = new HttpPost("http://192.168.1.100/tsuih/facultyreg.php");
			        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			        HttpResponse response = httpclient.execute(httppost); 
			        HttpEntity entity = response.getEntity();
			        is = entity.getContent();
			        Log.e("pass 1", "connection success ");
			}
		        catch(Exception e)
			{
		        	Log.e("Fail 1", e.toString());
			    	Toast.makeText(getApplicationContext(), "Invalid IP Address", Toast.LENGTH_LONG).show();
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
						
			            if(code==1)
			            {
					Toast.makeText(getBaseContext(), "Registration Successful.", Toast.LENGTH_SHORT).show();
					
					Intent i = new Intent(getApplicationContext(), MainActivity.class);
					startActivity(i);
					
					
			            }
			            else
			            {
					 Toast.makeText(getBaseContext(), "This ID Number is already registered.", Toast.LENGTH_LONG).show();
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
