package edu.upenn.cis350;

/**
 * represents a row in the Roster
 * used by RosterAdapter.java and Roster.java
 *
 */
public class RosterListItem {
	private String name;
	private String status;
	
	public RosterListItem(String name, String status){
		super();
		this.name = name;
		this.status = status;
	}
	
	public void cycleStatus(){
		if 		(this.status.equals("Present")){ this.status = "Absent";}
		else if (this.status.equals("Absent")){ this.status = "Late";}
		else if (this.status.equals("Late")){ this.status = "Present";}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

