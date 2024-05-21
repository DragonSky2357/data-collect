package com.example.datacollection.deviceGroup.service;

import com.example.datacollection.deviceGroup.dto.request.AddDeviceGroup;
import com.example.datacollection.deviceGroup.entity.DeviceGroup;


public interface DeviceGroupService {
    DeviceGroup addDeviceGroup(AddDeviceGroup request);
    DeviceGroup getDeviceGroup(Long id);
    DeviceGroup getDeviceGroupByStationGroupSerial(String stationGroupSerial);
}
