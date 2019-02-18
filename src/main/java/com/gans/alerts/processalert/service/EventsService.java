package com.gans.alerts.processalert.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gans.alerts.processalert.Validator.EventValidator;
import com.gans.alerts.processalert.Validator.IEventValidator;
import com.gans.alerts.processalert.domain.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by gmohan on 18/02/19.
 */
@Service
public class EventsService implements IEventsService {

    public static final String CHARSET_NAME = "UTF-8";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IEventValidator eventValidator;

    @Override
    public void loadEventsFromFile(String filePath) {


        if (StringUtils.isEmpty(filePath)) {
            logger.error("Invalid file name");
            return;
        }
        logger.info("file loaded from path:{}",filePath);
        Path path = Paths.get(filePath);
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName(CHARSET_NAME))) {


            String currentLine = null;
            while ((currentLine = reader.readLine()) != null) {

                ObjectMapper mapper = new ObjectMapper();
                Event event = mapper.readValue(currentLine, Event.class);
                if (eventValidator.isRecurringEvent(event)) {
                    eventValidator.saveEvent(event);
                } else {
                    eventValidator.KeepInMemory(event);
                }

            }
        } catch (IOException ex) {
            logger.error("error while reading file {}", ex.getMessage());
            //logger.debug(ex.getStackTrace().toString());

        }

    }
}
