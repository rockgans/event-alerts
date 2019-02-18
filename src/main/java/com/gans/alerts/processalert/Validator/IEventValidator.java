package com.gans.alerts.processalert.validator;

import com.gans.alerts.processalert.domain.Event;
import org.springframework.scheduling.annotation.Async;

/**
 * Validates the event instances for various criteria.
 * Created by gmohan on 18/02/19.
 */
public interface IEventValidator {

    /**
     * Validates if the event is recurring again and is previously cached.
     * @param event
     * @return true or false
     */
    boolean isRecurringEvent(Event event);

    /**
     * Stores the event in the Map based cache for processing later.
     * @param event
     * @return the saved event.
     */
    Event keepInMemory(Event event);

    /**
     * Asynchronous method which when triggered will processs in separate async thread. It saves the event into the database with the duration and a flag to alert.
     * @param event
     */
    @Async
    void saveEvent(Event event);
}
