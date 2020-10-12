package com.example.demo.service;

import com.example.demo.model.News;
import com.example.demo.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    NewsRepository newsRepository;

    @Override
    public List<News> getAll(int isForStudent) {
//        ArrayList<News> news = new ArrayList<>();

        if(isForStudent == 1){
            return newsRepository.findAll().stream().filter(x->x.getForRole().equals("ROLE_USER")).collect(Collectors.toList());
        }
        else{
            return newsRepository.findAll();
        }

    }

    @Override
    public News create(News news) {
        return newsRepository.save(news);
    }

    @Override
    public void delete(Long id) {
         newsRepository.deleteById(id);
    }

    @Override
    public News updater(News news) {
        return newsRepository.save(news);
    }
}
