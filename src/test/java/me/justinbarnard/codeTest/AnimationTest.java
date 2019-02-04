package me.justinbarnard.codeTest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import me.justinbarnard.codeTest.Animation;

public class AnimationTest extends TestCase {
	
	public void testAnimationSimpleInput() {
		List<String> testList = new ArrayList<String>();
		testList.add("X.X");
		testList.add(".X.");
		testList.add("X.X");
		testList.add("...");
		
		String init = "R.L";
		int speed = 1;
		
		List<String> result = Animation.animate(speed, init);
		
		assertEquals(testList, result);
		
	}
	
	public void testAnimationLowerCase() {
		List<String> testList = new ArrayList<String>();
		testList.add("X.X");
		testList.add(".X.");
		testList.add("X.X");
		testList.add("...");
		
		String init = "r.l";
		int speed = 1;
		
		List<String> result = Animation.animate(speed, init);
		
		assertEquals(testList, result);
		
	}
	
	public void testAnimationNonStandardInput() {
		List<String> testList = new ArrayList<String>();
		testList.add("X.X");
		testList.add(".X.");
		testList.add("X.X");
		testList.add("...");
		
		String init = "rql";
		int speed = 1;
		
		List<String> result = Animation.animate(speed, init);
		
		assertEquals(testList, result);
		
	}
	
	public void testAnimationBlank() {
		List<String> testList = new ArrayList<String>();
		testList.add("");
		
		String init = "";
		int speed = 1;
		
		List<String> result = Animation.animate(speed, init);
		
		assertEquals(testList, result);
		
	}
	
	public void testAnimationEmpty() {
		List<String> testList = new ArrayList<String>();
		testList.add("...");
		
		String init = "...";
		int speed = 1;
		
		List<String> result = Animation.animate(speed, init);
		
		assertEquals(testList, result);
		
	}

}
