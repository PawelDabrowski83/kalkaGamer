package com.facebook.games.lotek;

public class LotekConfiguration {
    public static final int LOWER_LIMIT_LOTTERY_NUMBERS = 1;
    public static final int UPPER_LIMIT_LOTTERY_NUMBERS = 66;
    public static final int NUMBER_POOL = 6;
    protected static final String INTRODUCTION = "Welcome to the Lottery Game.\n" +
            "Pick 6 numbers within range %d-%d and check your luck!\n";
    protected static final String NUMBER_INPUT = "Please enter a number:";
    protected static final String NUMBER_INPUT_STRONGER = "Please enter real number:";
    protected static final String NUMBER_DUPLICATE = "Your number is already saved, please enter a unique number";
    protected static final String NUMBER_OUT_BOUNDS = "Number out of range: %d-%d\n";
    protected static final String NUMBER_POOL_COMPLETED = "Your numbers: %s\n";
    protected static final String WINNING_NUMBERS_PRESENTATION = "Winning numbers are: %s\n";
    protected static final String DISPLAY_RESULT = "You have guessed %d numbers.\n";
}
