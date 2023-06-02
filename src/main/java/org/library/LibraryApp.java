package org.library;


import org.library.security.Encoder;
import org.library.user.RegisteredUsers;
import org.library.user.User;
import org.library.user.UserHelper;

public class LibraryApp
{
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("user");
        RegisteredUsers.getInstance().getUsers().add(user);
        System.out.println(UserHelper.findUserByUsername("user"));
    }
}

