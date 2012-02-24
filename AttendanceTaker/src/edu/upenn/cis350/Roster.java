package edu.upenn.cis350;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Roster extends Activity{

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roster);
    }
	
	public void onBackButtonClick(View view) {
		Intent i = new Intent();
		setResult(RESULT_OK, i);
		finish();	
	}
	
}
