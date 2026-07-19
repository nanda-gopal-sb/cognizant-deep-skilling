package com.cognizant.springlearn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START");
        LOGGER.trace("Starting Spring Boot application");
        SpringApplication.run(SpringLearnApplication.class, args);
        SpringLearnApplication application = new SpringLearnApplication();
        application.displayDate();
        application.displayCountry();
        application.displayPrototypeCountry();
        application.displayCountries();
        LOGGER.info("END");
    }

    public void displayDate() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        try {
            SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
            Date date = format.parse("31/12/2018");
            LOGGER.debug("{}", date);
        } catch (Exception exception) {
            LOGGER.error("Unable to parse date", exception);
        } finally {
            if (context instanceof ClassPathXmlApplicationContext xmlContext) {
                xmlContext.close();
            }
        }
        LOGGER.info("END");
    }

    public void displayCountry() {
        LOGGER.info("START");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            Country country = context.getBean("country", Country.class);
            Country anotherCountry = context.getBean("country", Country.class);
            LOGGER.debug("Country : {}", country);
            LOGGER.debug("Same instance : {}", country == anotherCountry);
        }
        LOGGER.info("END");
    }

    public void displayPrototypeCountry() {
        LOGGER.info("START");
        LOGGER.warn("Prototype scope creates a new bean for each lookup");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country-prototype.xml")) {
            Country country = context.getBean("country", Country.class);
            Country anotherCountry = context.getBean("country", Country.class);
            LOGGER.debug("Country : {}", country);
            LOGGER.debug("Same instance : {}", country == anotherCountry);
        }
        LOGGER.info("END");
    }

    public void displayCountries() {
        LOGGER.info("START");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);
            LOGGER.debug("Countries : {}", countries);
        }
        LOGGER.info("END");
    }
}