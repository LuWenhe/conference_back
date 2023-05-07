package edu.conf.service;

import edu.conf.dto.AdminInformationDTO;
import edu.conf.enums.AdminRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

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