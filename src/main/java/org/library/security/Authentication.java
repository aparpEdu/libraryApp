package org.library.security;

import org.library.exception.MissingUserDataException;
import org.library.user.RegisteredUsers;
import org.library.user.User;

public class Authentication {
    public static void signUp(User userToAdd,String password){
        try {
            if(userToAdd.isConsent()) {
                if (AuthenticationHelper.isUsernamePresent(userToAdd.getUsername())) {
                    System.out.println("User with this username already exists");
                } else {
                    if(AuthenticationHelper.isEmailPresent(userToAdd.getEmail())){
                        System.out.println("User with this email already exists!");
                    }else {
                        userToAdd.setLoggedIn(true);
                        RegisteredUsers.getInstance().getUsers().add(userToAdd);
                        String encodedPassword = Encoder.encodePassword(password);
                        EncodingHelper.addEncodedPassword(encodedPassword, userToAdd);
                        System.out.println("Account successfully created");
                    }
                }
            }
            else {
                System.out.println("User did not accept the terms of service");
            }
        }catch (NullPointerException exception){
            throw new MissingUserDataException("Missing credentials!");
        }

    }
    public static void signIn(String username,String password){
        if(AuthenticationHelper.isUsernamePresent(username)){
            if(AuthenticationHelper.isCorrectPassword(password,username)){
                System.out.println("Welcome back, "+username+"<3");
                AuthenticationHelper.setUserLoggedIn(username);
            }
            else {
                System.out.println("Incorrect credentials!");
            }
        }else {
            System.out.println("Such user does not exist in the system!");
        }

    }
}
