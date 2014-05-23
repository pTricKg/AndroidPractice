package com.pTricKg.AndroidPractice;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Media extends Activity {

	MediaPlayer mediaSTrek = null;
	MediaPlayer local_mp = null;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.media);
	}

	public void onStop() {

		super.onStop();
		if (mediaSTrek != null) {
			mediaSTrek.release();
			mediaSTrek = null;
		}
	}

	// playing sound from raw folder
	public void play(View v) {

		if (mediaSTrek != null) {
			mediaSTrek.release();
		}

		switch (v.getId()) {

		case R.id.btnSTOpen:
			mediaSTrek = MediaPlayer.create(getApplicationContext(),
					R.raw.star_trek_open);
			break;
		case R.id.btnSTClose:
			mediaSTrek = MediaPlayer.create(getApplicationContext(),
					R.raw.star_trek_close);
			break;
		}
		mediaSTrek.start();
	}

	// playing sound form sdCard
	// not used yet
	public void playLocalAudio(View v) {
		// file to play must reside on SDCard
		String sdPath = "mnt/sdcard/--";
		local_mp = new MediaPlayer();
		try {
			local_mp.setDataSource(sdPath);
			local_mp.prepare();
			local_mp.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
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
