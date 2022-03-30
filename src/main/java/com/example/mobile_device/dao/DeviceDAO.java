package com.example.mobile_device.dao;

import com.example.mobile_device.model.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceDAO {

    List<Device> findAll();

    Optional<Device> findById(long deviceId);

    List<Device> findByName(String name);

    List<Device> findByModel(String model);

    List<Device> findByStatus(String status);


    int save(Device device);

    int updateDevice(long id, Device device);

    int deleteDevice(long id);
}
