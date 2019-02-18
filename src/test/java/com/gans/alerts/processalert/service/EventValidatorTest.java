package com.gans.alerts.processalert.service;

import com.gans.alerts.processalert.Validator.EventValidator;
import com.gans.alerts.processalert.domain.Event;
import com.gans.alerts.processalert.repository.EventRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;

/**
 * Created by gmohan on 18/02/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EventValidator.class)
public class EventValidatorTest {

    @TestConfiguration
    static class EventValidatorTestConfig {

        @Bean
        public EventValidator getEventValidator() {
            return new EventValidator();
        }
    }

    @Autowired
    private EventValidator eventValidator;
    @MockBean
    private EventRepository repository;

    Event eventStart = null;
    Event eventFinish = null;

    @Before
    public void init(){

        eventStart = new Event();
        eventStart.setId("a1");
        eventStart.setState("STARTED");
        eventStart.setHost("host1");
        eventStart.setType("Type1");
        eventStart.setTimestamp(23);

        eventFinish = new Event();
        eventFinish.setId("a1");
        eventFinish.setState("FINISH");
        eventFinish.setHost("host1");
        eventFinish.setType("Type1");
        eventFinish.setTimestamp(28);
    }

    @Test
    public void shouldReturnTrueIfRecurringEvent() {

        eventValidator.







    }
}
