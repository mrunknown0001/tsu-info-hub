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

public class UpComingEvents extends Activity {
	
	
private TextView postMessage;
private TextView eventstitle;
private TextView eventsdatetime;
	
	InputStream is=null;
	String result=null;
	String line=null;
	
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upcomingevents);
        
        
        postMessage = (TextView) findViewById(R.id.upcomingpost);
        eventstitle = (TextView) findViewById(R.id.eventstitle);
        eventsdatetime = (TextView) findViewById(R.id.eventsdatetime);
        
        Message();
    }


	private void Message() {
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		 
		nameValuePairs.add(new BasicNameValuePair("type", "Upcoming Events"));
		
		try
    	{
			HttpClient httpclient = new DefaultHttpClient();
	        HttpPost httppost = new HttpPost("http://192.168.1.100/tsuih/upcomingevents.php");
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
            
            
            /*
             * This is for all (broadcast)
             */
            if (viewer.equals("All")) {
            	
            	String title = "Title: " + (json_data).getString("postTitle");
            	eventstitle.setText(title);
            	
            	String message = "Message: " + (json_data.getString("message"));
            	postMessage.setText(message);
            	
            	String date = "Date Posted: " + (json_data.getString("datetime"));
            	eventsdatetime.setText(date);
            	
            }

            // for all students
            if (viewer.equals("All Students")) {
            	
            	if (category.equals("Student")) {
            	
	            	String title = "Title: " + (json_data).getString("postTitle");
	            	eventstitle.setText(title);
	            	
	            	String message = "Message: " + (json_data.getString("message"));
	            	postMessage.setText(message);
	            	
	            	String date = "Date Posted: " + (json_data.getString("datetime"));
	            	eventsdatetime.setText(date);
	            	
            	}
            }
            
            // for all students of ccs
            if (viewer.equals("All Students of CCS")) {
            	
            	if (category.equals("Student")) {
            	
	            	String title = "Title: " + (json_data).getString("postTitle");
	            	eventstitle.setText(title);
	            	
	            	String message = "Message: " + (json_data.getString("message"));
	            	postMessage.setText(message);
	            	
	            	String date = "Date Posted: " + (json_data.getString("datetime"));
	            	eventsdatetime.setText(date);
	            	
            	}
            }
            
            
            
            /*
             * FOR CCS STUDENTS
             */
            if (viewer.equals("1st Year Students of CCS")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("First Year")) {
            			
            			if (college.equals("College of Computer Studies")) {
            	
		            	String title = "Title: " + (json_data).getString("postTitle");
		            	eventstitle.setText(title);
		            	
		            	String message = "Message: " + (json_data.getString("message"));
		            	postMessage.setText(message);
		            	
		            	String date = "Date Posted: " + (json_data.getString("datetime"));
		            	eventsdatetime.setText(date);
            			}
            		}
            	}
            }
            
            if (viewer.equals("2nd Year Students of CCS")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Second Year")) {
            	
            			if (college.equals("College of Computer Studies")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            if (viewer.equals("3rd Year Students of CCS")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Third Year")) {
            	
            			if (college.equals("College of Computer Studies")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            if (viewer.equals("4th Year Students of CCS")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Fourth Year")) {
            	
            			if (college.equals("College of Computer Studies")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            
            
         // for all students of coe
            if (viewer.equals("All Students of COE")) {
            	
            	if (category.equals("Student")) {
            	
	            	String title = "Title: " + (json_data).getString("postTitle");
	            	eventstitle.setText(title);
	            	
	            	String message = "Message: " + (json_data.getString("message"));
	            	postMessage.setText(message);
	            	
	            	String date = "Date Posted: " + (json_data.getString("datetime"));
	            	eventsdatetime.setText(date);
	            	
            	}
            }
            
            /*
             * FOR coe STUDENTS
             */
            if (viewer.equals("1st Year Students of COE")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("First Year")) {
            			
            			if (college.equals("College of Engineering")) {
            	
		            	String title = "Title: " + (json_data).getString("postTitle");
		            	eventstitle.setText(title);
		            	
		            	String message = "Message: " + (json_data.getString("message"));
		            	postMessage.setText(message);
		            	
		            	String date = "Date Posted: " + (json_data.getString("datetime"));
		            	eventsdatetime.setText(date);
            			}
            		}
            	}
            }
            
            if (viewer.equals("2nd Year Students of COE")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Second Year")) {
            	
            			if (college.equals("College of Engineering")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            if (viewer.equals("3rd Year Students of COE")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Third Year")) {
            	
            			if (college.equals("College of Engineering")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            if (viewer.equals("4th Year Students of COE")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Fourth Year")) {
            	
            			if (college.equals("College of Engineering")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            if (viewer.equals("5th Year Students of COE")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Fifth Year")) {
            	
            			if (college.equals("College of Engineering")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            
         // for all students of chk
            if (viewer.equals("All Students of CHK")) {
            	
            	if (category.equals("Student")) {
            	
	            	String title = "Title: " + (json_data).getString("postTitle");
	            	eventstitle.setText(title);
	            	
	            	String message = "Message: " + (json_data.getString("message"));
	            	postMessage.setText(message);
	            	
	            	String date = "Date Posted: " + (json_data.getString("datetime"));
	            	eventsdatetime.setText(date);
	            	
            	}
            }
            if (viewer.equals("1st Year Students of CHK")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("First Year")) {
            			
            			if (college.equals("College of Human Kinetics")) {
            	
		            	String title = "Title: " + (json_data).getString("postTitle");
		            	eventstitle.setText(title);
		            	
		            	String message = "Message: " + (json_data.getString("message"));
		            	postMessage.setText(message);
		            	
		            	String date = "Date Posted: " + (json_data.getString("datetime"));
		            	eventsdatetime.setText(date);
            			}
            		}
            	}
            }
            
            if (viewer.equals("2nd Year Students of CHK")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Second Year")) {
            	
            			if (college.equals("College of Human Kinetics")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            if (viewer.equals("3rd Year Students of CHK")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Third Year")) {
            	
            			if (college.equals("College of Human Kinetics")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            if (viewer.equals("4th Year Students of CHK")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Fourth Year")) {
            	
            			if (college.equals("College of Human Kinetics")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            
         // for all students of COS
            if (viewer.equals("All Students of COS")) {
            	
            	if (category.equals("Student")) {
            	
	            	String title = "Title: " + (json_data).getString("postTitle");
	            	eventstitle.setText(title);
	            	
	            	String message = "Message: " + (json_data.getString("message"));
	            	postMessage.setText(message);
	            	
	            	String date = "Date Posted: " + (json_data.getString("datetime"));
	            	eventsdatetime.setText(date);
	            	
            	}
            }
            
            
            if (viewer.equals("1st Year Students of COS")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("First Year")) {
            			
            			if (college.equals("College of Science")) {
            	
		            	String title = "Title: " + (json_data).getString("postTitle");
		            	eventstitle.setText(title);
		            	
		            	String message = "Message: " + (json_data.getString("message"));
		            	postMessage.setText(message);
		            	
		            	String date = "Date Posted: " + (json_data.getString("datetime"));
		            	eventsdatetime.setText(date);
            			}
            		}
            	}
            }
            
            if (viewer.equals("2nd Year Students of COS")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Second Year")) {
            	
            			if (college.equals("College of Science")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            if (viewer.equals("3rd Year Students of COS")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Third Year")) {
            	
            			if (college.equals("College of Science")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            if (viewer.equals("4th Year Students of COS")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Fourth Year")) {
            	
            			if (college.equals("College of Science")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
         // for all students of CASS
            if (viewer.equals("All Students of CASS")) {
            	
            	if (category.equals("Student")) {
            	
	            	String title = "Title: " + (json_data).getString("postTitle");
	            	eventstitle.setText(title);
	            	
	            	String message = "Message: " + (json_data.getString("message"));
	            	postMessage.setText(message);
	            	
	            	String date = "Date Posted: " + (json_data.getString("datetime"));
	            	eventsdatetime.setText(date);
	            	
            	}
            }
            
            if (viewer.equals("1st Year Students of CASS")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("First Year")) {
            			
            			if (college.equals("College of Arts and Social Sciences")) {
            	
		            	String title = "Title: " + (json_data).getString("postTitle");
		            	eventstitle.setText(title);
		            	
		            	String message = "Message: " + (json_data.getString("message"));
		            	postMessage.setText(message);
		            	
		            	String date = "Date Posted: " + (json_data.getString("datetime"));
		            	eventsdatetime.setText(date);
            			}
            		}
            	}
            }
            
            if (viewer.equals("2nd Year Students of CASS")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Second Year")) {
            	
            			if (college.equals("College of Arts and Social Sciences")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            if (viewer.equals("3rd Year Students of CASS")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Third Year")) {
            	
            			if (college.equals("College of Arts and Social Sciences")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            if (viewer.equals("4th Year Students of CASS")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Fourth Year")) {
            	
            			if (college.equals("College of Arts and Social Sciences")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            
            // for all students of CPA
            if (viewer.equals("All Students of CPA")) {
            	
            	if (category.equals("Student")) {
            	
	            	String title = "Title: " + (json_data).getString("postTitle");
	            	eventstitle.setText(title);
	            	
	            	String message = "Message: " + (json_data.getString("message"));
	            	postMessage.setText(message);
	            	
	            	String date = "Date Posted: " + (json_data.getString("datetime"));
	            	eventsdatetime.setText(date);
	            	
            	}
            }
            
            if (viewer.equals("1st Year Students of CPA")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("First Year")) {
            			
            			if (college.equals("College of Public Administration")) {
            	
		            	String title = "Title: " + (json_data).getString("postTitle");
		            	eventstitle.setText(title);
		            	
		            	String message = "Message: " + (json_data.getString("message"));
		            	postMessage.setText(message);
		            	
		            	String date = "Date Posted: " + (json_data.getString("datetime"));
		            	eventsdatetime.setText(date);
            			}
            		}
            	}
            }
            
            if (viewer.equals("2nd Year Students of CPA")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Second Year")) {
            	
            			if (college.equals("College of Public Administration")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            if (viewer.equals("3rd Year Students of CPA")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Third Year")) {
            	
            			if (college.equals("College of Public Administration")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            if (viewer.equals("4th Year Students of CPA")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Fourth Year")) {
            	
            			if (college.equals("College of Public Administration")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            
         // for all students of CBA
            if (viewer.equals("All Students of CBA")) {
            	
            	if (category.equals("Student")) {
            	
	            	String title = "Title: " + (json_data).getString("postTitle");
	            	eventstitle.setText(title);
	            	
	            	String message = "Message: " + (json_data.getString("message"));
	            	postMessage.setText(message);
	            	
	            	String date = "Date Posted: " + (json_data.getString("datetime"));
	            	eventsdatetime.setText(date);
	            	
            	}
            }
            if (viewer.equals("1st Year Students of CBA")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("First Year")) {
            			
            			if (college.equals("College of Business and Accountancy")) {
            	
		            	String title = "Title: " + (json_data).getString("postTitle");
		            	eventstitle.setText(title);
		            	
		            	String message = "Message: " + (json_data.getString("message"));
		            	postMessage.setText(message);
		            	
		            	String date = "Date Posted: " + (json_data.getString("datetime"));
		            	eventsdatetime.setText(date);
            			}
            		}
            	}
            }
            
            if (viewer.equals("2nd Year Students of CBA")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Second Year")) {
            	
            			if (college.equals("College of Business and Accountancy")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            if (viewer.equals("3rd Year Students of CBA")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Third Year")) {
            	
            			if (college.equals("College of Business and Accountancy")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            if (viewer.equals("4th Year Students of CBA")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Fourth Year")) {
            	
            			if (college.equals("College of Business and Accountancy")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            if (viewer.equals("5th Year Students of CBA")) {
            	
            	if (category.equals("Student")) {
            		
            		if (yearlevel.equals("Fifth Year")) {
            	
            			if (college.equals("College of Business and Accountancy")) {
                        	
    		            	String title = "Title: " + (json_data).getString("postTitle");
    		            	eventstitle.setText(title);
    		            	
    		            	String message = "Message: " + (json_data.getString("message"));
    		            	postMessage.setText(message);
    		            	
    		            	String date = "Date Posted: " + (json_data.getString("datetime"));
    		            	eventsdatetime.setText(date);
                			}
            		}
            	}
            }
            
            // for all faculty
            if (viewer.equals("All Faculty")) {
            	
            	if (category.equals("Faculty")) {
            	
	            	String title = "Title: " + (json_data).getString("postTitle");
	            	eventstitle.setText(title);
	            	
	            	String message = "Message: " + (json_data.getString("message"));
	            	postMessage.setText(message);
	            	
	            	String date = "Date Posted: " + (json_data.getString("datetime"));
	            	eventsdatetime.setText(date);
	            	
            	}
            }
            
            //for all ccs faculty
            if (category.equals("Faculty")) {
            	
            	if (college.equals("College of Computer Studies")) {
            		
            		String title = "Title: " + (json_data).getString("postTitle");
	            	eventstitle.setText(title);
	            	
	            	String message = "Message: " + (json_data.getString("message"));
	            	postMessage.setText(message);
	            	
	            	String date = "Date Posted: " + (json_data.getString("datetime"));
	            	eventsdatetime.setText(date);
            		
            	}
            	
            	
            }
            
          //for all coe faculty
            if (category.equals("Faculty")) {
            	
            	if (college.equals("College of Engineering")) {
            		
            		String title = "Title: " + (json_data).getString("postTitle");
	            	eventstitle.setText(title);
	            	
	            	String message = "Message: " + (json_data.getString("message"));
	            	postMessage.setText(message);
	            	
	            	String date = "Date Posted: " + (json_data.getString("datetime"));
	            	eventsdatetime.setText(date);
            		
            	}
            	
            	
            }
            
          //for all chk faculty
            if (category.equals("Faculty")) {
            	
            	if (college.equals("College of Human Kinetics")) {
            		
            		String title = "Title: " + (json_data).getString("postTitle");
	            	eventstitle.setText(title);
	            	
	            	String message = "Message: " + (json_data.getString("message"));
	            	postMessage.setText(message);
	            	
	            	String date = "Date Posted: " + (json_data.getString("datetime"));
	            	eventsdatetime.setText(date);
            		
            	}
            	
            	
            }
            
            
          //for all cos faculty
            if (category.equals("Faculty")) {
            	
            	if (college.equals("College of Science")) {
            		
            		String title = "Title: " + (json_data).getString("postTitle");
	            	eventstitle.setText(title);
	            	
	            	String message = "Message: " + (json_data.getString("message"));
	            	postMessage.setText(message);
	            	
	            	String date = "Date Posted: " + (json_data.getString("datetime"));
	            	eventsdatetime.setText(date);
            		
            	}
            	
            	
            }
            
          //for all cass faculty
            if (category.equals("Faculty")) {
            	
            	if (college.equals("College of Arts and Social Sciences")) {
            		
            		String title = "Title: " + (json_data).getString("postTitle");
	            	eventstitle.setText(title);
	            	
	            	String message = "Message: " + (json_data.getString("message"));
	            	postMessage.setText(message);
	            	
	            	String date = "Date Posted: " + (json_data.getString("datetime"));
	            	eventsdatetime.setText(date);
            		
            	}
            	
            	
            }
            
          //for all cpa faculty
            if (category.equals("Faculty")) {
            	
            	if (college.equals("College of Public Administration")) {
            		
            		String title = "Title: " + (json_data).getString("postTitle");
	            	eventstitle.setText(title);
	            	
	            	String message = "Message: " + (json_data.getString("message"));
	            	postMessage.setText(message);
	            	
	            	String date = "Date Posted: " + (json_data.getString("datetime"));
	            	eventsdatetime.setText(date);
            		
            	}
            	
            	
            }
            
          //for all cba faculty
            if (category.equals("Faculty")) {
            	
            	if (college.equals("College of Business and Accountancy")) {
            		
            		String title = "Title: " + (json_data).getString("postTitle");
	            	eventstitle.setText(title);
	            	
	            	String message = "Message: " + (json_data.getString("message"));
	            	postMessage.setText(message);
	            	
	            	String date = "Date Posted: " + (json_data.getString("datetime"));
	            	eventsdatetime.setText(date);
            		
            	}
            	
            	
            }
            
            
            
            // for all non teaching staff
            if (viewer.equals("Non Teaching Staffs")) {
            	
            	String title = "Title: " + (json_data).getString("postTitle");
            	eventstitle.setText(title);
            	
            	String message = "Message: " + (json_data.getString("message"));
            	postMessage.setText(message);
            	
            	String date = "Date Posted: " + (json_data.getString("datetime"));
            	eventsdatetime.setText(date);
            	
            }
            
         // for Directors
            if (viewer.equals("Directors")) {
            	
            	String title = "Title: " + (json_data).getString("postTitle");
            	eventstitle.setText(title);
            	
            	String message = "Message: " + (json_data.getString("message"));
            	postMessage.setText(message);
            	
            	String date = "Date Posted: " + (json_data.getString("datetime"));
            	eventsdatetime.setText(date);
            	
            }
            
         // for vps
            if (viewer.equals("Vice Presidents")) {
            	
            	String title = "Title: " + (json_data).getString("postTitle");
            	eventstitle.setText(title);
            	
            	String message = "Message: " + (json_data.getString("message"));
            	postMessage.setText(message);
            	
            	String date = "Date Posted: " + (json_data.getString("datetime"));
            	eventsdatetime.setText(date);
            	
            }
            
            
         // for all deans
            if (viewer.equals("All Deans")) {
            	
            	if (position.equals("Dean")) {
            	
	            	String title = "Title: " + (json_data).getString("postTitle");
	            	eventstitle.setText(title);
	            	
	            	String message = "Message: " + (json_data.getString("message"));
	            	postMessage.setText(message);
	            	
	            	String date = "Date Posted: " + (json_data.getString("datetime"));
	            	eventsdatetime.setText(date);
	            	
            	}
            }
            
        	
    	}
        catch(Exception e)
    	{
        	Log.e("Fail 3", e.toString());
    	}
		
	}
}