package com.pTricKg.AndroidPractice;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
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

}
