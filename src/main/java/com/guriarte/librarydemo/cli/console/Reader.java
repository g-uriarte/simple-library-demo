package com.guriarte.librarydemo.cli.console;

import com.guriarte.librarydemo.cli.console.validator.InputValidator;

public interface Reader<T> {

    T read(
        InputValidator<T> inputValidator, String messageInvalidValue,
        String messageException
    );

}
