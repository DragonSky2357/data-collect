package com.example.datacollection.deviceGroup.repository;

import com.example.datacollection.deviceGroup.entity.DeviceGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviceGroupRepository extends JpaRepository<DeviceGroup,Long> {
    boolean existsByStationGroupSerial(String stationGroupSerial);
    Optional<DeviceGroup> findByStationGroupSerial(String stationGroupSerial);
}
