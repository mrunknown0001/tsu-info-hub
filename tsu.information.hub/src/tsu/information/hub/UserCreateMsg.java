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
import android.widget.Spinner;
import android.widget.Toast;



public class UserCreateMsg extends Activity {
	
	/*
	 * Initialization of variables
	 */
	

	
		

	private Button post;
	private EditText posttitle;
	private EditText msg;
	private Spinner type;
	private Spinner viewer;
	String msgstr;
	String msgtype;
	String posttitlestr;
	String viewerStr;
	String idnumber;
	


	
	InputStream is=null;
	String result=null;
	String line=null;
	int code;
	
	
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usercreatemsg);

        /*
         * Calling GlobalClass
         * and getting the value of the globalvariable assigning to a string
         */
        final GlobalClass globalvariable = (GlobalClass) getApplicationContext();
        
        final String idnumber = globalvariable.getUserId();
        
        
        
        msg = (EditText) findViewById(R.id.txtmessage);
        post = (Button) findViewById(R.id.btnPostMsg);
        type = (Spinner) findViewById(R.id.spinposttype);
        posttitle = (EditText) findViewById(R.id.posttitle);
        
        
        viewer = (Spinner) findViewById(R.id.spinnerviewer);
        
        

        
        post.setOnClickListener(new OnClickListener() {
        	
       
			@Override
			public void onClick(View view) {

				

				
				 msgstr = msg.getText().toString();
				 msgtype = type.getSelectedItem().toString();
				 posttitlestr = posttitle.getText().toString();
				 viewerStr = viewer.getSelectedItem().toString();
				 
				 if (msgstr.equals("") || (posttitlestr.equals(""))) {
					 
					 Toast.makeText(getApplicationContext(), "Cannot Post a Blank Message", Toast.LENGTH_SHORT).show();
					 
				 }
				 else {
					 
					 AlertDialog.Builder alert = new AlertDialog.Builder(UserCreateMsg.this);
						
						alert.setTitle("Confirm");
						alert.setMessage("Are you sure you want to post this message?");
					 
						alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								
									Post();
									
							}
						});
					 
					 alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						  public void onClick(DialogInterface dialog, int whichButton) {
						    // Must do Nothing.
						  }
						});
			
						alert.show();
					 
				 }
				
			}

			private void Post() {
				
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				 
				nameValuePairs.add(new BasicNameValuePair("message",msgstr));
				nameValuePairs.add(new BasicNameValuePair("type",msgtype));
				nameValuePairs.add(new BasicNameValuePair("title", posttitlestr));
				nameValuePairs.add(new BasicNameValuePair("viewer", viewerStr));
			   	nameValuePairs.add(new BasicNameValuePair("idnumber", idnumber));
			   	
			   	try
		    	{
				HttpClient httpclient = new DefaultHttpClient();
			        HttpPost httppost = new HttpPost("http://192.168.1.100/tsuih/post.php");
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
					Toast.makeText(getBaseContext(), "Successfully Posted.", Toast.LENGTH_SHORT).show();
					
						Intent i = new Intent(getApplicationContext(), UserHomePage.class);
						startActivity(i);
					
			            }
			            else
			            {
					 Toast.makeText(getBaseContext(), "Sorry, Try Again", Toast.LENGTH_LONG).show();
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