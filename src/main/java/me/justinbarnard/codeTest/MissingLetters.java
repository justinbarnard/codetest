package me.justinbarnard.codeTest;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MissingLetters {
	private static final List<Character> alphabet = "abcdefghijklmnopqrstuvwxyz".chars().mapToObj(c -> (char) c)
			.collect(Collectors.toList());
	private static final int END = -1;
	private static final String EMPTY = "";

	public static String getMissingLetters(String input) {
		String sanitizedInput = sanitizeInput(input);
		if (EMPTY.equals(sanitizedInput)) {
			return EMPTY; // No Work Needed if input is empty
		}
		List<Character> unfoundLetters = new ArrayList<Character>(alphabet);
		StringReader sr = new StringReader(sanitizedInput.toLowerCase());
		try {
			int cur = sr.read();
			while (cur != END) {
				if (cur >= 97 && cur <= 122) {
					Character current = (char) cur;
					unfoundLetters.remove(current);
				}
				if (unfoundLetters.isEmpty()) {
					break; // If we found all letters stop checking
				}
				cur = sr.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sr.close();
		}

		return listToString(unfoundLetters);

	}

	private static String listToString(List<Character> list) {
		StringBuffer sb = new StringBuffer();
		list.forEach(item -> sb.append(item));
		return sb.toString();

	}

	private static String sanitizeInput(String input) {
		if (input == null || input.isBlank()) {
			return EMPTY;
		}
		return input.trim();

	}

}
