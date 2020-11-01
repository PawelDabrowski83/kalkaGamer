package com.facebook.games;

import com.facebook.games.gameInterfaces.GameWithScanner;
import com.facebook.games.lotek.LotekGame;
import com.facebook.games.lotek.LotekService;

import java.util.Scanner;

public class App {
    public void initialize(){
        try (Scanner scanner = new Scanner(System.in)){
            LotekService lotekService = new LotekService(scanner);
            GameWithScanner game = new LotekGame(lotekService);
            game.play(scanner);
        }
    }
}
