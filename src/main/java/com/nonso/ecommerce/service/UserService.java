package com.nonso.ecommerce.service;

import com.nonso.ecommerce.dto.product.ProductDto;
import com.nonso.ecommerce.dto.users.SignUpResponseDto;
import com.nonso.ecommerce.dto.users.SignupDto;
import com.nonso.ecommerce.model.Product;
import com.nonso.ecommerce.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAllCustomer();

    public User saveProduct(SignupDto signupDto);

    User addCustomer(SignupDto signupDto);


    User addAdmin(SignupDto signupDto);

    User findByEmail(String email);

    String userLogin(String email,String password);

    Product productDtoToEntity(ProductDto productDto);
}
