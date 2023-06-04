package org.library.exception;

public class MissingUserDataException extends NullPointerException{
    public MissingUserDataException(String message){
        super(message);
    }
}
