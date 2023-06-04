package org.library.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserHelperTest {
    @BeforeEach
    void setUp(){
        RegisteredUsers.getInstance().getUsers().clear();
    }
    @Test
    void shouldReturnAUserWhenFound() {
        User user = new User();
        String username = "Michael";
        user.setUsername(username);
        User wrongUser = new User();
        wrongUser.setUsername("GabeNewell");
        RegisteredUsers.getInstance().getUsers().add(wrongUser);//adding another user for example
        RegisteredUsers.getInstance().getUsers().add(user); // adding user to the system
        String foundUsername = UserHelper.findUserByUsername(user.getUsername()).orElse(user).getUsername();
        assertEquals(username, foundUsername);
    }
}