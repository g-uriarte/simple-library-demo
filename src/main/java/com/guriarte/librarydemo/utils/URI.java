package com.guriarte.librarydemo.utils;

import java.net.URISyntaxException;

public class URI {

    public static String encodeURLPathComponent(String path) {
        try {
            return new java.net.URI(null, null, path, null).toASCIIString();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
