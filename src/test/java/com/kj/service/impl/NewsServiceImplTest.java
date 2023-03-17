package com.kj.service.impl;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class NewsServiceImplTest {

    @Test
    void isExistsPicture() {
        String FILE_DIRECTOR = "D:/Projects/ActualProjects/conference/image";
        String FILE_NAME = "022b8817-9430-4114-86ac-becae7ed0983.png";
        File file = new File(FILE_DIRECTOR, FILE_NAME);
        boolean exists = file.exists();
        System.out.println(exists);
        String absolutePath = file.getAbsolutePath();
        String name = file.getName();
        System.out.println(name);
    }

}