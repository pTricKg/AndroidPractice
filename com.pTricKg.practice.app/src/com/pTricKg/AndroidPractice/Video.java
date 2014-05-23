package com.pTricKg.AndroidPractice;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

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

}
