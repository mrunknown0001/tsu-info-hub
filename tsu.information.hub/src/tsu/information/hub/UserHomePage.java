package tsu.information.hub;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class UserHomePage extends Activity {
	
	/*
	 * Declarations of Variables
	 */
	

	
	private Button btnview;
	private Button postMessage;
	private Button logout;


	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userhomepage);
		
        		
		/*
		 * Initializations of Elements
		 */
		
		btnview = (Button) findViewById(R.id.btnview);
		
		btnview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i = new Intent(getApplicationContext(), ViewPost.class);
				startActivity(i);
				
			}});
		
		postMessage = (Button) findViewById(R.id.btnpostmessage);
		
		postMessage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(), UserCreateMsg.class);
				startActivity(i);
				
			}
			
		});
		
		
		
				
		/*
		 * use to logout
		 */
		logout = (Button) findViewById(R.id.btnlogout);
		logout.setOnClickListener(new OnClickListener() {
		
		public void onClick(View view) {
			
			AlertDialog.Builder alert = new AlertDialog.Builder(UserHomePage.this);
			
			alert.setTitle("Logout");
			alert.setMessage("Are you sure you want to logout?");
			
			alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					
					// Return to MainActivtiy.class
					Intent i = new Intent(getApplicationContext(), MainActivity.class);
					startActivity(i);
				  }
				});
			
			alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				  public void onClick(DialogInterface dialog, int whichButton) {
				    // Must do Nothing.
					// Stay on the Current Page/Layout
				  }
				});
	
				alert.show();
		}
		
	});
	
	
	}
	
	/*
	 * Disables the back button
	 */
	@Override
	public void onBackPressed() {

		Toast.makeText(getApplicationContext(), "Use LOGOUT to Exit.", Toast.LENGTH_SHORT).show();
		
	}

}
