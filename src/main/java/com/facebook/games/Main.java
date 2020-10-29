package com.facebook.games;

import com.facebook.games.gameInterfaces.GameWithScanner;
import com.facebook.games.lotek.LotekGame;
import com.facebook.games.utils.ScannerWrapper;
import com.facebook.games.utils.ScannerWrapperImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            ScannerWrapper scannerWrapper = new ScannerWrapperImpl(scanner);
            GameWithScanner game = new LotekGame();
            game.play(scannerWrapper);
        }

    }
}
