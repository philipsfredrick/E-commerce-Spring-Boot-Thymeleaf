package com.nonso.ecommerce.dto.users;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpResponseDto {

    private String status;
    private String message;
}
