//package com.example.demo.contoller;
//
//import com.example.demo.helper.Response;
//import com.example.demo.model.User;
//import com.example.demo.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//
//@RestController
//@RequestMapping("/login")
//@CrossOrigin(origins = "*")
//public class LoginController {
//    @Autowired
//    UserRepository userRepository;
//    @Secured("ROLE_USER")
//    @RequestMapping(value = "/myUser", method = RequestMethod.GET)
//    @ResponseBody
//    public Response currentUserName(Principal principal) {
//        User user = userRepository.findByUsername(principal.getName());
////        if(user != null){
//        System.out.println("Request is successfully returned");
//        return new Response( true,"Current user information", user);
//
////        }
////        else{
////            return new Response( false,"Current user information", null );
////        }
//    }
//    @Secured("ROLE_USER")
//    @RequestMapping(value = "/dashBoard", method = RequestMethod.GET)
//    public Response currentDashBoard(Principal principal){
//        User user = userRepository.findByUsername(principal.getName());
//
//    }
//}
