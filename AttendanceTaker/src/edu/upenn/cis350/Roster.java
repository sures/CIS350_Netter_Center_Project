package edu.upenn.cis350;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * represents the 'roster' page.
 * extends ListActivity. Each list item is defined in list_item.xml, 
 * while the overall layout is defined in roster.xml
 *
 * TODO: 	-put a selector / button in each list item to select present/absent
 * 			-when clicked, each list item should go to corresponding profile
 * 			-pull names from database rather than from static array
 */
public class Roster extends ListActivity{

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roster);
        //ListView stuff
        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, PEOPLE));
        ListView lv = getListView();
        lv.setTextFilterEnabled(true);
        
        //click listener for each list item
        lv.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) {
            // When clicked, show a toast with the TextView text
            Toast.makeText(getApplicationContext(), "Present",
                Toast.LENGTH_SHORT).show();
          }
        });
    }
	
	public void onBackButtonClick(View view) {
		Intent i = new Intent();
		setResult(RESULT_OK, i);
		finish();	
	}
	public void onSubmitButtonClick(View view) {
		Toast.makeText(getApplicationContext(), "Attendance Submitted",
                Toast.LENGTH_SHORT).show();
	}
	
	//array holding data items for the list (temporary)
	//in future will pull these from a database or spreadsheet
	static final String[] PEOPLE = new String[] {
	    "Alice J.", "Bob D.", "Catherine H.", "Christian C.", "Victor G.",
	    "Rupi S.", "Sean W.","Alice J.", "Bob D.", "Catherine H.", "Christian C.", "Victor G.",
	    "Rupi S.", "Sean W."
	  };
}
