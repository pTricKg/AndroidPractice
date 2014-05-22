package com.pTricKg.AndroidPractice;

import com.pTricKg.AndroidPractice.BoundService.LocalBinder;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class BoundMain extends Activity {
	
	// Initiating BoundService
	BoundService bService;
	boolean isBound = false;
	
	// Check if connection is bound
	private ServiceConnection connection = new ServiceConnection() {

		// Methods for BoundService to connect and disconnect
        @Override
        public void onServiceConnected(ComponentName className,
                IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            LocalBinder binder = (LocalBinder) service;
            bService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bound);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menufive, menu);
        return true;
    }
    // Binding to service
    protected void onStart() {
    	super.onStart();
    	Intent intent = new Intent(BoundMain.this, BoundService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    // Unbinding from service
    protected void onStop() {
    	super.onStop();
    	if (isBound) {
            unbindService(connection);
            isBound = false;
        }
    }
    // Need to check if service is bound
    public void onBtnClick(View view) {
    	if (isBound) {
    		//pop a toast with the result of the current answer:
    		Toast.makeText(this, bService.getAnswer(), Toast.LENGTH_LONG).show();
    	}
    }
    
}
