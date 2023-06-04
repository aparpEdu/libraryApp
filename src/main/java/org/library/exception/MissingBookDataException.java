package org.library.exception;

public class MissingBookDataException extends NullPointerException {
    public MissingBookDataException(String message){
        super(message);
    }
}
