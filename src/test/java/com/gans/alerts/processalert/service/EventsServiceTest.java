package com.gans.alerts.processalert.service;

import com.gans.alerts.processalert.Validator.EventValidator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by gmohan on 18/02/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EventsService.class)
public class EventsServiceTest {

    @TestConfiguration
    static class EventsReaderServiceTestConfig {

        @Bean
        public IEventsService getEventsReaderService() {
            return new EventsService();
        }
    }

    @Before
    public void setup(){
        String path = "../src/test/resources/log.txt";
    }

    @Autowired
    private IEventsService eventsReaderService;
    @MockBean
    private EventValidator eventValidator;

    @Test
    public void shouldReturn() {



    }
}
