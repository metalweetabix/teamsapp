package model;

public class team {
	private manager manager;
	private player[] players = new player[8];
	private int playerCounter;
	private String colour;
	private String teamName;
	
	public team(manager manager, String colour, String teamName) {
		this.manager = manager;
		this.colour = colour;
		this.teamName = teamName;
	}
	
	public void setManager(manager manager) {
		this.manager = manager;
	}
	
	public void removeManager() {
		this.manager = null;
	}
	
	public void setPlayer(player newPlayer) {
		int playerSpot = 0;
		boolean spotFound = false;
		for (int i = 0; spotFound == false; i++) {
			if (players[i] == null) {
				playerSpot = i;
				spotFound = true;
				playerCounter++;
				break;
			}
		}
		players[playerSpot] = newPlayer;
	}
	
	public void kickPlayer(int position) {
		if (players[position] != null) {
			this.players[position] = null;
			playerCounter--;
		}
		else {
			System.out.println("Cannot remove a player that doesn't exist");
		}
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public int getPlayerCounter() {
		return playerCounter;
	}
	
	public player[] getPlayers() {
		return players;
	}
	
	public player getPlayer(int value) {
		return players[value];
	}
	
	public String toString() {
		String printThis = "\nName: " + teamName
						 + "\nColour: " + colour
						 + "\nManager: " + manager.getName()
						 + "\nPlayers: ";
		
		for (int i = 0; i < playerCounter; i++) {
			if (players[i] != null) {
				printThis += "\n\t-" + players[i].getName();
			}
		}
		
		return printThis;
	}
}
