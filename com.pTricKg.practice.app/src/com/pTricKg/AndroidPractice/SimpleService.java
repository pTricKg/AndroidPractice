package com.pTricKg.AndroidPractice;

import java.util.Timer;
import java.util.TimerTask;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;

public class SimpleService extends Service {
	
	// Set-up variables
//	private NotificationManager manager;
//	private Timer counter = new Timer();
//	private long seconds = 0L;
//	private TimerTask clockTask = null;
//	private PendingIntent notificationIntent = null;
	
	// Set-up IBinder but not used yet
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Getting service created and started
	public void onCreate() {
		super.onCreate();
//		manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
//		displayNotification("Service Started");
//		clockTask = new TimerTask() {
//			public void run() {
//				seconds++;
//			}
//		};
//		startCounter();
	}
	
	// int created for array and starts service
	public int onStartCommand(Intent intent, int flags, int startID) {
		int[] numArray = intent.getExtras().getIntArray("numbers");
		float avg = findAverage(numArray);
		
		Toast.makeText(getApplicationContext(), String.format("Average %f", avg), Toast.LENGTH_SHORT).show();
		return startID;
	}
	
	// Must explicitly destroy service
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(getApplicationContext(), "Service stopped.", Toast.LENGTH_SHORT).show();
//		stopCounter();
//		manager.cancel(R.string.notification);
//		displayNotification(String.format("Service stopped after %d seconds.", seconds));
//		seconds = 0L;
	}
	
	// loops through number array to find average
	float findAverage(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return (float)sum / nums.length;
	}
	
	// Creating notification for Service state
//	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//	private void displayNotification(CharSequence text) {
//		Notification notification = new Notification.Builder(this)
//			.setTicker(text)
//			.setContentTitle(text)
//			.setContentIntent(notificationIntent)
//			.setSmallIcon(R.drawable.ic_launcher)
//			.build();
//		
//		manager.notify(R.string.notification, notification);
//	}
//	
//	// Self explained
//	private void startCounter() {
//		//set up a timer to increment seconds once per second (1000 milliseconds):
//		counter.scheduleAtFixedRate(clockTask, 0, 1000L);
//	}
//	
//	private void stopCounter() {
//		if (counter != null) {
//			counter.cancel();
//		}
//	}

}
