package com.pathz.urlshort.exception;

public class UriNotFoundException extends RuntimeException {
    public UriNotFoundException(String uriId) {
        super(String.format("The specified URL cannot be found by %s id", uriId));
    }
}
