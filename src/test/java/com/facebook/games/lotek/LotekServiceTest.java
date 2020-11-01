package com.facebook.games.lotek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LotekServiceTest {
    LotekService lotekService = new LotekService(new Scanner(System.in));

    @DisplayName("Should stringifySet() work properly")
    @ParameterizedTest
    @MethodSource("stringifySetArgumentsProvider")
    void stringifySet(String expected, Set<Integer> given){
        assertEquals(expected, lotekService.stringifySet(given));
    }
    private static Stream<Arguments> stringifySetArgumentsProvider(){
        return Stream.of(
                Arguments.of("", Collections.emptySet()),
                Arguments.of("5, 10, 11, 19", new TreeSet<Integer>(Set.of(5, 11, 19, 10)))
        );
    }

    @DisplayName("should isNumberDuplicate() return correct answer")
    @ParameterizedTest
    @MethodSource("isNumberDuplicateArgumentsProvider")
    void isNumberDuplicate(boolean expected, int number, Set<Integer> numberPool){
        lotekService = new LotekService(numberPool);
        assertEquals(expected, lotekService.isNumberDuplicate(number));
    }
    private static Stream<Arguments> isNumberDuplicateArgumentsProvider(){
        return Stream.of(
                Arguments.of(true, 1, Set.of(1, 2, 3)),
                Arguments.of(false, 0, Set.of(1, 2, 3)),
                Arguments.of(false, 1, Collections.emptySet()),
                Arguments.of(false, Integer.MAX_VALUE, Set.of(1, 2, 3)),
                Arguments.of(true, Integer.MIN_VALUE, Set.of(Integer.MIN_VALUE, Integer.MAX_VALUE, -19))
        );
    }

    @DisplayName("Should isNumberOutOfBounds() work")
    @ParameterizedTest
    @MethodSource("isNumberOutOfBoundsArgumentsProvider")
    void isNumberOutOfBounds(boolean expected, int number){
        assertEquals(expected, lotekService.isNumberOutOfBounds(number));
    }
    private static Stream<Arguments> isNumberOutOfBoundsArgumentsProvider(){
        return Stream.of(
                Arguments.of(true, LotekConfiguration.LOWER_LIMIT_LOTTERY_NUMBERS - 1),
                Arguments.of(false, LotekConfiguration.LOWER_LIMIT_LOTTERY_NUMBERS),
                Arguments.of(false, LotekConfiguration.UPPER_LIMIT_LOTTERY_NUMBERS),
                Arguments.of(true, LotekConfiguration.UPPER_LIMIT_LOTTERY_NUMBERS + 1),
                Arguments.of(true, Integer.MIN_VALUE),
                Arguments.of(true, Integer.MAX_VALUE)
        );
    }

    @DisplayName("Should countGuessedNumbers() return how many lottery numbers you guessed")
    @ParameterizedTest
    @MethodSource("countGuessedNumbersArgumentsProvider")
    void countGuessedNumbers(int expected, Set<Integer> numbersGuessed, Set<Integer> lotteryNumbers){
        lotekService = new LotekService(numbersGuessed, lotteryNumbers);
        assertEquals(expected, lotekService.countGuessedNumbers());
    }
    private static Stream<Arguments> countGuessedNumbersArgumentsProvider(){
        return Stream.of(
                Arguments.of(0, Set.of(1, 2, 3, 4, 5, 6), Set.of(11, 22, 33, 44, 55, 66)),
                Arguments.of(1, Set.of(1, 2, 3, 4, 5, 6), Set.of(6, 7, 8)),
                Arguments.of(2, Set.of(11, 12, 13, 14, 15), Set.of(15, 13)),
                Arguments.of(6, Set.of(1, 2, 3, 4, 5, 6), Set.of(1, 2, 3, 4, 5, 6))
        );
    }
}
