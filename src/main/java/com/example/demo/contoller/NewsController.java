package com.example.demo.contoller;

import com.example.demo.helper.Response;
import com.example.demo.model.News;
import com.example.demo.model.UserRole;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.NewsService;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/news")
@CrossOrigin("*")
public class NewsController {
    @Autowired
    NewsService newsService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    UserRepository userRepository;
    @Secured("ROLE_USER")
    @GetMapping(path = "/getAll")
    public Response getAll(Principal principal){
        List<UserRole> userRoles = userRoleService.getRolesByUserId(userRepository.findByUsername(principal.getName()).getId());
        boolean isAdmin = false;
        for(UserRole u: userRoles){
            if(u.getRole().equals("ROLE_ADMIN")){
                isAdmin = true;
            }
        }
        if(isAdmin == true){
            return new Response(true, "all news objects", newsService.getAll(0));
        }
        else{
            return new Response(true, "All news object for students",newsService.getAll(1));
        }
    }
    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/create")
    public Response create(@RequestBody News news){
        return new Response(true, "Created new news", newsService.create(news));
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(path = "/delete/{id}")
    public Response delete(@PathVariable Long id){
        newsService.delete(id);
        return new Response(true, "Deleted news with id = " + id, null);
    }

}
