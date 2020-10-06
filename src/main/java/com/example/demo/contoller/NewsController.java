package com.example.demo.contoller;

import com.example.demo.helper.Response;
import com.example.demo.model.News;
import com.example.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    NewsService newsService;
    @Secured("ROLE_USER")
    @GetMapping(path = "/getAll")
    public Response getAll(){
        return new Response(true, "all news objects", newsService.getAll());

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
