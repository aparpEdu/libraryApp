package org.library.security;

import org.junit.Assert;
import org.junit.Test;
import org.library.user.User;

import java.util.HashMap;
import java.util.Map;

public class EncodedCredentialsTest {

    @Test
    public void shouldBeAbleToMakeOnlyOneInstance() {
        EncodedCredentials firstInstance = EncodedCredentials.getInstance();
        EncodedCredentials secondInstance = EncodedCredentials.getInstance();
        User user = new User();
        user.setUsername("HaroldRafaello");
        Map<String,String> mapForTestingPurposes = new HashMap<>();
        mapForTestingPurposes.put(user.getUsername(),"password");
        firstInstance.setPasswordMatch(mapForTestingPurposes);
        Assert.assertEquals(firstInstance,secondInstance);
    }
}