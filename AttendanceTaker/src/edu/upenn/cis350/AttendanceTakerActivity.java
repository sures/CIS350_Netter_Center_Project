package edu.upenn.cis350;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class AttendanceTakerActivity extends Activity {

    private static final int LOGIN_DIALOG = 0;
    public static final int ACTIVITY_Attendance = 1;
    public static final int ACTIVITY_Roster = 2;
    public static final int ACTIVITY_AddActivity = 3;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        showDialog(LOGIN_DIALOG);
    }
    
    protected Dialog onCreateDialog(int id) {
    	if (id == LOGIN_DIALOG) {
	    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Enter your username and password");
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(1);
            final EditText input1 = new EditText(this);
	        final EditText input2 = new EditText(this);
	        ll.addView(input1);
	        ll.addView(input2);
	        builder.setView(ll);
	    	builder.setPositiveButton(R.string.Login,
	    		new DialogInterface.OnClickListener() {
	    	           public void onClick(DialogInterface dialog, int id) {
	    	        	   dialog.cancel();
	    	           }
	    	         });
    		return builder.create();
    	}
    	else return null;
    }
    
    // quit application entirely
    public void onAttendanceClick(View view) {
    	Intent i = new Intent(this, Attendance.class);
    	startActivityForResult(i, AttendanceTakerActivity.ACTIVITY_Attendance);
    }
    
    // quit application entirely
    public void onRosterClick(View view) {
    	Intent i = new Intent(this, Roster.class);
    	startActivityForResult(i, AttendanceTakerActivity.ACTIVITY_Roster);
    }
    
    
    // quit application entirely
    public void onActivityClick(View view) {
    	Intent i = new Intent(this, AddActivity.class);
    	startActivityForResult(i, AttendanceTakerActivity.ACTIVITY_AddActivity);
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	super.onActivityResult(requestCode, resultCode, intent);
    }
}

