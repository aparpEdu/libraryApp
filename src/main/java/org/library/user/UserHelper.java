package org.library.user;

import java.util.Optional;
import java.util.Set;

public class UserHelper {
    public static Optional<User> findUserByUsername(String username){
        Set<User> registeredUsers = RegisteredUsers.getInstance().getUsers();
        return registeredUsers.stream().filter(user -> username.equals(user.getUsername())).findFirst();
    }
}