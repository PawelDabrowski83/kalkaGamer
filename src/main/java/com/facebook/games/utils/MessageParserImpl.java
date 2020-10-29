package com.facebook.games.utils;

public class MessageParserImpl implements MessageParser {
    public String print(String string){
        if (string == null || string.isBlank()){
            return "";
        }
        return string;
    }

    public String print(String string, int arg1){
        return String.format(string, arg1);
    }

    public String print(String string, int arg1, int arg2){
        return String.format(string, arg1, arg2);
    }

    public String print(String string, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6){
        return String.format(string, arg1, arg2, arg3, arg4, arg5, arg6);
    }

}
