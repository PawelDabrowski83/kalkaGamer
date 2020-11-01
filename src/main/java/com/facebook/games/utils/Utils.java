package com.facebook.games.utils;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public static int getRandomNumber(int inclusiveFrom, int inclusiveTo){
        if (inclusiveTo < inclusiveFrom){
            throw new IllegalArgumentException("Range is defined incorrectly - inclusiveTo cannot be lower than inclusiveFrom");
        }
        if (inclusiveTo == inclusiveFrom){
            return inclusiveFrom;
        }
        int range = inclusiveTo - inclusiveFrom;
        return ThreadLocalRandom.current().nextInt(range) + inclusiveFrom;
    }
}
