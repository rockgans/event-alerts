package com.gans.alerts.processalert.service;

import java.io.IOException;

/**
 * Created by gmohan on 18/02/19.
 */
public interface IEventsService {

    /**
     * Reads the file from the path and process the content. Identifies long duration process to set up alerts in the Database.
     * @param path
     */
    void loadEventsFromFile(String path);
}

