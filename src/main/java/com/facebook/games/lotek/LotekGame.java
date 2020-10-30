package com.facebook.games.lotek;

import com.facebook.games.gameInterfaces.GameWithScanner;
import com.facebook.games.utils.MessagePrinter;
import com.facebook.games.utils.ScannerWrapper;

import java.util.*;


public class LotekGame implements GameWithScanner {
    public static final int LOWER_LIMIT_LOTTERY_NUMBERS = 1;
    public static final int UPPER_LIMIT_LOTTERY_NUMBERS = 66;
    private final ResourceBundle messages;
    private final MessagePrinter messagePrinter;
    private final Set<Integer> numberPool = new TreeSet<>();

    public LotekGame(Locale currentLocale, MessagePrinter messagePrinter) {
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        this.messagePrinter = messagePrinter;
    }

    @Override
    public void play(ScannerWrapper scannerWrapper) {
        introduce();
        while(numberPool.size() < 6){
            int number = getNumberFromUser(scannerWrapper);
            if (number != -1){
                numberPool.add(number);
            }
        }
        announceLottery();
    }

    private void introduce(){
        messagePrinter.print(messages.getString("introduction"));
    }

    private int getNumberFromUser(ScannerWrapper scannerWrapper){
        messagePrinter.print(messages.getString("numberNext"), LOWER_LIMIT_LOTTERY_NUMBERS, UPPER_LIMIT_LOTTERY_NUMBERS);
        int inputNumber = scannerWrapper.getInt();
        if (!isInBoundaries(inputNumber)){
            messagePrinter.print(messages.getString("numberOutOfBound"), LOWER_LIMIT_LOTTERY_NUMBERS, UPPER_LIMIT_LOTTERY_NUMBERS);
            return -1;
        }
        if (!isUnique(inputNumber)){
            messagePrinter.print(messages.getString("numberDuplicate"));
            return -1;
        }
        return inputNumber;
    }

    private boolean isInBoundaries(int number){
        return number >= LOWER_LIMIT_LOTTERY_NUMBERS && number <= UPPER_LIMIT_LOTTERY_NUMBERS;
    }

    private boolean isUnique(int number){
        return !numberPool.contains(number);
    }

    private void announceLottery(){
        messagePrinter.print(messages.getString("numbersSaved"));
    }
}
