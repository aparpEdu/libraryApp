package org.library.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


class RegisteredUsersTest {

    @BeforeEach
    void setUp(){
        RegisteredUsers.getInstance().getUsers().clear();
    }

    @Test
    public void shouldBeAbleToMakeOnlyOneInstance() {
        RegisteredUsers firstInstance = RegisteredUsers.getInstance();
        RegisteredUsers secondInstance = RegisteredUsers.getInstance();
        User user = new User();
        user.setUsername("HaroldRafaello");
        firstInstance.getUsers().add(user);
        int numberOfUsersInFirstInstance = firstInstance.getUsers().size();
        int numberOfUsersInSecondInstance = secondInstance.getUsers().size();
        Assertions.assertEquals(numberOfUsersInFirstInstance,numberOfUsersInSecondInstance);
    }
}