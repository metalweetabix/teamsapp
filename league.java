package controller;

import model.team;

public class league {
	private String leagueName;
	protected team[] teams;
	private int counter;
	
	public league(String leagueName, int length) {
		this.setTeams(new team[length]);
		this.leagueName = leagueName;
	}

	private void setTeams(team[] newTeams) {
		this.teams = newTeams;
		
	}
	
	public String getName() {
		return leagueName;
	}
	
	public void setName(String name) {
		leagueName = name;
	}
	
	public int getCounter() {
		return counter;
	}

	public void add(team item) {
		for (int i = 0; i < teams.length; i++) {
			if (teams[i] == null) {
				getTeams()[counter] = item;
				counter += 1;
				break;
				
			}
			else {
				//System.out.println("League is full");
			}
			
			//System.out.println("Added item");
		}
	}
	
	public team[] getTeams() {
		return teams;
	}

	public void remove(int value) {
		if (this.isEmpty() == false) {
			getTeams()[value] = getTeams()[-value];
			counter -= 1;
		}
		else {
			//System.out.println("League is full");
		}
	}
	
	public Boolean isFull() {
		 boolean res = false;
		 if(counter == getTeams().length) {
		 res = true;
		 }
		 return res;
	}
	
	public Boolean isEmpty() {
		boolean res = false;
		if(counter == 0) {
			res = true;
		}
		return res;
	}
	
	public int getTotal() {
		int total = getTeams().length;
		return total;
	}
	
	public team getTeam(int value) {
		return teams[value];
	}

	public String toString() {
		String printThis = "\nName: " + leagueName
						 + "\nTeams: ";
		
		for (int i = 0; i < counter; i++) {
			if (teams[i] != null) {
				printThis += "\n\t-" + teams[i].getTeamName();
			}
		}
		
		return printThis;
	}
}
