package com.pTricKg.AndroidPractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
		getMenuInflater().inflate(R.menu.menuthree, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Set-up intent
		Intent mainIntent = new Intent(this, ListMain.class);
		Intent sqlIntent = new Intent(this, ListSQL.class);
		Intent sleep = new Intent(this, IntentServiceMain.class);

		switch (item.getItemId()) {
		case R.id.listarray:
			startActivity(mainIntent);
			return true;
		case R.id.sql:
			startActivity(sqlIntent);
			return true;
		case R.id.intentservice:
			startActivity(sleep);
			return true;

		}
		return false;

	}

}
