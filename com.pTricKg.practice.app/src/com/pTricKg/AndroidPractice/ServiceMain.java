package com.pTricKg.AndroidPractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/*
 * This activity uses SimpleService.  It asks for user input in EditText field
 * for a string array of integers.  We simply take input and average it and display
 * result in toast message. We also catch problems with try/catch block.
 */

public class ServiceMain extends Activity {

	private EditText numbersText;
	private Intent averagingIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_main);

		// find edit text field for interaction
		numbersText = (EditText) findViewById(R.id.editText);

	}

	// Starting service
	// first button
	public void startService(View v) {

		String checkText = numbersText.getText().toString();
		
		try {
			// checking if input was made
			if (checkText.trim().equals("")) {
				Toast.makeText(getApplicationContext(),
						"Please enter some integers..", Toast.LENGTH_SHORT).show();
			} else {
				
				// Set-up string array to collect input from user
				String[] strNumbers = numbersText.getText().toString().split(" ");
				
				// Set-up integer array
				int[] numbers = new int[strNumbers.length];
				// setting loop to check numbers
				// must initialize int i with 0
				for (int i = 0; i < strNumbers.length; i++) {
					numbers[i] = Integer.parseInt(strNumbers[i]);
				}
	
				averagingIntent = new Intent(ServiceMain.this, SimpleService.class);
				averagingIntent.putExtra("numbers", numbers);
	
				startService(averagingIntent);
	
			}
		}catch (NumberFormatException e) {
			Toast.makeText(getApplicationContext(),
					"Please enter integers only", Toast.LENGTH_SHORT).show();
		}

	}

	// Second button
	public void stopService(View v) {
		if (averagingIntent != null) {
			stopService(averagingIntent);
		} else {
			Toast.makeText(getApplicationContext(),
					"Please enter some integers..", Toast.LENGTH_SHORT).show();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Set-up intent
		Intent mainIntent = new Intent(this, ListMain.class);
		Intent sqlIntent = new Intent(this, ListSQL.class);
		Intent serviceIntent = new Intent(this, ServiceMain.class);
		Intent sleep = new Intent(this, IntentServiceMain.class);
		Intent bind = new Intent(this, BoundMain.class);
		Intent anotherService = new Intent(this, AnotherServiceMain.class);
		Intent media = new Intent(this, Media.class);
		Intent video = new Intent(this, Video.class);

		switch (item.getItemId()) {
		case R.id.listarray:
			startActivity(mainIntent);
			return true;
		case R.id.sql:
			startActivity(sqlIntent);
			return true;
		case R.id.service:
			startActivity(serviceIntent);
			return true;
		case R.id.intentservice:
			startActivity(sleep);
			return true;
		case R.id.binderservice:
			startActivity(bind);
			return true;
		case R.id.anotherservice:
			startActivity(anotherService);
			return true;
		case R.id.media:
			startActivity(media);
			return true;
		case R.id.video:
			startActivity(video);
			return true;
		case R.id.quit:
			finish();
			return true;

		}
		return false;

	}
}
