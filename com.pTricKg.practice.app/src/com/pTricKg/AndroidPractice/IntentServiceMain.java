package com.pTricKg.AndroidPractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class IntentServiceMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intent_service_main);

	}
	
	public void  startService (View v) {
		// find EditText
		EditText sleepTime = (EditText) findViewById(R.layout.intent_service_main);
		// Get sleep time from edit text then make string then parse into long
		long secondsToSleep = Long.parseLong(sleepTime.getText().toString());
		// Create Intent
		Intent intent = new Intent(IntentServiceMain.this, Sleeper.class);
		intent.putExtra("seconds", secondsToSleep);
		startService(intent);
	}
}
