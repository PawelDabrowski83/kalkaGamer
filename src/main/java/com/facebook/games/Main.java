package com.facebook.games;

import com.facebook.games.gameInterfaces.GameWithScanner;
import com.facebook.games.lotek.LotekGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            GameWithScanner game = new LotekGame();
            game.play(scanner);
        }

    }
}
