package com.example.mobile_device.model;

import java.util.Date;

public class Device {

    private long id;
    private String name;
    private String status;
    private String model;
    private Date enrolled;

    public Device() {
    }

    public Device(String name, String status, String model, Date enrolled) {
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
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(Date enrolled) {
        this.enrolled = enrolled;
    }
}
