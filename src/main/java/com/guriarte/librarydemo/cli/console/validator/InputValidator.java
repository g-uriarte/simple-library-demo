package com.guriarte.librarydemo.cli.console.validator;

@FunctionalInterface
public interface InputValidator<T> {
    boolean validate(T value);
}
