package com.nonso.ecommerce.service.impl;

import com.nonso.ecommerce.dto.product.ProductDto;
import com.nonso.ecommerce.dto.users.SignUpResponseDto;
import com.nonso.ecommerce.dto.users.SignupDto;
import com.nonso.ecommerce.exceptions.CustomException;
import com.nonso.ecommerce.model.Product;
import com.nonso.ecommerce.model.User;
import com.nonso.ecommerce.model.UserRole;
import com.nonso.ecommerce.repository.UserRepository;
import com.nonso.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;


    private SignupDto signupDto;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, SignupDto signupDto) {
        this.userRepository = userRepository;
        this.signupDto = signupDto;
    }

    @Override
    public User addCustomer(SignupDto signupDto) {
        return userRepository.save(customerDto(signupDto));
    }


    @Override
    public User addAdmin(SignupDto signupDto) {
         return userRepository.save(adminDto(signupDto));
    }


    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(()-> new CustomException("This user was not found"));

        return user;
    }



//    @Override
//    public User findByAdminEmail(String email) {
//        User user = userRepository.findByEmail(email);
//       if(user == null){
//           System.out.println("User not found");
//           return null;
//
//       }
//        return user;
//    }


    @Override
    public List<User> getAllCustomer() {
        return userRepository.findAll();
    }


    @Override
    public User saveProduct(SignupDto signupDto) {
        return null;
    }

    public User customerDto(SignupDto signupDto){
        User customer = new User();

        customer.setFirstName(signupDto.getFirstName());
        customer.setLastName(signupDto.getLastName());
        customer.setEmail(signupDto.getEmail());

        customer.setPassword(signupDto.getPassword());
        customer.setRole(UserRole.USER);

        return customer;
    }

    public User adminDto(SignupDto signupDto){
        User admin = new User();

        admin.setFirstName(signupDto.getFirstName());
        admin.setLastName(signupDto.getLastName());
        admin.setEmail(signupDto.getEmail());

        admin.setPassword(signupDto.getPassword());
        admin.setRole(UserRole.ADMIN);
        return admin;
    }
    public Product productDtoSave(ProductDto productDto){
        Product product1 = new Product();
        product1.setName(productDto.getName());
        product1.setPrice(productDto.getPrice());
       // product1.setProd(productDto.getProductQty());
        product1.setDescription(productDto.getDescription());
       // product1.setCategory(productDto.getCategory());
        return product1;
    }



    @Override
    public String userLogin(String email, String password) {
        // first find User by email
        String message = "";
        User user = findByEmail(email);
        if (user.getPassword().equals(password)){
            if (user.getRole() == UserRole.ADMIN){
                message = "admin";
            } else if (user.getRole() == UserRole.USER) {
                message = "user";
            }
        }else{
            message = "Incorrect Password";
        }

        return message;
    }

    @Override
    public Product productDtoToEntity(ProductDto productDto) {
        return null;
    }

}




//
//    private final UserRepository userRepository;
//
////    private SignupDto signupDto;
//
//
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
////    @Override
////    public User getUserById(Integer id) {
////        return userRepository.findById(id);
////    }
//
//    @Override
//    public User getUserByEmail(String email) {
//        User user = userRepository.findByEmail(email).orElseThrow(()-> new CustomException("Not found"));
//        return user;
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public SignUpResponseDto createCustomer(SignupDto signupDto)  throws CustomException{
//        // Check to see if the current email address has already been registered.
//        if (Objects.nonNull(userRepository.findByEmail(signupDto.getEmail()))) {
//            // If the email address has been registered then throw an exception.
//            throw new CustomException("User already exists");
//        }
//        User customer = new User();
//        customer.setFirstName(signupDto.getFirstName());
//        customer.setLastName(signupDto.getLastName());
//        customer.setEmail(signupDto.getEmail());
//        customer.setPassword(signupDto.getPassword());
//        customer.setRole(UserRole.USER);
//        try {
//            // save the User
//            userRepository.save(customer);
//            // success in creating
//            return new SignUpResponseDto("success", "user created successfully");
//        } catch (Exception e) {
//            // handle signup error
//            throw new CustomException(e.getMessage());
//        }
//    }
//
//    @Override
//    public SignUpResponseDto createAdmin(SignupDto signupDto) {
//        // Check to see if the current email address has already been registered.
//        if (Objects.nonNull(userRepository.findByEmail(signupDto.getEmail()))) {
//            // If the email address has been registered then throw an exception.
//            throw new CustomException("Admin already exists");
//        }
//        User admin = new User();
//        admin.setFirstName(signupDto.getFirstName());
//        admin.setLastName(signupDto.getLastName());
//        admin.setEmail(signupDto.getEmail());
//        admin.setPassword(signupDto.getPassword());
//        admin.setRole(UserRole.ADMIN);
//        try {
//            // save the admin
//            userRepository.save(admin);
//            // success in creating
//            return new SignUpResponseDto("success", "admin created successfully");
//        } catch (Exception e) {
//            throw  new CustomException(e.getMessage());
//        }
//    }
//
////    public User addUser(SignupDto signupDto) {
////        return userRepository.save(createCustomer(signupDto));
//    //  }
//
////    public User addAdmin(SignupDto signupDto) {
////        return userRepository.save(createAdmin(signupDto));
////    }
//
//    public String userLogin(String email, String password) {
//        String message = "";
//        User user = getUserByEmail(email);
//        if (user.getPassword().equals(password)) {
//            if (user.getRole() == UserRole.ADMIN) {
//                message = "admin";
//            } else if (user.getRole() == UserRole.USER) {
//                message = "customer";
//            }
//        } else {
//            message ="Not valid";
//        }
//        return message;
//    }
