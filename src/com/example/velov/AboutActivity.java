package com.example.velov;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;

public class AboutActivity extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// création du menu
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch(item.getItemId()) {
	    case R.id.index:
	        Intent intent = new Intent(this, MainActivity.class);
	        this.startActivity(intent);
	        break;
	    case R.id.about:
	        Intent intent2 = new Intent(this, AboutActivity.class);
	        this.startActivity(intent2);
	        break;
	    default:
	        return super.onOptionsItemSelected(item);
	    }

	    return true;
	}
	
	
}
