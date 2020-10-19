package com.example.demo.contoller;

import com.example.demo.helper.ProjectUser;
import com.example.demo.helper.Response;
import com.example.demo.model.Project;
import com.example.demo.model.User;
import com.example.demo.service.ProjectService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin("*")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Secured("ROLE_USER")
    @GetMapping("/getAll")
    public Response getAll(){
        ArrayList<ProjectUser> projectUsers = new ArrayList<>();
        List<Project> projects = projectService.getAll();
        for(Project p : projects){
            projectUsers.add(new ProjectUser(userService.getByProject(p), p));
        }

        return new Response(true, "All Projects", projectUsers);

    }
    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    public Response create(@RequestBody Project project){

        return new Response(true, "Created new project", projectService.create(project));
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/setCompleted/{id}/{status}")
    public Response setCompleted(@PathVariable Long id, @PathVariable int status){
        return new Response(true, "Set completed status to " + status, projectService.setCompleted(id, status));
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/updateProject/{id}")
    public Response update(@RequestBody Project project, @PathVariable Long id){
        return new Response(true, "Updated project with id " + id, projectService.updateProject(id, project));
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/delete/{id}")
    public Response delete(@PathVariable Long id){
        projectService.deleteProject(id);
        return new Response(true, "Deleted project with id = " + id, null );
    }
}
