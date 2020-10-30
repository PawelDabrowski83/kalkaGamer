package com.facebook.games.utils;

public interface ScannerWrapper{
    String getString();
    int getInt() throws NumberFormatException;
    double getDouble() throws NumberFormatException;
}
