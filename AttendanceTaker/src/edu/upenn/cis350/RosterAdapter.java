package edu.upenn.cis350;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Custom adapter for the ListView used in Roster.
 * Allows multiple pieces of data to be placed in each row of the list
 * Holds the following data: Student Name, Status, and a Button to cycle Status
 *
 */
public class RosterAdapter extends BaseAdapter implements OnClickListener{
	
	private Context context;
	private List<RosterListItem> listRoster;
	
	//constructor
	public RosterAdapter(Context context, List<RosterListItem> listRoster){
		this.context = context;
		this.listRoster = listRoster;
	}
	
	public int getCount() {
        return listRoster.size();
    }
	
	public Object getItem(int position) {
        return listRoster.get(position);
    }
	
	public long getItemId(int position) {
        return position;
    }
	
	public View getView(int position, View convertView, ViewGroup viewGroup){
		//gets entry associated with current row in ListView
		RosterListItem entry = listRoster.get(position);
		
		//handles null case
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
		}
		// handles Student Name
		TextView tvRosterItemName = (TextView) convertView.findViewById(R.id.tvRosterItemName);
		tvRosterItemName.setText(entry.getName());
		
		// handles Student Status
		TextView tvRosterStatus = (TextView) convertView.findViewById(R.id.tvRosterStatus);
		tvRosterStatus.setText(entry.getStatus());
		
		// button to cycle statuses
        Button btnChange = (Button) convertView.findViewById(R.id.btnChange);
        btnChange.setFocusableInTouchMode(false);
        btnChange.setFocusable(false);
        btnChange.setOnClickListener(this);
        btnChange.setTag(entry);	// associates this row with this button
        
        return convertView;
	}
	
	//handles button click for specific row in the ListView
    public void onClick(View view) {
        RosterListItem entry = (RosterListItem) view.getTag();
        entry.cycleStatus();
        notifyDataSetChanged();
    }
	
}
