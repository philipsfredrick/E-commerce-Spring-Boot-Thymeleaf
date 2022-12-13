package com.nonso.ecommerce.controller;

import com.nonso.ecommerce.common.GlobalData;
import com.nonso.ecommerce.dto.users.SignUpResponseDto;
import com.nonso.ecommerce.dto.users.SignupDto;
import com.nonso.ecommerce.model.Product;
import com.nonso.ecommerce.model.User;
import com.nonso.ecommerce.model.UserRole;
import com.nonso.ecommerce.repository.UserRepository;
import com.nonso.ecommerce.service.ProductService;
import com.nonso.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    private UserRepository userRepository;
//
//    @GetMapping("/login")
//    public String login() {
//        return "login";
 //   }
    @GetMapping("")
    public String viewHomePage(Model model) {
       List<Product> viewProducts = productService.getAllProducts();
        model.addAttribute("viewProducts", viewProducts);
        return "index";
    }
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/post_register")
    public String postRegister(@ModelAttribute("signupDto") SignupDto signupDto, HttpServletRequest request) throws ServletException {
      userService.addCustomer(signupDto);
        return "sign-up";
    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        GlobalData.cart.clear();
        return "login";
    }


    @PostMapping("/login2")
    public String Login(@ModelAttribute User user, HttpServletRequest request) {
        String message = userService.userLogin(user.getEmail(), user.getPassword());
        ///System.out.println("=======message is " + message );
        if(message.equals("user")){
            System.out.println("Customer logged in");
            request.setAttribute("email" , user.getEmail());
            return "redirect:/shop";
        } else if (message.equals("admin")) {
            System.out.println("Admin logged in");
            request.setAttribute("email" , user.getEmail());
            return "redirect:/admin";
        }
        return "redirect:/login";
    }

    @GetMapping("/viewProduct")
    public String display(Model model){
        model.addAttribute("viewProduct" , productService.getAllProducts());
        //System.out.println("display");
        return "viewProduct";
    }
//
//    @GetMapping("/users")
//    public String listUsers (Model model){
//        List<User> listUsers = userService.getAllCustomer();
//        model.addAttribute("listUsers", listUsers);
//        return "users";
//    }
}
