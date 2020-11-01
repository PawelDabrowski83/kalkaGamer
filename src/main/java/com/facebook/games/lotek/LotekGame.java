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
    private final Set<Integer> winningPool = new TreeSet<>();
    private final LotekService lotekService;

    public LotekGame(LotekService lotekService) {
        this.lotekService = lotekService;
    }

    @Override
    public void play(Scanner scanner) {
        lotekService.displayIntroduction();
        lotekService.collectNumbers(numberPool);
        lotekService.displayUserNumbers(numberPool);
    }
}