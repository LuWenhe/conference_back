package com.kj.service.impl;

import com.kj.service.AdminInformationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminInformationServiceImplTest {

    @Autowired
    private AdminInformationService adminInformationService;

    @Test
    void checkPassword() {
        boolean b = adminInformationService.checkPassword("admin", "nuist@305");
        System.out.println(b);
    }

}