package com.gans.alerts.processalert.repository;

import com.gans.alerts.processalert.domain.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface to perform basic CRUD operartions.
 * Created by gmohan on 17/02/19.
 */
@Repository
public interface EventRepository extends CrudRepository<Event, String> {

}
