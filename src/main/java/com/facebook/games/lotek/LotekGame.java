package com.facebook.games.lotek;

import com.facebook.games.gameInterfaces.GameWithScanner;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LotekGame implements GameWithScanner {
    public static final int LOWER_LIMIT_LOTTERY_NUMBERS = 1;
    public static final int UPPER_LIMIT_LOTTERY_NUMBERS = 66;
    public static final int NUMBER_POOL = 6;
    private final Set<Integer> numberPool = new TreeSet<>();
    private final MessagePrinter messagePrinter;

    public LotekGame(MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    @Override
    public void play(Scanner scanner) {
        messagePrinter.displayIntroduction();
        messagePrinter.collectNumbers(numberPool);
    }
}