package tsu.information.hub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	private Button btnlogo;
	private Button btnreg;
	
	
	   public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        
	        btnlogo = (Button) findViewById(R.id.btnlogo);
	        btnlogo.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub


					Intent i = new Intent(getApplicationContext(), Login.class);
					startActivity(i);
					

				}
	        	
	        });
	        
	        
	        btnreg = (Button) findViewById(R.id.btnreg);
	        btnreg.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View view) {
					// TODO Auto-generated method stub
					Intent i = new Intent(getApplicationContext(), Registration.class);
					startActivity(i);
					
				}});

	   }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
		/*
		 * Disables the back button
		 */
		@Override
		public void onBackPressed() {

			Toast.makeText(getApplicationContext(), "Use Home Button to Exit.", Toast.LENGTH_SHORT).show();
			
		}


}
