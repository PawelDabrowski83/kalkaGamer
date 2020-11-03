package com.facebook.games.lotek;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.mockito.Mockito.*;

public class LotekGameTest {

    LotekService lotekService = mock(LotekService.class);
    LotekGame lotekGame = new LotekGame(lotekService);

    @Test
    public void shouldPlayTriggerAllMethods(){
        lotekGame.play();
        verify(lotekService, times(1)).displayIntroduction();
        verify(lotekService, times(1)).collectNumbers();
        verify(lotekService, times(1)).displayUserNumbers();
        verify(lotekService, times(1)).getWinningNumbers();
        verify(lotekService, times(1)).displayWinningNumbers();
        verify(lotekService, times(1)).displayLotteryResolution();
    }
}
