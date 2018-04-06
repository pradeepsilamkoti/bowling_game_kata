package com.audition;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
	
	private BowlingGame game;
	
	@Before
	public void init() {
		game = new BowlingGame();
	}

	@Test
	public void testAllZeroPins() {
		System.out.println("***All 0 pins");
		for (int i=0; i<20; i++) {
			game.rollTheBall(0);
		}
		int totalScore = game.getTotalScore();
		System.out.println("Total score for all 0 pins: "+ totalScore);
		System.out.println("===============================================================================================");
		assertEquals(0, totalScore);
	}

	
	@Test
	public void testAllOnePins() {
		System.out.println("***All 1 pins");
		for (int i=0; i<20; i++) {
			game.rollTheBall(1);
		}
		int totalScore = game.getTotalScore();
		System.out.println("Total score for all 1 pins: "+ totalScore);
		System.out.println("===============================================================================================");
		assertEquals(20, totalScore);
	}
	
	@Test
	public void testAllThreePins() {
		System.out.println("***All 3 pins");
		for (int i=0; i<20; i++) {
			game.rollTheBall(3);
		}
		int totalScore = game.getTotalScore();
		System.out.println("Total score for all 3 pins: "+ totalScore);
		System.out.println("===============================================================================================");		
		assertEquals(60, totalScore);
	}
	
	@Test
	public void testOneSpare() {
		System.out.println("***One Spare");
		game.rollTheBall(5);
		game.rollTheBall(5);
		game.rollTheBall(5);
		
		this.rollMultipleTimes(16,  0);
		int totalScore = game.getTotalScore();
		System.out.println("Total score for one spare: "+ totalScore);
		System.out.println("===============================================================================================");
		assertEquals(20, totalScore);
	}
	
	
	@Test
	public void testOneStrike() {
		System.out.println("***One strike");
		game.rollTheBall(10);
		game.rollTheBall(3);
		game.rollTheBall(4);
		
		this.rollMultipleTimes(16,  0);
		int totalScore = game.getTotalScore();
		System.out.println("Total score for one strike: "+ totalScore);
		System.out.println("===============================================================================================");
		assertEquals(24, totalScore);
	}
	
	
	@Test
	public void testAllStrike() {
		System.out.println("***All strikes");

		
		this.rollMultipleTimes(12,  10);
		int totalScore = game.getTotalScore();
		System.out.println("Total score for all strikes: "+ totalScore);
		System.out.println("===============================================================================================");
		assertEquals(300, totalScore);
	}
	
	@Test
	public void testAllSpare() {
		System.out.println("***All spares");

		
		this.rollMultipleTimes(21,  5);
		int totalScore = game.getTotalScore();
		System.out.println("Total score for all spares: "+ totalScore);
		System.out.println("===============================================================================================");
		assertEquals(150, totalScore);
	}
	
	
	private void rollMultipleTimes(int rolls, int pins) {
		for (int i=0; i < rolls; i ++) {
			
			game.rollTheBall(pins);
		}
	}

	
}
