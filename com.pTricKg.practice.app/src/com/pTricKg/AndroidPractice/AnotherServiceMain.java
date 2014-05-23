package com.pTricKg.AndroidPractice;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class AnotherServiceMain extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_service);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void btnClicked(View view) {
    	
    	Intent intent = new Intent(AnotherServiceMain.this, AnotherService.class);
    	
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
    
}
