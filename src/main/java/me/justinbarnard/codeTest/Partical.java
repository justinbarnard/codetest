package me.justinbarnard.codeTest;

public class Partical {
	private char direction;
	private int startLocation;
	private int speed;

	public static final char LEFT = 'l';
	public static final char RIGHT = 'r';

	public Partical(char direction, int startLocation, int speed) {
		this.direction = direction;
		this.startLocation = startLocation;
		this.speed = speed;
	}

	// "Knowing where you are by knowing where you've been." - Maui (From Disney's Moana)
	// Sorry for the dad joke
	public int wayFinding(int time) {
		int movement = time * speed;
		if (LEFT == direction) {
			return startLocation - movement;
		}
		return startLocation + movement;
	}
}
