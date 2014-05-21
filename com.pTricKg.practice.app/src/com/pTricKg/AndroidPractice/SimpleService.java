package com.pTricKg.AndroidPractice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class SimpleService extends Service {

	// Getting service created and started
	public void onCreate() {
		super.onCreate();
		
	}

	// int created for array and starts service
	public int onStartCommand(Intent intent, int flags, int startID) {
		Log.e("onStartCommand", "onStartCommand started");

		int[] numArray = intent.getExtras().getIntArray("numbers");
		float avg = findAverage(numArray);

		Toast.makeText(getApplicationContext(),
				String.format("Average %f", avg), Toast.LENGTH_SHORT).show();
		return startID;
	}

	// Must explicitly destroy service
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(getApplicationContext(), "Service stopped.",
				Toast.LENGTH_SHORT).show();
		
	}

	// loops through number array to find average
	float findAverage(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return (float) sum / nums.length;
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}


}
