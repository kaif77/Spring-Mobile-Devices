package com.example.mobile_device.service.impl;

import com.example.mobile_device.dao.DeviceDAO;
import com.example.mobile_device.model.Device;
import com.example.mobile_device.payload.MessageResponse;
import com.example.mobile_device.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {
    final private DeviceDAO deviceDAO;

    public DeviceServiceImpl(DeviceDAO deviceDAO) {
        this.deviceDAO = deviceDAO;
    }

    @Override
    public List<Device> findAll() {
        return this.deviceDAO.findAll();
    }

    @Override
    public Optional<Device> findById(long Id) {
        return this.deviceDAO.findById(Id);
    }

    @Override
    public List<Device> findByName(String name) {
        return this.deviceDAO.findByName(name);
    }

    @Override
    public List<Device> findByModel(String model) {
        return this.deviceDAO.findByModel(model);
    }

    @Override
    public List<Device> findByStatus(String status) {
        return this.deviceDAO.findByStatus(status);
    }

    @Override
    public ResponseEntity<?> saveDevice(Device device) {
    //   checks whether sql has completed successfully if completed it returns 1 which is true
        if (this.deviceDAO.save(device) == 1) {
            return  ResponseEntity.status(201).body(new MessageResponse("Device Successfully Added"));
        } else {
            return ResponseEntity.status(404).body(new MessageResponse("Device Not Saved"));
        }
    }

    @Override
    public ResponseEntity<?> updateDevice(long id, Device device) {
//        checks whether sql has completed successfully if completed it returns 1 which is true
        if (this.deviceDAO.updateDevice(id, device) == 1) {
            return ResponseEntity.status(200).body(new MessageResponse("Device updated Successfully"));
        } else {
            return ResponseEntity.status(404).body(new MessageResponse("Unable to update device with Id:" + id));
        }
    }

    @Override
    public ResponseEntity<?> deleteDevice(long id) {
    //    checks whether sql has completed successfully if completed it returns 1 which is true
        if (this.deviceDAO.deleteDevice(id) == 1) {
            return ResponseEntity.status(200).body(new MessageResponse("Device Deleted Successfully"));
        } else {
            return ResponseEntity.status(404).body(new MessageResponse("Unable to delete device with Id:" + id));
        }
    }

}
