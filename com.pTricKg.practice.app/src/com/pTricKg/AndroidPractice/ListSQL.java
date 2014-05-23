package com.pTricKg.AndroidPractice;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

/*
 * This activity uses CountryDB service. It simply displays list populated from
 * SQLite database.
 */

public class ListSQL extends Activity {

	private CountryDB countryDatabase = null;
	private Cursor countries = null;
	private ListView lvCountries = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listsql);

		// Database Helper
		CursorFactory factory = null;
		countryDatabase = new CountryDB(this, "countryDB", factory);

		// Set-up Array for columns
		String[] columnNames = { "Name", "Pop", "Area", BaseColumns._ID };
		// Create list view for data
		lvCountries = (ListView) findViewById(R.id.lvCountries);

		// get integers from list view layout
		int[] targetLayoutIDs = { R.id.textName, R.id.textPop, R.id.textArea };

		// Set-up actual database and make query of all data
		SQLiteDatabase db = countryDatabase.getReadableDatabase();
		countries = db.query("countries", columnNames, null, null, null, null,
				null);

		// Set-up cursor to display data within this activity
		CursorAdapter adapter = new SimpleCursorAdapter(this,
				R.layout.country_item, countries, columnNames, targetLayoutIDs,
				0);
		lvCountries.setAdapter(adapter);
	}

	// Finally, must close database to prevent memory drain
	public void onPause() {
		super.onPause();
		countryDatabase.close();
	}

	// creating menu option
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
		Intent serviceIntent = new Intent(this, ServiceMain.class);
		Intent intentService = new Intent(this, IntentServiceMain.class);
		Intent bind = new Intent(this, BoundMain.class);
		Intent media = new Intent(this, Media.class);
		
		switch (item.getItemId()) {
		case R.id.listarray:
			startActivity(mainIntent);
			return true;
		case R.id.service:
			startActivity(serviceIntent);
			return true;
		case R.id.intentservice:
			startActivity(intentService);
			return true;
		case R.id.binderservice:
			startActivity(bind);
			return true;
		case R.id.media:
			startActivity(media);
			return true;
		case R.id.quit:
				finish();
				return true;
		
		

		}
		return false;

	}
}
