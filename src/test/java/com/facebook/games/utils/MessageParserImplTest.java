package com.facebook.games.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageParserImplTest {

    MessageParser messageParser = new MessageParserImpl();

    @DisplayName("should parse() return simple string")
    @ParameterizedTest
    @ValueSource(strings = {"test", "Hańba", "abc", "", ";"})
    void print(String expected){
        assertEquals(expected, messageParser.parse(expected));
    }

    @Test
    public void shouldParseGivenNullReturnEmpty(){
        assertEquals("", messageParser.parse(null));
    }

    @DisplayName("should parse(String, int) format valid String")
    @ParameterizedTest
    @MethodSource("parseWithOneIntArgumentsProvider")
    void print(String expected, String given, int arg1){
        assertEquals(expected, messageParser.parse(given, arg1));
    }
    private static Stream<Arguments> parseWithOneIntArgumentsProvider(){
        return Stream.of(
                Arguments.of("test 5", "test %d", 5),
                Arguments.of("Ab234c ", "Ab2%dc ", 34),
                Arguments.of("2147483647", "%d", Integer.MAX_VALUE),
                Arguments.of("13test", "%dtest", 13),
                Arguments.of("Test 14%d", "Test %d%%d", 14)
        );
    }

    @DisplayName("should parse(String, int1, int2) return properly formatted String")
    @ParameterizedTest
    @MethodSource("parseWithTwoIntArgumentsProvider")
    void print(String expected, String given, int arg1, int arg2){
        assertEquals(expected, messageParser.parse(given, arg1, arg2));
    }
    private static Stream<Arguments> parseWithTwoIntArgumentsProvider(){
        return Stream.of(
                Arguments.of("1111test 33", "%dtest %d", 1111, 33),
                Arguments.of("1701", "%d%d", 170, 1),
                Arguments.of("Ala -1 ma kota;;;; 13", "Ala %d ma kota;;;; %d", -1, 13)
        );
    }

    @DisplayName("should parse(String, int1... int6) return properly formatted String")
    @ParameterizedTest
    @MethodSource("parseWithSixIntArgumentsProvider")
    void print(String expected, String given, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6){
        assertEquals(expected, messageParser.parse(given, arg1, arg2, arg3, arg4, arg5, arg6));
    }
    private static Stream<Arguments> parseWithSixIntArgumentsProvider(){
        return Stream.of(
                Arguments.of("Winning numbers are: 10, 11, 12, 13, 14, 15", "Winning numbers are: %d, %d, %d, %d, %d, %d", 10, 11, 12, 13, 14, 15),
                Arguments.of("1 2 3 4 5 6", "%d %d %d %d %d %d", 1, 2, 3, 4, 5, 6),
                Arguments.of("-15 00000;", "%d %d%d%d%d%d;", -15, 0, 0, 0, 0, 0)
        );
    }
}
