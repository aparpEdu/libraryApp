package org.library.security;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.library.user.RegisteredUsers;
import org.library.user.User;

public class AuthenticationHelperTest {
    @BeforeEach
    void setUp(){
        EncodedCredentials.getInstance().getPasswordMatch().clear();
        RegisteredUsers.getInstance().getUsers().clear();
    }

    @Test
    public void shouldReturnTrueWhenTheUsernameExists() {
        String usernameInput = "Sanji";
        User user = new User();
        user.setUsername(usernameInput);
        RegisteredUsers.getInstance().getUsers().add(user);// add user to the system
        boolean isInTheSystem = AuthenticationHelper.isUsernamePresent(usernameInput);
        Assertions.assertTrue(isInTheSystem);
    }

    @Test
    public void shouldReturnFalseWhenTheUsernameIsNotPresentInTheSystem() {
        String usernameInput = "Sanji";
        boolean isInTheSystem = AuthenticationHelper.isUsernamePresent(usernameInput);
        Assertions.assertFalse(isInTheSystem);
    }

    @Test
    public void shouldReturnTrueWhenThePasswordIsCorrect() {
        String usernameInput = "Sanji";
        String passwordInput = "namiswan";
        User user = new User();
        user.setUsername(usernameInput);
        user.setConsent(true);
        user.setEmail("roger@gmail.com");
        Authentication.signUp(user, passwordInput); //signing up user
        boolean passwordIsCorrect = AuthenticationHelper.isCorrectPassword(passwordInput, usernameInput);
        Assertions.assertTrue(passwordIsCorrect);
    }

    @Test
    public void shouldReturnFalseWhenThePasswordIsIncorrect() {
        String usernameInput = "Sanji";
        String passwordInput = "namiswan";
        String realPassword = "iLoveZoro";
        User user = new User();
        user.setUsername(usernameInput);
        user.setConsent(true);
        user.setEmail("roger@gmail.com");
        Authentication.signUp(user,realPassword); //signing up user
        boolean passwordIsCorrect = AuthenticationHelper.isCorrectPassword(passwordInput,usernameInput);
        Assertions.assertFalse(passwordIsCorrect);
    }

    @Test
    public void shouldReturnTrueIfEmailExists() {
        String emailInput = "harrypotter@gmail.com";
        User user = new User();
        user.setEmail(emailInput);
        RegisteredUsers.getInstance().getUsers().add(user); //adding user to the system
        boolean emailAlreadyExists = AuthenticationHelper.isEmailPresent(emailInput);
        Assertions.assertTrue(emailAlreadyExists);
    }

    @Test
    public void shouldReturnFalseIfEmailDoesntExists() {
        String emailInput = "harrypotter@gmail.com";
        User user = new User();
        user.setEmail("crysis@gmail.com");
        RegisteredUsers.getInstance().getUsers().add(user); //adding user to the system
        boolean emailAlreadyExists = AuthenticationHelper.isEmailPresent(emailInput);
        Assertions.assertFalse(emailAlreadyExists);
    }

    @Test
    public void shouldSetTheUserAsLoggedIn() {
        User user = new User();
        user.setUsername("Pinocchio");
        RegisteredUsers.getInstance().getUsers().add(user); //adding user to the system
        AuthenticationHelper.setUserLoggedIn(user.getUsername()); //logging in user
        boolean userIsLoggedIn = user.isLoggedIn();
        Assertions.assertTrue(userIsLoggedIn);
    }


}