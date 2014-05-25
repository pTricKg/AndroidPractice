package com.pTricKg.AndroidPractice;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

/*
 * This activity uses MediaController and VideoView to display video.
 */

public class Video extends Activity {
	
	//Initialize variable for video view
	//VideoView displays while MediaController plays
	VideoView vView = null;
	MediaController vCont = null;
	
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video);
		
		//find vView
		vView = (VideoView) findViewById(R.id.videoView);
		//create controller
		vCont = new MediaController(this);
		//set controller to play video view
		vView.setMediaController(vCont);
		//set path to video form res/raw
		Uri video= Uri.parse("android.resource://com.pTricKg.AndroidPractice/" + R.raw.data_asks_spock);
		//set path to video from sdcard
		//vView.setVideoPath("mnt/sdcard/Movies/data_asks_spock.mp4"); 
		// setting parsed video 
		vView.setVideoURI(video);
		vView.requestFocus();
		vCont.show();
		vView.start();
				
		
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
