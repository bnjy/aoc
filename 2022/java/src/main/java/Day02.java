package main.java;

import java.io.*;
import java.util.*;

public class Day02 {
    final static int ROCK = 0;
    final static int PAPER = 1;
    final static int SCISSOR = 2;

    public static void main(String[] args) throws IOException {
        part1();
    }

    public static void part1() throws IOException {
        Scanner in = new Scanner(new File("java/src/main/resources/day02.txt"));
        int total = 0;
        while (in.hasNext()) {
            String line = in.nextLine();
            total += evaluate(line);
        }
        System.out.println("total: " + total);
    }

    public static void part2() throws IOException {
        Scanner in = new Scanner(new File("java/src/main/resources/day02.txt"));

    }

    public static int evaluate(String currentStrategyLine) {
        int score = 0;
        String[] competingHands = currentStrategyLine.split(" ");
        int opponentHand = competingHands[0].charAt(0) - 65;
        int myHand = competingHands[1].charAt(0) - 88;

        score = calculateScore(opponentHand, myHand, score);

        return score;
    }

    /**
     * evalute the score of the two competing hands
     * WIN = 6 points
     * DRAW = 3 points
     * LOSS = 0 points
     * you also get score from the hand
     * A / X / 0 = ROCK = 1 points
     * B / Y / 1 = PAPER = 2 points
     * C / Z / 2 = SCISSOR = 3 points
     * 
     * @param opponentHand
     * @param myHand
     * @param score
     * @return
     */
    private static int calculateScore(int opponentHand, int myHand, int score) {
        switch (myHand) {
            case ROCK:
                score += 1;
                break;
            case PAPER:
                score += 2;
                break;
            case SCISSOR:
                score += 3;
                break;
        }

        if (opponentHand == myHand) {
            score += 3;
        } else if (playerWin(opponentHand, myHand)) {
            score += 6;
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
