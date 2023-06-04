package org.library.security;

import org.library.exception.MissingUserDataException;
import org.library.user.RegisteredUsers;
import org.library.user.User;
import org.library.user.UserHelper;

import java.util.Optional;

import static org.library.security.EncodingHelper.getEncryptedPassword;

public class AuthenticationHelper {
    public static boolean isUsernamePresent(String username){
        RegisteredUsers registeredUsers = RegisteredUsers.getInstance();
        try {
            return registeredUsers.getUsers().stream().anyMatch(user -> user.getUsername().equals(username));
        }catch (NullPointerException exception){
            throw new MissingUserDataException("Missing username!");
        }

    }
    public static boolean isCorrectPassword(String password, String username){
        Optional<User> foundUser = UserHelper.findUserByUsername(username);
        if(foundUser.isPresent()){
            User userToVerify = foundUser.get();
            return Encoder.verifyPassword(password, getEncryptedPassword(userToVerify));
        }
        return  false;
    }
    public static boolean isEmailPresent(String email){
        RegisteredUsers registeredUsers = RegisteredUsers.getInstance();
        try {
            return registeredUsers.getUsers().stream().anyMatch(user -> user.getEmail().equals(email));
        }catch (NullPointerException exception){
            throw  new MissingUserDataException("Missing email");
        }

    }
    public static void setUserLoggedIn(String username){
        Optional<User> foundUser = UserHelper.findUserByUsername(username);
        if(foundUser.isPresent()){
            User userToLogIn = foundUser.get();
            RegisteredUsers.getInstance().getUsers().remove(userToLogIn);
            userToLogIn.setLoggedIn(true);
            RegisteredUsers.getInstance().getUsers().add(userToLogIn);
        }
    }
}
