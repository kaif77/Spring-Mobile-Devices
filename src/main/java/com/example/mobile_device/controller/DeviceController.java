package com.example.mobile_device.controller;

import com.example.mobile_device.model.Device;
import com.example.mobile_device.service.DeviceService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DeviceController {

    final private DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping(value = "/devices",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Device> findAll() {
        return this.deviceService.findAll();
    }

    @GetMapping(value = "/devices/{deviceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Device> findById(@PathVariable long deviceId) {
        return this.deviceService.findById(deviceId);
    }

    @GetMapping(value = "devices/name/{deviceName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Device> findByName(@PathVariable String deviceName) {
        return this.deviceService.findByName(deviceName);
    }

    @GetMapping(value = "/devices/model/{deviceModel}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Device> findByModel(@PathVariable String deviceModel) {
        return this.deviceService.findByModel(deviceModel);
    }

    @GetMapping(value = "/devices/status/{deviceStatus}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Device> findByStaus(@PathVariable String deviceStatus) {
        return this.deviceService.findByStatus(deviceStatus);
    }

    @PostMapping(value = "/devices",consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> saveDevice(@RequestBody Device device) {
        return this.deviceService.saveDevice(device);
    }

    @PutMapping(value = "/devices/{deviceId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateDevice(@PathVariable long deviceId, @RequestBody Device device) {
        return this.deviceService.updateDevice(deviceId, device);
    }

    @DeleteMapping("/devices/{deviceId}")
    public ResponseEntity<?> deleteDevice(@PathVariable long deviceId) {
        return this.deviceService.deleteDevice(deviceId);
    }
}
