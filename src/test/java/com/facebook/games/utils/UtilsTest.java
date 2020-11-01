package com.facebook.games.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilsTest {

    @DisplayName("Should getRandomNumber() return number within given limits")
    @ParameterizedTest
    @MethodSource("getRandomNumberArgumentsProvider")
    void getRandomNumber(int lowerBound, int upperBound){
        int repetitions = 100_000;
        while (repetitions > 0){
            int currentRandomInt = Utils.getRandomNumber(lowerBound, upperBound);
            assertTrue(currentRandomInt >= lowerBound);
            assertTrue(currentRandomInt <= upperBound);
            repetitions--;
        }
    }
    private static Stream<Arguments> getRandomNumberArgumentsProvider(){
        return Stream.of(
                Arguments.of(1, 10),
                Arguments.of(1, 2),
                Arguments.of(8, 19),
                Arguments.of(1, 100009),
                Arguments.of(Integer.MAX_VALUE, Integer.MAX_VALUE)
        );
    }
}
