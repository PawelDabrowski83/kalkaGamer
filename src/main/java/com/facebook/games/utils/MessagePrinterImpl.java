package com.facebook.games.utils;

public class MessagePrinterImpl implements MessagePrinter{
    private final MessageParser messageParser;

    public MessagePrinterImpl(MessageParser messageParser) {
        this.messageParser = messageParser;
    }

    @Override
    public void print(String string) {
        String message = messageParser.parse(string);
        System.out.println(message);
    }

    @Override
    public void print(String string, int arg1) {
        String message = messageParser.parse(string, arg1);
        System.out.println(message);
    }

    @Override
    public void print(String string, int arg1, int arg2) {
        String message = messageParser.parse(string, arg1, arg2);
        System.out.println(message);
    }

    @Override
    public void print(String string, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        String message = messageParser.parse(string, arg1, arg2, arg3, arg4, arg5, arg6);
        System.out.println(message);
    }
}
