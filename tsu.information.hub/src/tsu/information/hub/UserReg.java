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
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

	

public class UserReg extends Activity {
	
	/*
	 * Declaration of Variables
	 */
	private EditText userIdNumber;
	private EditText userPassword;
	private EditText userFirstName;
	private EditText userLastName;
	private EditText userMiddle;
	
	private Spinner position;
	private Spinner salutation;
	
	private Button btnContinueUser;
	
	private String cat;
	private String userIdNumberStr;
	private String userPasswordStr;
	private String userFirstNameStr;
	private String userLastNameStr;
	private String userMiddleStr;
	private String positionStr;
	private String salutationStr;


	InputStream is=null;
	String result=null;
	String line=null;
	int code;
	
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userreg);
        
        /*
         * Initialization of Variables
         */
        userIdNumber = (EditText) findViewById(R.id.userIdNumber);
        userPassword = (EditText) findViewById(R.id.userPassword);
        userFirstName = (EditText) findViewById(R.id.userFirstName);
        userLastName = (EditText) findViewById(R.id.userLastName);
        userMiddle = (EditText) findViewById(R.id.userMiddleName);
        position = (Spinner) findViewById(R.id.spinnerposition);
        salutation =(Spinner) findViewById(R.id.salutation);
        
        /*
         * Declarations of Values of Variables
         * 
         */

        
        
        btnContinueUser = (Button) findViewById(R.id.btnContinueUser);
        
        btnContinueUser.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				
				/*
				 * Assigning Variables
				 */
		        userIdNumberStr = userIdNumber.getText().toString();
		        userPasswordStr = userPassword.getText().toString();
		        userFirstNameStr = userFirstName.getText().toString();
		        userLastNameStr = userLastName.getText().toString();
		        userMiddleStr = userMiddle.getText().toString();
		        positionStr = position.getSelectedItem().toString();
		        salutationStr = salutation.getSelectedItem().toString();
		        cat = "User";
		        
		        if (userIdNumberStr.equals("") || userPasswordStr.equals("") || userFirstNameStr.equals("") || userLastNameStr.equals("") || userMiddleStr.equals("") || userIdNumberStr.equals("")) {
		        	
		        	Toast toast = Toast.makeText(getApplicationContext(), "All fields are required to fill up with valid information!", Toast.LENGTH_SHORT);
		        	toast.setGravity(Gravity.CENTER, 0, 0);
		        	toast.show();
		        }
		        else {
		        	/*
					 * This condition check weather the device is
					 * connected to the network or not. (WiFi)
					 */
					
					//ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
					//NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

					//if (mWifi.isConnected()) {

		        			// This called to register a user.
		        			Register();
		        	
						/*
						 *This were the methods in creating a new User user 
						 */

					//}
					//else {
					
					//Toast.makeText(getApplicationContext(), "Not Connected to the Network!", Toast.LENGTH_SHORT).show();
				    //}
		        }
			}

			private void Register() {

				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

			   	nameValuePairs.add(new BasicNameValuePair("idnumber", userIdNumberStr ));
			   	nameValuePairs.add(new BasicNameValuePair("password", userPasswordStr ));
			   	nameValuePairs.add(new BasicNameValuePair("firstname", userFirstNameStr ));
			   	nameValuePairs.add(new BasicNameValuePair("lastname", userLastNameStr ));
			   	nameValuePairs.add(new BasicNameValuePair("middle", userMiddleStr ));
			   	nameValuePairs.add(new BasicNameValuePair("position", positionStr));
			   	nameValuePairs.add(new BasicNameValuePair("salutation", salutationStr));
			   	nameValuePairs.add(new BasicNameValuePair("category", cat ));
				
			   	try
		    	{
				HttpClient httpclient = new DefaultHttpClient();
			        HttpPost httppost = new HttpPost("http://192.168.1.100/tsuih/userreg.php");
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
			            code=(json_data.getInt("code"));
						
			            if(code==1)
			            {
					Toast.makeText(getBaseContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
					
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