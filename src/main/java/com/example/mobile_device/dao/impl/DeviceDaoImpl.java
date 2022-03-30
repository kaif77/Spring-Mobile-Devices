package com.example.mobile_device.dao.impl;

import com.example.mobile_device.dao.DeviceDAO;
import com.example.mobile_device.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class DeviceDaoImpl implements DeviceDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //    mapping the data with the Device class which retrieved from database
    static class DeviceMapper implements RowMapper<Device> {
        @Override
        public Device mapRow(ResultSet rs, int rowNum) throws SQLException {
            Device device = new Device();
            device.setId(rs.getLong("id"));
            device.setName(rs.getString("name"));
            device.setStatus(rs.getString("status"));
            device.setModel(rs.getString("model"));
            device.setEnrolled(rs.getTimestamp("enrolled"));
            return device;
        }
    }

    @Override
    public List<Device> findAll() {
        return jdbcTemplate.query("select * from device", new DeviceMapper());
    }

    @Override
    public Optional<Device> findById(long deviceId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("select * from device where id=?",
                    new Object[]{
                            deviceId
                    }, new DeviceMapper()));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

    }

    @Override
    public List<Device> findByName(String name) {
        return jdbcTemplate.query("select * from device where name=" + "'" + name + "'", new DeviceMapper());
    }

    @Override
    public List<Device> findByModel(String model) {
        return jdbcTemplate.query("select * from device where model=" + "'" + model + "'", new DeviceMapper());
    }

    @Override
    public List<Device> findByStatus(String status) {
        return jdbcTemplate.query("select * from device where status=" + "'" + status + "'", new DeviceMapper());
    }


    @Override
    public int save(Device device) {
        return jdbcTemplate.update("insert into device(id, name, status, model, enrolled )" +
                "values (?,?,?,?,now())", null, device.getName(), device.getStatus(), device.getModel());
    }

    @Override
    public int updateDevice(long id, Device device) {
        return jdbcTemplate.update("update device set name=?,status=?, model=? where id=? ",
                device.getName(), device.getStatus(), device.getModel(), id);
    }

    @Override
    public int deleteDevice(long id) {
        return jdbcTemplate.update("delete from device where id=?", id);
    }
}
