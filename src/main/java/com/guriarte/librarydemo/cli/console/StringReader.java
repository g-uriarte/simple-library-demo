package com.guriarte.librarydemo.cli.console;

import com.guriarte.librarydemo.cli.console.validator.InputValidator;

import java.util.NoSuchElementException;

public class StringReader implements Reader<String> {

    private final ConsoleReader consoleReader;

    public StringReader(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    @Override
    public String read(
        InputValidator<String> inputValidator, String messageInvalidIntegerValue,
        String messageInputMismatch
    ) {
        String value = "";
        boolean valid = false;
        while (!valid) {
            try {
                value = this.consoleReader.read();
                valid = inputValidator.validate(value.trim());
                if (!valid) {
                    ConsolePrinter.println(messageInvalidIntegerValue);
                }
            } catch (NoSuchElementException e) {
                ConsolePrinter.println(messageInputMismatch);
                this.consoleReader.cleanBuffer();
            }
        }

        return value;
    }
}
