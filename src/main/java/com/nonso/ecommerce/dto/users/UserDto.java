package com.nonso.ecommerce.dto.users;

import com.nonso.ecommerce.model.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class UserDto implements Serializable {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;

}
