package org.library.security;

import org.junit.Assert;
import org.junit.Test;
import org.library.user.User;

public class EncodingHelperTest {

    @Test
    public void shouldAddAEncodedPasswordToTheCorrectUser() {
        int initialNumberOfPasswords = EncodedCredentials.getInstance().getPasswordMatch().size();
        User user = new User();
        user.setUsername("HaroldRafaello");
        String inputPassword = "imCool";
        String encodedPassword = Encoder.encodePassword(inputPassword);
        EncodingHelper.addEncodedPassword(encodedPassword, user);
        int numberOfPasswordsAfterAdding =  EncodedCredentials.getInstance().getPasswordMatch().size();
        Assert.assertNotEquals(initialNumberOfPasswords,numberOfPasswordsAfterAdding);
    }
    @Test
    public void shouldReturnCorrespondingEncodedPassword(){
        User user = new User();
        String password = "johnnyBravo123";
        String expectedEncodedPassword = Encoder.encodePassword(password);
        EncodingHelper.addEncodedPassword(expectedEncodedPassword,user);
        String returnedPassword =  EncodingHelper.getEncryptedPassword(user);
        Assert.assertEquals(expectedEncodedPassword,returnedPassword);
    }
    @Test
    public void shouldNotReturnEncodedPassword(){
        User user = new User();
        String password = "johnnyBravo123";
        String expectedEncodedPassword = Encoder.encodePassword(password);
        String returnedPassword =  EncodingHelper.getEncryptedPassword(user);
        Assert.assertNotEquals(expectedEncodedPassword,returnedPassword);
    }
}