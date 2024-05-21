package com.example.datacollection.device.service;

import com.example.datacollection.device.dto.request.AddDevice;
import com.example.datacollection.device.entity.Device;

public interface DeviceService {
    Device addDevice(AddDevice device);
}
