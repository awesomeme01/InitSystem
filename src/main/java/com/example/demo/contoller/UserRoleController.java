package com.example.demo.contoller;

import com.example.demo.helper.Response;
import com.example.demo.model.UserRole;
import com.example.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@Secured("ROLE_ADMIN")
@RequestMapping(path = "/api/userRoles")
public class UserRoleController {
    //    List<UserRole> getAll();
    //    List<UserRole> getRolesByUser(User user);
    //    UserRole createUserRole(UserRole userRole);
    //    void deleteUserRole(Long id);
    @Autowired
    UserRoleService userRoleService;

    @GetMapping("/getAll")
    public Response getAll(){
        return new Response(true, "All registered user-roles", userRoleService.getAll());
    }
    @GetMapping("/getByUser/{id}")
    public Response getByUserId(@PathVariable Long id){
        return new Response(true, "All roles for user with id = " + id, userRoleService.getRolesByUserId(id));
    }
    @PostMapping("/create")
    public Response create(@RequestBody UserRole userRole){
        return new Response(true, "Created new user-role", userRoleService.createUserRole(userRole));
    }
    @DeleteMapping("/delete/{id}")
    public Response delete(@PathVariable Long id){
        userRoleService.deleteUserRole(id);
        return new Response(true, "User-role with id = " + id + " was deleted", null );
    }
}
