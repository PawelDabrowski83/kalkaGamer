package com.facebook.games;

import com.facebook.games.gameInterfaces.GameWithScanner;
import com.facebook.games.lotek.LotekGame;
import com.facebook.games.lotek.MessagePrinter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            MessagePrinter messagePrinter = new MessagePrinter(scanner);
            GameWithScanner game = new LotekGame(messagePrinter);
            game.play(scanner);
        }

    }
}
