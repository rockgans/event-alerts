package com.gans.alerts.processalert.Validator;

import com.gans.alerts.processalert.domain.Event;
import com.gans.alerts.processalert.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by gmohan on 17/02/19.
 */
@Component
public class EventValidator implements IEventValidator{

    private final static Map<String, Event> EVENTS_CACHE = new ConcurrentHashMap<String, Event>();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EventRepository eventRepository;


    @Override
    public boolean isRecurringEvent(Event event) {
        return EVENTS_CACHE.containsKey(event.getId());
    }

    @Override
    public Event KeepInMemory(Event event) {
        return EVENTS_CACHE.put(event.getId(), event);
    }


    @Override
    @Async
    public void saveEvent(Event event) {

        logger.info("saving event with id={}", event.getId());
        if(logger.isDebugEnabled())
            logger.debug("saving event {}",event.toString());

        Event previousEvent = EVENTS_CACHE.get(event.getId());
        EVENTS_CACHE.remove(event.getId());
        long duration = Math.abs(previousEvent.getTimestamp() - event.getTimestamp());
        event.setDuration(duration);
        event.setAlertEnabled((duration > 4) ? true : false);

         eventRepository.save(event);
    }


}
