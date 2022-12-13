package com.nonso.ecommerce.model;

import lombok.*;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "fullName is required")
    private String firstName;

    @NotBlank(message = "fullName is required")
    private String lastName;

//   // @NotBlank(message = "username is required")
//    private String username;

    @Column(unique = true)
    private String email;

    @NotBlank(message = "password is required")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;
    // getters and setters

}
