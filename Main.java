package com.vinhhua;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        playMontyHall();
    }

    /**
     * This method will show the the number of wins when you decide to switch/ stay with the door
     * that you initially picked.
     */
    public static void playMontyHall() {
        int switchWins = 0;
        int stayWins = 0;
        int games = 10000;
        Random rand = new Random();
        for (int plays = 0; plays < games; plays++) {
            // 0 is a goat, 1 is the winning prize (car)
            int[] doors = { 0, 0, 0 };
            // put a prize in one random door
            doors[rand.nextInt(3)] = 1;
            // pick a random door
            int choice = rand.nextInt(3);
            int shown;
            do {
                shown = rand.nextInt(3);
            } while (doors[shown] == 1 || shown == choice);

            stayWins += doors[choice];

            switchWins += doors[3 - choice - shown];
        }
        System.out.println("Switching wins " +switchWins+ " times.");
        System.out.println("Staying wins " +stayWins+ " times.");
    }
}
