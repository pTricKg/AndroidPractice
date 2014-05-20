package com.ptrickg.practice.app;



import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ServiceMain extends Activity {
	
	private EditText numbersText;
	private static Intent averagingIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_main);
		
		// find edit text field for interaction
		numbersText = (EditText) findViewById(R.id.editText);

		
	}
	public void btnClicked(View view) {
		
		switch (view.getId()) {
    	case R.id.btnStartService:
    		startService(averagingIntent);
    	case R.id.btnStopService:
    		stopService(averagingIntent);
    		Button startButton = (Button) findViewById(R.id.btnStartService);
    		startButton.setEnabled(true);
    	default:
    		Log.e("ERROR", "A click event was generated unexpectedly");
    	}
		
	}
	// Starting service
	// first button
	public void startService(View v) {
		// Set-up string array to collect input from user
		String[] strNumbers = numbersText.getText().toString().split(" ");
		int[] numbers = new int[strNumbers.length];
		// setting loop to check numbers
		// must initialize int i with 0
		for(int i = 0; i < strNumbers.length; i++) {
			numbers[i] = Integer.parseInt(strNumbers[i]);
		}
		
		averagingIntent = new Intent(ServiceMain.this, SimpleService.class);
		averagingIntent.putExtra("numbers", numbers);
		
		startService(averagingIntent);
	}
	
	// Second button
	public void stopService(View v) {
		stopService(averagingIntent);
	}
	
//	 @TargetApi(Build.VERSION_CODES.HONEYCOMB)
//	public void btnClicked(View view) {
//	    	
//	    	Intent intent = new Intent(ServiceMain.this, SimpleService.class);
//	    	
//	    	switch (view.getId()) {
//	    	case R.id.btnStartService:
//	    		startService(intent);
//	    		view.setEnabled(false);
//	    		view.setAlpha(0.8f);
//	    		break;
//	    	case R.id.btnStopService:
//	    		stopService(intent);
//	    		Button startButton = (Button) findViewById(R.id.btnStartService);
//	    		startButton.setEnabled(true);
//	    		startButton.setAlpha(1.0f);
//	    		break;
//	    	default:
//	    		Log.e("ERROR", "A click event was generated unexpectedly");
//	    	}
//	    }
//	    

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.service_main, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//	// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
//
//	}

}
