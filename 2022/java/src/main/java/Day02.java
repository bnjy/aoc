package main.java;

import java.io.*;
import java.util.*;

public class Day02 {
    final static int ROCK = 0;
    final static int PAPER = 1;
    final static int SCISSOR = 2;

    final static int ROCK_SCORE = 1;
    final static int PAPER_SCORE = 2;
    final static int SCISSOR_SCORE = 3;

    final static int X = 0;
    final static int Y = 1;
    final static int Z = 2;

    final static int LOSE = 0;
    final static int DRAW = 3;
    final static int WIN = 6;

    public static void main(String[] args) throws IOException {
        //part1();
        part2();
    }

    public static void part1() throws IOException {
        Scanner in = new Scanner(new File("java/src/main/resources/day02.txt"));
        int total = 0;
        while (in.hasNext()) {
            String line = in.nextLine();
            total += evaluate(line);
        }
        System.out.println("total part1: " + total);
    }

    public static void part2() throws IOException {
        Scanner in = new Scanner(new File("java/src/main/resources/day02.txt"));
        int total = 0;
        while (in.hasNext()) {
            String line = in.nextLine();
            total += evaluatePart2(line);
        }
        System.out.println("total part2: " + total);
    }

    private static int evaluatePart2(String currentStrategyLine) {
        int score = 0;
        String[] competingHands = currentStrategyLine.split(" ");
        int opponentHand = competingHands[0].charAt(0) - 65;
        int myHand = competingHands[1].charAt(0) - 88;

        score = calculateScorePart2(opponentHand, myHand);

        return score;
    }
    
    /**
     * Brute force!!!!!!!!!
     * 
     * @param opponentHand
     * @param myHand
     * @return
     */
    private static int calculateScorePart2(int opponentHand, int myHand) {
        int score = 0;

        if(opponentHand == ROCK){
            if(myHand == X){ // need to loose to ROCK, so pick scissor
                score += LOSE + SCISSOR_SCORE;
            } else if(myHand == Y){ // need draw with ROCK, so pick rock
                score += DRAW + ROCK_SCORE;
            } else { // need to win against ROCK, so pick paper
                score += WIN + PAPER_SCORE;
            }
        } else if(opponentHand == PAPER){
            if(myHand == X){ // need to loose to PAPER, so pick ROCK
                score += LOSE + ROCK_SCORE;
            } else if(myHand == Y){ // need draw with PAPER, so pick PAPER
                score += DRAW + PAPER_SCORE;
            } else { // need to win against PAPER, so pick SCISSOR
                score += WIN + SCISSOR_SCORE;
            }
        } else {
            if(myHand == X){ // need to loose to SCISSOR, so pick PAPER
                score += LOSE + PAPER_SCORE;
            } else if(myHand == Y){ // need draw with SCISSOR, so pick SCISSOR
                score += DRAW + SCISSOR_SCORE;
            } else { // need to win against SCISSOR, so pick ROCK
                score += WIN + ROCK_SCORE;
            }
        }
        return score;
    }

    public static int evaluate(String currentStrategyLine) {
        int score = 0;
        String[] competingHands = currentStrategyLine.split(" ");
        int opponentHand = competingHands[0].charAt(0) - 65;
        int myHand = competingHands[1].charAt(0) - 88;

        score = calculateScore(opponentHand, myHand);

        return score;
    }

    /**
     * evalute the score of the two competing hands
     * WIN = 6 points
     * DRAW = 3 points
     * LOSS = 0 points
     * you also get score from the hand
     * A / X / 0 = ROCK = 1 points = LOSE
     * B / Y / 1 = PAPER = 2 points = DRAW
     * C / Z / 2 = SCISSOR = 3 points = WIN
     * 
     * @param opponentHand
     * @param myHand
     * @return
     */
    private static int calculateScore(int opponentHand, int myHand) {
        int score = 0;
        switch (myHand) {
            case ROCK:
                score += ROCK_SCORE;
                break;
            case PAPER:
                score += PAPER_SCORE;
                break;
            case SCISSOR:
                score += SCISSOR_SCORE;
                break;
        }

        if (opponentHand == myHand) {
            score += DRAW;
        } else if (playerWin(opponentHand, myHand)) {
            score += WIN;
        }
        return score;
    }
    
    private static boolean playerWin(int opponentHand, int myHand) {
        if (myHand == ROCK) {
            return (opponentHand == SCISSOR);
        } else if (myHand == PAPER) {
            return (opponentHand == ROCK);
        } else
            return (opponentHand == PAPER);
    }
}
