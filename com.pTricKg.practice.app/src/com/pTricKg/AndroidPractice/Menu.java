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
		Intent sqlIntent = new Intent(this, ListSQL.class);
		Intent serviceIntent = new Intent(this, ServiceMain.class);
		Intent sleep = new Intent(this, IntentServiceMain.class);
		Intent bind = new Intent(this, BoundMain.class);
		Intent anotherService = new Intent(this, AnotherServiceMain.class);
		Intent media = new Intent(this, Media.class);
		Intent video = new Intent(this, Video.class);

		switch (item.getItemId()) {
		case R.id.listarray:
			startActivity(mainIntent);
			return true;
		case R.id.sql:
			startActivity(sqlIntent);
			return true;
		case R.id.service:
			startActivity(serviceIntent);
			return true;
		case R.id.intentservice:
			startActivity(sleep);
			return true;
		case R.id.binderservice:
			startActivity(bind);
			return true;
		case R.id.anotherservice:
			startActivity(anotherService);
			return true;
		case R.id.media:
			startActivity(media);
			return true;
		case R.id.video:
			startActivity(video);
			return true;
		case R.id.quit:
			finish();
			return true;

		}
		return false;

	}
