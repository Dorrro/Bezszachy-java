package com.bezszachy;

public class Constants {

    private static Constants instance;
    public int FieldSize = 8;

    private Constants() {
    }

    public static Constants getInstance() {
        if (instance == null) {
            instance = new Constants();
        }

        return instance;
    }

    public int getFieldSize() {
        return FieldSize;
    }
}
