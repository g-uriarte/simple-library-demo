package com.guriarte.librarydemo.cli.ui.messages;

import com.guriarte.librarydemo.utils.Text;

import java.util.List;
import java.util.Set;

public class MenuMessage {

    private final List<String> titleOptions;

    public MenuMessage(List<String> titleOptions) {
        this.titleOptions = titleOptions;
    }

    public String generate() {
        var text = new Text();
        text.appendln("--- Menu ---");
        titleOptions.forEach(text::appendln);
        text.append("Select an option: ");
        return text.toString();
    }

}
