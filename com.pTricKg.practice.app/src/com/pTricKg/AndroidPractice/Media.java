package com.pTricKg.AndroidPractice;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Media extends Activity {
	
	MediaPlayer sTrekOpen = null;
	MediaPlayer sTrekClose = null;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.media);
	}
	
	public void onStop() {
		super.onStop();
		if (sTrekOpen == null) {
			sTrekOpen.release();
			sTrekOpen = null;
		}
		if (sTrekClose == null) {
			sTrekClose.release();
			sTrekClose = null;
		}
	}

}
