package tsu.information.hub;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ViewPost extends Activity{ 
	
	
	/*
	 * Declaration of Variables
	 * 
	 */
	private Button btnwhatsnew;
	private Button btnannouncements;
	private Button btnmemos;
	private Button btnmaypasokba;
	private Button btnupcomingevents;
	private Button btndateofgrad;
	private Button btnlogout;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		
		/*
		 * Initializations
		 */
		
		/*
		 * Action of whats new Button
		 */

		
		
		btnwhatsnew = (Button) findViewById(R.id.btnwhatsnew);
		btnwhatsnew.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(), WhatsNew.class);
				startActivity(i);
			}
		});
		
		/*
		 * action of announcements button
		 */
		btnannouncements = (Button) findViewById(R.id.btnannouncements);
		btnannouncements.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(), Announcements.class);
				startActivity(i);
			}
		});
		/*
		 * Action for button memos
		 */
		btnmemos = (Button) findViewById(R.id.btnmemos);
		btnmemos.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(), Memo.class);
				startActivity(i);
			}
		});
		/*
		 * Action for maypasokba button
		 */
		btnmaypasokba = (Button) findViewById(R.id.btnmaypaoskba);
		btnmaypasokba.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(), MayPasokBa.class);
				startActivity(i);
			}
		});
		/*
		 * Action for Upcoming Events button
		 */
		btnupcomingevents = (Button) findViewById(R.id.btnupcomingevents);
		btnupcomingevents.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(), UpComingEvents.class);
				startActivity(i);
			}
		});
		
		/*
		 * Action for date of graduation button
		 */
		btndateofgrad = (Button) findViewById(R.id.btndateofgrad);
		btndateofgrad.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(), DateOfGrad.class);
				startActivity(i);
			}
	});
		
		
		/*
		 * Action of LOGOUT Button - return to login/register
		 */
		btnlogout = (Button) findViewById(R.id.btnlogout);
		btnlogout.setOnClickListener(new OnClickListener() {
			
			public void onClick(View view) {
				
				AlertDialog.Builder alert = new AlertDialog.Builder(ViewPost.this);
				
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
	}
