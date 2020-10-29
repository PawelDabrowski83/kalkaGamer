package com.facebook.games.lotek;

import com.facebook.games.gameInterfaces.GameWithScanner;
import com.facebook.games.utils.MessageParser;
import com.facebook.games.utils.ScannerWrapper;

import java.util.Locale;
import java.util.ResourceBundle;


public class LotekGame implements GameWithScanner {
    public static final int LOWER_LIMIT_LOTTERY_NUMBERS = 1;
    public static final int UPPER_LIMIT_LOTTERY_NUMBERS = 66;
    private ResourceBundle messages;
    private MessageParser messageParser;

    public LotekGame(Locale currentLocale, MessageParser messageParser) {
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    @Override
    public void play(ScannerWrapper scannerWrapper) {
        introduce();
    }

    private void introduce(){
        String message = messages.getString("introduction");
        System.out.printf(message, LOWER_LIMIT_LOTTERY_NUMBERS, UPPER_LIMIT_LOTTERY_NUMBERS);
    }
}
