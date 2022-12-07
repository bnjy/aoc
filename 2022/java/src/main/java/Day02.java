package main.java;

import java.io.*;
import java.util.*;

public class Day02 {
    public static void main(String[] args) throws IOException {
        part1();
    }

    public static void part1() throws IOException {
        Scanner in = new Scanner(new File("java/src/main/resources/day02.txt"));
        int total = 0;
        while(in.hasNext()){
            String line = in.nextLine();
            total += evaluate(line);
        }
        System.out.println("total: " + total);
    }

    public static int evaluate(String strategy) {
        int score = 0;
        String[] competingHands = strategy.split(" ");
        int opponentHand = competingHands[0].compareTo("A");
        //System.out.println("opponent hand = " + opponentHand);
        int myHand = competingHands[1].compareTo("X");
        //System.out.println("my hand = " + myHand);
        int diffMod3 = Math.floorMod((opponentHand - myHand),3);
        switch(diffMod3){
            case 0: score += 3; break;
            case 1: break;
            case 2: score += 6; break;
        }
        score += myHand + 1;
        return score;
    }
}
