package com.pTricKg.AndroidPractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExplicitlyLoadedActivity extends Activity {

	static private final String TAG = "Lab-Intents";

	EditText mEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.explicitly_loaded);

		// Get a reference to the EditText field
		mEditText = (EditText) findViewById(R.id.editText);

		// Declare and setup "Enter" button
		Button enterButton = (Button) findViewById(R.id.enter_button);
		enterButton.setOnClickListener(new OnClickListener() {

			// Call enterClicked() when pressed

			@Override
			public void onClick(View v) {

				enterClicked();

			}
		});

	}

	// Sets result to send back to calling Activity and finishes

	private void enterClicked() {

		Log.i(TAG, "Entered enterClicked()");

		// TODO - Create a new intent and save the input from the EditText field
		// as an extra
		Intent editIntent = new Intent();
		/*
		 * I could not, for the life of me get the editText to populate the TextView.
		 * I tried what i though was everything, then, I realized i could add intent 
		 * from here to setResult().  Still no luck, then i realized maybe I need a blank
		 * intent to fill with editText.  Walla!!!  It works!!
		 */

		// TODO - Save user provided input from the EditText field
		editIntent.putExtra("key", mEditText.getText().toString());

		// TODO - Set Activity's result with result code RESULT_OK
		setResult(RESULT_OK, editIntent);

		// TODO - Finish the Activity
		finish();

	}
}
