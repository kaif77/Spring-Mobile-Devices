package com.example.mobile_device.service;

import com.example.mobile_device.model.Device;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DeviceService {

    List<Device> findAll();

    Optional<Device> findById(long Id);

    List<Device> findByName(String name);

    List<Device> findByModel(String model);

    List<Device> findByStatus(String status);

    ResponseEntity<?> saveDevice(Device device);

    ResponseEntity<?> updateDevice(long id, Device device);

    ResponseEntity<?> deleteDevice(long id);
}
