package edu.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("edu.conf.mapper")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class ConferenceBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceBackApplication.class, args);
    }

}
