package com.nonso.ecommerce.dto.users;

import com.nonso.ecommerce.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor @NoArgsConstructor
@Component
public class SignupDto {


    @NotBlank(message = "fullName is required")
    private String firstName;

    @NotBlank(message = "fullName is required")
    private String lastName;


    @NotBlank(message = "username is required")
    private String username;

    @Column(unique = true)
    private String email;

    @NotBlank(message = "password is required")
    private String password;
}
