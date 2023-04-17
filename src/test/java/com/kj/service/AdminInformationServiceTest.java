package com.kj.service;

import com.kj.dto.AdminInformationDTO;
import com.kj.enums.AdminRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminInformationServiceTest {

    @Resource
    private AdminInformationService adminInformationService;

    @Test
    void getAdminInformationByUsername() {
        AdminInformationDTO adminInformationDTO = adminInformationService.getAdminInformationByUsername("admin");
        AdminRole role = adminInformationDTO.getRole();
        System.out.println(adminInformationDTO);
        System.out.println(role);
    }

}