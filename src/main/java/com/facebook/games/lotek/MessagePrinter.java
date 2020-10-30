package com.facebook.games.lotek;

import com.facebook.games.lotek.LotekGame;

import java.util.Scanner;

public class MessagePrinter {

    protected static final String INTRODUCTION = "Welcome to the Lottery Game.\n" +
            "Pick 6 numbers within range %d-%d and check your luck!\n";
    private final Scanner scanner;

    public MessagePrinter(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayIntroduction(){
        System.out.printf(INTRODUCTION, LotekGame.LOWER_LIMIT_LOTTERY_NUMBERS, LotekGame.UPPER_LIMIT_LOTTERY_NUMBERS);
    }
}
