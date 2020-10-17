package com.example.demo.contoller;

import com.example.demo.helper.Response;
import com.example.demo.helper.UserUpdateWrapper;
import com.example.demo.helper.UserWrapper;
import com.example.demo.helper.PasswordWrapper;
import com.example.demo.model.User;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.GroupRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin(origins = "*")
public class UserController {
    //    List<User> getAll();
    //    User createUser(User user);
    //    User updateUser(User user);
    //    User getUserById(Long id);
    //    void deleteUserById(Long id);

    @Autowired
    UserService userService;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    GroupRepository groupRepository;

    @Secured("ROLE_USER")
    @GetMapping(path = "/getAll")
    public Response getAll(){
        return new Response(true, "All registered users", userService.getAll());
    }
    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/create")
    public Response createUser(@RequestBody UserWrapper userWrapper){
        User user = new User.Builder(userWrapper.getUsername())
                .withName(userWrapper.getFullname())
                .withGender(userWrapper.getGender())
                .withPassword(userWrapper.getPassword())
                .withPhoneNumber(userWrapper.getPhonenumber())
                .withEmail(userWrapper.getEmail())
                .isActive(userWrapper.getIsActive())
                .withLevel(userWrapper.getLevel())
                .build();
        if(userWrapper.getCourseId()!=null){
            user.setCourse(courseRepository.findById(userWrapper.getCourseId()).get());
        }
        if(userWrapper.getGroupId()!=null){
            user.setGroup(groupRepository.findById(userWrapper.getGroupId()).get());
        }
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
    @Secured("ROLE_USER")
    @GetMapping(path = "/getByCourseId/{id}")
    public Response getByCourseId(@PathVariable Long id){
        return new Response(true, "All users of the course with id = " + id, userService.getUsersByCourse(courseRepository.findById(id).get()));
    }
    @Secured("ROLE_ADMIN")
    @DeleteMapping(path = "/delete/{id}")
    public Response deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return new Response(true, "User with id = " + id + " was deleted!", null );
    }
    @Secured("ROLE_USER")
    @PostMapping(path = "/changePassword/{id}")
    public Response changePassword(@RequestBody PasswordWrapper passwordWrapper, @PathVariable Long id){

        return new Response(true,"Password changed successfully", userService.changePassword(userService.getUserById(id), passwordWrapper.getPassword()));
    }


}
