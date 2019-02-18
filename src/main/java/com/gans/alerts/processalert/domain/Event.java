package com.gans.alerts.processalert.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by gmohan on 17/02/19.
 */
@Entity
@Table(name = "Event")
public class Event {

    @Id
    private String id;

    private String state;

    @Column(name = "TYPE", nullable = true)
    private String type;

    @Column(name = "HOST", nullable = true)
    private String host;

    private long timestamp;

    @Column(name = "DURATION", nullable = false)
    private long duration;

    @Column(name = "ALERT", nullable = false)
    private boolean alertEnabled;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public boolean isAlertEnabled() {
        return alertEnabled;
    }

    public void setAlertEnabled(boolean alertEnabled) {
        this.alertEnabled = alertEnabled;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Event)) {
            return false;
        }

        Event event = (Event) o;

        return event.id.equals(this.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {

        return new StringBuilder().append("id:").append(id).append(",").append("type:").append(type).append(",").append("host:")
                .append(host).append(",").append("duration:").append(duration).append(",").append("alert:").append(alertEnabled).toString();
    }

}
