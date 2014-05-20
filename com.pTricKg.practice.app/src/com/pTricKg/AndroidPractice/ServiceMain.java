package com.pTricKg.AndroidPractice;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
//		// Set-up string array to collect input from user
		String[] strNumbers = numbersText.getText().toString().split(" ");
		int[] numbers = new int[strNumbers.length];
		// setting loop to check numbers
		// must initialize int i with 0
		for (int i = 0; i < strNumbers.length; i++) {
			numbers[i] = Integer.parseInt(strNumbers[i]);
		}

		averagingIntent = new Intent(ServiceMain.this, SimpleService.class);
		averagingIntent.putExtra("numbers", numbers);

		// checking if input was made
		if (strNumbers.length > 0) {

			startService(averagingIntent);
		}
		else {
			Toast.makeText(getApplicationContext(), "Please enter some integers..", Toast.LENGTH_SHORT).show();
		}

	}

	// Second button
	public void stopService(View v) {
		if (averagingIntent != null) {
			stopService(averagingIntent);
		}
		else {
			Toast.makeText(getApplicationContext(), "Please enter some integers..", Toast.LENGTH_SHORT).show();
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
		
		switch (item.getItemId()) {
		case R.id.list:
			startActivity(mainIntent);
			return true;
		case R.id.list2:
			startActivity(sqlIntent);
			return true;

		}
		return false;

	}

}
