package edu.conf.service.impl;

import edu.conf.service.AdminInformationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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