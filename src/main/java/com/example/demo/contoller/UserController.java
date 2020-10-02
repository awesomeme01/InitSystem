package com.example.demo.contoller;

import com.example.demo.helper.LoginCheck;
import com.example.demo.helper.Response;
import com.example.demo.helper.UserUpdateWrapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin(origins = "*, 192.168.0.138:3000")
public class UserController {
    //    List<User> getAll();
    //    User createUser(User user);
    //    User updateUser(User user);
    //    User getUserById(Long id);
    //    void deleteUserById(Long id);

    @Autowired
    UserService userService;

    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/getAll")
    public Response getAll(){
        return new Response(true, "All registered users", userService.getAll());
    }
    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/create")
    public Response createUser(@RequestBody User user){
        return new Response(true, "New user created!", userService.createUser(user));
    }
    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/update/{id}")
    public Response updateUser(@RequestBody UserUpdateWrapper userUpdateWrapper, @PathVariable Long id){
        return new Response(true, "Updated user with id = " + id, userService.updateUser(userUpdateWrapper, id));
    }
//    @Secured("ROLE_ADMIN")
//    @PostMapping(path = "/login")
//    public Response updateUser(@RequestBody LoginCheck loginCheck){
//        return new Response(true, "Login successful",userService.updateUser());
//    }
    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/get/{id}")
    public Response getUserById(@PathVariable Long id){
        return new Response(true, "Information about User with id = " + id, userService.getUserById(id));
    }
    @Secured("ROLE_ADMIN")
    @DeleteMapping(path = "/delete/{id}")
    public Response deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return new Response(true, "User with id = " + id + " was deleted!", null );
    }


}
