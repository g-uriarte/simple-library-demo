package com.guriarte.librarydemo.cli.console;

import com.guriarte.librarydemo.cli.console.validator.InputValidator;

import java.util.InputMismatchException;

public class IntegerReader {

    private final ConsoleReader consoleReader;

    public IntegerReader(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    public int read(InputValidator inputValidator, String messageInvalidIntegerValue, String messageInputMismatch) {
        int value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                value = this.consoleReader.readInt();

                valid = inputValidator.validate(value);
                if (!valid) {
                    System.out.println(messageInvalidIntegerValue);
                }
            } catch (InputMismatchException e) {
                System.out.println(messageInputMismatch);
                this.consoleReader.read();
            }
        }

        return value;
    }

}
