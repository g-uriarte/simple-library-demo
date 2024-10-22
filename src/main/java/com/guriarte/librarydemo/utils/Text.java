package com.guriarte.librarydemo.utils;

public class Text {

    private final StringBuilder sb;

    public Text() {
        this.sb = new StringBuilder();
    }

    public void append(String value) {
        this.sb.append(value);
    }

    public void appendln(String value) {
        this.append(value + "\n");
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
