package com.gans.alerts.processalert;


import com.gans.alerts.processalert.service.IEventsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class ProcessAlertApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ProcessAlertApplication.class, args);
        IEventsService eventsReaderService = (IEventsService) applicationContext.getBean("eventsService");
        eventsReaderService.loadEventsFromFile(args[0]);

    }

}
