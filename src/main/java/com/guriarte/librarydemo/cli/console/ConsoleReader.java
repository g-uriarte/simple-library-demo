package com.guriarte.librarydemo.cli.console;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleReader {

    private final Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    public String read() throws NoSuchElementException {
        return this.scanner.nextLine();
    }

    public int readInt() throws InputMismatchException {
        return this.scanner.nextInt();
    }

}
