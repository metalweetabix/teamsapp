package model;

public class player extends person{
	private int numGoals;
	private boolean isGoalie;
	private team team;

	public player(name personName, String phone, String email, int numGoals, boolean isGoalie, Object team) {
		super(personName, phone, email);
		this.setNumGoals(numGoals);
		this.isGoalie = isGoalie;
		this.team = (model.team) team;
	}

	public int getNumGoals() {
		return numGoals;
	}

	public void setNumGoals(int numGoals) {
		this.numGoals = numGoals;
	}
	
	public boolean getGoalie() {
		return isGoalie;
	}
	
	public void makeGoalie(boolean isGoalie) {
		this.isGoalie = isGoalie;
	}
	
	public String toString() {
		return "\nName: " + personName.toString()
		     + "\nPhone: " + phone
		     + "\neMail: " + email
		     + "\nTeam: " + team.getTeamName()
		     + "\nGoalie: " + isGoalie;
	}
}
