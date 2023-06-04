package org.library.security;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.library.user.RegisteredUsers;
import org.library.user.User;



public class AuthenticationTest {
    @BeforeEach
    public void setUp(){
        EncodedCredentials.getInstance().getPasswordMatch().clear();
        RegisteredUsers.getInstance().getUsers().clear();
    }
    @Test
    public void userShouldBeSignedUpWithNewUsernameAndEmailAndAcceptedEULA() {
        String usernameInput  = "Leonardo";
        String passwordInput = "daVinciBro";
        String emailInput = "brovinci@gmail.com";
        User newUser = new User();
        newUser.setUsername(usernameInput);
        newUser.setEmail(emailInput);
        newUser.setConsent(true);
        Authentication.signUp(newUser,passwordInput); //signing up user
        boolean userIsCreated = AuthenticationHelper.isUsernamePresent(usernameInput);
        Assertions.assertTrue(userIsCreated);
    }

    @Test
    public void userShouldNotBeSignedUpWithoutAcceptedEULA() {
        String usernameInput  = "Leonardo";
        String passwordInput = "daVinciBro";
        String emailInput = "brovinci@gmail.com";
        User newUser = new User();
        newUser.setUsername(usernameInput);
        newUser.setEmail(emailInput);
        Authentication.signUp(newUser,passwordInput); //signing up user
        boolean userIsCreated = AuthenticationHelper.isUsernamePresent(usernameInput);
        Assertions.assertFalse(userIsCreated);
    }

    @Test
    public void userShouldNotBeSignedUpWithSameUsername() {
        String usernameInput  = "Leonardo";
        String passwordInput = "daVinciBro";
        String emailInput = "brovinci@gmail.com";
        User newUser = new User();
        newUser.setUsername(usernameInput);
        newUser.setEmail(emailInput);
        newUser.setConsent(true);
        Authentication.signUp(newUser,passwordInput); //signing up user
        int initialNumberOfAccounts  = RegisteredUsers.getInstance().getUsers().size();
        Authentication.signUp(newUser,passwordInput); //signing up user again
        int afterTryingWithSameUsername  = RegisteredUsers.getInstance().getUsers().size();
        boolean userIsCreated = initialNumberOfAccounts < afterTryingWithSameUsername;
        Assertions.assertFalse(userIsCreated);
    }
    @Test
    public void userShouldNotBeSignedUpWithSameEmail() {
        String usernameInput  = "Leonardo";
        String passwordInput = "daVinciBro";
        String emailInput = "brovinci@gmail.com";
        User existingUser = new User();
        existingUser.setUsername(usernameInput);
        existingUser.setEmail(emailInput);
        existingUser.setConsent(true);
        Authentication.signUp(existingUser,passwordInput); //signing up user
        int initialNumberOfAccounts  = RegisteredUsers.getInstance().getUsers().size();

        User newUser = new User();
        newUser.setUsername("Alfred");
        newUser.setConsent(true);
        newUser.setEmail(emailInput);
        Authentication.signUp(newUser,passwordInput); //signing up a different user with same email
        int afterTryingWithSameUsername  = RegisteredUsers.getInstance().getUsers().size();
        boolean userIsCreated = initialNumberOfAccounts < afterTryingWithSameUsername;
        Assertions.assertFalse(userIsCreated);
    }
    @Test
    public void userShouldBeSignedInWhenInputtingCorrectCredentials(){
        String usernameInput = "Leonardo";
        String passwordInput = "daVinciBro";
        String emailInput = "brovinci@gmail.com";
        User existingUser = new User();
        existingUser.setUsername(usernameInput);
        existingUser.setEmail(emailInput);
        existingUser.setConsent(true);
        Authentication.signUp(existingUser,passwordInput);
        existingUser.setLoggedIn(false);
        Authentication.signIn(usernameInput,passwordInput);
        boolean isLoggedIn = existingUser.isLoggedIn();
        Assertions.assertTrue(isLoggedIn);
    }
    @Test
    public void userShouldNotBeSignedInWhenInputtingNonExistentUsername(){
        String usernameInput = "Leonardo";
        String passwordInput = "daVinciBro";
        String emailInput = "brovinci@gmail.com";
        String existingUsername = "Picasso";
        User existingUser = new User();
        existingUser.setUsername(existingUsername);
        existingUser.setEmail(emailInput);
        existingUser.setConsent(true);
        Authentication.signUp(existingUser,passwordInput);//creating account for example
        existingUser.setLoggedIn(false);//logging out the newly created account
        Authentication.signIn(usernameInput,passwordInput);
        boolean isLoggedIn = existingUser.isLoggedIn();
        Assertions.assertFalse(isLoggedIn);
    }
    @Test
    public void userShouldNotBeSignedInWhenInputtingWrongPassword(){
        String usernameInput = "Leonardo";
        String passwordInput = "daVinciBro";
        String emailInput = "brovinci@gmail.com";
        String existingPassword = "Picasso";
        User existingUser = new User();
        existingUser.setUsername(usernameInput);
        existingUser.setEmail(emailInput);
        existingUser.setConsent(true);
        Authentication.signUp(existingUser,existingPassword); //creating account for example
        existingUser.setLoggedIn(false);//logging out the newly created account
        Authentication.signIn(usernameInput,passwordInput);
        boolean isLoggedIn = existingUser.isLoggedIn();
        Assertions.assertFalse(isLoggedIn);
    }
}