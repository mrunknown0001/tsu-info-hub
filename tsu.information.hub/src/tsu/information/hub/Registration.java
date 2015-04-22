package tsu.information.hub;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registration extends Activity{
	
	
	/*
	 * Declarations of Variables
	 */
	private Spinner spinnerCat;
	//private String spinnerCatString;
	private Button btnContinue;
	
	private Button btnreturntologin;
	
	
	/* This will link to the respected
	 * registration page, depends on what 
	 * category you had chosen
	 * 
	 */

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);
		
		/*
		 * Initialization
		 */
		spinnerCat = (Spinner) findViewById(R.id.spinnerCat);
		
		
		btnContinue = (Button) findViewById(R.id.continueReg);
		
		btnContinue.setOnClickListener(new OnClickListener() {
			

		@Override
		public void onClick(View view) {

			String spinnerCatString = spinnerCat.getSelectedItem().toString();
			
			if(spinnerCatString.equals("Students")) {
				Toast.makeText(getApplicationContext(), "Students was Selected.", Toast.LENGTH_LONG).show();
				
				Intent i = new Intent(getApplicationContext(), StudentReg.class);
				startActivity(i);

			}
			else if(spinnerCatString.equals("Faculty")) {


				//Start of Verification for Faculty

				AlertDialog.Builder alert = new AlertDialog.Builder(Registration.this);
				
				alert.setTitle("Verification Code");
				alert.setMessage("Enter Here:");
	
				// Set an EditText view to get user input 
				final EditText input = new EditText(Registration.this);
				alert.setView(input);
	
				alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
				  String value = input.getText().toString();

				  	if (value.equals("232601")) { // The value of the Verification code.
				  		
				  		Toast.makeText(getApplicationContext(), "Code Accepted!", Toast.LENGTH_SHORT).show();
				  		
				  		Intent i = new Intent(getApplicationContext(), FacultyReg.class);
						startActivity(i);
				  	}
				  	else {
				  		
				  		Toast.makeText(getApplicationContext(), "Invalid Code!", Toast.LENGTH_SHORT).show();
				  		
				  		Intent i = new Intent(getApplicationContext(), Registration.class);
						startActivity(i);
				  		
				  	}
				  }
				});
				
				alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					  public void onClick(DialogInterface dialog, int whichButton) {
					    // Must do Nothing.
					  }
					});
		
					alert.show();
				
				
			}
			else if(spinnerCatString.equals("Non-Teaching Staff")) {


			// Start of verification for Non-teaching staff

			AlertDialog.Builder alert = new AlertDialog.Builder(Registration.this);
			
			alert.setTitle("Verification Code");
			alert.setMessage("Enter Here:");

			// Set an EditText view to get user input 
			final EditText input = new EditText(Registration.this);
			alert.setView(input);

			alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			  String value = input.getText().toString();

			  	if (value.equals("232601")) { // The value of the Verification code.
			  		
			  		Toast.makeText(getApplicationContext(), "Code Accepted!", Toast.LENGTH_SHORT).show();
			  		
			  		Intent i = new Intent(getApplicationContext(), NonTeachingReg.class);
					startActivity(i);
			  	}
			  	else {
			  		
			  		Toast.makeText(getApplicationContext(), "Invalid Code!", Toast.LENGTH_SHORT).show();
			  		
			  		Intent i = new Intent(getApplicationContext(), Registration.class);
					startActivity(i);
			  		
			  	}
			  }
			});
			
			alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				  public void onClick(DialogInterface dialog, int whichButton) {
				    // Must do Nothing.
				  }
				});
	
				alert.show();
			
			
			}
			else if(spinnerCatString.equals("User")) {
			
			// Start of the Verification code.
			
					AlertDialog.Builder alert = new AlertDialog.Builder(Registration.this);
		
					alert.setTitle("Verification Code");
					alert.setMessage("Enter Here:");
		
					// Set an EditText view to get user input 
					final EditText input = new EditText(Registration.this);
					alert.setView(input);
		
					alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
					  String value = input.getText().toString();

					  	if (value.equals("232601")) { // The value of the Verification code.
					  		
					  		Toast.makeText(getApplicationContext(), "Code Accepted!", Toast.LENGTH_SHORT).show();
					  		
					  		Intent i = new Intent(getApplicationContext(), UserReg.class);
							startActivity(i);
					  	}
					  	else {
					  		
					  		Toast.makeText(getApplicationContext(), "Invalid Code!", Toast.LENGTH_SHORT).show();
					  		
					  		Intent i = new Intent(getApplicationContext(), Registration.class);
							startActivity(i);
					  		
					  	}
					  }
					});
		
					alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					  public void onClick(DialogInterface dialog, int whichButton) {
					    // Must do Nothing.
					  }
					});
		
					alert.show();
					
			
			
			// End of the Verification code 
			
			}
			
			}
		});
		
		
		btnreturntologin = (Button) findViewById(R.id.btnreturntologin);
		
		btnreturntologin.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {

				// Return to Login Page
				Intent i = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(i);
				
			}
			
			
		});
		
	}
	/*
	 * Disables the back button
	 */
	@Override
	public void onBackPressed() {
		// Do nothing.
	}

}
