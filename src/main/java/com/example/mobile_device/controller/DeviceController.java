package com.example.mobile_device.controller;

import com.example.mobile_device.model.Device;
import com.example.mobile_device.payload.MessageResponse;
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

    @GetMapping(value = "/devices", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Device>> findAll() {
        List<Device> devices = this.deviceService.findAll();
        return ResponseEntity.status(200).body(devices);
    }

    @GetMapping(value = "/devices/{deviceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Device>> findById(@PathVariable long deviceId) {
        Optional<Device> device = this.deviceService.findById(deviceId);
        return ResponseEntity.status(200).body(device);
    }

    @GetMapping(value = "devices/name/{deviceName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Device>> findByName(@PathVariable String deviceName) {
        List<Device> device = this.deviceService.findByName(deviceName);
        return ResponseEntity.status(200).body(device);
    }

    @GetMapping(value = "/devices/model/{deviceModel}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Device>> findByModel(@PathVariable String deviceModel) {
        List<Device> device = this.deviceService.findByModel(deviceModel);
        return ResponseEntity.status(200).body(device);
    }

    @GetMapping(value = "/devices/status/{deviceStatus}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Device>> findByStatus(@PathVariable String deviceStatus) {
        List<Device> device = this.deviceService.findByStatus(deviceStatus);
        return ResponseEntity.status(200).body(device);
    }

    @PostMapping(value = "/devices", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> saveDevice(@RequestBody Device device) {
        if (this.deviceService.saveDevice(device) == 1) {
            return ResponseEntity.status(201).body(new MessageResponse("Device Successfully Added"));
        } else {
            return ResponseEntity.status(404).body(new MessageResponse("Device Not Saved"));
        }
    }

    @PutMapping(value = "/devices/{deviceId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> updateDevice(@PathVariable long deviceId, @RequestBody Device device) {
        if (this.deviceService.updateDevice(deviceId, device) == 1) {
            return ResponseEntity.status(200).body(new MessageResponse("Device updated Successfully"));
        } else {
            return ResponseEntity.status(404).body(new MessageResponse("Unable to update device with Id:" + deviceId));
        }
    }

    @DeleteMapping(value = "/devices/{deviceId}")
    public ResponseEntity<MessageResponse> deleteDevice(@PathVariable long deviceId) {
        if (this.deviceService.deleteDevice(deviceId) == 1) {
            return ResponseEntity.status(200).body(new MessageResponse("Device Deleted Successfully"));
        } else {
            return ResponseEntity.status(404).body(new MessageResponse("Unable to delete device with Id:" + deviceId));
        }
    }
}
