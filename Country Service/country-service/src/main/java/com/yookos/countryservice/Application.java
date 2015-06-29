package com.yookos.countryservice;

import com.yookos.countryservice.DAO.CountryRepository;
import com.yookos.countryservice.DAO.Impl.CountryRepositoryImpl;
import com.yookos.countryservice.controllers.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class Application {



//    public CountryRepository getInstance()
//    {
//        return new CountryRepositoryImpl();
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
