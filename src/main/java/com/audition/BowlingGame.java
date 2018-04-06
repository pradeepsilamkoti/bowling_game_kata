package com.audition;

public class BowlingGame {
	
	
	
	private int[] rolls = new int[22];
	
	private int FRAME_COUNT = 10;
	
	private int MAX_PINS_PER_ROLL = 10;
	
	private int currentRoll;
	
	public void rollTheBall(int pins) {
		rolls[currentRoll++] = pins;
	}
	
	public int getTotalScore() {
		int roll=0;
		int totalScore =0;
		System.out.println("***** Scores for each frame *******");
		for (int frame=0; frame< FRAME_COUNT; frame++) {
		
			if (rolls[roll] == 10) { //when roll is strike
				int frameScore = MAX_PINS_PER_ROLL + rolls[roll + 1] + rolls[roll+2];
				totalScore += frameScore;
				System.out.println("Score for frame "+ (frame+1) + ": " +  frameScore);
				roll++;
			}
			else if (rolls[roll] + rolls[roll+1] == 10) { // if its spare
				int frameScore = MAX_PINS_PER_ROLL + rolls[roll+2];
				totalScore += MAX_PINS_PER_ROLL + rolls[roll+2];
				System.out.println("Score for frame "+ (frame+1)+ ": " +  frameScore);
				roll += 2;
			} else {
				//If no spare and no strike
				int frameScore = rolls[roll] + rolls[roll + 1];
				totalScore += frameScore;
				System.out.println("Score for frame "+ (frame+1) + ": " + frameScore);
				roll += 2;
			}
			
		}
		
		return totalScore;
	}

}
