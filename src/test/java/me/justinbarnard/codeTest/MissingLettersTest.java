package me.justinbarnard.codeTest;

import junit.framework.TestCase;
import me.justinbarnard.codeTest.MissingLetters;

public class MissingLettersTest extends TestCase {
	private static final String ALL = "abcdefghijklmnopqrstuvwxyz";
	private static final String PANGRAM = "sphinx of black quartz judge my vow";
	private static final String WHITESPACE = "         ";
	private static final String EMPTY = "";
	private static final String FAILURE1 = "Hello World";
	private static final String FAILURE2 = "Never gonna give you up, Never gonna let you down, Never gonna run around and desert you";

	public void testMissingLettersAlphabet() {
		String result = MissingLetters.getMissingLetters(ALL);
		assertEquals(EMPTY, result);
		String result1 = MissingLetters.getMissingLetters(PANGRAM);
		assertEquals(EMPTY, result1);

	}

	public void testMissingLettersPangram() {
		String result = MissingLetters.getMissingLetters(PANGRAM);
		assertEquals(EMPTY, result);

	}

	public void testMissingLettersWhitespace() {
		String result = MissingLetters.getMissingLetters(WHITESPACE);
		assertEquals(EMPTY, result);
	}

	public void testMissingLettersEmpty() {
		String result = MissingLetters.getMissingLetters(EMPTY);
		assertEquals(EMPTY, result);

	}

	public void testMissingLettersNonPangram1() {
		String result = MissingLetters.getMissingLetters(FAILURE1);
		assertEquals("abcfgijkmnpqstuvxyz", result);
	}

	public void testMissingLettersNonPangram2() {
		String result = MissingLetters.getMissingLetters(FAILURE2);
		assertEquals("bcfhjkmqxz", result);
	}

}