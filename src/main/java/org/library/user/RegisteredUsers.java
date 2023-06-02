package org.library.user;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

public class RegisteredUsers {
    private static RegisteredUsers instance = null;
    @Getter
    @Setter
    private Set<User> users = new HashSet<>();
    private RegisteredUsers(){}

    public static RegisteredUsers getInstance(){
        if(instance == null){
            instance = new RegisteredUsers();
        }
        return instance;
    }
}
