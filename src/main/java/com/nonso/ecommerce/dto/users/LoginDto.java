package com.nonso.ecommerce.dto.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
@Component
public class LoginDto implements Serializable {
    private String email;
    private String password;
}
