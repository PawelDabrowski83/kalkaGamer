package com.facebook.games.lotek;

import com.facebook.games.gameInterfaces.GameWithScanner;

import java.util.Scanner;

public class LotekGame implements GameWithScanner {
    private final LotekService lotekService;

    public LotekGame(LotekService lotekService) {
        this.lotekService = lotekService;
    }

    @Override
    public void play(Scanner scanner) {
        lotekService.displayIntroduction();
        lotekService.collectNumbers();
        lotekService.displayUserNumbers();
        lotekService.getWinningNumbers();
        lotekService.displayWinningNumbers();
        lotekService.displayLotteryResolution();
    }
}