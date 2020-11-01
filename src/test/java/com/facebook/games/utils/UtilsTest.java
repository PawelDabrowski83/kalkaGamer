package com.facebook.games.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilsTest {

    @DisplayName("Should getRandomNumber() return number within given limits")
    @ParameterizedTest
    @MethodSource("getRandomNumberArgumentsProvider")
    void getRandomNumber(int inclusiveFrom, int inclusiveTo){
        int loops = 100_000;
        while (loops > 0){
            int currentRandomInt = Utils.getRandomNumber(inclusiveFrom, inclusiveTo);
            assertTrue(currentRandomInt >= inclusiveFrom);
            assertTrue(currentRandomInt <= inclusiveTo);
            loops--;
        }
    }
    private static Stream<Arguments> getRandomNumberArgumentsProvider(){
        return Stream.of(
                Arguments.of(1, 10),
                Arguments.of(1, 2),
                Arguments.of(8, 19),
                Arguments.of(1, 100009),
                Arguments.of(Integer.MAX_VALUE, Integer.MAX_VALUE),
                Arguments.of(Integer.MIN_VALUE, Integer.MAX_VALUE),
                Arguments.of(Integer.MIN_VALUE, 0),
                Arguments.of(-1000, 1999)
        );
    }

    @DisplayName("should getRandomNumber() throw IllegalArgumentException given incorrect range of numbers")
    @ParameterizedTest
    @MethodSource("getRandomNumberArgumentsProviderSetForFail")
    void getRandomNumberSetForFail(int inclusiveFrom, int inclusiveTo){
        int loops = 100_000;
        while (loops > 0){
            assertThrows(IllegalArgumentException.class, () -> Utils.getRandomNumber(inclusiveFrom, inclusiveTo));
            loops--;
        }
    }
    private static Stream<Arguments> getRandomNumberArgumentsProviderSetForFail(){
        return Stream.of(
                Arguments.of(0, -1),
                Arguments.of(Integer.MAX_VALUE, Integer.MIN_VALUE),
                Arguments.of(4, 3),
                Arguments.of(Integer.MAX_VALUE, 0)
        );
    }
}
