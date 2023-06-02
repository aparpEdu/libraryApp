package org.library.security;

import org.library.user.User;

public class EncodingHelper {
    public static void addEncodedPassword(String encodedPassword, User user){
        EncodedCredentials.getInstance().getPasswordMatch().put(user.getUsername(),encodedPassword);
    }
    public static String getEncryptedPassword(User user){
        return EncodedCredentials.getInstance().getPasswordMatch().get(user.getUsername());
    }
}