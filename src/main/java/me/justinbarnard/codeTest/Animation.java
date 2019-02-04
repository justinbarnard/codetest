package me.justinbarnard.codeTest;

import java.util.ArrayList;
import java.util.List;

public class Animation {
	private static final String OCCUPIED = "X";
	private static final String EMPTY = ".";

	public static List<String> animate(int speed, String init) {
		int currentTime = 0;
		int chamber = init.length();

		String exit = getExitCondition(chamber);

		List<String> animation = new ArrayList<String>();
		List<Partical> particals = createParticals(speed, init);

		String animationCell = null;
		while (!(exit.equals(animationCell))) {
			List<Integer> currPositions = findParticals(currentTime, particals);
			animationCell = getCurrentChamber(chamber, currPositions);
			animation.add(animationCell);
			currentTime++;

		}

		return animation;
	}

	private static List<Partical> createParticals(int speed, String init) {
		int startLocation = 0;
		List<Partical> particals = new ArrayList<Partical>();

		for (char direction : init.toLowerCase().toCharArray()) {
			if (Partical.LEFT == direction || Partical.RIGHT == direction) { // Treat non L/R characters as empty
				particals.add(new Partical(direction, startLocation, speed));
			}
			startLocation++;
		}

		return particals;
	}

	private static List<Integer> findParticals(int time, List<Partical> particals) {
		List<Integer> currPositions = new ArrayList<Integer>();

		particals.forEach(partical -> currPositions.add(partical.wayFinding(time)));

		return currPositions;

	}

	private static String getCurrentChamber(int chamber, List<Integer> currPositions) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < chamber; i++) {
			if (currPositions.contains(i)) {
				sb.append(OCCUPIED);
			} else {
				sb.append(EMPTY);
			}
		}

		return sb.toString();
	}

	private static String getExitCondition(int chamber) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < chamber; i++) {
			sb.append(EMPTY);
		}
		return sb.toString();

	}

}
