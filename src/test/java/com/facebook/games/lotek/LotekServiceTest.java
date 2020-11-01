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
}
