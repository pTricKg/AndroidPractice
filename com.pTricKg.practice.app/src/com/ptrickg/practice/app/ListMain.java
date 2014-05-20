package com.ptrickg.practice.app;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListMain extends ListActivity {
	
	String[] countries;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// pull from string array from resources
		countries = getResources().getStringArray(R.array.countries);
		// setting up adapter for this list activity string array
		this.setListAdapter(new ArrayAdapter<>(
				this, 
				R.layout.list_activity,
				R.id.countryName,
				countries));
		
		// pointer to list view
		ListView listview = getListView();
		//adding click listener
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View clickView,
					int position, long id) {
				// Setting countries to string country
				String country = countries[position];
				// Make toast message from that string array
				Toast.makeText(ListMain.this, String.format("%s was chosen", country), Toast.LENGTH_SHORT).show();
				
			}
						
		});
		
	}
		// Creating menu option
		@Override 
		public boolean onCreateOptionsMenu(Menu menu) {
			super.onCreateOptionsMenu(menu);
			getMenuInflater().inflate(R.menu.menu, menu);
		      return true;
		}
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// Set-up intent to open SQL activity
			Intent sqlIntent = new Intent(this, ListSQL.class);
			
			startActivity(sqlIntent);
			//finish();
			return false;
		}
	}

