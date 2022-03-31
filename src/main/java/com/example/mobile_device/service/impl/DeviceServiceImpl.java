package com.example.mobile_device.service.impl;

import com.example.mobile_device.dao.DeviceDAO;
import com.example.mobile_device.model.Device;
import com.example.mobile_device.service.DeviceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {
//    @Autowired
    final private DeviceDAO deviceDAO;

    public DeviceServiceImpl(DeviceDAO deviceDAO) {
        this.deviceDAO = deviceDAO;
    }

    @Override
    public List<Device> findAll() {
        return this.deviceDAO.findAll();
    }

    @Override
    public Device findById(long Id) {
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
    public int saveDevice(Device device) {
    //   checks whether sql has completed successfully if completed it returns 1 which is true
        return this.deviceDAO.save(device);
    }

    @Override
    public int updateDevice(long id, Device device) {
//        checks whether sql has completed successfully if completed it returns 1 which is true
        return this.deviceDAO.updateDevice(id,device);
    }

    @Override
    public int deleteDevice(long id) {
    //    checks whether sql has completed successfully if completed it returns 1 which is true
        return this.deviceDAO.deleteDevice(id);
    }

}
