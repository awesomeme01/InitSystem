package com.example.demo.service;

import com.example.demo.model.News;

import java.util.List;

public interface NewsService {
    List<News> getAll(int isForStudent);

    News create(News news);

    void delete(Long id);

    News updater(News news);
}
