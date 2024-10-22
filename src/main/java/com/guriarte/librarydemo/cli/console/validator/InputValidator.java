package com.guriarte.librarydemo.cli.console.validator;

@FunctionalInterface
public interface InputValidator {
    boolean validate(int value);
}
