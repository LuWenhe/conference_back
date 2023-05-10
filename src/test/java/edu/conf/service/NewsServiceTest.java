package edu.conf.service;

import edu.conf.dto.NewsQueryDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.InputStreamSource;
import org.springframework.web.multipart.MultipartFile;

@SpringBootTest
class NewsServiceTest {

    @Autowired
    private NewsService newsService;

    @Test
    void getNewsById() {
        NewsQueryDTO news = newsService.getNewsById(262);
        System.out.println(news);
    }

    @Test
    void getNewListByNewsCategoryId() {
        NewsQueryDTO newByNewCategoryId = newsService.getNewByNewCategoryId(38);
        System.out.println(newByNewCategoryId);
    }

    @Test
    void test() {

    }

}