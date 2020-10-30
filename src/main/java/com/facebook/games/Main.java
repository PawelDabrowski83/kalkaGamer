package com.facebook.games;

import com.facebook.games.gameInterfaces.GameWithScanner;
import com.facebook.games.lotek.LotekGame;
import com.facebook.games.utils.*;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String language;
        String country;

        if (args.length != 2) {
            language = new String("en");
            country = new String("US");
        } else {
            language = new String(args[0]);
            country = new String(args[1]);
        }

        Locale currentLocale;
        currentLocale = new Locale(language, country);

        try (Scanner scanner = new Scanner(System.in)){
            ScannerWrapper scannerWrapper = new ScannerWrapperImpl(scanner);
            MessageParser messageParser = new MessageParserImpl();
            MessagePrinter messagePrinter = new MessagePrinterImpl(messageParser);

            GameWithScanner game = new LotekGame(currentLocale, messagePrinter);
            game.play(scannerWrapper);
        }

    }
}
