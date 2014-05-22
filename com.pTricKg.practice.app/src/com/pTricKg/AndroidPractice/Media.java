package com.pTricKg.AndroidPractice;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class Media extends Activity {
	
	MediaPlayer sTrekOpen = null;
	MediaPlayer sTrekClose = null;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.media);
	}
	
	public void onStop() {
		// check if media present
		super.onStop();
		if (sTrekOpen != null) {
			sTrekOpen.release();
			sTrekOpen = null;
		}
		if (sTrekClose != null) {
			sTrekClose.release();
			sTrekClose = null;
		}
	}
	
	//playing sounds
	public void play(View v) {
		if(sTrekOpen != null) {
			sTrekOpen.release();
		}
		switch(v.getId()) {
		
		case R.id.btnSTOpen:
			sTrekOpen = MediaPlayer.create(getApplicationContext(), R.raw.star_trek_open);
			break;
		case R.id.btnSTClose:
			sTrekOpen = MediaPlayer.create(getApplicationContext(), R.raw.star_trek_close);
			break;
		}
		}

}
