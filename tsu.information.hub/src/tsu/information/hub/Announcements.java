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
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Announcements extends Activity {
	

	
	private TextView posttitle;
	private TextView postdatetime;
	private TextView postMessage;
	
	InputStream is=null;
	String result=null;
	String line=null;
	
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.announcements);
        
        
        
        posttitle = (TextView) findViewById(R.id.posttitle);
        postdatetime = (TextView) findViewById(R.id.postdatetime);
        postMessage = (TextView) findViewById(R.id.postMessage);
        
        Message();
    }

	private void Message() {

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		 
		nameValuePairs.add(new BasicNameValuePair("type", "Announcement"));
		
		try
    	{
			HttpClient httpclient = new DefaultHttpClient();
	        HttpPost httppost = new HttpPost("http://192.168.1.100/tsuih/announcements.php");
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
            	//Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
	        Log.e("pass 2", "connection success ");
	}
        catch(Exception e)
    	{
		Log.e("Fail 2", e.toString());
	}
		
		try
    	{
        	JSONObject json_data = new JSONObject(result);
        	
        	String viewer = (json_data.getString("viewer"));
        	
        	//Toast.makeText(getApplicationContext(), viewer, Toast.LENGTH_SHORT).show();
        	
        	/*
             * Calling GlobalClass
             * and assigning value to the global variable
             */
            GlobalClass globalvariable = (GlobalClass) getApplicationContext();
            
            @SuppressWarnings("unused")
			final String idnumber = globalvariable.getUserId();
            final String college = globalvariable.getCol();
            final String yearlevel = globalvariable.getYL();
            final String category = globalvariable.getCat();
            final String position = globalvariable.getPosition();
        	
            /*
             * Start of Condition of Filtering in Announcement
             * 
             * ****************************************************************************
             */
            
            
               
        	
        	// Condition for All Students
        	if (viewer.equals("All Students")) {
        		
        		if (category.equals("Student"))  {
        			
        			if (result != null) {
        	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
        	        	posttitle.setText(msgtitle);
                	}
                	        	
                	if (result != null) {
        	        	String msgresult = "Message:  " + (json_data.getString("message"));
        	        	postMessage.setText(msgresult);
                	}

                	if(result != null) {
                		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                    	postdatetime.setText(msgdattime);
                	}
        			
        		}
        		
        	}
        	
        	
        	/*
        	 * ******************************************
        	 * START OF FILTERING FOR STUDENTS BY COLLEGE
        	 * ******************************************
        	 */
        	
        	
        	// Condition for All Students of CCS
        	if (viewer.equals("All Students of CCS")) {
        		
        		if (college.equals("College of Computer Studies")) {
        			
        			if (category.equals("Student")) {
        				
        				if (result != null) {
            	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
            	        	posttitle.setText(msgtitle);
                    	}
                    	        	
                    	if (result != null) {
            	        	String msgresult = "Message:  " + (json_data.getString("message"));
            	        	postMessage.setText(msgresult);
                    	}

                    	if(result != null) {
                    		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                        	postdatetime.setText(msgdattime);
                    	}
        				
        			}
        		}
        		
        	}
        	//**********************************************************
        	// Condition for First Year Students of CCS
        	if (viewer.equals("1st Year Students of CCS")) {
        		
        		if (college.equals("College of Computer Studies")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("First Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	// Condition for Second Year Students of CCS
        	if (viewer.equals("2nd Year Students of CCS")) {
        		
        		if (college.equals("College of Computer Studies")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Second Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Third Year Students of CCS
        	if (viewer.equals("3rd Year Students of CCS")) {
        		
        		if (college.equals("College of Computer Studies")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Third Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Fourth Year Students of CCS
        	if (viewer.equals("4th Year Students of CCS")) {
        		
        		if (college.equals("College of Computer Studies")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Fourth Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	//******************************************************************
        	
        	// Condition for All Students of COE
        	if (viewer.equals("All Students of COE")) {
        		
        		if (college.equals("College of Engineering")) {
        			
        			if (category.equals("Student")) {
        				
        				if (result != null) {
            	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
            	        	posttitle.setText(msgtitle);
                    	}
                    	        	
                    	if (result != null) {
            	        	String msgresult = "Message:  " + (json_data.getString("message"));
            	        	postMessage.setText(msgresult);
                    	}

                    	if(result != null) {
                    		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                        	postdatetime.setText(msgdattime);
                    	}
        				
        			}
        		}
        		
        	}
        	
        	//******************************************************************
        	
        	
        	// Condition for First Year Students of COE
        	if (viewer.equals("1st Year Students of COE")) {
        		
        		if (college.equals("College of Engineering")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("First Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	// Condition for Second Year Students of COE
        	if (viewer.equals("2nd Year Students of COE")) {
        		
        		if (college.equals("College of Engineering")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Second Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Third Year Students of COE
        	if (viewer.equals("3rd Year Students of COE")) {
        		
        		if (college.equals("College of Engineering")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Third Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Fourth Year Students of COE
        	if (viewer.equals("4th Year Students of COE")) {
        		
        		if (college.equals("College of Engineering")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Fourth Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	// Condition for Fifth Year Students of COE
        	if (viewer.equals("5th Year Students of COE")) {
        		
        		if (college.equals("College of Engineering")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Fifth Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	//******************************************************************
        	
        	
        	
        	
        	
        	// Condition for All Students of CHK
        	if (viewer.equals("All Students of CHK")) {
        		
        		if (college.equals("College of Human Kinetics")) {
        			
        			if (category.equals("Student")) {
        				
        				if (result != null) {
            	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
            	        	posttitle.setText(msgtitle);
                    	}
                    	        	
                    	if (result != null) {
            	        	String msgresult = "Message:  " + (json_data.getString("message"));
            	        	postMessage.setText(msgresult);
                    	}

                    	if(result != null) {
                    		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                        	postdatetime.setText(msgdattime);
                    	}
        				
        			}
        		}
        		
        	}
        	/*
        	 * *************************************************
        	 * 
        	 */
        	
        	
        	// Condition for First Year Students of CHK
        	if (viewer.equals("1st Year Students of CHK")) {
        		
        		if (college.equals("College of Human Kinetics")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("First Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	// Condition for Second Year Students of CHK
        	if (viewer.equals("2nd Year Students of CHK")) {
        		
        		if (college.equals("College of Human Kinetics")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Second Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Third Year Students of CHK
        	if (viewer.equals("3rd Year Students of CHK")) {
        		
        		if (college.equals("College of Human Kinetics")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Third Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Fourth Year Students of CHK
        	if (viewer.equals("4th Year Students of CHK")) {
        		
        		if (college.equals("College of Human Kinetics")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Fourth Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	
        	//*************************************************
        	
        	
        	
        	// Condition for All Students of COS
        	if (viewer.equals("All Students of COS")) {
        		
        		if (college.equals("College of Science")) {
        			
        			if (category.equals("Student")) {
        				
        				if (result != null) {
            	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
            	        	posttitle.setText(msgtitle);
                    	}
                    	        	
                    	if (result != null) {
            	        	String msgresult = "Message:  " + (json_data.getString("message"));
            	        	postMessage.setText(msgresult);
                    	}

                    	if(result != null) {
                    		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                        	postdatetime.setText(msgdattime);
                    	}
        				
        			}
        		}
        		
        	}
        	
        	//*****************************************
        	
        	
        	// Condition for First Year Students of COS
        	if (viewer.equals("1st Year Students of COS")) {
        		
        		if (college.equals("College of Science")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("First Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	// Condition for Second Year Students of COS
        	if (viewer.equals("2nd Year Students of COS")) {
        		
        		if (college.equals("College of Science")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Second Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Third Year Students of COS
        	if (viewer.equals("3rd Year Students of COS")) {
        		
        		if (college.equals("College of Science")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Third Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Fourth Year Students of COS
        	if (viewer.equals("4th Year Students of COS")) {
        		
        		if (college.equals("College of Science")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Fourth Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	//*****************************************
        	
        	
        	// Condition for All Students of CASS
        	if (viewer.equals("All Students of CASS")) {
        		
        		if (college.equals("College of Arts and Social Sciences")) {
        			
        			if (category.equals("Student")) {
        				
        				if (result != null) {
            	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
            	        	posttitle.setText(msgtitle);
                    	}
                    	        	
                    	if (result != null) {
            	        	String msgresult = "Message:  " + (json_data.getString("message"));
            	        	postMessage.setText(msgresult);
                    	}

                    	if(result != null) {
                    		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                        	postdatetime.setText(msgdattime);
                    	}
        				
        			}
        		}
        		
        	}
        	
        	//***************************
        	
        	// Condition for First Year Students of CASS
        	if (viewer.equals("1st Year Students of CASS")) {
        		
        		if (college.equals("College of Arts and Social Sciences")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("First Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	// Condition for Second Year Students of CASS
        	if (viewer.equals("2nd Year Students of CASS")) {
        		
        		if (college.equals("College of Arts and Social Sciences")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Second Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Third Year Students of CASS
        	if (viewer.equals("3rd Year Students of CASS")) {
        		
        		if (college.equals("College of Arts and Social Sciences")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Third Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Fourth Year Students of CASS
        	if (viewer.equals("4th Year Students of CASS")) {
        		
        		if (college.equals("College of Arts and Social Sciences")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Fourth Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	//***************************
        	
        	
        	// Condition for All Students of CPA
        	if (viewer.equals("All Students of CPA")) {
        		
        		if (college.equals("College of Public Administration")) {
        			
        			if (category.equals("Student")) {
        				
        				if (result != null) {
            	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
            	        	posttitle.setText(msgtitle);
                    	}
                    	        	
                    	if (result != null) {
            	        	String msgresult = "Message:  " + (json_data.getString("message"));
            	        	postMessage.setText(msgresult);
                    	}

                    	if(result != null) {
                    		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                        	postdatetime.setText(msgdattime);
                    	}
        				
        			}
        		}
        		
        	}
        	//*********************************************
        	
        	// Condition for First Year Students of CPA
        	if (viewer.equals("1st Year Students of CPA")) {
        		
        		if (college.equals("College of Public Administration")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("First Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	// Condition for Second Year Students of CPA
        	if (viewer.equals("2nd Year Students of CPA")) {
        		
        		if (college.equals("College of Public Administration")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Second Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Third Year Students of CPA
        	if (viewer.equals("3rd Year Students of CPA")) {
        		
        		if (college.equals("College of Public Administration")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Third Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Fourth Year Students of CPA
        	if (viewer.equals("4th Year Students of CPA")) {
        		
        		if (college.equals("College of Public Administration")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Fourth Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	//*********************************************
        	
        	// Condition for All Students of CBA
        	if (viewer.equals("All Students of CBA")) {
        		
        		if (college.equals("College of Business and Accountancy")) {
        			
        			if (category.equals("Student")) {
        				
        				if (result != null) {
            	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
            	        	posttitle.setText(msgtitle);
                    	}
                    	        	
                    	if (result != null) {
            	        	String msgresult = "Message:  " + (json_data.getString("message"));
            	        	postMessage.setText(msgresult);
                    	}

                    	if(result != null) {
                    		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                        	postdatetime.setText(msgdattime);
                    	}
        				
        			}
        		}
        		
        	}
        	//**********
        	
        	
        	// Condition for First Year Students of CBA
        	if (viewer.equals("1st Year Students of CBA")) {
        		
        		if (college.equals("College of Business and Accountancy")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("First Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	// Condition for Second Year Students of CBA
        	if (viewer.equals("2nd Year Students of CBA")) {
        		
        		if (college.equals("College of Business and Accountancy")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Second Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Third Year Students of CBA
        	if (viewer.equals("3rd Year Students of CBA")) {
        		
        		if (college.equals("College of Business and Accountancy")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Third Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Fourth Year Students of CBA
        	if (viewer.equals("4th Year Students of CBA")) {
        		
        		if (college.equals("College of Business and Accountancy")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Fourth Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Fifth Year Students of CBA
        	if (viewer.equals("5th Year Students of CBA")) {
        		
        		if (college.equals("College of Business and Accountancy")) {
        			
        			if (category.equals("Student")) {
        				
        				if (yearlevel.equals("Fifth Year")) {
        					
        					if (result != null) {
                	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
                	        	posttitle.setText(msgtitle);
                        	}
                        	        	
                        	if (result != null) {
                	        	String msgresult = "Message:  " + (json_data.getString("message"));
                	        	postMessage.setText(msgresult);
                        	}

                        	if(result != null) {
                        		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                            	postdatetime.setText(msgdattime);
                        	}
        					
        				}
        				
        			}
        		}
        		
        	}
        	
        	//**********
        	
        	// Condition for All Faculty
        	if (viewer.equals("All Faculty")) {
        		
        		if (category.equals("Faculty"))  {
        			
        			if (result != null) {
        	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
        	        	posttitle.setText(msgtitle);
                	}
                	        	
                	if (result != null) {
        	        	String msgresult = "Message:  " + (json_data.getString("message"));
        	        	postMessage.setText(msgresult);
                	}
                	
                	if(result != null) {
                		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                    	postdatetime.setText(msgdattime);
                	}
        			
        		}
        		
        	}
        	/*
        	 * ****************************
        	 * END OF STUDENTS BY COLLEGE
        	 * ***************************
        	 */
        	
        	
        	/*
        	 * ***************************
        	 * START OF FACULTY BY COLLEGE
        	 * ***************************
        	 */
        	
        	// Condition for  Faculty of CCS
        	if (viewer.equals("Faculty of CCS")) {
        		
        		if (college.equals("College of Computer Studies")) {
        			
        			if (category.equals("Faculty")) {
        				
        				if (result != null) {
            	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
            	        	posttitle.setText(msgtitle);
                    	}
                    	        	
                    	if (result != null) {
            	        	String msgresult = "Message:  " + (json_data.getString("message"));
            	        	postMessage.setText(msgresult);
                    	}

                    	if(result != null) {
                    		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                        	postdatetime.setText(msgdattime);
                    	}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Faculty of COE
        	if (viewer.equals("Faculty of COE")) {
        		
        		if (college.equals("College of Engineering")) {
        			
        			if (category.equals("Faculty")) {
        				
        				if (result != null) {
            	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
            	        	posttitle.setText(msgtitle);
                    	}
                    	        	
                    	if (result != null) {
            	        	String msgresult = "Message:  " + (json_data.getString("message"));
            	        	postMessage.setText(msgresult);
                    	}

                    	if(result != null) {
                    		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                        	postdatetime.setText(msgdattime);
                    	}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Faculty of CHK
        	if (viewer.equals("Faculty of CHK")) {
        		
        		if (college.equals("College of Human Kinetics")) {
        			
        			if (category.equals("Faculty")) {
        				
        				if (result != null) {
            	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
            	        	posttitle.setText(msgtitle);
                    	}
                    	        	
                    	if (result != null) {
            	        	String msgresult = "Message:  " + (json_data.getString("message"));
            	        	postMessage.setText(msgresult);
                    	}

                    	if(result != null) {
                    		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                        	postdatetime.setText(msgdattime);
                    	}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Faculty of COS
        	if (viewer.equals("Faculty of COS")) {
        		
        		if (college.equals("College of Science")) {
        			
        			if (category.equals("Faculty")) {
        				
        				if (result != null) {
            	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
            	        	posttitle.setText(msgtitle);
                    	}
                    	        	
                    	if (result != null) {
            	        	String msgresult = "Message:  " + (json_data.getString("message"));
            	        	postMessage.setText(msgresult);
                    	}

                    	if(result != null) {
                    		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                        	postdatetime.setText(msgdattime);
                    	}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Faculty of CASS
        	if (viewer.equals("Faculty of CASS")) {
        		
        		if (college.equals("College of Arts and Social Sciences")) {
        			
        			if (category.equals("Faculty")) {
        				
        				if (result != null) {
            	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
            	        	posttitle.setText(msgtitle);
                    	}
                    	        	
                    	if (result != null) {
            	        	String msgresult = "Message:  " + (json_data.getString("message"));
            	        	postMessage.setText(msgresult);
                    	}

                    	if(result != null) {
                    		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                        	postdatetime.setText(msgdattime);
                    	}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Faculty of CPA
        	if (viewer.equals("Faculty of CPA")) {
        		
        		if (college.equals("College of Public Administration")) {
        			
        			if (category.equals("Faculty")) {
        				
        				if (result != null) {
            	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
            	        	posttitle.setText(msgtitle);
                    	}
                    	        	
                    	if (result != null) {
            	        	String msgresult = "Message:  " + (json_data.getString("message"));
            	        	postMessage.setText(msgresult);
                    	}

                    	if(result != null) {
                    		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                        	postdatetime.setText(msgdattime);
                    	}
        				
        			}
        		}
        		
        	}
        	
        	
        	// Condition for Faculty of CBA
        	if (viewer.equals("Faculty of CBA")) {
        		
        		if (college.equals("College of Business and Accountancy")) {
        			
        			if (category.equals("Faculty")) {
        				
        				if (result != null) {
            	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
            	        	posttitle.setText(msgtitle);
                    	}
                    	        	
                    	if (result != null) {
            	        	String msgresult = "Message:  " + (json_data.getString("message"));
            	        	postMessage.setText(msgresult);
                    	}

                    	if(result != null) {
                    		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                        	postdatetime.setText(msgdattime);
                    	}
        				
        			}
        		}
        		
        	}
        	
        	/*
        	 * *************************
        	 * END OF FACULTY BY COLLEGE
        	 * *************************
        	 */
        	
        	
        	// Condition for All Non Teaching
        	if (viewer.equals("Non Teaching Staffs")) {
        		
        		if (category.equals("Non-Teaching Staff"))  {
        			
        			if (result != null) {
        	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
        	        	posttitle.setText(msgtitle);
                	}
                	        	
                	if (result != null) {
        	        	String msgresult = "Message:  " + (json_data.getString("message"));
        	        	postMessage.setText(msgresult);
                	}
                	
                	if(result != null) {
                		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                    	postdatetime.setText(msgdattime);
                	}
        			
        		}
        		
        	}
        	
        	
        	// Condition for All Deans
        	if (viewer.equals("All Deans")) {
        		
        		if (position.equals("Dean"))  {
        			
        			if (result != null) {
        	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
        	        	posttitle.setText(msgtitle);
                	}
                	        	
                	if (result != null) {
        	        	String msgresult = "Message:  " + (json_data.getString("message"));
        	        	postMessage.setText(msgresult);
                	}
                	
                	if(result != null) {
                		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                    	postdatetime.setText(msgdattime);
                	}
        			
        		}
        		
        	}
        	
        	// Condition for All VP
        	if (viewer.equals("Vice Presidents")) {
        		
        		if (position.equals("Vice President"))  {
        			
        			if (result != null) {
        	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
        	        	posttitle.setText(msgtitle);
                	}
                	        	
                	if (result != null) {
        	        	String msgresult = "Message:  " + (json_data.getString("message"));
        	        	postMessage.setText(msgresult);
                	}
                	
                	if(result != null) {
                		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                    	postdatetime.setText(msgdattime);
                	}
        			
        		}
        		
        	}
        	
        	
        	  // Condition for All (Broadcast)
            if (viewer.equals("All")) {
        		
        			
        			if (result != null) {
        	        	String msgtitle = "Title:  " + (json_data.getString("postTitle"));
        	        	posttitle.setText(msgtitle);
                	}
                	        	
                	if (result != null) {
        	        	String msgresult = "Message:  " + (json_data.getString("message"));
        	        	postMessage.setText(msgresult);
                	}

                	if(result != null) {
                		String msgdattime = "Date Posted:  " + (json_data.getString("datetime"));
                    	postdatetime.setText(msgdattime);
                	}

        	}
        	
        	/*
        	 * End of Condition
        	 * **********************************************************************************
        	 */
        	
    	}
        catch(Exception e)
    	{
        	Log.e("Fail 3", e.toString());
    	}
		
	}
}