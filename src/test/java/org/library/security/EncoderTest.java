package org.library.security;

import org.junit.Assert;
import org.junit.Test;

public class EncoderTest {

    @Test
    public void shouldReturnAnEncodedPassword() {
        String inputPassword = "Zoro";
        String encodedPassword =  Encoder.encodePassword(inputPassword);
        Assert.assertNotSame(inputPassword, encodedPassword);
    }
    @Test
    public void shouldReturnTrueIfTheEnteredPasswordIsCorrect() {
        String accountPassword = "elephantintheroom";
        String encodedPassword = Encoder.encodePassword(accountPassword);
        String userInput = "elephantintheroom";
        boolean isAMatch = Encoder.verifyPassword(userInput,encodedPassword);
        Assert.assertTrue(isAMatch);
    }
    @Test
    public void shouldReturnFalseIfTheEnteredPasswordIsIncorrect(){
        String accountPassword = "elephantintheroom";
        String encodedPassword = Encoder.encodePassword(accountPassword);
        String userInput = "hogwarts";
        boolean isAMatch = Encoder.verifyPassword(userInput,encodedPassword);
        Assert.assertFalse(isAMatch);
    }
}