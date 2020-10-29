package com.facebook.games.utils;

import java.util.Scanner;

public class ScannerWrapperImpl implements ScannerWrapper {
    private final Scanner scanner;

    public ScannerWrapperImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        return scanner.nextLine().trim();
    }

    @Override
    public int getInt() {
        return scanner.nextInt();
    }

    @Override
    public double getDouble() {
        return scanner.nextDouble();
    }
}
