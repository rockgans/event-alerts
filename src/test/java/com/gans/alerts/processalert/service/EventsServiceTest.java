package com.gans.alerts.processalert.service;

import com.gans.alerts.processalert.domain.Event;
import com.gans.alerts.processalert.validator.EventValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by gmohan on 18/02/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EventsService.class)
public class EventsServiceTest {

    private String path = null;

    @TestConfiguration
    static class EventsReaderServiceTestConfig {

        @Bean
        public IEventsService getEventsReaderService() {
            return new EventsService();
        }
    }

    @Before
    public void setup(){
         path = "../src/test/resources/log.txt";
    }

    @Autowired
    private IEventsService eventsReaderService;
    @MockBean
    private EventValidator eventValidator;

    @Test
    public void shouldReturnIfFilePathIsEmpty() {

    eventsReaderService.loadEventsFromFile("");

    }



    @Test
    public void shouldThrowNoFileExceptionAndExit(){
        File file = new File("test/resources/log.txt");
        String absolutePath = file.getAbsolutePath();

        eventsReaderService.loadEventsFromFile(absolutePath);
    }

    @Test
    public void shouldThrowIOExceptionAndExit(){
        File file = new File("src/test/resources/corrupted_log.txt");
        String absolutePath = file.getAbsolutePath();

        eventsReaderService.loadEventsFromFile(absolutePath);
    }

    @Test
    public void shouldThrowInvalidEventException(){
        File file = new File("src/test/resources/invalid_log.txt");
        String absolutePath = file.getAbsolutePath();

        eventsReaderService.loadEventsFromFile(absolutePath);
    }

    @Test
    public void shouldLoadFileInPathAndCache(){
        File file = new File("src/test/resources/log.txt");
        String absolutePath = file.getAbsolutePath();

        when(eventValidator.isRecurringEvent(any(Event.class))).thenReturn(false);

        eventsReaderService.loadEventsFromFile(absolutePath);
    }

    @Test
    public void shouldLoadFileInPathAndSave(){
        File file = new File("src/test/resources/log.txt");
        String absolutePath = file.getAbsolutePath();

        when(eventValidator.isRecurringEvent(any(Event.class))).thenReturn(true);

        eventsReaderService.loadEventsFromFile(absolutePath);
    }
}
