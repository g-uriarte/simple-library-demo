package com.guriarte.librarydemo.library.domain.mapper;

import com.guriarte.librarydemo.library.domain.Language;

public class LanguageMapper {

    public static Language fromPrimitive(String language) {
        var languageDomain = new Language();
        languageDomain.setName(language);
        return languageDomain;
    }

}
