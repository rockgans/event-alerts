package com.gans.alerts.processalert.validator;

import com.gans.alerts.processalert.domain.Event;
import org.springframework.scheduling.annotation.Async;

/**
 * Created by gmohan on 18/02/19.
 */
public interface IEventValidator {


    boolean isRecurringEvent(Event event);

    Event keepInMemory(Event event);

    @Async
    void saveEvent(Event event);
}
