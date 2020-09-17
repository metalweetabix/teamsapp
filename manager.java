package model;

public class manager extends person{
	private String dob;
	private int stars;
	private team team;
	
	public manager(name personName, String phone, String email) {
		super(personName, phone, email);
		// TODO Auto-generated constructor stub
	}
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		if (stars >= 0 || stars <= 10) {
			this.stars = stars;
		}
		else if (stars > 10) {
			this.stars = 10;
		}
		else {
			this.stars = 0;
		}
	}
	
	public String starsToString() {
		return String.valueOf(stars); 
	}

	public team getTeam() {
		return team;
	}

	public void setTeam(team team) {
		this.team = team;
	}
	
	public String toString() {
		return "\nName: " + personName.toString() 
			 + "\nStars: " + starsToString()
			 + "\nDate Of Birth: " + dob
	   	     + "\nPhone: " + phone
		     + "\neMail: " + email
		     + "\nTeam:" + team.getTeamName();
	}

}
