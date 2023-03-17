package com.kj.service;

import com.kj.dto.NewsQueryDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NewsServiceTest {

    @Autowired
    private NewsService newsService;

    @Test
    void getNewsById() {
        NewsQueryDTO news = newsService.getNewsById(262);
        System.out.println(news);
    }

}