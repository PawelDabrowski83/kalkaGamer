package com.facebook.games.lotek;

import java.util.Scanner;
import java.util.Set;

public class LotekService {

    protected static final String INTRODUCTION = "Welcome to the Lottery Game.\n" +
            "Pick 6 numbers within range %d-%d and check your luck!\n";
    protected static final String NUMBER_INPUT = "Please enter a number:";
    protected static final String NUMBER_INPUT_STRONGER = "Please enter real number:";
    protected static final String NUMBER_DUPLICATE = "Your number is already saved, please enter a unique number";
    protected static final String NUMBER_OUT_BOUNDS = "Number out of range: %d-%d\n";
    protected static final String NUMBER_POOL_COMPLETED = "Your numbers: %s\n";
    private final Scanner scanner;

    public LotekService(Scanner scanner) {
        this.scanner = scanner;
    }

    protected void displayIntroduction(){
        System.out.printf(INTRODUCTION, LotekGame.LOWER_LIMIT_LOTTERY_NUMBERS, LotekGame.UPPER_LIMIT_LOTTERY_NUMBERS);
    }

    protected void collectNumbers(Set<Integer> numberPool){
        while(numberPool.size() < LotekGame.NUMBER_POOL){
            int numberInput = getNumber();

            if (isNumberDuplicate(numberInput, numberPool)){
                System.out.println(NUMBER_DUPLICATE);
                continue;
            }
            if (isNumberOutOfBounds(numberInput)){
                System.out.printf(NUMBER_OUT_BOUNDS, LotekGame.LOWER_LIMIT_LOTTERY_NUMBERS, LotekGame.UPPER_LIMIT_LOTTERY_NUMBERS);
                continue;
            }
            numberPool.add(numberInput);
        }
    }

    private int getNumber(){
        int number = -1;
        System.out.println(NUMBER_INPUT);
        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println(NUMBER_INPUT_STRONGER);
        }
        return scanner.nextInt();
    }

    private boolean isNumberDuplicate(int number, Set<Integer> numberPool){
        return numberPool.contains(number);
    }

    private boolean isNumberOutOfBounds(int number){
        return number > LotekGame.UPPER_LIMIT_LOTTERY_NUMBERS || number < LotekGame.LOWER_LIMIT_LOTTERY_NUMBERS;
    }

    protected void displayUserNumbers(Set<Integer> numbers){
        String numberPoolAsString = stringifySet(numbers);
        System.out.printf(NUMBER_POOL_COMPLETED, numberPoolAsString);
    }

    protected String stringifySet(Set<Integer> numbers){
        return numbers.toString().replaceAll("[]\\[]", "");
    }

}
