package com.pTricKg.AndroidPractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IntentServiceMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intent_service_main);

	}
	
	public void  startService (View v) {
		// find EditText
		EditText sleepTime = (EditText) findViewById(R.id.editSleep);
		
		//Creating string for empty edit text check
		String checkInput = sleepTime.getText().toString();
		try {
			// checking input
			if (checkInput.trim().equals("")) {
				Toast.makeText(getApplicationContext(),
						"Please enter seconds to stop service", Toast.LENGTH_SHORT).show();
			}
			else {
				Toast.makeText(getApplicationContext(),
						"Starting service", Toast.LENGTH_SHORT).show();
				// Get sleep time from edit text then make string then parse into long
				long secondsToSleep = Long.parseLong(sleepTime.getText().toString());
				// Create Intent
				Intent intent = new Intent(IntentServiceMain.this, Sleeper.class);
				intent.putExtra("seconds", secondsToSleep);
				startService(intent);
			}
		}catch (NumberFormatException e) {
			Toast.makeText(getApplicationContext(),
					"Please enter only one integer", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.menufour, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Set-up intent
		Intent mainIntent = new Intent(this, ListMain.class);
		Intent sqlIntent = new Intent(this, ListSQL.class);
		Intent service = new Intent(this, ServiceMain.class);
		Intent bind = new Intent(this, BoundMain.class);
		
		switch (item.getItemId()) {
		case R.id.listarray:
			startActivity(mainIntent);
			return true;
		case R.id.sql:
			startActivity(sqlIntent);
			return true;
		case R.id.service:
			startActivity(service);
			return true;
		case R.id.binderservice:
			startActivity(bind);
			return true;
		case R.id.quit:
			finish();
			return true;
		

		}
		return false;

	}
}
