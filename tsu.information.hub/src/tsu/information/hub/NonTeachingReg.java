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
import android.widget.Toast;

public class NonTeachingReg extends Activity {
	
	/*
	 * Declarations of Variables
	 */
	private EditText nonTeachingIdNumber;
	private EditText nonTeachingPassword;
	private EditText nonTeachingFirstName;
	private EditText nonTeachingLastName;
	private EditText nonTeachingMiddle;
	
	private Button btnContinueNonteachingReg;


	private String nonTeachingIdNumberStr;
	private String nonTeachingPasswordStr;
	private String nonTeachingFirstNameStr;
	private String nonTeachingLastNameStr;
	private String nonTeachingMiddleStr;
	private String cat;
	
	
	InputStream is=null;
	String result=null;
	String line=null;
	int code;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nonteachingreg);
		
		/*
		 * Initialization of Variables
		 */

		nonTeachingPassword = (EditText) findViewById(R.id.nonteachingPassword);
		nonTeachingFirstName = (EditText) findViewById(R.id.nonteachingFirstName);
		nonTeachingLastName = (EditText) findViewById(R.id.nonteachingLastName);
		nonTeachingMiddle = (EditText) findViewById(R.id.nonteachingMiddleName);
		nonTeachingIdNumber = (EditText) findViewById(R.id.nonTeachingIdNumber);
		
		/*
		 * Declaration of Variables
		 */
		
		
		
		
		btnContinueNonteachingReg = (Button) findViewById(R.id.btnContinueNonteaching);
		
		btnContinueNonteachingReg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				
				/*
				 * Assigning Variables
				 */

				nonTeachingIdNumberStr = nonTeachingIdNumber.getText().toString();	
				nonTeachingPasswordStr = nonTeachingPassword.getText().toString();
				nonTeachingFirstNameStr = nonTeachingFirstName.getText().toString();
				nonTeachingLastNameStr = nonTeachingLastName.getText().toString();
				nonTeachingMiddleStr = nonTeachingMiddle.getText().toString();
				cat = "Non Teaching";
				
				if (nonTeachingIdNumberStr.equals("") || nonTeachingPasswordStr.equals("") || nonTeachingFirstNameStr.equals("") || nonTeachingLastNameStr.equals("") || nonTeachingMiddleStr.equals("") || nonTeachingIdNumberStr.equals("")) {
					
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
					    
					/*
					 * The method Register() called to register a user.
					 */
						Register();
					
						
					//}
					//else {
					
					//Toast.makeText(getApplicationContext(), "Not Connected to the Network!", Toast.LENGTH_SHORT).show();
				   // }
					
					
					
				}
							
			}

			private void Register() {
				
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

			   	nameValuePairs.add(new BasicNameValuePair("idnumber", nonTeachingIdNumberStr ));
			   	nameValuePairs.add(new BasicNameValuePair("password", nonTeachingPasswordStr ));
			   	nameValuePairs.add(new BasicNameValuePair("ntfirstname", nonTeachingFirstNameStr ));
			   	nameValuePairs.add(new BasicNameValuePair("ntlastname", nonTeachingLastNameStr ));
			   	nameValuePairs.add(new BasicNameValuePair("ntmiddle", nonTeachingMiddleStr ));
			   	nameValuePairs.add(new BasicNameValuePair("position", cat));
			   	nameValuePairs.add(new BasicNameValuePair("category", cat ));
				
			   	
			   	try
		    	{
				HttpClient httpclient = new DefaultHttpClient();
			        HttpPost httppost = new HttpPost("http://192.168.1.100/tsuih/nonteachingreg.php");
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
		            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
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
					Toast.makeText(getBaseContext(), "Registered Successful.", Toast.LENGTH_SHORT).show();
					
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
