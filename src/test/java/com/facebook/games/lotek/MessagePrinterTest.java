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

public class MessagePrinterTest {
    MessagePrinter messagePrinter = new MessagePrinter(new Scanner(System.in));

    @DisplayName("Should stringifySet() work properly")
    @ParameterizedTest
    @MethodSource("stringifySetArgumentsProvider")
    void stringifySet(String expected, Set<Integer> given){
        assertEquals(expected, messagePrinter.stringifySet(given));
    }
    private static Stream<Arguments> stringifySetArgumentsProvider(){
        return Stream.of(
                Arguments.of("", Collections.emptySet()),
                Arguments.of("5, 10, 11, 19", new TreeSet<Integer>(Set.of(5, 11, 19, 10)))
        );
    }
}
