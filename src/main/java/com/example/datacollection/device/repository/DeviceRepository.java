package com.example.datacollection.device.repository;

import com.example.datacollection.device.entity.Device;
import com.example.datacollection.deviceGroup.entity.DeviceGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device,Long> {
    boolean existsBySerialNumber(String serialNumber);
}
