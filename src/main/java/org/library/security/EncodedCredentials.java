package org.library.security;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class EncodedCredentials {
    private static EncodedCredentials instance = null;
    @Getter
    @Setter
    private Map<String,String> passwordMatch = new HashMap<>();
    private EncodedCredentials(){}
    public static EncodedCredentials getInstance(){
        if(instance == null){
            instance = new EncodedCredentials();
        }
        return instance;
    }
}
