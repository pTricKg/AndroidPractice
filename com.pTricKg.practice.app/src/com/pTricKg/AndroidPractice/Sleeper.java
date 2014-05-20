package com.pTricKg.AndroidPractice;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

public class Sleeper extends IntentService {
	
	long seconds;
	
	// Service constructor
	public Sleeper() {
		super("Sleeper");
	}
	// Meat for starting service
	@Override
	protected void onHandleIntent(Intent intent) {
		
		seconds = intent.getExtras().getLong("seconds");
		long millis = seconds * 1000;
		// set-up try/catch for errors in thread
		try {
			Thread.sleep(millis);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, String.format("Slept %d seconds", seconds), Toast.LENGTH_SHORT).show();
	}

}
