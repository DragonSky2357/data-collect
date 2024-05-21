package com.example.datacollection.device.service.impl;

import com.example.datacollection.device.dto.request.AddDevice;
import com.example.datacollection.device.entity.Device;
import com.example.datacollection.device.repository.DeviceRepository;
import com.example.datacollection.device.service.DeviceService;
import com.example.datacollection.deviceGroup.entity.DeviceGroup;
import com.example.datacollection.deviceGroup.service.DeviceGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;
    private final DeviceGroupService deviceGroupService;

    @Override
    public Device addDevice(AddDevice request) {

        boolean isExistDevice = deviceRepository.existsBySerialNumber(request.getSerialNumber());

        if(isExistDevice){
            throw new IllegalArgumentException("이미 존재하는 디바이스입니다");
        }

        DeviceGroup deviceGroup = deviceGroupService.getDeviceGroupByStationGroupSerial(request.getStationGroupSerial());

        Device device = new Device(request,deviceGroup);

        return deviceRepository.save(device);
    }
}
