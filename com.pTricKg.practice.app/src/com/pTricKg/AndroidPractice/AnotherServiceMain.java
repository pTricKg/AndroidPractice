package com.pTricKg.AndroidPractice;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/*
 * @author pTricKg
 *
 * This activity uses AnotherService.  This activity simply gives two buttons:
 * one to start the service and one to stop it.  It will display an status bar
 * notification to user giving the time that service was started for.
 */

public class AnotherServiceMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.another_service);
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void btnClicked(View view) {

		Intent intent = new Intent(AnotherServiceMain.this,
				AnotherService.class);

		switch (view.getId()) {
		case R.id.btnStartService:
			startService(intent);
			view.setEnabled(false);
			view.setAlpha(0.8f);
			break;
		case R.id.btnStopService:
			stopService(intent);
			Button startButton = (Button) findViewById(R.id.btnStartService);
			startButton.setEnabled(true);
			startButton.setAlpha(1.0f);
			break;
		default:
			Log.e("ERROR", "A click event was generated unexpectedly");
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
		Intent intent = new Intent(this, ActivityLoaderActivity.class);

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
		case R.id.intent:
			startActivity(intent);
			return true;
		case R.id.quit:
			finish();
			return true;

		}
		return false;

	}

}
