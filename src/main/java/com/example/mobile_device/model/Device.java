package com.example.mobile_device.model;

import java.sql.Timestamp;

public class Device {

    private long id;
    private String name;
    private deviceStatus status;
    public enum deviceStatus{
        enroll,active,inactive
    }
    private String model;
    private Timestamp enrolled;

    public Device() {
    }

    public Device(String name, deviceStatus status, String model, Timestamp enrolled) {
        this.name = name;
        this.status = status;
        this.model = model;
        this.enrolled = enrolled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status.name();
    }

    public void setStatus(String status) throws IllegalArgumentException {
        if(status.equalsIgnoreCase("enroll"))
            this.status = deviceStatus.enroll;
        else if (status.equalsIgnoreCase("active")){
            this.status = deviceStatus.active;
        } else if (status.equalsIgnoreCase("inactive")){
            this.status = deviceStatus.inactive;
        } else {
            throw new IllegalArgumentException("Invalid Status");
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Timestamp getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(Timestamp enrolled) {
        this.enrolled = enrolled;
    }
}
