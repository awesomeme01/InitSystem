package com.example.demo.contoller;

import com.example.demo.helper.Dashboard;
import com.example.demo.helper.Response;
import com.example.demo.model.User;
import com.example.demo.repository.NewsRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CourseService;
import com.example.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    CourseService courseService;
    @Autowired
    NewsRepository newsRepository;

    @Secured("ROLE_USER")
    @RequestMapping(value = "/myUser", method = RequestMethod.GET)
    @ResponseBody
    public Response currentUserName(Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
//        if(user != null){
        System.out.println("Request is successfully returned");
        return new Response(true,"Current user information", user, userRoleService.getRolesByUserId(user.getId()));

//        }
//        else{
//            return new Response( false,"Current user information", null );
//        }
    }

    @RequestMapping(value = "/dashBoard", method = RequestMethod.GET)
    public Response currentDashBoard(Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        String role = userRoleService.getRolesByUserId(user.getId()).stream().findFirst().get().getRole();
        Dashboard dashboard = new Dashboard(user.getCourse(), newsRepository.findAll().stream().filter(x->x.getForRole().equals(role)).filter(x->x.getIsActive()==1).collect(Collectors.toList()));
        return new Response(true, "Dashboard info", dashboard);
    }
}
