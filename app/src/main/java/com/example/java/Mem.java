package com.example.java;

import java.util.Random;

public class Mem {
    static Random random = new Random();
    private static int randNum = random.nextInt(11);
    private static int countLox = 0;
    private static int allCountLox = 0;
    private static int countNewGame = 0;

    public int getAllCountLox() {
        return allCountLox;
    }

    public int getCountLox() {
        return countLox;
    }

    public int getCountNewGame() {
        return countNewGame;
    }

    public int getRandNum() {
        return randNum;
    }

    public void setAllCountLox(int allCountLox) {
        this.allCountLox = allCountLox;
    }

    public void setCountLox(int countLox) {
        this.countLox = countLox;
    }

    public void setCountNewGame(int countNewGame) {
        this.countNewGame = countNewGame;
    }

    public void newRandom() {
        this.randNum = random.nextInt(11);
    }
}
