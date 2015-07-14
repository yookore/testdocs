package com.yookos.countryservice;

import com.yookos.countryservice.DAO.CountryRepository;
import com.yookos.countryservice.DAO.Impl.CountryRepositoryImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
@PropertySource(value={"classpath:application.properties"})
public class Application {

    @Bean
    @Profile(value = {"!test"})
    public CountryRepository conRepository(@Value("${country.service.dev.dbDriver}")String dbDriver,
                                           @Value("${country.service.dev.dbUrl}")String dbUrl,
                                           @Value("${country.service.dev.dbUsername}") String dbUsername,
                                           @Value("${country.service.dev.dbPassword}") String dbPassword)
    {
        CountryRepository conRepository = new CountryRepositoryImpl();
        conRepository.setDbDriver(dbDriver);
        conRepository.setDbUrl(dbUrl);
        conRepository.setDbUsername(dbUsername);
        conRepository.setDbPassword(dbPassword);
        return conRepository;
    }

    @Bean
    @Profile("test")
    public CountryRepository conRepositoryTests(@Value("${country.service.test.dbDriver}")String dbDriver,
                                           @Value("${country.service.test.dbUrl}")String dbUrl,
                                           @Value("${country.service.test.dbUsername}") String dbUsername,
                                           @Value("${country.service.test.dbPassword}") String dbPassword)
    {
        CountryRepository conRepository = new CountryRepositoryImpl();
        conRepository.setDbDriver(dbDriver);
        conRepository.setDbUrl(dbUrl);
        conRepository.setDbUsername(dbUsername);
        conRepository.setDbPassword(dbPassword);
        return conRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
