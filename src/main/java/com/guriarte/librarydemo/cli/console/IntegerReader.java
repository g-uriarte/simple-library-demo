package com.guriarte.librarydemo.cli.console;

import com.guriarte.librarydemo.cli.console.validator.InputValidator;

import java.util.InputMismatchException;

public class IntegerReader implements Reader<Integer> {

    private final ConsoleReader consoleReader;

    public IntegerReader(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    public Integer read(
        InputValidator<Integer> inputValidator, String messageInvalidValue,
        String messageException
    ) {
        int value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                value = this.consoleReader.readInt();

                valid = inputValidator.validate(value);
                if (!valid) {
                    ConsolePrinter.println(messageInvalidValue);
                }
            } catch (InputMismatchException e) {
                ConsolePrinter.println(messageException);
                this.consoleReader.read();
            }
        }

        return value;
    }

}
