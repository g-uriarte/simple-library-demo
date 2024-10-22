package com.guriarte.librarydemo.cli.actions.listbooks.messages;

import com.guriarte.librarydemo.utils.Text;

import java.util.List;

public class ListLanguagesMessage {

    private final List<String> languages;
    private static final String LANGUAGE_FORMAT = "%d.\t%s";
    private static final String LANGUAGE_FOUND_FORMAT = "Languages found (%d): ";

    public ListLanguagesMessage(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        var text = new Text();
        text.appendln(String.format(LANGUAGE_FOUND_FORMAT, languages.size()));
        text.appendln("Id\tcode");
        for (int i = 0; i < languages.size(); i++) {
            text.appendln(String.format(LANGUAGE_FORMAT, i + 1, languages.get(i)));
        }
        return text.toString();
    }
}
