package com.facebook.games.lotek;

import com.facebook.games.gameInterfaces.Game;

import java.util.Scanner;

public class LotekGame implements Game {
    private final LotekService lotekService;

    public LotekGame(LotekService lotekService) {
        this.lotekService = lotekService;
    }

    @Override
    public void play() {
        lotekService.displayIntroduction();
        lotekService.collectNumbers();
        lotekService.displayUserNumbers();
        lotekService.getWinningNumbers();
        lotekService.displayWinningNumbers();
        lotekService.displayLotteryResolution();
    }
}