package com.facebook.games.lotek;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import static com.facebook.games.lotek.LotekConfiguration.*;

public class LotekService {
    private final Scanner scanner;
    private final Set<Integer> numberPool;
    private final Set<Integer> winningPool;

    public LotekService(Scanner scanner) {
        this.scanner = scanner;
        this.numberPool = new TreeSet<>();
        this.winningPool = new TreeSet<>();
    }

    // for tests
    protected LotekService(Set<Integer> numberPool){
        this.scanner = new Scanner(System.in);
        this.numberPool = numberPool;
        this.winningPool = new TreeSet<>();
    }

    protected void displayIntroduction(){
        System.out.printf(INTRODUCTION, LOWER_LIMIT_LOTTERY_NUMBERS, UPPER_LIMIT_LOTTERY_NUMBERS);
    }

    protected void collectNumbers(){
        while(numberPool.size() < NUMBER_POOL){
            int numberInput = getNumber();

            if (isNumberDuplicate(numberInput)){
                System.out.println(NUMBER_DUPLICATE);
                continue;
            }
            if (isNumberOutOfBounds(numberInput)){
                System.out.printf(NUMBER_OUT_BOUNDS, LOWER_LIMIT_LOTTERY_NUMBERS, UPPER_LIMIT_LOTTERY_NUMBERS);
                continue;
            }
            numberPool.add(numberInput);
        }
    }

    private int getNumber(){
        System.out.println(NUMBER_INPUT);
        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println(NUMBER_INPUT_STRONGER);
        }
        return scanner.nextInt();
    }

    protected boolean isNumberDuplicate(int number){
        return numberPool.contains(number);
    }

    protected boolean isNumberOutOfBounds(int number){
        return number > UPPER_LIMIT_LOTTERY_NUMBERS || number < LOWER_LIMIT_LOTTERY_NUMBERS;
    }

    protected void displayUserNumbers(){
        String numberPoolAsString = stringifySet(numberPool);
        System.out.printf(NUMBER_POOL_COMPLETED, numberPoolAsString);
    }

    protected String stringifySet(Set<Integer> numbers){
        return numbers.toString().replaceAll("[]\\[]", "");
    }

}
