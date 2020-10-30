package com.facebook.games.utils;

public interface MessageParser {
    String parse(String string);
    String parse(String string, int arg1);
    String parse(String string, int arg1, int arg2);
    String parse(String string, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6);
}
