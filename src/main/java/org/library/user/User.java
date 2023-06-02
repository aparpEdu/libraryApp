package org.library.user;

import lombok.Data;
import org.library.country.Country;

@Data
public class User {
    private String username;
    private String fullName;
    private short age;
    private String gender;
    private String email;
    private Country country;
    private String city;
    private String address;
    private boolean consent;
    private boolean isLoggedIn;
}
